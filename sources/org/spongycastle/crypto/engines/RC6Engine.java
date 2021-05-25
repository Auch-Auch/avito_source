package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class RC6Engine implements BlockCipher {
    public int[] a = null;
    public boolean b;

    public final int a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 3; i3 >= 0; i3--) {
            i2 = (i2 << 8) + (bArr[i3 + i] & 255);
        }
        return i2;
    }

    public final int b(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public final void c(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3 + i2] = (byte) i;
            i >>>= 8;
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC6";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        int[] iArr;
        int i;
        if (cipherParameters instanceof KeyParameter) {
            this.b = z;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            int length = (key.length + 3) / 4;
            int length2 = ((key.length + 4) - 1) / 4;
            int[] iArr2 = new int[length2];
            for (int length3 = key.length - 1; length3 >= 0; length3--) {
                int i2 = length3 / 4;
                iArr2[i2] = (iArr2[i2] << 8) + (key[length3] & 255);
            }
            int[] iArr3 = new int[44];
            this.a = iArr3;
            iArr3[0] = -1209970333;
            int i3 = 1;
            while (true) {
                iArr = this.a;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = iArr[i3 - 1] - 1640531527;
                i3++;
            }
            if (length2 > iArr.length) {
                i = length2 * 3;
            } else {
                i = iArr.length * 3;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                int[] iArr4 = this.a;
                i5 = b(iArr4[i4] + i5 + i6, 3);
                iArr4[i4] = i5;
                i6 = b(iArr2[i7] + i5 + i6, i6 + i5);
                iArr2[i7] = i6;
                i4 = (i4 + 1) % this.a.length;
                i7 = (i7 + 1) % length2;
            }
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to RC6 init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int blockSize = getBlockSize();
        if (this.a == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i + blockSize > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (blockSize + i2 <= bArr2.length) {
            int i3 = 5;
            int i4 = 20;
            if (this.b) {
                int a3 = a(bArr, i);
                int a4 = a(bArr, i + 4);
                int a5 = a(bArr, i + 8);
                int a6 = a(bArr, i + 12);
                int[] iArr = this.a;
                int i5 = a4 + iArr[0];
                int i6 = a6 + iArr[1];
                int i7 = 1;
                while (i7 <= 20) {
                    int b2 = b(((i5 * 2) + 1) * i5, 5);
                    int b3 = b(((i6 * 2) + 1) * i6, 5);
                    int i8 = i7 * 2;
                    int b4 = b(a5 ^ b3, b2) + this.a[i8 + 1];
                    i7++;
                    a5 = i6;
                    i6 = b(a3 ^ b2, b3) + this.a[i8];
                    a3 = i5;
                    i5 = b4;
                }
                int[] iArr2 = this.a;
                c(a3 + iArr2[42], bArr2, i2);
                c(i5, bArr2, i2 + 4);
                c(a5 + iArr2[43], bArr2, i2 + 8);
                c(i6, bArr2, i2 + 12);
                return 16;
            }
            int a8 = a(bArr, i);
            int a9 = a(bArr, i + 4);
            int a10 = a(bArr, i + 8);
            int a11 = a(bArr, i + 12);
            int[] iArr3 = this.a;
            int i9 = a10 - iArr3[43];
            int i10 = a8 - iArr3[42];
            while (i4 >= 1) {
                int b5 = b(((i10 * 2) + 1) * i10, i3);
                int b6 = b(((i9 * 2) + 1) * i9, i3);
                int[] iArr4 = this.a;
                int i11 = i4 * 2;
                int i12 = a9 - iArr4[i11 + 1];
                int i13 = ((i12 << (-b5)) | (i12 >>> b5)) ^ b6;
                int i14 = a11 - iArr4[i11];
                i4--;
                a9 = i10;
                i10 = ((i14 << (-b6)) | (i14 >>> b6)) ^ b5;
                a11 = i9;
                i9 = i13;
                i3 = 5;
            }
            int[] iArr5 = this.a;
            c(i10, bArr2, i2);
            c(a9 - iArr5[0], bArr2, i2 + 4);
            c(i9, bArr2, i2 + 8);
            c(a11 - iArr5[1], bArr2, i2 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
