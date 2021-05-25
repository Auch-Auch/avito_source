package com.google.android.exoplayer2.extractor.wav;

import a2.j.b.b.u0.m.d;
import android.util.Pair;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.sumsub.sns.R2;
import java.io.IOException;
public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a2.j.b.b.u0.m.a.a;
    public ExtractorOutput a;
    public TrackOutput b;
    public b c;
    public int d = -1;
    public long e = -1;

    public static final class a implements b {
        public static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, R2.styleable.Snackbar_snackbarButtonStyle, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final ExtractorOutput a;
        public final TrackOutput b;
        public final a2.j.b.b.u0.m.b c;
        public final int d;
        public final byte[] e;
        public final ParsableByteArray f;
        public final int g;
        public final Format h;
        public int i;
        public long j;
        public int k;
        public long l;

        public a(ExtractorOutput extractorOutput, TrackOutput trackOutput, a2.j.b.b.u0.m.b bVar) throws ParserException {
            this.a = extractorOutput;
            this.b = trackOutput;
            this.c = bVar;
            int max = Math.max(1, bVar.c / 10);
            this.g = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(bVar.f);
            parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.d = readLittleEndianUnsignedShort;
            int i2 = bVar.b;
            int i3 = (((bVar.d - (i2 * 4)) * 8) / (bVar.e * i2)) + 1;
            if (readLittleEndianUnsignedShort == i3) {
                int ceilDivide = Util.ceilDivide(max, readLittleEndianUnsignedShort);
                this.e = new byte[(bVar.d * ceilDivide)];
                this.f = new ParsableByteArray(readLittleEndianUnsignedShort * 2 * i2 * ceilDivide);
                int i4 = ((bVar.c * bVar.d) * 8) / readLittleEndianUnsignedShort;
                this.h = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setAverageBitrate(i4).setPeakBitrate(i4).setMaxInputSize(max * 2 * i2).setChannelCount(bVar.b).setSampleRate(bVar.c).setPcmEncoding(2).build();
                return;
            }
            throw new ParserException(a2.b.a.a.a.R2("Expected frames per block: ", i3, "; got: ", readLittleEndianUnsignedShort));
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
            */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0049 A[ADDED_TO_REGION, EDGE_INSN: B:41:0x0049->B:12:0x0049 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x002b  */
        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public boolean a(com.google.android.exoplayer2.extractor.ExtractorInput r19, long r20) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 373
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.a.a(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public void b(int i2, long j2) {
            this.a.seekMap(new d(this.c, this.d, (long) i2, j2));
            this.b.format(this.h);
        }

        public final int c(int i2) {
            return i2 / (this.c.b * 2);
        }

        public final void d(int i2) {
            long scaleLargeTimestamp = this.j + Util.scaleLargeTimestamp(this.l, 1000000, (long) this.c.c);
            int i3 = i2 * 2 * this.c.b;
            this.b.sampleMetadata(scaleLargeTimestamp, 1, i3, this.k - i3, null);
            this.l += (long) i2;
            this.k -= i3;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public void reset(long j2) {
            this.i = 0;
            this.j = j2;
            this.k = 0;
            this.l = 0;
        }
    }

    public interface b {
        boolean a(ExtractorInput extractorInput, long j) throws IOException;

        void b(int i, long j) throws ParserException;

        void reset(long j);
    }

    public static final class c implements b {
        public final ExtractorOutput a;
        public final TrackOutput b;
        public final a2.j.b.b.u0.m.b c;
        public final Format d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(ExtractorOutput extractorOutput, TrackOutput trackOutput, a2.j.b.b.u0.m.b bVar, String str, int i) throws ParserException {
            this.a = extractorOutput;
            this.b = trackOutput;
            this.c = bVar;
            int i2 = (bVar.b * bVar.e) / 8;
            if (bVar.d == i2) {
                int i3 = bVar.c * i2;
                int i4 = i3 * 8;
                int max = Math.max(i2, i3 / 10);
                this.e = max;
                this.d = new Format.Builder().setSampleMimeType(str).setAverageBitrate(i4).setPeakBitrate(i4).setMaxInputSize(max).setChannelCount(bVar.b).setSampleRate(bVar.c).setPcmEncoding(i).build();
                return;
            }
            StringBuilder M = a2.b.a.a.a.M("Expected block size: ", i2, "; got: ");
            M.append(bVar.d);
            throw new ParserException(M.toString());
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public boolean a(ExtractorInput extractorInput, long j) throws IOException {
            int i;
            int i2;
            int i3;
            long j2 = j;
            while (true) {
                i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i <= 0 || (i2 = this.g) >= (i3 = this.e)) {
                    break;
                }
                int sampleData = this.b.sampleData((DataReader) extractorInput, (int) Math.min((long) (i3 - i2), j2), true);
                if (sampleData == -1) {
                    j2 = 0;
                } else {
                    this.g += sampleData;
                    j2 -= (long) sampleData;
                }
            }
            a2.j.b.b.u0.m.b bVar = this.c;
            int i4 = bVar.d;
            int i5 = this.g / i4;
            if (i5 > 0) {
                int i6 = i5 * i4;
                int i7 = this.g - i6;
                this.b.sampleMetadata(this.f + Util.scaleLargeTimestamp(this.h, 1000000, (long) bVar.c), 1, i6, i7, null);
                this.h += (long) i5;
                this.g = i7;
            }
            if (i <= 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public void b(int i, long j) {
            this.a.seekMap(new d(this.c, 1, (long) i, j));
            this.b.format(this.d);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.b
        public void reset(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
        this.b = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.b);
        Util.castNonNull(this.a);
        if (this.c == null) {
            a2.j.b.b.u0.m.b x1 = AppCompatDelegateImpl.i.x1(extractorInput);
            if (x1 != null) {
                int i = x1.a;
                if (i == 17) {
                    this.c = new a(this.a, this.b, x1);
                } else if (i == 6) {
                    this.c = new c(this.a, this.b, x1, MimeTypes.AUDIO_ALAW, -1);
                } else if (i == 7) {
                    this.c = new c(this.a, this.b, x1, MimeTypes.AUDIO_MLAW, -1);
                } else {
                    int pcmEncodingForType = WavUtil.getPcmEncodingForType(i, x1.e);
                    if (pcmEncodingForType != 0) {
                        this.c = new c(this.a, this.b, x1, MimeTypes.AUDIO_RAW, pcmEncodingForType);
                    } else {
                        StringBuilder L = a2.b.a.a.a.L("Unsupported WAV format type: ");
                        L.append(x1.a);
                        throw new ParserException(L.toString());
                    }
                }
            } else {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
        }
        if (this.d == -1) {
            Assertions.checkNotNull(extractorInput);
            extractorInput.resetPeekPosition();
            ParsableByteArray parsableByteArray = new ParsableByteArray(8);
            a2.j.b.b.u0.m.c a3 = a2.j.b.b.u0.m.c.a(extractorInput, parsableByteArray);
            while (true) {
                int i2 = a3.a;
                if (i2 != 1684108385) {
                    if (!(i2 == 1380533830 || i2 == 1718449184)) {
                        StringBuilder L2 = a2.b.a.a.a.L("Ignoring unknown WAV chunk: ");
                        L2.append(a3.a);
                        Log.w("WavHeaderReader", L2.toString());
                    }
                    long j = a3.b + 8;
                    if (a3.a == 1380533830) {
                        j = 12;
                    }
                    if (j <= 2147483647L) {
                        extractorInput.skipFully((int) j);
                        a3 = a2.j.b.b.u0.m.c.a(extractorInput, parsableByteArray);
                    } else {
                        StringBuilder L3 = a2.b.a.a.a.L("Chunk is too large (~2GB+) to skip; id: ");
                        L3.append(a3.a);
                        throw new ParserException(L3.toString());
                    }
                } else {
                    extractorInput.skipFully(8);
                    long position = extractorInput.getPosition();
                    long j2 = a3.b + position;
                    long length = extractorInput.getLength();
                    if (length != -1 && j2 > length) {
                        StringBuilder O = a2.b.a.a.a.O("Data exceeds input length: ", j2, ", ");
                        O.append(length);
                        Log.w("WavHeaderReader", O.toString());
                        j2 = length;
                    }
                    Pair create = Pair.create(Long.valueOf(position), Long.valueOf(j2));
                    this.d = ((Long) create.first).intValue();
                    long longValue = ((Long) create.second).longValue();
                    this.e = longValue;
                    this.c.b(this.d, longValue);
                }
            }
        } else if (extractorInput.getPosition() == 0) {
            extractorInput.skipFully(this.d);
        }
        Assertions.checkState(this.e != -1);
        if (this.c.a(extractorInput, this.e - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.reset(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return AppCompatDelegateImpl.i.x1(extractorInput) != null;
    }
}
