package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
public final class AztecWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    @Override // com.google.zxing.Writer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r7, com.google.zxing.BarcodeFormat r8, int r9, int r10, java.util.Map<com.google.zxing.EncodeHintType, ?> r11) {
        /*
            r6 = this;
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.ISO_8859_1
            r1 = 33
            if (r11 == 0) goto L_0x0043
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r3 = r11.containsKey(r2)
            if (r3 == 0) goto L_0x001a
            java.lang.Object r0 = r11.get(r2)
            java.lang.String r0 = r0.toString()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
        L_0x001a:
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            boolean r3 = r11.containsKey(r2)
            if (r3 == 0) goto L_0x002e
            java.lang.Object r1 = r11.get(r2)
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
        L_0x002e:
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.AZTEC_LAYERS
            boolean r3 = r11.containsKey(r2)
            if (r3 == 0) goto L_0x0043
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = r11.toString()
            int r11 = java.lang.Integer.parseInt(r11)
            goto L_0x0044
        L_0x0043:
            r11 = 0
        L_0x0044:
            com.google.zxing.BarcodeFormat r2 = com.google.zxing.BarcodeFormat.AZTEC
            if (r8 != r2) goto L_0x009c
            byte[] r7 = r7.getBytes(r0)
            com.google.zxing.aztec.encoder.AztecCode r7 = com.google.zxing.aztec.encoder.Encoder.encode(r7, r1, r11)
            com.google.zxing.common.BitMatrix r7 = r7.getMatrix()
            if (r7 == 0) goto L_0x0096
            int r8 = r7.getWidth()
            int r11 = r7.getHeight()
            int r9 = java.lang.Math.max(r9, r8)
            int r10 = java.lang.Math.max(r10, r11)
            int r0 = r9 / r8
            int r1 = r10 / r11
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 2
            int r1 = a2.b.a.a.a.n2(r8, r0, r9, r1)
            r2 = 2
            int r2 = a2.b.a.a.a.n2(r11, r0, r10, r2)
            com.google.zxing.common.BitMatrix r3 = new com.google.zxing.common.BitMatrix
            r3.<init>(r9, r10)
            r9 = 0
        L_0x007e:
            if (r9 >= r11) goto L_0x0095
            r10 = 0
            r4 = r1
        L_0x0082:
            if (r10 >= r8) goto L_0x0091
            boolean r5 = r7.get(r10, r9)
            if (r5 == 0) goto L_0x008d
            r3.setRegion(r4, r2, r0, r0)
        L_0x008d:
            int r10 = r10 + 1
            int r4 = r4 + r0
            goto L_0x0082
        L_0x0091:
            int r9 = r9 + 1
            int r2 = r2 + r0
            goto L_0x007e
        L_0x0095:
            return r3
        L_0x0096:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x009c:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "Can only encode AZTEC, but got "
            java.lang.String r8 = r9.concat(r8)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
