package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class XTEAEngine implements BlockCipher {
    public int[] a = new int[4];
    public int[] b = new int[32];
    public int[] c = new int[32];
    public boolean d = false;
    public boolean e;

    public final int a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16);
        return (bArr[i3 + 1] & 255) | i4 | ((bArr[i3] & 255) << 8);
    }

    public final void b(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "XTEA";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.e = z;
            this.d = true;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                int i = 0;
                int i2 = 0;
                while (i < 4) {
                    this.a[i] = a(key, i2);
                    i++;
                    i2 += 4;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < 32; i4++) {
                    int[] iArr = this.b;
                    int[] iArr2 = this.a;
                    iArr[i4] = iArr2[i3 & 3] + i3;
                    i3 -= 1640531527;
                    this.c[i4] = iArr2[(i3 >>> 11) & 3] + i3;
                }
                return;
            }
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to TEA init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.d) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.e) {
            int a3 = a(bArr, i);
            int a4 = a(bArr, i + 4);
            for (int i3 = 0; i3 < 32; i3++) {
                a3 += (((a4 << 4) ^ (a4 >>> 5)) + a4) ^ this.b[i3];
                a4 += (((a3 << 4) ^ (a3 >>> 5)) + a3) ^ this.c[i3];
            }
            b(a3, bArr2, i2);
            b(a4, bArr2, i2 + 4);
            return 8;
        } else {
            int a5 = a(bArr, i);
            int a6 = a(bArr, i + 4);
            for (int i4 = 31; i4 >= 0; i4--) {
                a6 -= (((a5 << 4) ^ (a5 >>> 5)) + a5) ^ this.c[i4];
                a5 -= (((a6 << 4) ^ (a6 >>> 5)) + a6) ^ this.b[i4];
            }
            b(a5, bArr2, i2);
            b(a6, bArr2, i2 + 4);
            return 8;
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
