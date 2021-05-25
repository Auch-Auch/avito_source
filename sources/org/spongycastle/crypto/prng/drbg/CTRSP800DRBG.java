package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;
import x6.e.b.d.b.a;
public class CTRSP800DRBG implements SP80090DRBG {
    public static final byte[] j = Hex.decode("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    public EntropySource a;
    public BlockCipher b;
    public int c;
    public int d;
    public int e;
    public byte[] f;
    public byte[] g;
    public long h = 0;
    public boolean i = false;

    public CTRSP800DRBG(BlockCipher blockCipher, int i2, int i3, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this.a = entropySource;
        this.b = blockCipher;
        this.c = i2;
        this.e = i3;
        this.d = (blockCipher.getBlockSize() * 8) + i2;
        this.i = i(blockCipher);
        if (i3 <= 256) {
            if (i(blockCipher) && i2 == 168) {
                i2 = 112;
            } else if (!blockCipher.getAlgorithmName().equals("AES")) {
                i2 = -1;
            }
            if (i2 < i3) {
                throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
            } else if (entropySource.entropySize() >= i3) {
                byte[] a3 = a(Arrays.concatenate(h(), bArr2, bArr), this.d);
                int blockSize = this.b.getBlockSize();
                byte[] bArr3 = new byte[((this.c + 7) / 8)];
                this.f = bArr3;
                byte[] bArr4 = new byte[blockSize];
                this.g = bArr4;
                c(a3, bArr3, bArr4);
                this.h = 1;
            } else {
                throw new IllegalArgumentException("Not enough entropy for security strength required");
            }
        } else {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
    }

    public final byte[] a(byte[] bArr, int i2) {
        int blockSize = this.b.getBlockSize();
        int length = bArr.length;
        int i3 = length + 8;
        int i4 = ((((i3 + 1) + blockSize) - 1) / blockSize) * blockSize;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        f(bArr2, length, 0);
        f(bArr2, i2 / 8, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[i3] = Byte.MIN_VALUE;
        int i6 = this.c;
        int i7 = (i6 / 8) + blockSize;
        byte[] bArr3 = new byte[i7];
        byte[] bArr4 = new byte[blockSize];
        byte[] bArr5 = new byte[blockSize];
        int i8 = i6 / 8;
        byte[] bArr6 = new byte[i8];
        System.arraycopy(j, 0, bArr6, 0, i8);
        int i9 = 0;
        while (true) {
            int i10 = i9 * blockSize;
            if (i10 * 8 >= (blockSize * 8) + this.c) {
                break;
            }
            f(bArr5, i9, i5);
            int blockSize2 = this.b.getBlockSize();
            byte[] bArr7 = new byte[blockSize2];
            int i11 = i4 / blockSize2;
            byte[] bArr8 = new byte[blockSize2];
            this.b.init(true, new KeyParameter(g(bArr6)));
            this.b.processBlock(bArr5, 0, bArr7, 0);
            for (int i12 = 0; i12 < i11; i12++) {
                d(bArr8, bArr7, bArr2, i12 * blockSize2);
                this.b.processBlock(bArr8, 0, bArr7, 0);
            }
            System.arraycopy(bArr7, 0, bArr4, 0, blockSize);
            int i13 = i7 - i10;
            if (i13 > blockSize) {
                i13 = blockSize;
            }
            System.arraycopy(bArr4, 0, bArr3, i10, i13);
            i9++;
            i8 = i8;
            i4 = i4;
            i5 = 0;
        }
        byte[] bArr9 = new byte[blockSize];
        System.arraycopy(bArr3, 0, bArr6, 0, i8);
        System.arraycopy(bArr3, i8, bArr9, 0, blockSize);
        int i14 = i2 / 2;
        byte[] bArr10 = new byte[i14];
        this.b.init(true, new KeyParameter(g(bArr6)));
        int i15 = 0;
        while (true) {
            int i16 = i15 * blockSize;
            if (i16 >= i14) {
                return bArr10;
            }
            this.b.processBlock(bArr9, 0, bArr9, 0);
            int i17 = i14 - i16;
            if (i17 > blockSize) {
                i17 = blockSize;
            }
            System.arraycopy(bArr9, 0, bArr10, i16, i17);
            i15++;
        }
    }

    public final void b(byte[] bArr) {
        c(a(Arrays.concatenate(h(), bArr), this.d), this.f, this.g);
        this.h = 1;
    }

    public final void c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this.b.getBlockSize()];
        int blockSize = this.b.getBlockSize();
        this.b.init(true, new KeyParameter(g(bArr2)));
        int i2 = 0;
        while (true) {
            int i3 = i2 * blockSize;
            if (i3 < bArr.length) {
                e(bArr3);
                this.b.processBlock(bArr3, 0, bArr5, 0);
                int i4 = length - i3;
                if (i4 > blockSize) {
                    i4 = blockSize;
                }
                System.arraycopy(bArr5, 0, bArr4, i3, i4);
                i2++;
            } else {
                d(bArr4, bArr, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            }
        }
    }

    public final void d(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = (byte) (bArr2[i3] ^ bArr3[i3 + i2]);
        }
    }

    public final void e(byte[] bArr) {
        int i2 = 1;
        for (int i3 = 1; i3 <= bArr.length; i3++) {
            int i4 = (bArr[bArr.length - i3] & 255) + i2;
            i2 = i4 > 255 ? 1 : 0;
            bArr[bArr.length - i3] = (byte) i4;
        }
    }

    public final void f(byte[] bArr, int i2, int i3) {
        bArr[i3 + 0] = (byte) (i2 >> 24);
        bArr[i3 + 1] = (byte) (i2 >> 16);
        bArr[i3 + 2] = (byte) (i2 >> 8);
        bArr[i3 + 3] = (byte) i2;
    }

    public byte[] g(byte[] bArr) {
        if (!this.i) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        j(bArr, 0, bArr2, 0);
        j(bArr, 7, bArr2, 8);
        j(bArr, 14, bArr2, 16);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArr3;
        if (this.i) {
            if (this.h > 2147483648L) {
                return -1;
            }
            if (a.b(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.h > 140737488355328L) {
            return -1;
        } else {
            if (a.b(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            b(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArr3 = a(bArr2, this.d);
            c(bArr3, this.f, this.g);
        } else {
            bArr3 = new byte[this.d];
        }
        int length = this.g.length;
        byte[] bArr4 = new byte[length];
        this.b.init(true, new KeyParameter(g(this.f)));
        for (int i2 = 0; i2 <= bArr.length / length; i2++) {
            int i3 = i2 * length;
            int length2 = bArr.length - i3 > length ? length : bArr.length - (this.g.length * i2);
            if (length2 != 0) {
                e(this.g);
                this.b.processBlock(this.g, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr, i3, length2);
            }
        }
        c(bArr3, this.f, this.g);
        this.h++;
        return bArr.length * 8;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this.g.length * 8;
    }

    public final byte[] h() {
        byte[] entropy = this.a.getEntropy();
        if (entropy.length >= (this.e + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final boolean i(BlockCipher blockCipher) {
        return blockCipher.getAlgorithmName().equals("DESede") || blockCipher.getAlgorithmName().equals("TDEA");
    }

    public final void j(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 0;
        bArr2[i3 + 0] = (byte) (bArr[i4] & 254);
        int i5 = i2 + 1;
        bArr2[i3 + 1] = (byte) ((bArr[i4] << 7) | ((bArr[i5] & 252) >>> 1));
        int i6 = i2 + 2;
        bArr2[i3 + 2] = (byte) ((bArr[i5] << 6) | ((bArr[i6] & 248) >>> 2));
        int i7 = i2 + 3;
        bArr2[i3 + 3] = (byte) ((bArr[i6] << 5) | ((bArr[i7] & 240) >>> 3));
        int i8 = i2 + 4;
        bArr2[i3 + 4] = (byte) ((bArr[i7] << 4) | ((bArr[i8] & 224) >>> 4));
        int i9 = i2 + 5;
        bArr2[i3 + 5] = (byte) ((bArr[i8] << 3) | ((bArr[i9] & 192) >>> 5));
        int i10 = i2 + 6;
        bArr2[i3 + 6] = (byte) ((bArr[i9] << 2) | ((bArr[i10] & 128) >>> 6));
        int i11 = i3 + 7;
        bArr2[i11] = (byte) (bArr[i10] << 1);
        while (i3 <= i11) {
            byte b2 = bArr2[i3];
            bArr2[i3] = (byte) (((((b2 >> 7) ^ ((((((b2 >> 1) ^ (b2 >> 2)) ^ (b2 >> 3)) ^ (b2 >> 4)) ^ (b2 >> 5)) ^ (b2 >> 6))) ^ 1) & 1) | (b2 & 254));
            i3++;
        }
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        b(bArr);
    }
}
