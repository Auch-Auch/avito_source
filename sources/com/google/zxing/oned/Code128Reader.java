package com.google.zxing.oned;
public final class Code128Reader extends OneDReader {
    public static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x017e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:116:0x01d3 */
    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: com.google.zxing.common.BitArray */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a3, code lost:
        if (r3 != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a5, code lost:
        r3 = false;
        r10 = false;
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0152, code lost:
        if (r3 != false) goto L_0x01a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01ad A[PHI: r19 
      PHI: (r19v12 boolean) = (r19v16 boolean), (r19v19 boolean) binds: [B:89:0x017e, B:67:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b7 A[PHI: r3 r18 r19 
      PHI: (r3v16 boolean) = (r3v7 boolean), (r3v17 boolean), (r3v20 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean), (r3v7 boolean) binds: [B:51:0x00f7, B:102:0x01ab, B:84:0x0174, B:89:0x017e, B:90:0x0182, B:94:0x018e, B:93:0x018a, B:79:0x015e, B:67:0x0132, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r18v5 boolean) = (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v6 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean), (r18v1 boolean) binds: [B:51:0x00f7, B:102:0x01ab, B:84:0x0174, B:89:0x017e, B:90:0x0182, B:94:0x018e, B:93:0x018a, B:79:0x015e, B:67:0x0132, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v11 boolean) = (r19v2 boolean), (r19v13 boolean), (r19v2 boolean), (r19v16 boolean), (r19v16 boolean), (r19v16 boolean), (r19v16 boolean), (r19v18 boolean), (r19v19 boolean), (r19v19 boolean), (r19v19 boolean), (r19v19 boolean) binds: [B:51:0x00f7, B:102:0x01ab, B:84:0x0174, B:89:0x017e, B:90:0x0182, B:94:0x018e, B:93:0x018a, B:79:0x015e, B:67:0x0132, B:68:0x0137, B:72:0x0144, B:71:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.zxing.oned.OneDReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r26, com.google.zxing.common.BitArray r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        // Method dump skipped, instructions count: 806
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
