package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.d;
import a2.j.b.b.u0.l.g;
import a2.j.b.b.u0.l.h;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
public final class PsExtractor implements Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final ExtractorsFactory FACTORY = d.a;
    public static final int PRIVATE_STREAM_1 = 189;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    public final TimestampAdjuster a;
    public final SparseArray<a> b;
    public final ParsableByteArray c;
    public final h d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    @Nullable
    public g i;
    public ExtractorOutput j;
    public boolean k;

    public static final class a {
        public final ElementaryStreamReader a;
        public final TimestampAdjuster b;
        public final ParsableBitArray c = new ParsableBitArray(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public long h;

        public a(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.a = elementaryStreamReader;
            this.b = timestampAdjuster;
        }
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.j = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.j);
        long length = extractorInput.getLength();
        int i2 = 1;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        boolean z = i3 != 0;
        long j2 = C.TIME_UNSET;
        if (z) {
            h hVar = this.d;
            if (!hVar.c) {
                if (!hVar.e) {
                    long length2 = extractorInput.getLength();
                    int min = (int) Math.min((long) SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, length2);
                    long j3 = length2 - ((long) min);
                    if (extractorInput.getPosition() != j3) {
                        positionHolder.position = j3;
                        return i2;
                    }
                    hVar.b.reset(min);
                    extractorInput.resetPeekPosition();
                    extractorInput.peekFully(hVar.b.getData(), 0, min);
                    ParsableByteArray parsableByteArray = hVar.b;
                    int position = parsableByteArray.getPosition();
                    int limit = parsableByteArray.limit() - 4;
                    while (true) {
                        if (limit < position) {
                            break;
                        }
                        if (hVar.b(parsableByteArray.getData(), limit) == 442) {
                            parsableByteArray.setPosition(limit + 4);
                            long c2 = h.c(parsableByteArray);
                            if (c2 != C.TIME_UNSET) {
                                j2 = c2;
                                break;
                            }
                        }
                        limit--;
                    }
                    hVar.g = j2;
                    hVar.e = true;
                } else if (hVar.g == C.TIME_UNSET) {
                    hVar.a(extractorInput);
                    return 0;
                } else if (!hVar.d) {
                    int min2 = (int) Math.min((long) SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength());
                    long j4 = (long) 0;
                    if (extractorInput.getPosition() != j4) {
                        positionHolder.position = j4;
                        return i2;
                    }
                    hVar.b.reset(min2);
                    extractorInput.resetPeekPosition();
                    extractorInput.peekFully(hVar.b.getData(), 0, min2);
                    ParsableByteArray parsableByteArray2 = hVar.b;
                    int position2 = parsableByteArray2.getPosition();
                    int limit2 = parsableByteArray2.limit();
                    while (true) {
                        if (position2 >= limit2 - 3) {
                            break;
                        }
                        if (hVar.b(parsableByteArray2.getData(), position2) == 442) {
                            parsableByteArray2.setPosition(position2 + 4);
                            long c3 = h.c(parsableByteArray2);
                            if (c3 != C.TIME_UNSET) {
                                j2 = c3;
                                break;
                            }
                        }
                        position2++;
                    }
                    hVar.f = j2;
                    hVar.d = true;
                } else {
                    long j5 = hVar.f;
                    if (j5 == C.TIME_UNSET) {
                        hVar.a(extractorInput);
                        return 0;
                    }
                    hVar.h = hVar.a.adjustTsTimestamp(hVar.g) - hVar.a.adjustTsTimestamp(j5);
                    hVar.a(extractorInput);
                    return 0;
                }
                i2 = 0;
                return i2;
            }
        }
        if (!this.k) {
            this.k = true;
            h hVar2 = this.d;
            long j6 = hVar2.h;
            if (j6 != C.TIME_UNSET) {
                g gVar = new g(hVar2.a, j6, length);
                this.i = gVar;
                this.j.seekMap(gVar.getSeekMap());
            } else {
                this.j.seekMap(new SeekMap.Unseekable(j6));
            }
        }
        g gVar2 = this.i;
        if (gVar2 != null && gVar2.isSeeking()) {
            return this.i.handlePendingSeek(extractorInput, positionHolder);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = i3 != 0 ? length - extractorInput.getPeekPosition() : -1;
        if ((peekPosition != -1 && peekPosition < 4) || !extractorInput.peekFully(this.c.getData(), 0, 4, true)) {
            return -1;
        }
        this.c.setPosition(0);
        int readInt = this.c.readInt();
        if (readInt == 441) {
            return -1;
        }
        if (readInt == 442) {
            extractorInput.peekFully(this.c.getData(), 0, 10);
            this.c.setPosition(9);
            extractorInput.skipFully((this.c.readUnsignedByte() & 7) + 14);
            return 0;
        } else if (readInt == 443) {
            extractorInput.peekFully(this.c.getData(), 0, 2);
            this.c.setPosition(0);
            extractorInput.skipFully(this.c.readUnsignedShort() + 6);
            return 0;
        } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        } else {
            int i4 = readInt & 255;
            a aVar = this.b.get(i4);
            if (!this.e) {
                if (aVar == null) {
                    ElementaryStreamReader elementaryStreamReader = null;
                    if (i4 == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.f = true;
                        this.h = extractorInput.getPosition();
                    } else if ((i4 & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.f = true;
                        this.h = extractorInput.getPosition();
                    } else if ((i4 & 240) == 224) {
                        elementaryStreamReader = new H262Reader();
                        this.g = true;
                        this.h = extractorInput.getPosition();
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.createTracks(this.j, new TsPayloadReader.TrackIdGenerator(i4, 256));
                        aVar = new a(elementaryStreamReader, this.a);
                        this.b.put(i4, aVar);
                    }
                }
                if (extractorInput.getPosition() > ((!this.f || !this.g) ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : this.h + PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
                    this.e = true;
                    this.j.endTracks();
                }
            }
            extractorInput.peekFully(this.c.getData(), 0, 2);
            this.c.setPosition(0);
            int readUnsignedShort = this.c.readUnsignedShort() + 6;
            if (aVar == null) {
                extractorInput.skipFully(readUnsignedShort);
            } else {
                this.c.reset(readUnsignedShort);
                extractorInput.readFully(this.c.getData(), 0, readUnsignedShort);
                this.c.setPosition(6);
                ParsableByteArray parsableByteArray3 = this.c;
                parsableByteArray3.readBytes(aVar.c.data, 0, 3);
                aVar.c.setPosition(0);
                aVar.c.skipBits(8);
                aVar.d = aVar.c.readBit();
                aVar.e = aVar.c.readBit();
                aVar.c.skipBits(6);
                int readBits = aVar.c.readBits(8);
                aVar.g = readBits;
                parsableByteArray3.readBytes(aVar.c.data, 0, readBits);
                aVar.c.setPosition(0);
                aVar.h = 0;
                if (aVar.d) {
                    aVar.c.skipBits(4);
                    aVar.c.skipBits(1);
                    aVar.c.skipBits(1);
                    long readBits2 = (((long) aVar.c.readBits(3)) << 30) | ((long) (aVar.c.readBits(15) << 15)) | ((long) aVar.c.readBits(15));
                    aVar.c.skipBits(1);
                    if (!aVar.f && aVar.e) {
                        aVar.c.skipBits(4);
                        aVar.c.skipBits(1);
                        aVar.c.skipBits(1);
                        aVar.c.skipBits(1);
                        aVar.b.adjustTsTimestamp((((long) aVar.c.readBits(3)) << 30) | ((long) (aVar.c.readBits(15) << 15)) | ((long) aVar.c.readBits(15)));
                        aVar.f = true;
                    }
                    aVar.h = aVar.b.adjustTsTimestamp(readBits2);
                }
                aVar.a.packetStarted(aVar.h, 4);
                aVar.a.consume(parsableByteArray3);
                aVar.a.packetFinished();
                ParsableByteArray parsableByteArray4 = this.c;
                parsableByteArray4.setLimit(parsableByteArray4.capacity());
            }
            return 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        if ((this.a.getTimestampOffsetUs() == C.TIME_UNSET) || !(this.a.getFirstSampleTimestampUs() == 0 || this.a.getFirstSampleTimestampUs() == j3)) {
            this.a.reset();
            this.a.setFirstSampleTimestampUs(j3);
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.setSeekTargetUs(j3);
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            a valueAt = this.b.valueAt(i2);
            valueAt.f = false;
            valueAt.a.seek();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.a = timestampAdjuster;
        this.c = new ParsableByteArray(4096);
        this.b = new SparseArray<>();
        this.d = new h();
    }
}
