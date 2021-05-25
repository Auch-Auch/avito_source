package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class NoekeonEngine implements BlockCipher {
    public static final int[] f = {0, 0, 0, 0};
    public static final int[] g = {128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212};
    public int[] a = new int[4];
    public int[] b = new int[4];
    public int[] c = new int[4];
    public boolean d = false;
    public boolean e;

    public final int a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16);
        return (bArr[i3 + 1] & 255) | i4 | ((bArr[i3] & 255) << 8);
    }

    public final void b(int[] iArr) {
        iArr[1] = iArr[1] ^ ((~iArr[3]) & (~iArr[2]));
        iArr[0] = iArr[0] ^ (iArr[2] & iArr[1]);
        int i = iArr[3];
        iArr[3] = iArr[0];
        iArr[0] = i;
        iArr[2] = iArr[2] ^ ((iArr[0] ^ iArr[1]) ^ iArr[3]);
        iArr[1] = ((~iArr[3]) & (~iArr[2])) ^ iArr[1];
        iArr[0] = (iArr[1] & iArr[2]) ^ iArr[0];
    }

    public final void c(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public final void d(int[] iArr) {
        iArr[1] = f(iArr[1], 1);
        iArr[2] = f(iArr[2], 5);
        iArr[3] = f(iArr[3], 2);
    }

    public final void e(int[] iArr) {
        iArr[1] = f(iArr[1], 31);
        iArr[2] = f(iArr[2], 27);
        iArr[3] = f(iArr[3], 30);
    }

    public final int f(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public final void g(int[] iArr, int[] iArr2) {
        int i = iArr[0] ^ iArr[2];
        int f2 = i ^ (f(i, 8) ^ f(i, 24));
        iArr[1] = iArr[1] ^ f2;
        iArr[3] = f2 ^ iArr[3];
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = iArr[i2] ^ iArr2[i2];
        }
        int i3 = iArr[1] ^ iArr[3];
        int f3 = i3 ^ (f(i3, 8) ^ f(i3, 24));
        iArr[0] = iArr[0] ^ f3;
        iArr[2] = f3 ^ iArr[2];
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Noekeon";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.e = z;
            this.d = true;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.b[0] = a(key, 0);
            this.b[1] = a(key, 4);
            this.b[2] = a(key, 8);
            this.b[3] = a(key, 12);
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to Noekeon init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.d) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            if (this.e) {
                this.a[0] = a(bArr, i);
                this.a[1] = a(bArr, i + 4);
                this.a[2] = a(bArr, i + 8);
                this.a[3] = a(bArr, i + 12);
                int i3 = 0;
                while (i3 < 16) {
                    int[] iArr = this.a;
                    iArr[0] = iArr[0] ^ g[i3];
                    g(iArr, this.b);
                    d(this.a);
                    b(this.a);
                    e(this.a);
                    i3++;
                }
                int[] iArr2 = this.a;
                iArr2[0] = g[i3] ^ iArr2[0];
                g(iArr2, this.b);
                c(this.a[0], bArr2, i2);
                c(this.a[1], bArr2, i2 + 4);
                c(this.a[2], bArr2, i2 + 8);
                c(this.a[3], bArr2, i2 + 12);
            } else {
                this.a[0] = a(bArr, i);
                this.a[1] = a(bArr, i + 4);
                this.a[2] = a(bArr, i + 8);
                this.a[3] = a(bArr, i + 12);
                int[] iArr3 = this.b;
                System.arraycopy(iArr3, 0, this.c, 0, iArr3.length);
                g(this.c, f);
                int i4 = 16;
                while (i4 > 0) {
                    g(this.a, this.c);
                    int[] iArr4 = this.a;
                    iArr4[0] = iArr4[0] ^ g[i4];
                    d(iArr4);
                    b(this.a);
                    e(this.a);
                    i4--;
                }
                g(this.a, this.c);
                int[] iArr5 = this.a;
                iArr5[0] = g[i4] ^ iArr5[0];
                c(iArr5[0], bArr2, i2);
                c(this.a[1], bArr2, i2 + 4);
                c(this.a[2], bArr2, i2 + 8);
                c(this.a[3], bArr2, i2 + 12);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
