package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.RC5Parameters;
public class RC564Engine implements BlockCipher {
    public int a = 12;
    public long[] b = null;
    public boolean c;

    public final long a(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 7; i2 >= 0; i2--) {
            j = (j << 8) + ((long) (bArr[i2 + i] & 255));
        }
        return j;
    }

    public final long b(long j, long j2) {
        long j3 = j2 & 63;
        return (j >>> ((int) (64 - j3))) | (j << ((int) j3));
    }

    public final void c(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2 + i] = (byte) ((int) j);
            j >>>= 8;
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-64";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        long[] jArr;
        int i;
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.c = z;
            this.a = rC5Parameters.getRounds();
            byte[] key = rC5Parameters.getKey();
            int length = (key.length + 7) / 8;
            long[] jArr2 = new long[length];
            for (int i2 = 0; i2 != key.length; i2++) {
                int i3 = i2 / 8;
                jArr2[i3] = jArr2[i3] + (((long) (key[i2] & 255)) << ((i2 % 8) * 8));
            }
            long[] jArr3 = new long[((this.a + 1) * 2)];
            this.b = jArr3;
            jArr3[0] = -5196783011329398165L;
            int i4 = 1;
            while (true) {
                jArr = this.b;
                if (i4 >= jArr.length) {
                    break;
                }
                jArr[i4] = jArr[i4 - 1] - 7046029254386353131L;
                i4++;
            }
            if (length > jArr.length) {
                i = length * 3;
            } else {
                i = jArr.length * 3;
            }
            long j = 0;
            long j2 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                long[] jArr4 = this.b;
                j = b(jArr4[i5] + j + j2, 3);
                jArr4[i5] = j;
                j2 = b(jArr2[i6] + j + j2, j2 + j);
                jArr2[i6] = j2;
                i5 = (i5 + 1) % this.b.length;
                i6 = (i6 + 1) % length;
            }
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to RC564 init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.c) {
            long a3 = a(bArr, i) + this.b[0];
            long a4 = a(bArr, i + 8) + this.b[1];
            for (int i3 = 1; i3 <= this.a; i3++) {
                int i4 = i3 * 2;
                a3 = b(a3 ^ a4, a4) + this.b[i4];
                a4 = b(a4 ^ a3, a3) + this.b[i4 + 1];
            }
            c(a3, bArr2, i2);
            c(a4, bArr2, i2 + 8);
            return 16;
        }
        long a5 = a(bArr, i);
        long a6 = a(bArr, i + 8);
        int i5 = this.a;
        for (int i6 = 1; i5 >= i6; i6 = 1) {
            long[] jArr = this.b;
            int i7 = i5 * 2;
            long j = a6 - jArr[i7 + 1];
            long j2 = a5 & 63;
            a6 = ((j << ((int) (64 - j2))) | (j >>> ((int) j2))) ^ a5;
            long j3 = a5 - jArr[i7];
            long j4 = a6 & 63;
            a5 = ((j3 << ((int) (64 - j4))) | (j3 >>> ((int) j4))) ^ a6;
            i5--;
        }
        c(a5 - this.b[0], bArr2, i2);
        c(a6 - this.b[1], bArr2, i2 + 8);
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
