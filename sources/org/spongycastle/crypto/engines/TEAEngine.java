package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class TEAEngine implements BlockCipher {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e = false;
    public boolean f;

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
        return "TEA";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f = z;
            this.e = true;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.a = a(key, 0);
                this.b = a(key, 4);
                this.c = a(key, 8);
                this.d = a(key, 12);
                return;
            }
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to TEA init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.e) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            int i3 = 0;
            if (this.f) {
                int a3 = a(bArr, i);
                int a4 = a(bArr, i + 4);
                int i4 = 0;
                while (i3 != 32) {
                    i4 -= 1640531527;
                    a3 += (((a4 << 4) + this.a) ^ (a4 + i4)) ^ ((a4 >>> 5) + this.b);
                    a4 += (((a3 << 4) + this.c) ^ (a3 + i4)) ^ ((a3 >>> 5) + this.d);
                    i3++;
                }
                b(a3, bArr2, i2);
                b(a4, bArr2, i2 + 4);
                return 8;
            }
            int a5 = a(bArr, i);
            int a6 = a(bArr, i + 4);
            int i5 = -957401312;
            while (i3 != 32) {
                a6 -= (((a5 << 4) + this.c) ^ (a5 + i5)) ^ ((a5 >>> 5) + this.d);
                a5 -= (((a6 << 4) + this.a) ^ (a6 + i5)) ^ ((a6 >>> 5) + this.b);
                i5 += 1640531527;
                i3++;
            }
            b(a5, bArr2, i2);
            b(a6, bArr2, i2 + 4);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
