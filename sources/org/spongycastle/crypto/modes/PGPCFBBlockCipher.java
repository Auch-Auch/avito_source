package org.spongycastle.crypto.modes;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
public class PGPCFBBlockCipher implements BlockCipher {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public BlockCipher e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.e = blockCipher;
        this.i = z;
        int blockSize = blockCipher.getBlockSize();
        this.g = blockSize;
        this.a = new byte[blockSize];
        this.b = new byte[blockSize];
        this.c = new byte[blockSize];
        this.d = new byte[blockSize];
    }

    public final byte a(byte b2, int i2) {
        return (byte) (b2 ^ this.c[i2]);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        if (this.i) {
            return this.e.getAlgorithmName() + "/PGPCFBwithIV";
        }
        return this.e.getAlgorithmName() + "/PGPCFB";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.e.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.e;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.h = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.a;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i2 = 0;
                while (true) {
                    byte[] bArr2 = this.a;
                    if (i2 >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i2] = 0;
                    i2++;
                }
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            this.e.init(true, parametersWithIV.getParameters());
            return;
        }
        reset();
        this.e.init(true, cipherParameters);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (this.i) {
            if (this.h) {
                int i9 = this.g;
                if (i2 + i9 <= bArr.length) {
                    int i10 = this.f;
                    if (i10 != 0) {
                        if (i10 >= i9 + 2) {
                            if (i9 + i3 <= bArr2.length) {
                                this.e.processBlock(this.b, 0, this.c, 0);
                                int i11 = 0;
                                while (true) {
                                    i6 = this.g;
                                    if (i11 >= i6) {
                                        break;
                                    }
                                    bArr2[i3 + i11] = a(bArr[i2 + i11], i11);
                                    i11++;
                                }
                                System.arraycopy(bArr2, i3, this.b, 0, i6);
                            } else {
                                throw new OutputLengthException("output buffer too short");
                            }
                        }
                        return this.g;
                    } else if (a.c2(i9, 2, i3, 2) <= bArr2.length) {
                        this.e.processBlock(this.b, 0, this.c, 0);
                        int i12 = 0;
                        while (true) {
                            i7 = this.g;
                            if (i12 >= i7) {
                                break;
                            }
                            bArr2[i3 + i12] = a(this.a[i12], i12);
                            i12++;
                        }
                        System.arraycopy(bArr2, i3, this.b, 0, i7);
                        this.e.processBlock(this.b, 0, this.c, 0);
                        int i13 = this.g;
                        bArr2[i3 + i13] = a(this.a[i13 - 2], 0);
                        int i14 = this.g;
                        bArr2[i3 + i14 + 1] = a(this.a[i14 - 1], 1);
                        System.arraycopy(bArr2, i3 + 2, this.b, 0, this.g);
                        this.e.processBlock(this.b, 0, this.c, 0);
                        int i15 = 0;
                        while (true) {
                            int i16 = this.g;
                            if (i15 < i16) {
                                bArr2[a.G1(i16, i3, 2, i15)] = a(bArr[i2 + i15], i15);
                                i15++;
                            } else {
                                System.arraycopy(bArr2, i3 + i16 + 2, this.b, 0, i16);
                                int i17 = this.f;
                                int i18 = (this.g * 2) + 2;
                                this.f = i17 + i18;
                                return i18;
                            }
                        }
                    } else {
                        throw new OutputLengthException("output buffer too short");
                    }
                } else {
                    throw new DataLengthException("input buffer too short");
                }
            } else {
                int i19 = this.g;
                if (i2 + i19 > bArr.length) {
                    throw new DataLengthException("input buffer too short");
                } else if (i3 + i19 <= bArr2.length) {
                    int i20 = this.f;
                    if (i20 == 0) {
                        for (int i21 = 0; i21 < this.g; i21++) {
                            this.b[i21] = bArr[i2 + i21];
                        }
                        this.e.processBlock(this.b, 0, this.c, 0);
                        this.f += this.g;
                    } else if (i20 == i19) {
                        System.arraycopy(bArr, i2, this.d, 0, i19);
                        byte[] bArr3 = this.b;
                        System.arraycopy(bArr3, 2, bArr3, 0, this.g - 2);
                        byte[] bArr4 = this.b;
                        int i22 = this.g;
                        byte[] bArr5 = this.d;
                        bArr4[i22 - 2] = bArr5[0];
                        bArr4[i22 - 1] = bArr5[1];
                        this.e.processBlock(bArr4, 0, this.c, 0);
                        int i23 = 0;
                        while (true) {
                            i5 = this.g;
                            if (i23 >= i5 - 2) {
                                break;
                            }
                            bArr2[i3 + i23] = a(this.d[i23 + 2], i23);
                            i23++;
                        }
                        System.arraycopy(this.d, 2, this.b, 0, i5 - 2);
                        this.f += 2;
                        i8 = this.g - 2;
                    } else {
                        if (i20 >= i19 + 2) {
                            System.arraycopy(bArr, i2, this.d, 0, i19);
                            bArr2[i3 + 0] = a(this.d[0], this.g - 2);
                            bArr2[i3 + 1] = a(this.d[1], this.g - 1);
                            System.arraycopy(this.d, 0, this.b, this.g - 2, 2);
                            this.e.processBlock(this.b, 0, this.c, 0);
                            int i24 = 0;
                            while (true) {
                                i4 = this.g;
                                if (i24 >= i4 - 2) {
                                    break;
                                }
                                bArr2[i3 + i24 + 2] = a(this.d[i24 + 2], i24);
                                i24++;
                            }
                            System.arraycopy(this.d, 2, this.b, 0, i4 - 2);
                        }
                        i8 = this.g;
                    }
                    return i8;
                } else {
                    throw new OutputLengthException("output buffer too short");
                }
            }
        } else if (this.h) {
            int i25 = this.g;
            if (i2 + i25 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i25 + i3 <= bArr2.length) {
                this.e.processBlock(this.b, 0, this.c, 0);
                for (int i26 = 0; i26 < this.g; i26++) {
                    bArr2[i3 + i26] = a(bArr[i2 + i26], i26);
                }
                while (true) {
                    int i27 = this.g;
                    if (i8 >= i27) {
                        return i27;
                    }
                    this.b[i8] = bArr2[i3 + i8];
                    i8++;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            int i28 = this.g;
            if (i2 + i28 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i28 + i3 <= bArr2.length) {
                this.e.processBlock(this.b, 0, this.c, 0);
                for (int i29 = 0; i29 < this.g; i29++) {
                    bArr2[i3 + i29] = a(bArr[i2 + i29], i29);
                }
                while (true) {
                    int i30 = this.g;
                    if (i8 >= i30) {
                        return i30;
                    }
                    this.b[i8] = bArr[i2 + i8];
                    i8++;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        this.f = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 != bArr.length) {
                if (this.i) {
                    bArr[i2] = 0;
                } else {
                    bArr[i2] = this.a[i2];
                }
                i2++;
            } else {
                this.e.reset();
                return;
            }
        }
    }
}
