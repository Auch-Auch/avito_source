package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
public class OpenPGPCFBBlockCipher implements BlockCipher {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public BlockCipher d;
    public int e;
    public int f;
    public boolean g;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.d = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.f = blockSize;
        this.a = new byte[blockSize];
        this.b = new byte[blockSize];
        this.c = new byte[blockSize];
    }

    public final byte a(byte b2, int i) {
        return (byte) (b2 ^ this.c[i]);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.d.getAlgorithmName() + "/OpenPGPCFB";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.d.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.d;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.g = z;
        reset();
        this.d.init(true, cipherParameters);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 2;
        if (this.g) {
            int i9 = this.f;
            if (i + i9 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i2 + i9 <= bArr2.length) {
                int i10 = this.e;
                if (i10 > i9) {
                    byte[] bArr3 = this.b;
                    int i11 = i9 - 2;
                    byte a3 = a(bArr[i], i9 - 2);
                    bArr2[i2] = a3;
                    bArr3[i11] = a3;
                    byte[] bArr4 = this.b;
                    int i12 = this.f;
                    int i13 = i12 - 1;
                    byte a4 = a(bArr[i + 1], i12 - 1);
                    bArr2[i2 + 1] = a4;
                    bArr4[i13] = a4;
                    this.d.processBlock(this.b, 0, this.c, 0);
                    while (i8 < this.f) {
                        byte[] bArr5 = this.b;
                        int i14 = i8 - 2;
                        byte a5 = a(bArr[i + i8], i14);
                        bArr2[i2 + i8] = a5;
                        bArr5[i14] = a5;
                        i8++;
                    }
                } else if (i10 == 0) {
                    this.d.processBlock(this.b, 0, this.c, 0);
                    while (true) {
                        i6 = this.f;
                        if (i7 >= i6) {
                            break;
                        }
                        byte[] bArr6 = this.b;
                        byte a6 = a(bArr[i + i7], i7);
                        bArr2[i2 + i7] = a6;
                        bArr6[i7] = a6;
                        i7++;
                    }
                    this.e += i6;
                } else if (i10 == i9) {
                    this.d.processBlock(this.b, 0, this.c, 0);
                    bArr2[i2] = a(bArr[i], 0);
                    bArr2[i2 + 1] = a(bArr[i + 1], 1);
                    byte[] bArr7 = this.b;
                    System.arraycopy(bArr7, 2, bArr7, 0, this.f - 2);
                    System.arraycopy(bArr2, i2, this.b, this.f - 2, 2);
                    this.d.processBlock(this.b, 0, this.c, 0);
                    while (true) {
                        i5 = this.f;
                        if (i8 >= i5) {
                            break;
                        }
                        byte[] bArr8 = this.b;
                        int i15 = i8 - 2;
                        byte a8 = a(bArr[i + i8], i15);
                        bArr2[i2 + i8] = a8;
                        bArr8[i15] = a8;
                        i8++;
                    }
                    this.e += i5;
                }
                return this.f;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            int i16 = this.f;
            if (i + i16 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i2 + i16 <= bArr2.length) {
                int i17 = this.e;
                if (i17 > i16) {
                    byte b2 = bArr[i];
                    this.b[i16 - 2] = b2;
                    bArr2[i2] = a(b2, i16 - 2);
                    byte b3 = bArr[i + 1];
                    byte[] bArr9 = this.b;
                    int i18 = this.f;
                    bArr9[i18 - 1] = b3;
                    bArr2[i2 + 1] = a(b3, i18 - 1);
                    this.d.processBlock(this.b, 0, this.c, 0);
                    while (i8 < this.f) {
                        byte b4 = bArr[i + i8];
                        int i19 = i8 - 2;
                        this.b[i19] = b4;
                        bArr2[i2 + i8] = a(b4, i19);
                        i8++;
                    }
                } else if (i17 == 0) {
                    this.d.processBlock(this.b, 0, this.c, 0);
                    while (true) {
                        i4 = this.f;
                        if (i7 >= i4) {
                            break;
                        }
                        int i20 = i + i7;
                        this.b[i7] = bArr[i20];
                        bArr2[i7] = a(bArr[i20], i7);
                        i7++;
                    }
                    this.e += i4;
                } else if (i17 == i16) {
                    this.d.processBlock(this.b, 0, this.c, 0);
                    byte b5 = bArr[i];
                    byte b6 = bArr[i + 1];
                    bArr2[i2] = a(b5, 0);
                    bArr2[i2 + 1] = a(b6, 1);
                    byte[] bArr10 = this.b;
                    System.arraycopy(bArr10, 2, bArr10, 0, this.f - 2);
                    byte[] bArr11 = this.b;
                    int i21 = this.f;
                    bArr11[i21 - 2] = b5;
                    bArr11[i21 - 1] = b6;
                    this.d.processBlock(bArr11, 0, this.c, 0);
                    while (true) {
                        i3 = this.f;
                        if (i8 >= i3) {
                            break;
                        }
                        byte b8 = bArr[i + i8];
                        int i22 = i8 - 2;
                        this.b[i22] = b8;
                        bArr2[i2 + i8] = a(b8, i22);
                        i8++;
                    }
                    this.e += i3;
                }
                return this.f;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        this.e = 0;
        byte[] bArr = this.a;
        byte[] bArr2 = this.b;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.d.reset();
    }
}
