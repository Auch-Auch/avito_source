package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
public class GOST28147Engine implements BlockCipher {
    public static final int BLOCK_SIZE = 8;
    public static byte[] d = {4, 10, 9, 2, Ascii.CR, 8, 0, Ascii.SO, 6, Ascii.VT, 1, Ascii.FF, 7, Ascii.SI, 5, 3, Ascii.SO, Ascii.VT, 4, Ascii.FF, 6, Ascii.CR, Ascii.SI, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, Ascii.CR, 10, 3, 4, 2, Ascii.SO, Ascii.SI, Ascii.FF, 7, 6, 0, 9, Ascii.VT, 7, Ascii.CR, 10, 1, 0, 8, 9, Ascii.SI, Ascii.SO, 4, 6, Ascii.FF, Ascii.VT, 2, 5, 3, 6, Ascii.FF, 7, 1, 5, Ascii.SI, Ascii.CR, 8, 4, 10, 9, Ascii.SO, 0, 3, Ascii.VT, 2, 4, Ascii.VT, 10, 0, 7, 2, 1, Ascii.CR, 3, 6, 8, 5, 9, Ascii.FF, Ascii.SI, Ascii.SO, Ascii.CR, Ascii.VT, 4, 1, 3, Ascii.SI, 5, 9, 0, 10, Ascii.SO, 7, 6, 8, 2, Ascii.FF, 1, Ascii.SI, Ascii.CR, 0, 5, 7, 10, 4, 9, 2, 3, Ascii.SO, 6, Ascii.VT, 8, Ascii.FF};
    public static byte[] e = {4, 2, Ascii.SI, 5, 9, 1, 0, 8, Ascii.SO, 3, Ascii.VT, Ascii.FF, Ascii.CR, 7, 10, 6, Ascii.FF, 9, Ascii.SI, Ascii.SO, 8, 1, 3, 10, 2, 7, 4, Ascii.CR, 6, 0, Ascii.VT, 5, Ascii.CR, 8, Ascii.SO, Ascii.FF, 7, 3, 9, 10, 1, 5, 2, 4, 6, Ascii.SI, 0, Ascii.VT, Ascii.SO, 9, Ascii.VT, 2, 5, Ascii.SI, 7, 1, 0, Ascii.CR, Ascii.FF, 6, 10, 4, 3, 8, 3, Ascii.SO, 5, 9, 6, 8, 0, Ascii.CR, 10, Ascii.VT, 7, Ascii.FF, 2, 1, Ascii.SI, 4, 8, Ascii.SI, 6, Ascii.VT, 1, 9, Ascii.FF, 5, Ascii.CR, 3, 7, 10, 0, Ascii.SO, 2, 4, 9, Ascii.VT, Ascii.FF, 0, 3, 6, 7, 5, 4, 8, Ascii.SO, Ascii.SI, 1, 10, 2, Ascii.CR, Ascii.FF, 6, 5, 2, Ascii.VT, 0, 9, Ascii.CR, 3, Ascii.SO, 7, 10, Ascii.SI, 4, 1, 8};
    public static byte[] f = {9, 6, 3, 2, 8, Ascii.VT, 1, 7, 10, 4, Ascii.SO, Ascii.SI, Ascii.FF, 0, Ascii.CR, 5, 3, 7, Ascii.SO, 9, 8, 10, Ascii.SI, 0, 5, 2, 6, Ascii.FF, Ascii.VT, 4, Ascii.CR, 1, Ascii.SO, 4, 6, 2, Ascii.VT, 3, Ascii.CR, 8, Ascii.FF, Ascii.SI, 5, 10, 0, 7, 1, 9, Ascii.SO, 7, 10, Ascii.FF, Ascii.CR, 1, 3, 9, 0, 2, Ascii.VT, 4, Ascii.SI, 8, 5, 6, Ascii.VT, 5, 1, 9, 8, Ascii.CR, Ascii.SI, 0, Ascii.SO, 4, 2, 3, Ascii.FF, 7, 10, 6, 3, 10, Ascii.CR, Ascii.FF, 1, 2, 0, Ascii.VT, 7, 5, 9, 4, 8, Ascii.SI, Ascii.SO, 6, 1, Ascii.CR, 2, 9, 7, 10, 6, 0, 8, Ascii.FF, 4, 5, Ascii.SI, 3, Ascii.VT, Ascii.SO, Ascii.VT, 10, Ascii.SI, 5, 0, Ascii.FF, Ascii.SO, 8, 6, 2, 3, 9, 1, 7, Ascii.CR, 4};
    public static byte[] g = {8, 4, Ascii.VT, 1, 3, 5, 0, 9, 2, Ascii.SO, 10, Ascii.FF, Ascii.CR, 6, 7, Ascii.SI, 0, 1, 2, 10, 4, Ascii.CR, 5, Ascii.FF, 9, 7, 3, Ascii.SI, Ascii.VT, 8, 6, Ascii.SO, Ascii.SO, Ascii.FF, 0, 10, 9, 2, Ascii.CR, Ascii.VT, 7, 5, 8, Ascii.SI, 3, 6, 1, 4, 7, 5, 0, Ascii.CR, Ascii.VT, 6, 1, 2, 3, 10, Ascii.FF, Ascii.SI, 4, Ascii.SO, 9, 8, 2, 7, Ascii.FF, Ascii.SI, 9, 5, 10, Ascii.VT, 1, 4, 0, Ascii.CR, 6, 8, Ascii.SO, 3, 8, 3, 2, 6, 4, Ascii.CR, Ascii.SO, Ascii.VT, Ascii.FF, 1, 7, Ascii.SI, 10, 0, 9, 5, 5, 2, 10, Ascii.VT, 9, 1, Ascii.FF, 3, 7, 4, Ascii.CR, 0, 6, Ascii.SI, 8, Ascii.SO, 0, 4, Ascii.VT, Ascii.SO, 8, 3, 7, 1, 10, 2, 9, 6, Ascii.SI, Ascii.CR, 5, Ascii.FF};
    public static byte[] h = {1, Ascii.VT, Ascii.FF, 2, 9, Ascii.CR, 0, Ascii.SI, 4, 5, 8, Ascii.SO, 10, 7, 6, 3, 0, 1, 7, Ascii.CR, Ascii.VT, 4, 5, 2, 8, Ascii.SO, Ascii.SI, Ascii.FF, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, Ascii.SI, 10, 3, 7, Ascii.FF, Ascii.CR, 6, Ascii.SO, 1, Ascii.VT, 3, 6, 0, 1, 5, Ascii.CR, 10, 8, Ascii.VT, 2, 9, 7, Ascii.SO, Ascii.SI, Ascii.FF, 4, 8, Ascii.CR, Ascii.VT, 0, 4, 5, 1, 2, 9, 3, Ascii.FF, Ascii.SO, 6, Ascii.SI, 10, 7, Ascii.FF, 9, Ascii.VT, 1, 8, Ascii.SO, 2, 4, 7, 3, 6, 5, 10, 0, Ascii.SI, Ascii.CR, 10, 9, 6, 8, Ascii.CR, Ascii.SO, 2, 0, Ascii.SI, 3, 5, Ascii.VT, 4, 1, Ascii.FF, 7, 7, 4, 0, 5, 10, 2, Ascii.SI, Ascii.SO, Ascii.FF, 6, 1, Ascii.VT, Ascii.CR, 9, 3, 8};
    public static byte[] i = {Ascii.SI, Ascii.FF, 2, 10, 6, 4, 5, 0, 7, 9, Ascii.SO, Ascii.CR, 1, Ascii.VT, 8, 3, Ascii.VT, 6, 3, 4, Ascii.FF, Ascii.SI, Ascii.SO, 2, 7, Ascii.CR, 8, 0, 5, 10, 9, 1, 1, Ascii.FF, Ascii.VT, 0, Ascii.SI, Ascii.SO, 6, 5, 10, Ascii.CR, 4, 8, 9, 3, 7, 2, 1, 5, Ascii.SO, Ascii.FF, 10, 7, 0, Ascii.CR, 6, 2, Ascii.VT, 4, 9, 3, Ascii.SI, 8, 0, Ascii.FF, 8, 9, Ascii.CR, 2, 10, Ascii.VT, 7, 3, 6, 5, 4, Ascii.SO, Ascii.SI, 1, 8, 0, Ascii.SI, 3, 2, 5, Ascii.SO, Ascii.VT, 1, 10, 4, 7, Ascii.FF, 9, Ascii.CR, 6, 3, 0, 6, Ascii.SI, 1, Ascii.SO, 9, 2, Ascii.CR, 8, Ascii.FF, 4, Ascii.VT, 10, 5, 7, 1, 10, 6, 8, Ascii.SI, Ascii.VT, 0, 4, Ascii.FF, 3, 5, 9, 7, Ascii.CR, 2, Ascii.SO};
    public static byte[] j = {4, 10, 9, 2, Ascii.CR, 8, 0, Ascii.SO, 6, Ascii.VT, 1, Ascii.FF, 7, Ascii.SI, 5, 3, Ascii.SO, Ascii.VT, 4, Ascii.FF, 6, Ascii.CR, Ascii.SI, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, Ascii.CR, 10, 3, 4, 2, Ascii.SO, Ascii.SI, Ascii.FF, 7, 6, 0, 9, Ascii.VT, 7, Ascii.CR, 10, 1, 0, 8, 9, Ascii.SI, Ascii.SO, 4, 6, Ascii.FF, Ascii.VT, 2, 5, 3, 6, Ascii.FF, 7, 1, 5, Ascii.SI, Ascii.CR, 8, 4, 10, 9, Ascii.SO, 0, 3, Ascii.VT, 2, 4, Ascii.VT, 10, 0, 7, 2, 1, Ascii.CR, 3, 6, 8, 5, 9, Ascii.FF, Ascii.SI, Ascii.SO, Ascii.CR, Ascii.VT, 4, 1, 3, Ascii.SI, 5, 9, 0, 10, Ascii.SO, 7, 6, 8, 2, Ascii.FF, 1, Ascii.SI, Ascii.CR, 0, 5, 7, 10, 4, 9, 2, 3, Ascii.SO, 6, Ascii.VT, 8, Ascii.FF};
    public static byte[] k = {10, 4, 5, 6, 8, 1, 3, 7, Ascii.CR, Ascii.FF, Ascii.SO, 0, 9, 2, Ascii.VT, Ascii.SI, 5, Ascii.SI, 4, 0, 2, Ascii.CR, Ascii.VT, 9, 1, 7, 6, 3, Ascii.FF, Ascii.SO, 10, 8, 7, Ascii.SI, Ascii.FF, Ascii.SO, 9, 4, 1, 0, 3, Ascii.VT, 5, 2, 6, 10, 8, Ascii.CR, 4, 10, 7, Ascii.FF, 0, Ascii.SI, 2, 8, Ascii.SO, 1, 6, 5, Ascii.CR, Ascii.VT, 9, 3, 7, 6, 4, Ascii.VT, 9, Ascii.FF, 2, 10, 1, 8, 0, Ascii.SO, Ascii.SI, Ascii.CR, 3, 5, 7, 6, 2, 4, Ascii.CR, 9, Ascii.SI, 0, 10, 1, 5, Ascii.VT, 8, Ascii.SO, Ascii.FF, 3, Ascii.CR, Ascii.SO, 4, 1, 7, 0, 5, 10, 3, Ascii.FF, 8, Ascii.SI, 6, 2, 9, Ascii.VT, 1, 3, 10, 9, 5, Ascii.VT, 4, Ascii.SI, 8, 6, 7, Ascii.SO, Ascii.CR, 0, 2, Ascii.FF};
    public static Hashtable l = new Hashtable();
    public int[] a = null;
    public boolean b;
    public byte[] c = d;

    static {
        b("Default", d);
        b("E-TEST", e);
        b("E-A", f);
        b("E-B", g);
        b("E-C", h);
        b("E-D", i);
        b("D-TEST", j);
        b("D-A", k);
    }

    public static void b(String str, byte[] bArr) {
        l.put(Strings.toUpperCase(str), bArr);
    }

    public static byte[] getSBox(String str) {
        byte[] bArr = (byte[]) l.get(Strings.toUpperCase(str));
        if (bArr != null) {
            return Arrays.clone(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"D-Test\", \"D-A\".");
    }

    public static String getSBoxName(byte[] bArr) {
        Enumeration keys = l.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (Arrays.areEqual((byte[]) l.get(str), bArr)) {
                return str;
            }
        }
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }

    public final int a(int i2, int i3) {
        int i4 = i3 + i2;
        byte[] bArr = this.c;
        int i5 = (bArr[((i4 >> 0) & 15) + 0] << 0) + (bArr[((i4 >> 4) & 15) + 16] << 4) + (bArr[((i4 >> 8) & 15) + 32] << 8) + (bArr[((i4 >> 12) & 15) + 48] << Ascii.FF) + (bArr[((i4 >> 16) & 15) + 64] << Ascii.DLE) + (bArr[((i4 >> 20) & 15) + 80] << Ascii.DC4) + (bArr[((i4 >> 24) & 15) + 96] << Ascii.CAN) + (bArr[((i4 >> 28) & 15) + 112] << Ascii.FS);
        return (i5 << 11) | (i5 >>> 21);
    }

    public final int c(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr[i2 + 2] << Ascii.DLE) & 16711680) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public final int[] d(boolean z, byte[] bArr) {
        this.b = z;
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i2 = 0; i2 != 8; i2++) {
                iArr[i2] = c(bArr, i2 * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public final void e(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >>> 24);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3] = (byte) i2;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST28147";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            byte[] sBox = parametersWithSBox.getSBox();
            if (sBox.length == d.length) {
                this.c = Arrays.clone(sBox);
                if (parametersWithSBox.getParameters() != null) {
                    this.a = d(z, ((KeyParameter) parametersWithSBox.getParameters()).getKey());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
        } else if (cipherParameters instanceof KeyParameter) {
            this.a = d(z, ((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to GOST28147 init - ")));
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int[] iArr = this.a;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        } else if (i2 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + 8 <= bArr2.length) {
            int c2 = c(bArr, i2);
            int c3 = c(bArr, i2 + 4);
            int i6 = 7;
            if (this.b) {
                for (int i7 = 0; i7 < 3; i7++) {
                    int i8 = 0;
                    while (i8 < 8) {
                        i8++;
                        c2 = c3 ^ a(c2, iArr[i8]);
                        c3 = c2;
                    }
                }
                i4 = c3;
                i5 = c2;
                while (i6 > 0) {
                    int a3 = i4 ^ a(i5, iArr[i6]);
                    i6--;
                    i4 = i5;
                    i5 = a3;
                }
            } else {
                int i9 = 0;
                while (i9 < 8) {
                    i9++;
                    c2 = c3 ^ a(c2, iArr[i9]);
                    c3 = c2;
                }
                i4 = c3;
                i5 = c2;
                int i10 = 0;
                while (i10 < 3) {
                    int i11 = 7;
                    while (i11 >= 0 && (i10 != 2 || i11 != 0)) {
                        int a4 = i4 ^ a(i5, iArr[i11]);
                        i11--;
                        i4 = i5;
                        i5 = a4;
                    }
                    i10++;
                }
            }
            e(i5, bArr2, i3);
            e(i4 ^ a(i5, iArr[0]), bArr2, i3 + 4);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
