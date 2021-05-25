package com.google.android.exoplayer2.extractor.mp3;

import a2.j.b.b.u0.i.a;
import a2.j.b.b.u0.i.b;
import a2.j.b.b.u0.i.c;
import a2.j.b.b.u0.i.d;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public static final int FLAG_DISABLE_ID3_METADATA = 4;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 2;
    public static final Id3Decoder.FramePredicate u = b.a;
    public final int a;
    public final long b;
    public final ParsableByteArray c;
    public final MpegAudioUtil.Header d;
    public final GaplessInfoHolder e;
    public final Id3Peeker f;
    public final TrackOutput g;
    public ExtractorOutput h;
    public TrackOutput i;
    public TrackOutput j;
    public int k;
    @Nullable
    public Metadata l;
    public long m;
    public long n;
    public long o;
    public int p;
    public Seeker q;
    public boolean r;
    public boolean s;
    public long t;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    public static long c(@Nullable Metadata metadata) {
        if (metadata == null) {
            return C.TIME_UNSET;
        }
        int length = metadata.length();
        for (int i2 = 0; i2 < length; i2++) {
            Metadata.Entry entry = metadata.get(i2);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return C.msToUs(Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static boolean d(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    public final long a(long j2) {
        return ((j2 * 1000000) / ((long) this.d.sampleRate)) + this.m;
    }

    public final Seeker b(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.c.getData(), 0, 4);
        this.c.setPosition(0);
        this.d.setForHeaderData(this.c.readInt());
        return new c(extractorInput.getLength(), extractorInput.getPosition(), this.d);
    }

    public void disableSeeking() {
        this.r = true;
    }

    public final boolean e(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.q;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.c.getData(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean f(ExtractorInput extractorInput, boolean z) throws IOException {
        int i2;
        int i3;
        int frameSize;
        Id3Decoder.FramePredicate framePredicate;
        int i4 = z ? 32768 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.a & 4) == 0) {
                framePredicate = null;
            } else {
                framePredicate = u;
            }
            Metadata peekId3Data = this.f.peekId3Data(extractorInput, framePredicate);
            this.l = peekId3Data;
            if (peekId3Data != null) {
                this.e.setFromMetadata(peekId3Data);
            }
            i2 = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(i2);
            }
            i3 = 0;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!e(extractorInput)) {
                this.c.setPosition(0);
                int readInt = this.c.readInt();
                if ((i3 == 0 || d(readInt, (long) i3)) && (frameSize = MpegAudioUtil.getFrameSize(readInt)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.d.setForHeaderData(readInt);
                        i3 = readInt;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 != i4) {
                        if (z) {
                            extractorInput.resetPeekPosition();
                            extractorInput.advancePeekPosition(i2 + i7);
                        } else {
                            extractorInput.skipFully(1);
                        }
                        i6 = i7;
                        i3 = 0;
                        i5 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw new ParserException("Searched too many bytes.");
                    }
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            extractorInput.skipFully(i2 + i6);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.k = i3;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.h = extractorOutput;
        TrackOutput track = extractorOutput.track(0, 1);
        this.i = track;
        this.j = track;
        this.h.endTracks();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02e0, code lost:
        if ((r4.a & 1) != 0) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r3 != 1231971951) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0242  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r32, com.google.android.exoplayer2.extractor.PositionHolder r33) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.k = 0;
        this.m = C.TIME_UNSET;
        this.n = 0;
        this.p = 0;
        this.t = j3;
        Seeker seeker = this.q;
        if ((seeker instanceof d) && !((d) seeker).a(j3)) {
            this.s = true;
            this.j = this.g;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return f(extractorInput, true);
    }

    public Mp3Extractor(int i2) {
        this(i2, C.TIME_UNSET);
    }

    public Mp3Extractor(int i2, long j2) {
        this.a = i2;
        this.b = j2;
        this.c = new ParsableByteArray(10);
        this.d = new MpegAudioUtil.Header();
        this.e = new GaplessInfoHolder();
        this.m = C.TIME_UNSET;
        this.f = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.g = dummyTrackOutput;
        this.j = dummyTrackOutput;
    }
}
