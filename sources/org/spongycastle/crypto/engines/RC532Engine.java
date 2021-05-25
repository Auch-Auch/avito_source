package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC5Parameters;
public class RC532Engine implements BlockCipher {
    public int a = 12;
    public int[] b = null;
    public boolean c;

    public final int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final int b(int i, int i2) {
        int i3 = i2 & 31;
        return (i >>> (32 - i3)) | (i << i3);
    }

    public final void c(byte[] bArr) {
        int[] iArr;
        int i;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = i2 / 4;
            iArr2[i3] = iArr2[i3] + ((bArr[i2] & 255) << ((i2 % 4) * 8));
        }
        int[] iArr3 = new int[((this.a + 1) * 2)];
        this.b = iArr3;
        iArr3[0] = -1209970333;
        int i4 = 1;
        while (true) {
            iArr = this.b;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = iArr[i4 - 1] - 1640531527;
            i4++;
        }
        if (length > iArr.length) {
            i = length * 3;
        } else {
            i = iArr.length * 3;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            int[] iArr4 = this.b;
            i6 = b(iArr4[i5] + i6 + i7, 3);
            iArr4[i5] = i6;
            i7 = b(iArr2[i8] + i6 + i7, i7 + i6);
            iArr2[i8] = i7;
            i5 = (i5 + 1) % this.b.length;
            i8 = (i8 + 1) % length;
        }
    }

    public final void d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-32";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.a = rC5Parameters.getRounds();
            c(rC5Parameters.getKey());
        } else if (cipherParameters instanceof KeyParameter) {
            c(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to RC532 init - ")));
        }
        this.c = z;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.c) {
            int a3 = a(bArr, i) + this.b[0];
            int a4 = a(bArr, i + 4) + this.b[1];
            for (int i3 = 1; i3 <= this.a; i3++) {
                int i4 = i3 * 2;
                a3 = b(a3 ^ a4, a4) + this.b[i4];
                a4 = b(a4 ^ a3, a3) + this.b[i4 + 1];
            }
            d(a3, bArr2, i2);
            d(a4, bArr2, i2 + 4);
            return 8;
        }
        int a5 = a(bArr, i);
        int a6 = a(bArr, i + 4);
        for (int i5 = this.a; i5 >= 1; i5--) {
            int[] iArr = this.b;
            int i6 = i5 * 2;
            int i7 = a6 - iArr[i6 + 1];
            int i8 = a5 & 31;
            a6 = ((i7 << (32 - i8)) | (i7 >>> i8)) ^ a5;
            int i9 = a5 - iArr[i6];
            int i10 = a6 & 31;
            a5 = ((i9 << (32 - i10)) | (i9 >>> i10)) ^ a6;
        }
        d(a5 - this.b[0], bArr2, i2);
        d(a6 - this.b[1], bArr2, i2 + 4);
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
