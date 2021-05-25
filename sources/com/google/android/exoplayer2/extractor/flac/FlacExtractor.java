package com.google.android.exoplayer2.extractor.flac;

import a2.j.b.b.u0.f.a;
import a2.j.b.b.u0.f.c;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class FlacExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    public final byte[] a;
    public final ParsableByteArray b;
    public final boolean c;
    public final FlacFrameReader.SampleNumberHolder d;
    public ExtractorOutput e;
    public TrackOutput f;
    public int g;
    @Nullable
    public Metadata h;
    public FlacStreamMetadata i;
    public int j;
    public int k;
    public c l;
    public int m;
    public long n;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    public final void a() {
        ((TrackOutput) Util.castNonNull(this.f)).sampleMetadata((this.n * 1000000) / ((long) ((FlacStreamMetadata) Util.castNonNull(this.i)).sampleRate), 1, this.m, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.e = extractorOutput;
        this.f = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        SeekMap seekMap;
        long j2;
        boolean z;
        int i2 = this.g;
        boolean z2 = true;
        if (i2 == 0) {
            this.h = FlacMetadataReader.readId3Metadata(extractorInput, !this.c);
            this.g = 1;
            return 0;
        } else if (i2 == 1) {
            byte[] bArr = this.a;
            extractorInput.peekFully(bArr, 0, bArr.length);
            extractorInput.resetPeekPosition();
            this.g = 2;
            return 0;
        } else if (i2 == 2) {
            FlacMetadataReader.readStreamMarker(extractorInput);
            this.g = 3;
            return 0;
        } else if (i2 == 3) {
            FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.i);
            boolean z3 = false;
            while (!z3) {
                z3 = FlacMetadataReader.readMetadataBlock(extractorInput, flacStreamMetadataHolder);
                this.i = (FlacStreamMetadata) Util.castNonNull(flacStreamMetadataHolder.flacStreamMetadata);
            }
            Assertions.checkNotNull(this.i);
            this.j = Math.max(this.i.minFrameSize, 6);
            ((TrackOutput) Util.castNonNull(this.f)).format(this.i.getFormat(this.a, this.h));
            this.g = 4;
            return 0;
        } else if (i2 == 4) {
            this.k = FlacMetadataReader.getFrameStartMarker(extractorInput);
            ExtractorOutput extractorOutput = (ExtractorOutput) Util.castNonNull(this.e);
            long position = extractorInput.getPosition();
            long length = extractorInput.getLength();
            Assertions.checkNotNull(this.i);
            FlacStreamMetadata flacStreamMetadata = this.i;
            if (flacStreamMetadata.seekTable != null) {
                seekMap = new FlacSeekTableSeekMap(flacStreamMetadata, position);
            } else if (length == -1 || flacStreamMetadata.totalSamples <= 0) {
                seekMap = new SeekMap.Unseekable(flacStreamMetadata.getDurationUs());
            } else {
                c cVar = new c(flacStreamMetadata, this.k, position, length);
                this.l = cVar;
                seekMap = cVar.getSeekMap();
            }
            extractorOutput.seekMap(seekMap);
            this.g = 5;
            return 0;
        } else if (i2 == 5) {
            Assertions.checkNotNull(this.f);
            Assertions.checkNotNull(this.i);
            c cVar2 = this.l;
            if (cVar2 != null && cVar2.isSeeking()) {
                return this.l.handlePendingSeek(extractorInput, positionHolder);
            }
            if (this.n == -1) {
                this.n = FlacFrameReader.getFirstSampleNumber(extractorInput, this.i);
                return 0;
            }
            int limit = this.b.limit();
            if (limit < 32768) {
                int read = extractorInput.read(this.b.getData(), limit, 32768 - limit);
                if (read != -1) {
                    z2 = false;
                }
                if (!z2) {
                    this.b.setLimit(limit + read);
                } else if (this.b.bytesLeft() == 0) {
                    a();
                    return -1;
                }
            } else {
                z2 = false;
            }
            int position2 = this.b.getPosition();
            int i3 = this.m;
            int i4 = this.j;
            if (i3 < i4) {
                ParsableByteArray parsableByteArray = this.b;
                parsableByteArray.skipBytes(Math.min(i4 - i3, parsableByteArray.bytesLeft()));
            }
            ParsableByteArray parsableByteArray2 = this.b;
            Assertions.checkNotNull(this.i);
            int position3 = parsableByteArray2.getPosition();
            while (true) {
                if (position3 <= parsableByteArray2.limit() - 16) {
                    parsableByteArray2.setPosition(position3);
                    if (FlacFrameReader.checkAndReadFrameHeader(parsableByteArray2, this.i, this.k, this.d)) {
                        parsableByteArray2.setPosition(position3);
                        j2 = this.d.sampleNumber;
                        break;
                    }
                    position3++;
                } else {
                    if (z2) {
                        while (position3 <= parsableByteArray2.limit() - this.j) {
                            parsableByteArray2.setPosition(position3);
                            try {
                                z = FlacFrameReader.checkAndReadFrameHeader(parsableByteArray2, this.i, this.k, this.d);
                            } catch (IndexOutOfBoundsException unused) {
                                z = false;
                            }
                            if (parsableByteArray2.getPosition() > parsableByteArray2.limit()) {
                                z = false;
                            }
                            if (z) {
                                parsableByteArray2.setPosition(position3);
                                j2 = this.d.sampleNumber;
                                break;
                            }
                            position3++;
                        }
                        parsableByteArray2.setPosition(parsableByteArray2.limit());
                    } else {
                        parsableByteArray2.setPosition(position3);
                    }
                    j2 = -1;
                }
            }
            int position4 = this.b.getPosition() - position2;
            this.b.setPosition(position2);
            this.f.sampleData(this.b, position4);
            this.m += position4;
            if (j2 != -1) {
                a();
                this.m = 0;
                this.n = j2;
            }
            if (this.b.bytesLeft() >= 16) {
                return 0;
            }
            System.arraycopy(this.b.getData(), this.b.getPosition(), this.b.getData(), 0, this.b.bytesLeft());
            ParsableByteArray parsableByteArray3 = this.b;
            parsableByteArray3.reset(parsableByteArray3.bytesLeft());
            return 0;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.g = 0;
        } else {
            c cVar = this.l;
            if (cVar != null) {
                cVar.setSeekTargetUs(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.n = j4;
        this.m = 0;
        this.b.reset(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.peekId3Metadata(extractorInput, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }

    public FlacExtractor(int i2) {
        this.a = new byte[42];
        this.b = new ParsableByteArray(new byte[32768], 0);
        this.c = (i2 & 1) == 0 ? false : true;
        this.d = new FlacFrameReader.SampleNumberHolder();
        this.g = 0;
    }
}
