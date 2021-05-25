package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.TrackOutput;
public final class TrackEncryptionBox {
    public final TrackOutput.CryptoData cryptoData;
    @Nullable
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    @Nullable
    public final String schemeType;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r6.equals(com.google.android.exoplayer2.C.CENC_TYPE_cbc1) == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TrackEncryptionBox(boolean r5, @androidx.annotation.Nullable java.lang.String r6, int r7, byte[] r8, int r9, int r10, @androidx.annotation.Nullable byte[] r11) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x0009
            r2 = 1
            goto L_0x000a
        L_0x0009:
            r2 = 0
        L_0x000a:
            if (r11 != 0) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            r2 = r2 ^ r3
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            r4.isEncrypted = r5
            r4.schemeType = r6
            r4.perSampleIvSize = r7
            r4.defaultInitializationVector = r11
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData r5 = new com.google.android.exoplayer2.extractor.TrackOutput$CryptoData
            r7 = 2
            if (r6 != 0) goto L_0x0021
            goto L_0x0075
        L_0x0021:
            r11 = -1
            int r2 = r6.hashCode()
            switch(r2) {
                case 3046605: goto L_0x004c;
                case 3046671: goto L_0x0041;
                case 3049879: goto L_0x0036;
                case 3049895: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r0 = -1
            goto L_0x0055
        L_0x002b:
            java.lang.String r0 = "cens"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r0 = 3
            goto L_0x0055
        L_0x0036:
            java.lang.String r0 = "cenc"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r0 = 2
            goto L_0x0055
        L_0x0041:
            java.lang.String r0 = "cbcs"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r0 = 1
            goto L_0x0055
        L_0x004c:
            java.lang.String r2 = "cbc1"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x0055
            goto L_0x0029
        L_0x0055:
            switch(r0) {
                case 0: goto L_0x0074;
                case 1: goto L_0x0074;
                case 2: goto L_0x0075;
                case 3: goto L_0x0075;
                default: goto L_0x0058;
            }
        L_0x0058:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "Unsupported protection scheme type '"
            r7.append(r11)
            r7.append(r6)
            java.lang.String r6 = "'. Assuming AES-CTR crypto mode."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "TrackEncryptionBox"
            com.google.android.exoplayer2.util.Log.w(r7, r6)
            goto L_0x0075
        L_0x0074:
            r1 = 2
        L_0x0075:
            r5.<init>(r1, r8, r9, r10)
            r4.cryptoData = r5
            return
            switch-data {3046605->0x004c, 3046671->0x0041, 3049879->0x0036, 3049895->0x002b, }
            switch-data {0->0x0074, 1->0x0074, 2->0x0075, 3->0x0075, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
