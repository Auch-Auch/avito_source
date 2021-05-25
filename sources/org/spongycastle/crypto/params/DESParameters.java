package org.spongycastle.crypto.params;

import com.google.common.base.Ascii;
public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    public static byte[] b = {1, 1, 1, 1, 1, 1, 1, 1, Ascii.US, Ascii.US, Ascii.US, Ascii.US, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.SO, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, Ascii.US, -32, Ascii.US, -32, Ascii.SO, -15, Ascii.SO, -15, 1, -32, 1, -32, 1, -15, 1, -15, Ascii.US, -2, Ascii.US, -2, Ascii.SO, -2, Ascii.SO, -2, 1, Ascii.US, 1, Ascii.US, 1, Ascii.SO, 1, Ascii.SO, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, Ascii.US, -32, Ascii.US, -15, Ascii.SO, -15, Ascii.SO, -32, 1, -32, 1, -15, 1, -15, 1, -2, Ascii.US, -2, Ascii.US, -2, Ascii.SO, -2, Ascii.SO, Ascii.US, 1, Ascii.US, 1, Ascii.SO, 1, Ascii.SO, 1, -2, -32, -2, -32, -2, -15, -2, -15};

    public DESParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    public static boolean isWeakKey(byte[] bArr, int i) {
        if (bArr.length - i >= 8) {
            for (int i2 = 0; i2 < 16; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if (bArr[i3 + i] != b[(i2 * 8) + i3]) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("key material too short.");
    }

    public static void setOddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            bArr[i] = (byte) (((((b2 >> 7) ^ ((((((b2 >> 1) ^ (b2 >> 2)) ^ (b2 >> 3)) ^ (b2 >> 4)) ^ (b2 >> 5)) ^ (b2 >> 6))) ^ 1) & 1) | (b2 & 254));
        }
    }
}
