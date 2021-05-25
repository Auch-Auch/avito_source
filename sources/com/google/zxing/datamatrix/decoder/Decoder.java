package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
public final class Decoder {
    public final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

    public DecoderResult decode(boolean[][] zArr) throws FormatException, ChecksumException {
        return decode(BitMatrix.parse(zArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:437:0x06a5, code lost:
        if (r5.length() <= 0) goto L_0x06aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x06a7, code lost:
        r4.append((java.lang.CharSequence) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:439:0x06aa, code lost:
        r2 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x06b5, code lost:
        if (r7.isEmpty() == false) goto L_0x06b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:441:0x06b7, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:443:0x06bb, code lost:
        return new com.google.zxing.common.DecoderResult(r0, r2, r7, null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x06a1 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x051a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix r23) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        // Method dump skipped, instructions count: 1780
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.Decoder.decode(com.google.zxing.common.BitMatrix):com.google.zxing.common.DecoderResult");
    }
}
