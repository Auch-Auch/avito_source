package x6.e.f.a.b;

import androidx.appcompat.app.AppCompatDelegateImpl;
import kotlin.UShort;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class a {
    public static void a(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            sArr3[i] = AppCompatDelegateImpl.i.k((short) (sArr[i] + sArr2[i]));
        }
    }

    public static int b(int[] iArr, int i, int i2, int i3) {
        int i4 = (i3 * 2730) >> 25;
        int i5 = i4 - ((12288 - (i3 - (i4 * 12289))) >> 31);
        iArr[i] = (i5 >> 1) + (i5 & 1);
        int i6 = i5 - 1;
        iArr[i2] = (i6 >> 1) + (i6 & 1);
        int i7 = i3 - ((iArr[i] * 2) * 12289);
        int i8 = i7 >> 31;
        return (i7 ^ i8) - i8;
    }

    public static void c(short[] sArr, byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 7;
            int i3 = bArr[i2 + 1] & 255;
            int i4 = bArr[i2 + 3] & 255;
            int i5 = bArr[i2 + 5] & 255;
            int i6 = i * 4;
            sArr[i6 + 0] = (short) ((bArr[i2 + 0] & 255) | ((i3 & 63) << 8));
            sArr[i6 + 1] = (short) ((i3 >>> 6) | ((bArr[i2 + 2] & 255) << 2) | ((i4 & 15) << 10));
            sArr[i6 + 2] = (short) ((i4 >>> 4) | ((bArr[i2 + 4] & 255) << 4) | ((i5 & 3) << 12));
            sArr[i6 + 3] = (short) (((bArr[i2 + 6] & 255) << 6) | (i5 >>> 2));
        }
    }

    public static void d(short[] sArr) {
        for (int i = 0; i < 1024; i++) {
            short s = b.a[i];
            if (i < s) {
                short s2 = sArr[i];
                sArr[i] = sArr[s];
                sArr[s] = s2;
            }
        }
        b.a(sArr, c.b);
        b.b(sArr, c.d);
    }

    public static int e(int i) {
        int i2 = (i * 2730) >> 27;
        int i3 = i2 - ((CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA - (i - (CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA * i2))) >> 31);
        int i4 = (((i3 >> 1) + (i3 & 1)) * 98312) - i;
        int i5 = i4 >> 31;
        return (i4 ^ i5) - i5;
    }

    public static void f(short[] sArr, byte[] bArr, byte b) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[4096];
        AppCompatDelegateImpl.i.E1(bArr, bArr2, bArr3, 0, 4096);
        for (int i = 0; i < 1024; i++) {
            int bigEndianToInt = Pack.bigEndianToInt(bArr3, i * 4);
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 += (bigEndianToInt >> i3) & 16843009;
            }
            sArr[i] = (short) (((((i2 >>> 24) + (i2 >>> 0)) & 255) + 12289) - (((i2 >>> 16) + (i2 >>> 8)) & 255));
        }
    }

    public static short g(short s) {
        short k = AppCompatDelegateImpl.i.k(s);
        int i = k - 12289;
        return (short) (((k ^ i) & (i >> 31)) ^ i);
    }

    public static void h(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            sArr3[i] = AppCompatDelegateImpl.i.k1((sArr[i] & UShort.MAX_VALUE) * (65535 & AppCompatDelegateImpl.i.k1((sArr2[i] & UShort.MAX_VALUE) * 3186)));
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0023: APUT  
      (r1v1 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x0022: ARITH  (r4v3 int) = (wrap: int : 0x0015: ARITH  (r4v2 int) = (wrap: int : 0x0010: ARITH  (r4v1 int) = (wrap: short : 0x000e: AGET  (r4v0 short A[IMMUTABLE_TYPE]) = (r11v0 short[] A[IMMUTABLE_TYPE]), (r3v1 int)) * (8 short)) + (196624 int)) - (wrap: int : 0x0020: ARITH  (r3v5 int) = (wrap: int : 0x001f: ARITH  (r3v4 int) = (wrap: int : 0x0019: ARITH  (r3v3 int) = (wrap: short : 0x0016: AGET  (r3v2 short A[IMMUTABLE_TYPE]) = (r12v0 short[] A[IMMUTABLE_TYPE]), (r3v1 int)) * (2 short)) + (wrap: short : 0x001d: AGET  (r8v0 short A[IMMUTABLE_TYPE]) = (r12v0 short[] A[IMMUTABLE_TYPE]), (r7v0 int))) * (12289 int)))
     */
    public static void i(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.fill(bArr, (byte) 0);
        int[] iArr = new int[4];
        for (int i = 0; i < 256; i++) {
            int i2 = i + 0;
            int i3 = i + 768;
            iArr[0] = ((sArr[i2] * 8) + 196624) - (((sArr2[i2] * 2) + sArr2[i3]) * 12289);
            int i4 = i + 256;
            iArr[1] = ((sArr[i4] * 8) + 196624) - (((sArr2[i4] * 2) + sArr2[i3]) * 12289);
            int i5 = i + 512;
            iArr[2] = ((sArr[i5] * 8) + 196624) - (((sArr2[i5] * 2) + sArr2[i3]) * 12289);
            iArr[3] = ((sArr[i3] * 8) + 196624) - (sArr2[i3] * 12289);
            int i6 = i >>> 3;
            byte b = bArr[i6];
            int i7 = iArr[0];
            int i8 = iArr[1];
            int i9 = iArr[2];
            int i10 = iArr[3];
            int e = e(i7);
            bArr[i6] = (byte) ((((short) (((e(i10) + (e(i9) + (e(i8) + e))) - 98312) >>> 31)) << (i & 7)) | b);
        }
    }

    public static void j(byte[] bArr, short[] sArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            short g = g(sArr[i2 + 0]);
            short g2 = g(sArr[i2 + 1]);
            short g3 = g(sArr[i2 + 2]);
            short g4 = g(sArr[i2 + 3]);
            int i3 = i * 7;
            bArr[i3 + 0] = (byte) g;
            bArr[i3 + 1] = (byte) ((g >> 8) | (g2 << 6));
            bArr[i3 + 2] = (byte) (g2 >> 2);
            bArr[i3 + 3] = (byte) ((g2 >> 10) | (g3 << 4));
            bArr[i3 + 4] = (byte) (g3 >> 4);
            bArr[i3 + 5] = (byte) ((g3 >> 12) | (g4 << 2));
            bArr[i3 + 6] = (byte) (g4 >> 6);
        }
    }

    public static void k(short[] sArr) {
        b.b(sArr, c.c);
        b.a(sArr, c.a);
    }
}
