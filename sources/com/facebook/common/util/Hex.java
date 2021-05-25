package com.facebook.common.util;

import a2.b.a.a.a;
public class Hex {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = new char[256];
    public static final char[] c = new char[256];
    public static final byte[] d = new byte[103];

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = b;
            char[] cArr2 = a;
            cArr[i] = cArr2[(i >> 4) & 15];
            c[i] = cArr2[i & 15];
        }
        for (int i2 = 0; i2 <= 70; i2++) {
            d[i2] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            d[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = d;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String byte2Hex(int i) {
        if (i > 255 || i < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return String.valueOf(b[i]) + String.valueOf(c[i]);
    }

    public static byte[] decodeHex(String str) {
        byte[] bArr;
        byte b2;
        byte b3;
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr2 = new byte[(length >> 1)];
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i3 = i + 1;
                char charAt = str.charAt(i);
                if (charAt > 'f' || (b2 = (bArr = d)[charAt]) == -1) {
                    break;
                }
                int i4 = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 > 'f' || (b3 = bArr[charAt2]) == -1) {
                    break;
                }
                bArr2[i2] = (byte) ((b2 << 4) | b3);
                i2++;
                i = i4;
            }
            z = true;
            if (!z) {
                return bArr2;
            }
            throw new IllegalArgumentException(a.c3("Invalid hexadecimal digit: ", str));
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        int i;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && ((i = bArr[i2] & 255) != 0 || !z)) {
            int i4 = i3 + 1;
            cArr[i3] = b[i];
            i3 = i4 + 1;
            cArr[i4] = c[i];
            i2++;
        }
        return new String(cArr, 0, i3);
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(" ", ""));
    }
}
