package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
public class KXTSBlockCipher extends BufferedBlockCipher {
    public final int a;
    public final long b;
    public final long[] c;
    public final long[] d;
    public int e = -1;

    public KXTSBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.a = blockSize;
        this.b = getReductionPolynomial(blockSize);
        this.c = new long[(blockSize >>> 3)];
        this.d = new long[(blockSize >>> 3)];
    }

    public static long getReductionPolynomial(int i) {
        if (i == 16) {
            return 135;
        }
        if (i == 32) {
            return 1061;
        }
        if (i == 64) {
            return 293;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i) {
        reset();
        return 0;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        return i;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i) {
        return i;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters parameters = parametersWithIV.getParameters();
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            int i = this.a;
            if (length == i) {
                byte[] bArr = new byte[i];
                System.arraycopy(iv, 0, bArr, 0, i);
                this.cipher.init(true, parameters);
                this.cipher.processBlock(bArr, 0, bArr, 0);
                this.cipher.init(z, parameters);
                Pack.littleEndianToLong(bArr, 0, this.c);
                long[] jArr = this.c;
                System.arraycopy(jArr, 0, this.d, 0, jArr.length);
                this.e = 0;
                return;
            }
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        throw new IllegalArgumentException("Invalid parameters passed");
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processByte(byte b2, byte[] bArr, int i) {
        throw new IllegalStateException("unsupported operation");
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (bArr2.length - i < i2) {
            throw new OutputLengthException("Output buffer too short");
        } else if (i2 % this.a == 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i + i5;
                int i7 = i3 + i5;
                int i8 = this.e;
                if (i8 != -1) {
                    this.e = i8 + 1;
                    long j = this.b;
                    long[] jArr = this.d;
                    long j2 = 0;
                    int i9 = 0;
                    while (i9 < jArr.length) {
                        long j3 = jArr[i9];
                        jArr[i9] = j2 ^ (j3 << 1);
                        i9++;
                        j2 = j3 >>> 63;
                    }
                    jArr[0] = (j & (-j2)) ^ jArr[0];
                    byte[] bArr3 = new byte[this.a];
                    Pack.longToLittleEndian(this.d, bArr3, 0);
                    int i10 = this.a;
                    byte[] bArr4 = new byte[i10];
                    System.arraycopy(bArr3, 0, bArr4, 0, i10);
                    for (int i11 = 0; i11 < this.a; i11++) {
                        bArr4[i11] = (byte) (bArr4[i11] ^ bArr[i6 + i11]);
                    }
                    this.cipher.processBlock(bArr4, 0, bArr4, 0);
                    int i12 = 0;
                    while (true) {
                        i4 = this.a;
                        if (i12 >= i4) {
                            break;
                        }
                        bArr2[i7 + i12] = (byte) (bArr4[i12] ^ bArr3[i12]);
                        i12++;
                    }
                    i5 += i4;
                } else {
                    throw new IllegalStateException("Attempt to process too many blocks");
                }
            }
            return i2;
        } else {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public void reset() {
        this.cipher.reset();
        long[] jArr = this.c;
        System.arraycopy(jArr, 0, this.d, 0, jArr.length);
        this.e = 0;
    }
}
