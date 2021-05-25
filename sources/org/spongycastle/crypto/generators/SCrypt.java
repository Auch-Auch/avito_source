package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.engines.Salsa20Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class SCrypt {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        System.arraycopy(iArr, iArr.length - 16, iArr2, 0, 16);
        int length = iArr.length >>> 1;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = i * 2; i4 > 0; i4--) {
            f(iArr2, iArr, i2, iArr3);
            Salsa20Engine.salsaCore(8, iArr3, iArr2);
            System.arraycopy(iArr2, 0, iArr4, i3, 16);
            i3 = (length + i2) - i3;
            i2 += 16;
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
    }

    public static void b(int[] iArr) {
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    public static void c(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            b(iArr2);
        }
    }

    public static void d(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 * 32;
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[][] iArr6 = new int[i2][];
        try {
            System.arraycopy(iArr, i, iArr5, 0, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                iArr6[i5] = Arrays.clone(iArr5);
                a(iArr5, iArr2, iArr3, iArr4, i3);
            }
            int i6 = i2 - 1;
            for (int i7 = 0; i7 < i2; i7++) {
                f(iArr5, iArr6[iArr5[i4 - 16] & i6], 0, iArr5);
                a(iArr5, iArr2, iArr3, iArr4, i3);
            }
            System.arraycopy(iArr5, 0, iArr, i, i4);
            c(iArr6);
            c(new int[][]{iArr5, iArr2, iArr3, iArr4});
        } catch (Throwable th) {
            c(iArr6);
            c(new int[][]{iArr5, iArr2, iArr3, iArr4});
            throw th;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        pKCS5S2ParametersGenerator.init(bArr, bArr2, 1);
        return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedMacParameters(i * 8)).getKey();
    }

    public static void f(int[] iArr, int[] iArr2, int i, int[] iArr3) {
        for (int length = iArr3.length - 1; length >= 0; length--) {
            iArr3[length] = iArr[length] ^ iArr2[i + length];
        }
    }

    public static byte[] generate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        if (bArr == null) {
            throw new IllegalArgumentException("Passphrase P must be provided.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Salt S must be provided.");
        } else if (i <= 1) {
            throw new IllegalArgumentException("Cost parameter N must be > 1.");
        } else if (i2 == 1 && i > 65536) {
            throw new IllegalArgumentException("Cost parameter N must be > 1 and < 65536.");
        } else if (i2 >= 1) {
            int i5 = i2 * 128;
            int i6 = Integer.MAX_VALUE / (i5 * 8);
            if (i3 < 1 || i3 > i6) {
                throw new IllegalArgumentException(a.S2("Parallelisation parameter p must be >= 1 and <= ", i6, " (based on block size r of ", i2, ")"));
            } else if (i4 >= 1) {
                byte[] e = e(bArr, bArr2, i3 * i5);
                try {
                    int length = e.length >>> 2;
                    int[] iArr = new int[length];
                    Pack.littleEndianToInt(e, 0, iArr);
                    int i7 = i5 >>> 2;
                    for (int i8 = 0; i8 < length; i8 += i7) {
                        d(iArr, i8, i, i2);
                    }
                    Pack.intToLittleEndian(iArr, e, 0);
                    byte[] e2 = e(bArr, e, i4);
                    Arrays.fill(e, (byte) 0);
                    b(iArr);
                    return e2;
                } catch (Throwable th) {
                    if (e != null) {
                        Arrays.fill(e, (byte) 0);
                    }
                    b(null);
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("Generated key length dkLen must be >= 1.");
            }
        } else {
            throw new IllegalArgumentException("Block size r must be >= 1.");
        }
    }
}
