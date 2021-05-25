package com.google.android.exoplayer2.extractor.amr;

import a2.j.b.b.u0.e.a;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
public final class AmrExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.a;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int[] p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] q;
    public static final byte[] r = Util.getUtf8Bytes("#!AMR\n");
    public static final byte[] s = Util.getUtf8Bytes("#!AMR-WB\n");
    public static final int t;
    public final byte[] a;
    public final int b;
    public boolean c;
    public long d;
    public int e;
    public int f;
    public boolean g;
    public long h;
    public int i;
    public int j;
    public long k;
    public ExtractorOutput l;
    public TrackOutput m;
    public SeekMap n;
    public boolean o;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        q = iArr;
        t = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        if ((!r0 && (r4 < 12 || r4 > 14)) != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.ExtractorInput r4) throws java.io.IOException {
        /*
            r3 = this;
            r4.resetPeekPosition()
            byte[] r0 = r3.a
            r1 = 0
            r2 = 1
            r4.peekFully(r0, r1, r2)
            byte[] r4 = r3.a
            byte r4 = r4[r1]
            r0 = r4 & 131(0x83, float:1.84E-43)
            if (r0 > 0) goto L_0x0070
            int r4 = r4 >> 3
            r0 = 15
            r4 = r4 & r0
            if (r4 < 0) goto L_0x003c
            if (r4 > r0) goto L_0x003c
            boolean r0 = r3.c
            if (r0 == 0) goto L_0x0029
            r2 = 10
            if (r4 < r2) goto L_0x0027
            r2 = 13
            if (r4 <= r2) goto L_0x0029
        L_0x0027:
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r2 != 0) goto L_0x003b
            if (r0 != 0) goto L_0x0038
            r0 = 12
            if (r4 < r0) goto L_0x0036
            r0 = 14
            if (r4 <= r0) goto L_0x0038
        L_0x0036:
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x003c
        L_0x003b:
            r1 = 1
        L_0x003c:
            if (r1 != 0) goto L_0x0062
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Illegal AMR "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            boolean r2 = r3.c
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = "WB"
            goto L_0x004f
        L_0x004d:
            java.lang.String r2 = "NB"
        L_0x004f:
            r1.append(r2)
            java.lang.String r2 = " frame type "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0062:
            boolean r0 = r3.c
            if (r0 == 0) goto L_0x006b
            int[] r0 = com.google.android.exoplayer2.extractor.amr.AmrExtractor.q
            r4 = r0[r4]
            goto L_0x006f
        L_0x006b:
            int[] r0 = com.google.android.exoplayer2.extractor.amr.AmrExtractor.p
            r4 = r0[r4]
        L_0x006f:
            return r4
        L_0x0070:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Invalid padding bits for frame header "
            java.lang.String r4 = a2.b.a.a.a.M2(r1, r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.amr.AmrExtractor.a(com.google.android.exoplayer2.extractor.ExtractorInput):int");
    }

    public final boolean b(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = r;
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.c = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        byte[] bArr3 = s;
        extractorInput.resetPeekPosition();
        byte[] bArr4 = new byte[bArr3.length];
        extractorInput.peekFully(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.c = true;
        extractorInput.skipFully(bArr3.length);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.l = extractorOutput;
        this.m = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput r13, com.google.android.exoplayer2.extractor.PositionHolder r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.amr.AmrExtractor.read(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):int");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        if (j2 != 0) {
            SeekMap seekMap = this.n;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.k = ((ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(j2);
                return;
            }
        }
        this.k = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return b(extractorInput);
    }

    public AmrExtractor(int i2) {
        this.b = i2;
        this.a = new byte[1];
        this.i = -1;
    }
}
