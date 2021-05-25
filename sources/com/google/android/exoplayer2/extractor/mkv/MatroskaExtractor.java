package com.google.android.exoplayer2.extractor.mkv;

import a2.j.b.b.u0.h.e;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
public class MatroskaExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a2.j.b.b.u0.h.a.a;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    public static final byte[] b0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] c0 = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] d0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final UUID e0 = new UUID(72057594037932032L, -9223371306706625679L);
    public static final Map<String, Integer> f0;
    public long A;
    public long B;
    @Nullable
    public LongArray C;
    @Nullable
    public LongArray D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public byte Y;
    public boolean Z;
    public final a2.j.b.b.u0.h.c a;
    public ExtractorOutput a0;
    public final e b;
    public final SparseArray<c> c;
    public final boolean d;
    public final ParsableByteArray e;
    public final ParsableByteArray f;
    public final ParsableByteArray g;
    public final ParsableByteArray h;
    public final ParsableByteArray i;
    public final ParsableByteArray j;
    public final ParsableByteArray k;
    public final ParsableByteArray l;
    public final ParsableByteArray m;
    public final ParsableByteArray n;
    public ByteBuffer o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    @Nullable
    public c u;
    public boolean v;
    public int w;
    public long x;
    public boolean y;
    public long z;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class b implements EbmlProcessor {
        public b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }
    }

    public static final class d {
        public final byte[] a = new byte[10];
        public boolean b;
        public int c;
        public long d;
        public int e;
        public int f;
        public int g;

        public void a(c cVar) {
            if (this.c > 0) {
                cVar.X.sampleMetadata(this.d, this.e, this.f, this.g, cVar.j);
                this.c = 0;
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f0 = Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    public static int[] b(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }

    public static byte[] c(long j2, String str, long j3) {
        Assertions.checkArgument(j2 != C.TIME_UNSET);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - (((long) (i2 * 3600)) * 1000000);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - (((long) (i3 * 60)) * 1000000);
        int i4 = (int) (j5 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (((long) i4) * 1000000)) / j3))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.c r17, long r18, int r20, int r21, int r22) {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.a(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$c, long, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0210, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void binaryElement(int r20, int r21, com.google.android.exoplayer2.extractor.ExtractorInput r22) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 702
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.binaryElement(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void");
    }

    public final void d(ExtractorInput extractorInput, int i2) throws IOException {
        if (this.g.limit() < i2) {
            if (this.g.capacity() < i2) {
                ParsableByteArray parsableByteArray = this.g;
                parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), Math.max(this.g.getData().length * 2, i2)), this.g.limit());
            }
            extractorInput.readFully(this.g.getData(), this.g.limit(), i2 - this.g.limit());
            this.g.setLimit(i2);
        }
    }

    public final void e() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = 0;
        this.Z = false;
        this.j.reset(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v44, types: [java.util.List<byte[]>] */
    /* JADX WARN: Type inference failed for: r3v58, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v60, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v63, types: [java.util.List<byte[]>] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.util.List] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x07ba, code lost:
        if (r3.readLong() == r4.getLeastSignificantBits()) goto L_0x07bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x07c1  */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x07e7  */
    /* JADX WARNING: Unknown variable types count: 8 */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void endMasterElement(int r19) throws com.google.android.exoplayer2.ParserException {
        /*
        // Method dump skipped, instructions count: 3146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.endMasterElement(int):void");
    }

    public final long f(long j2) throws ParserException {
        long j3 = this.r;
        if (j3 != C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j2, j3, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    @CallSuper
    public void floatElement(int i2, double d2) throws ParserException {
        if (i2 == 181) {
            this.u.Q = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.u.D = (float) d2;
                    return;
                case 21970:
                    this.u.E = (float) d2;
                    return;
                case 21971:
                    this.u.F = (float) d2;
                    return;
                case 21972:
                    this.u.G = (float) d2;
                    return;
                case 21973:
                    this.u.H = (float) d2;
                    return;
                case 21974:
                    this.u.I = (float) d2;
                    return;
                case 21975:
                    this.u.J = (float) d2;
                    return;
                case 21976:
                    this.u.K = (float) d2;
                    return;
                case 21977:
                    this.u.L = (float) d2;
                    return;
                case 21978:
                    this.u.M = (float) d2;
                    return;
                default:
                    switch (i2) {
                        case 30323:
                            this.u.s = (float) d2;
                            return;
                        case 30324:
                            this.u.t = (float) d2;
                            return;
                        case 30325:
                            this.u.u = (float) d2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.s = (long) d2;
        }
    }

    public final int g(ExtractorInput extractorInput, c cVar, int i2) throws IOException {
        int i3;
        if ("S_TEXT/UTF8".equals(cVar.b)) {
            h(extractorInput, b0, i2);
            int i4 = this.S;
            e();
            return i4;
        } else if ("S_TEXT/ASS".equals(cVar.b)) {
            h(extractorInput, d0, i2);
            int i5 = this.S;
            e();
            return i5;
        } else {
            TrackOutput trackOutput = cVar.X;
            if (!this.U) {
                if (cVar.h) {
                    this.O &= -1073741825;
                    int i6 = 128;
                    if (!this.V) {
                        extractorInput.readFully(this.g.getData(), 0, 1);
                        this.R++;
                        if ((this.g.getData()[0] & 128) != 128) {
                            this.Y = this.g.getData()[0];
                            this.V = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b2 = this.Y;
                    if ((b2 & 1) == 1) {
                        boolean z2 = (b2 & 2) == 2;
                        this.O |= 1073741824;
                        if (!this.Z) {
                            extractorInput.readFully(this.l.getData(), 0, 8);
                            this.R += 8;
                            this.Z = true;
                            byte[] data = this.g.getData();
                            if (!z2) {
                                i6 = 0;
                            }
                            data[0] = (byte) (i6 | 8);
                            this.g.setPosition(0);
                            trackOutput.sampleData(this.g, 1, 1);
                            this.S++;
                            this.l.setPosition(0);
                            trackOutput.sampleData(this.l, 8, 1);
                            this.S += 8;
                        }
                        if (z2) {
                            if (!this.W) {
                                extractorInput.readFully(this.g.getData(), 0, 1);
                                this.R++;
                                this.g.setPosition(0);
                                this.X = this.g.readUnsignedByte();
                                this.W = true;
                            }
                            int i7 = this.X * 4;
                            this.g.reset(i7);
                            extractorInput.readFully(this.g.getData(), 0, i7);
                            this.R += i7;
                            short s2 = (short) ((this.X / 2) + 1);
                            int i8 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.o;
                            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                                this.o = ByteBuffer.allocate(i8);
                            }
                            this.o.position(0);
                            this.o.putShort(s2);
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i3 = this.X;
                                if (i9 >= i3) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.g.readUnsignedIntToInt();
                                if (i9 % 2 == 0) {
                                    this.o.putShort((short) (readUnsignedIntToInt - i10));
                                } else {
                                    this.o.putInt(readUnsignedIntToInt - i10);
                                }
                                i9++;
                                i10 = readUnsignedIntToInt;
                            }
                            int i11 = (i2 - this.R) - i10;
                            if (i3 % 2 == 1) {
                                this.o.putInt(i11);
                            } else {
                                this.o.putShort((short) i11);
                                this.o.putInt(0);
                            }
                            this.m.reset(this.o.array(), i8);
                            trackOutput.sampleData(this.m, i8, 1);
                            this.S += i8;
                        }
                    }
                } else {
                    byte[] bArr = cVar.i;
                    if (bArr != null) {
                        this.j.reset(bArr, bArr.length);
                    }
                }
                if (cVar.f > 0) {
                    this.O |= 268435456;
                    this.n.reset(0);
                    this.g.reset(4);
                    this.g.getData()[0] = (byte) ((i2 >> 24) & 255);
                    this.g.getData()[1] = (byte) ((i2 >> 16) & 255);
                    this.g.getData()[2] = (byte) ((i2 >> 8) & 255);
                    this.g.getData()[3] = (byte) (i2 & 255);
                    trackOutput.sampleData(this.g, 4, 2);
                    this.S += 4;
                }
                this.U = true;
            }
            int limit = this.j.limit() + i2;
            if (!"V_MPEG4/ISO/AVC".equals(cVar.b) && !"V_MPEGH/ISO/HEVC".equals(cVar.b)) {
                if (cVar.T != null) {
                    Assertions.checkState(this.j.limit() == 0);
                    d dVar = cVar.T;
                    if (!dVar.b) {
                        extractorInput.peekFully(dVar.a, 0, 10);
                        extractorInput.resetPeekPosition();
                        if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(dVar.a) != 0) {
                            dVar.b = true;
                        }
                    }
                }
                while (true) {
                    int i12 = this.R;
                    if (i12 >= limit) {
                        break;
                    }
                    int i13 = i(extractorInput, trackOutput, limit - i12);
                    this.R += i13;
                    this.S += i13;
                }
            } else {
                byte[] data2 = this.f.getData();
                data2[0] = 0;
                data2[1] = 0;
                data2[2] = 0;
                int i14 = cVar.Y;
                int i15 = 4 - i14;
                while (this.R < limit) {
                    int i16 = this.T;
                    if (i16 == 0) {
                        int min = Math.min(i14, this.j.bytesLeft());
                        extractorInput.readFully(data2, i15 + min, i14 - min);
                        if (min > 0) {
                            this.j.readBytes(data2, i15, min);
                        }
                        this.R += i14;
                        this.f.setPosition(0);
                        this.T = this.f.readUnsignedIntToInt();
                        this.e.setPosition(0);
                        trackOutput.sampleData(this.e, 4);
                        this.S += 4;
                    } else {
                        int i17 = i(extractorInput, trackOutput, i16);
                        this.R += i17;
                        this.S += i17;
                        this.T -= i17;
                    }
                }
            }
            if ("A_VORBIS".equals(cVar.b)) {
                this.h.setPosition(0);
                trackOutput.sampleData(this.h, 4);
                this.S += 4;
            }
            int i18 = this.S;
            e();
            return i18;
        }
    }

    @CallSuper
    public int getElementType(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public final void h(ExtractorInput extractorInput, byte[] bArr, int i2) throws IOException {
        int length = bArr.length + i2;
        if (this.k.capacity() < length) {
            this.k.reset(Arrays.copyOf(bArr, length + i2));
        } else {
            System.arraycopy(bArr, 0, this.k.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.k.getData(), bArr.length, i2);
        this.k.reset(length);
    }

    public void handleBlockAddIDExtraData(c cVar, ExtractorInput extractorInput, int i2) throws IOException {
        int i3 = cVar.g;
        if (i3 == 1685485123 || i3 == 1685480259) {
            byte[] bArr = new byte[i2];
            cVar.N = bArr;
            extractorInput.readFully(bArr, 0, i2);
            return;
        }
        extractorInput.skipFully(i2);
    }

    public void handleBlockAdditionalData(c cVar, int i2, ExtractorInput extractorInput, int i3) throws IOException {
        if (i2 != 4 || !"V_VP9".equals(cVar.b)) {
            extractorInput.skipFully(i3);
            return;
        }
        this.n.reset(i3);
        extractorInput.readFully(this.n.getData(), 0, i3);
    }

    public final int i(ExtractorInput extractorInput, TrackOutput trackOutput, int i2) throws IOException {
        int bytesLeft = this.j.bytesLeft();
        if (bytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i2, false);
        }
        int min = Math.min(i2, bytesLeft);
        trackOutput.sampleData(this.j, min);
        return min;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.a0 = extractorOutput;
    }

    @CallSuper
    public void integerElement(int i2, long j2) throws ParserException {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case 131:
                        this.u.d = (int) j2;
                        return;
                    case 136:
                        c cVar = this.u;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        cVar.V = z2;
                        return;
                    case 155:
                        this.I = f(j2);
                        return;
                    case 159:
                        this.u.O = (int) j2;
                        return;
                    case 176:
                        this.u.m = (int) j2;
                        return;
                    case 179:
                        this.C.add(f(j2));
                        return;
                    case 186:
                        this.u.n = (int) j2;
                        return;
                    case 215:
                        this.u.c = (int) j2;
                        return;
                    case 231:
                        this.B = f(j2);
                        return;
                    case 238:
                        this.P = (int) j2;
                        return;
                    case 241:
                        if (!this.E) {
                            this.D.add(j2);
                            this.E = true;
                            return;
                        }
                        return;
                    case 251:
                        this.Q = true;
                        return;
                    case 16871:
                        this.u.g = (int) j2;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            throw new ParserException(a2.b.a.a.a.V2("ContentCompAlgo ", j2, " not supported"));
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            throw new ParserException(a2.b.a.a.a.V2("DocTypeReadVersion ", j2, " not supported"));
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            throw new ParserException(a2.b.a.a.a.V2("EBMLReadVersion ", j2, " not supported"));
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            throw new ParserException(a2.b.a.a.a.V2("ContentEncAlgo ", j2, " not supported"));
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            throw new ParserException(a2.b.a.a.a.V2("AESSettingsCipherMode ", j2, " not supported"));
                        }
                        return;
                    case 21420:
                        this.x = j2 + this.q;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            this.u.w = 0;
                            return;
                        } else if (i3 == 1) {
                            this.u.w = 2;
                            return;
                        } else if (i3 == 3) {
                            this.u.w = 1;
                            return;
                        } else if (i3 == 15) {
                            this.u.w = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.u.o = (int) j2;
                        return;
                    case 21682:
                        this.u.q = (int) j2;
                        return;
                    case 21690:
                        this.u.p = (int) j2;
                        return;
                    case 21930:
                        c cVar2 = this.u;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        cVar2.U = z2;
                        return;
                    case 21998:
                        this.u.f = (int) j2;
                        return;
                    case 22186:
                        this.u.R = j2;
                        return;
                    case 22203:
                        this.u.S = j2;
                        return;
                    case 25188:
                        this.u.P = (int) j2;
                        return;
                    case 30321:
                        int i4 = (int) j2;
                        if (i4 == 0) {
                            this.u.r = 0;
                            return;
                        } else if (i4 == 1) {
                            this.u.r = 1;
                            return;
                        } else if (i4 == 2) {
                            this.u.r = 2;
                            return;
                        } else if (i4 == 3) {
                            this.u.r = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        this.u.e = (int) j2;
                        return;
                    case 2807729:
                        this.r = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i5 = (int) j2;
                                if (i5 == 1) {
                                    this.u.A = 2;
                                    return;
                                } else if (i5 == 2) {
                                    this.u.A = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i6 = (int) j2;
                                if (i6 != 1) {
                                    if (i6 == 16) {
                                        this.u.z = 6;
                                        return;
                                    } else if (i6 == 18) {
                                        this.u.z = 7;
                                        return;
                                    } else if (!(i6 == 6 || i6 == 7)) {
                                        return;
                                    }
                                }
                                this.u.z = 3;
                                return;
                            case 21947:
                                c cVar3 = this.u;
                                cVar3.x = true;
                                int i7 = (int) j2;
                                if (i7 == 1) {
                                    cVar3.y = 1;
                                    return;
                                } else if (i7 == 9) {
                                    cVar3.y = 6;
                                    return;
                                } else if (i7 == 4 || i7 == 5 || i7 == 6 || i7 == 7) {
                                    cVar3.y = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.u.B = (int) j2;
                                return;
                            case 21949:
                                this.u.C = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                throw new ParserException(a2.b.a.a.a.V2("ContentEncodingScope ", j2, " not supported"));
            }
        } else if (j2 != 0) {
            throw new ParserException(a2.b.a.a.a.V2("ContentEncodingOrder ", j2, " not supported"));
        }
    }

    @CallSuper
    public boolean isLevel1Element(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0194, code lost:
        r2 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int read(com.google.android.exoplayer2.extractor.ExtractorInput r14, com.google.android.exoplayer2.extractor.PositionHolder r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 484
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    @CallSuper
    public void seek(long j2, long j3) {
        this.B = C.TIME_UNSET;
        this.G = 0;
        a2.j.b.b.u0.h.b bVar = (a2.j.b.b.u0.h.b) this.a;
        bVar.e = 0;
        bVar.b.clear();
        e eVar = bVar.c;
        eVar.b = 0;
        eVar.c = 0;
        e eVar2 = this.b;
        eVar2.b = 0;
        eVar2.c = 0;
        e();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            d dVar = this.c.valueAt(i2).T;
            if (dVar != null) {
                dVar.b = false;
                dVar.c = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        long a3;
        int i2;
        a2.j.b.b.u0.h.d dVar = new a2.j.b.b.u0.h.d();
        long length = extractorInput.getLength();
        long j2 = 1024;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j2 = length;
        }
        int i4 = (int) j2;
        extractorInput.peekFully(dVar.a.getData(), 0, 4);
        dVar.b = 4;
        for (long readUnsignedInt = dVar.a.readUnsignedInt(); readUnsignedInt != 440786851; readUnsignedInt = ((readUnsignedInt << 8) & -256) | ((long) (dVar.a.getData()[0] & 255))) {
            int i5 = dVar.b + 1;
            dVar.b = i5;
            if (i5 == i4) {
                return false;
            }
            extractorInput.peekFully(dVar.a.getData(), 0, 1);
        }
        long a4 = dVar.a(extractorInput);
        long j3 = (long) dVar.b;
        if (a4 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j3 + a4 >= length) {
            return false;
        }
        while (true) {
            int i6 = (((long) dVar.b) > (j3 + a4) ? 1 : (((long) dVar.b) == (j3 + a4) ? 0 : -1));
            if (i6 < 0) {
                if (dVar.a(extractorInput) == Long.MIN_VALUE || (a3 = dVar.a(extractorInput)) < 0 || a3 > 2147483647L) {
                    return false;
                }
                if (i2 != 0) {
                    int i7 = (int) a3;
                    extractorInput.advancePeekPosition(i7);
                    dVar.b += i7;
                }
            } else if (i6 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @CallSuper
    public void startMasterElement(int i2, long j2, long j3) throws ParserException {
        if (i2 == 160) {
            this.Q = false;
        } else if (i2 == 174) {
            this.u = new c(null);
        } else if (i2 == 187) {
            this.E = false;
        } else if (i2 == 19899) {
            this.w = -1;
            this.x = -1;
        } else if (i2 == 20533) {
            this.u.h = true;
        } else if (i2 == 21968) {
            this.u.x = true;
        } else if (i2 == 408125543) {
            long j4 = this.q;
            if (j4 == -1 || j4 == j2) {
                this.q = j2;
                this.p = j3;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i2 == 475249515) {
            this.C = new LongArray();
            this.D = new LongArray();
        } else if (i2 != 524531317 || this.v) {
        } else {
            if (!this.d || this.z == -1) {
                this.a0.seekMap(new SeekMap.Unseekable(this.t));
                this.v = true;
                return;
            }
            this.y = true;
        }
    }

    @CallSuper
    public void stringElement(int i2, String str) throws ParserException {
        if (i2 == 134) {
            this.u.b = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                this.u.a = str;
            } else if (i2 == 2274716) {
                this.u.W = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new ParserException(a2.b.a.a.a.e3("DocType ", str, " not supported"));
        }
    }

    public MatroskaExtractor(int i2) {
        a2.j.b.b.u0.h.b bVar = new a2.j.b.b.u0.h.b();
        this.q = -1;
        this.r = C.TIME_UNSET;
        this.s = C.TIME_UNSET;
        this.t = C.TIME_UNSET;
        this.z = -1;
        this.A = -1;
        this.B = C.TIME_UNSET;
        this.a = bVar;
        bVar.d = new b(null);
        this.d = (i2 & 1) == 0;
        this.b = new e();
        this.c = new SparseArray<>();
        this.g = new ParsableByteArray(4);
        this.h = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new ParsableByteArray(4);
        this.e = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.f = new ParsableByteArray(4);
        this.j = new ParsableByteArray();
        this.k = new ParsableByteArray();
        this.l = new ParsableByteArray(8);
        this.m = new ParsableByteArray();
        this.n = new ParsableByteArray();
        this.L = new int[1];
    }

    public static final class c {
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        @Nullable
        public byte[] N;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        @Nullable
        public d T;
        public boolean U;
        public boolean V = true;
        public String W = "eng";
        public TrackOutput X;
        public int Y;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public TrackOutput.CryptoData j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;

        public c() {
        }

        public c(a aVar) {
        }
    }
}
