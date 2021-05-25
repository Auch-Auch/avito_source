package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class KeccakDigest implements ExtendedDigest {
    public static long[] a;
    public static int[] b;
    public int bitsInQueue;
    public byte[] dataQueue;
    public int fixedOutputLength;
    public int rate;
    public boolean squeezing;
    public long[] state;

    static {
        long[] jArr = new long[24];
        int i = 1;
        int i2 = 0;
        byte[] bArr = {1};
        for (int i3 = 0; i3 < 24; i3++) {
            jArr[i3] = 0;
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = (1 << i4) - 1;
                boolean z = (bArr[0] & 1) != 0;
                if ((bArr[0] & 128) != 0) {
                    bArr[0] = (byte) ((bArr[0] << 1) ^ 113);
                } else {
                    bArr[0] = (byte) (bArr[0] << 1);
                }
                if (z) {
                    jArr[i3] = jArr[i3] ^ (1 << i5);
                }
            }
        }
        a = jArr;
        int[] iArr = new int[25];
        iArr[0] = 0;
        int i6 = 0;
        while (i2 < 24) {
            int i7 = i2 + 1;
            iArr[((i6 % 5) * 5) + (i % 5)] = (((i2 + 2) * i7) / 2) % 64;
            int i8 = i6 * 1;
            i6 = ((i6 * 3) + (i * 2)) % 5;
            i = (i8 + (i * 0)) % 5;
            i2 = i7;
        }
        b = iArr;
    }

    public KeccakDigest() {
        this(288);
    }

    public static long d(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    public final void a(byte[] bArr, int i) {
        int i2 = this.rate >> 6;
        for (int i3 = 0; i3 < i2; i3++) {
            long[] jArr = this.state;
            jArr[i3] = jArr[i3] ^ Pack.littleEndianToLong(bArr, i);
            i += 8;
        }
        b();
    }

    public void absorb(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.bitsInQueue;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            int i5 = i4 >> 3;
            int i6 = this.rate >> 3;
            int i7 = 0;
            while (i7 < i2) {
                if (i5 != 0 || i7 > (i3 = i2 - i6)) {
                    int min = Math.min(i6 - i5, i2 - i7);
                    System.arraycopy(bArr, i + i7, this.dataQueue, i5, min);
                    i5 += min;
                    i7 += min;
                    if (i5 == i6) {
                        a(this.dataQueue, 0);
                        i5 = 0;
                    }
                } else {
                    do {
                        a(bArr, i + i7);
                        i7 += i6;
                    } while (i7 <= i3);
                }
            }
            this.bitsInQueue = i5 << 3;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public void absorbBits(int i, int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i3 = this.bitsInQueue;
        if (i3 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.squeezing) {
            this.dataQueue[i3 >> 3] = (byte) (i & ((1 << i2) - 1));
            this.bitsInQueue = i3 + i2;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public final void b() {
        char c = 0;
        int i = 0;
        while (i < 24) {
            long[] jArr = this.state;
            long j = (((jArr[c] ^ jArr[5]) ^ jArr[10]) ^ jArr[15]) ^ jArr[20];
            long j2 = (((jArr[1] ^ jArr[6]) ^ jArr[11]) ^ jArr[16]) ^ jArr[21];
            long j3 = (((jArr[2] ^ jArr[7]) ^ jArr[12]) ^ jArr[17]) ^ jArr[22];
            long j4 = (((jArr[3] ^ jArr[8]) ^ jArr[13]) ^ jArr[18]) ^ jArr[23];
            long j5 = (((jArr[4] ^ jArr[9]) ^ jArr[14]) ^ jArr[19]) ^ jArr[24];
            long d = d(j2, 1) ^ j5;
            jArr[c] = jArr[c] ^ d;
            jArr[5] = jArr[5] ^ d;
            jArr[10] = jArr[10] ^ d;
            jArr[15] = jArr[15] ^ d;
            jArr[20] = jArr[20] ^ d;
            long d2 = d(j3, 1) ^ j;
            jArr[1] = jArr[1] ^ d2;
            jArr[6] = jArr[6] ^ d2;
            jArr[11] = jArr[11] ^ d2;
            jArr[16] = jArr[16] ^ d2;
            jArr[21] = d2 ^ jArr[21];
            long d3 = d(j4, 1) ^ j2;
            jArr[2] = jArr[2] ^ d3;
            jArr[7] = jArr[7] ^ d3;
            jArr[12] = jArr[12] ^ d3;
            jArr[17] = jArr[17] ^ d3;
            jArr[22] = d3 ^ jArr[22];
            long d4 = d(j5, 1) ^ j3;
            jArr[3] = jArr[3] ^ d4;
            jArr[8] = jArr[8] ^ d4;
            jArr[13] = jArr[13] ^ d4;
            jArr[18] = jArr[18] ^ d4;
            jArr[23] = d4 ^ jArr[23];
            long d5 = j4 ^ d(j, 1);
            jArr[4] = jArr[4] ^ d5;
            jArr[9] = jArr[9] ^ d5;
            jArr[14] = jArr[14] ^ d5;
            jArr[19] = jArr[19] ^ d5;
            jArr[24] = d5 ^ jArr[24];
            long[] jArr2 = this.state;
            for (int i2 = 1; i2 < 25; i2++) {
                jArr2[i2] = d(jArr2[i2], b[i2]);
            }
            long[] jArr3 = this.state;
            long j6 = jArr3[1];
            jArr3[1] = jArr3[6];
            jArr3[6] = jArr3[9];
            jArr3[9] = jArr3[22];
            jArr3[22] = jArr3[14];
            jArr3[14] = jArr3[20];
            jArr3[20] = jArr3[2];
            jArr3[2] = jArr3[12];
            jArr3[12] = jArr3[13];
            jArr3[13] = jArr3[19];
            jArr3[19] = jArr3[23];
            jArr3[23] = jArr3[15];
            jArr3[15] = jArr3[4];
            jArr3[4] = jArr3[24];
            jArr3[24] = jArr3[21];
            jArr3[21] = jArr3[8];
            jArr3[8] = jArr3[16];
            jArr3[16] = jArr3[5];
            jArr3[5] = jArr3[3];
            jArr3[3] = jArr3[18];
            jArr3[18] = jArr3[17];
            jArr3[17] = jArr3[11];
            jArr3[11] = jArr3[7];
            jArr3[7] = jArr3[10];
            jArr3[10] = j6;
            for (int i3 = 0; i3 < 25; i3 += 5) {
                int i4 = i3 + 0;
                int i5 = i3 + 1;
                int i6 = i3 + 2;
                long j7 = jArr3[i4] ^ ((~jArr3[i5]) & jArr3[i6]);
                int i7 = i3 + 3;
                long j8 = jArr3[i5] ^ ((~jArr3[i6]) & jArr3[i7]);
                int i8 = i3 + 4;
                long j9 = jArr3[i6] ^ ((~jArr3[i7]) & jArr3[i8]);
                long j10 = ((~jArr3[i8]) & jArr3[i4]) ^ jArr3[i7];
                long j11 = jArr3[i8];
                jArr3[i4] = j7;
                jArr3[i5] = j8;
                jArr3[i6] = j9;
                jArr3[i7] = j10;
                jArr3[i8] = ((~jArr3[i4]) & jArr3[i5]) ^ j11;
            }
            long[] jArr4 = this.state;
            jArr4[0] = jArr4[0] ^ a[i];
            i++;
            c = 0;
        }
    }

    public final void c(int i) {
        if (i == 128 || i == 224 || i == 256 || i == 288 || i == 384 || i == 512) {
            int i2 = 1600 - (i << 1);
            if (i2 <= 0 || i2 >= 1600 || i2 % 64 != 0) {
                throw new IllegalStateException("invalid rate value");
            }
            this.rate = i2;
            int i3 = 0;
            while (true) {
                long[] jArr = this.state;
                if (i3 < jArr.length) {
                    jArr[i3] = 0;
                    i3++;
                } else {
                    Arrays.fill(this.dataQueue, (byte) 0);
                    this.bitsInQueue = 0;
                    this.squeezing = false;
                    this.fixedOutputLength = (1600 - i2) / 2;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        squeeze(bArr, i, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        StringBuilder L = a.L("Keccak-");
        L.append(this.fixedOutputLength);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.rate / 8;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        c(this.fixedOutputLength);
    }

    public void squeeze(byte[] bArr, int i, long j) {
        if (!this.squeezing) {
            byte[] bArr2 = this.dataQueue;
            int i2 = this.bitsInQueue;
            int i3 = i2 >> 3;
            bArr2[i3] = (byte) (bArr2[i3] | ((byte) ((int) (1 << (i2 & 7)))));
            int i4 = i2 + 1;
            this.bitsInQueue = i4;
            if (i4 == this.rate) {
                a(bArr2, 0);
                this.bitsInQueue = 0;
            }
            int i5 = this.bitsInQueue;
            int i6 = i5 >> 6;
            int i7 = i5 & 63;
            int i8 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                long[] jArr = this.state;
                jArr[i9] = jArr[i9] ^ Pack.littleEndianToLong(this.dataQueue, i8);
                i8 += 8;
            }
            if (i7 > 0) {
                long[] jArr2 = this.state;
                jArr2[i6] = (Pack.littleEndianToLong(this.dataQueue, i8) & ((1 << i7) - 1)) ^ jArr2[i6];
            }
            long[] jArr3 = this.state;
            int i10 = (this.rate - 1) >> 6;
            jArr3[i10] = jArr3[i10] ^ Long.MIN_VALUE;
            b();
            Pack.longToLittleEndian(this.state, 0, this.rate >> 6, this.dataQueue, 0);
            this.bitsInQueue = this.rate;
            this.squeezing = true;
        }
        long j2 = 0;
        if (j % 8 == 0) {
            while (j2 < j) {
                if (this.bitsInQueue == 0) {
                    b();
                    Pack.longToLittleEndian(this.state, 0, this.rate >> 6, this.dataQueue, 0);
                    this.bitsInQueue = this.rate;
                }
                int min = (int) Math.min((long) this.bitsInQueue, j - j2);
                System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, bArr, i + ((int) (j2 / 8)), min / 8);
                this.bitsInQueue -= min;
                j2 += (long) min;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        absorb(new byte[]{b2}, 0, 1);
    }

    public KeccakDigest(int i) {
        this.state = new long[25];
        this.dataQueue = new byte[192];
        c(i);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        absorb(bArr, i, i2);
    }

    public int doFinal(byte[] bArr, int i, byte b2, int i2) {
        if (i2 > 0) {
            absorbBits(b2, i2);
        }
        squeeze(bArr, i, (long) this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.state = jArr;
        this.dataQueue = new byte[192];
        long[] jArr2 = keccakDigest.state;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
    }
}
