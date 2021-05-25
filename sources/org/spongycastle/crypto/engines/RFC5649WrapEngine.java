package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class RFC5649WrapEngine implements Wrapper {
    public BlockCipher a;
    public KeyParameter b;
    public boolean c;
    public byte[] d;
    public byte[] e;
    public byte[] f = null;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        byte[] bArr = {-90, 89, 89, -90};
        this.d = bArr;
        this.e = bArr;
        this.a = blockCipher;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.a.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        this.c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.b = (KeyParameter) cipherParameters;
            this.e = this.d;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.e = parametersWithIV.getIV();
            this.b = (KeyParameter) parametersWithIV.getParameters();
            if (this.e.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2;
        if (!this.c) {
            int i3 = i2 / 8;
            if (i3 * 8 != i2) {
                throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
            } else if (i3 != 1) {
                byte[] bArr3 = new byte[i2];
                System.arraycopy(bArr, i, bArr3, 0, i2);
                byte[] bArr4 = new byte[i2];
                if (i3 == 2) {
                    this.a.init(false, this.b);
                    int i4 = 0;
                    while (i4 < i2) {
                        this.a.processBlock(bArr3, i4, bArr4, i4);
                        i4 += this.a.getBlockSize();
                    }
                    byte[] bArr5 = new byte[8];
                    this.f = bArr5;
                    System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
                    byte[] bArr6 = this.f;
                    int length = i2 - bArr6.length;
                    bArr2 = new byte[length];
                    System.arraycopy(bArr4, bArr6.length, bArr2, 0, length);
                } else {
                    int i5 = i2 - 8;
                    byte[] bArr7 = new byte[i5];
                    byte[] bArr8 = new byte[8];
                    byte[] bArr9 = new byte[16];
                    System.arraycopy(bArr, i, bArr8, 0, 8);
                    System.arraycopy(bArr, i + 8, bArr7, 0, i5);
                    this.a.init(false, this.b);
                    int i6 = i3 - 1;
                    for (int i7 = 5; i7 >= 0; i7--) {
                        int i8 = i6;
                        while (i8 >= 1) {
                            System.arraycopy(bArr8, 0, bArr9, 0, 8);
                            int i9 = i8 - 1;
                            int i10 = i9 * 8;
                            System.arraycopy(bArr7, i10, bArr9, 8, 8);
                            int i11 = (i6 * i7) + i8;
                            int i12 = 1;
                            while (i11 != 0) {
                                int i13 = 8 - i12;
                                bArr9[i13] = (byte) (((byte) i11) ^ bArr9[i13]);
                                i11 >>>= 8;
                                i12++;
                            }
                            this.a.processBlock(bArr9, 0, bArr9, 0);
                            System.arraycopy(bArr9, 0, bArr8, 0, 8);
                            System.arraycopy(bArr9, 8, bArr7, i10, 8);
                            i8 = i9;
                        }
                    }
                    this.f = bArr8;
                    bArr2 = bArr7;
                }
                byte[] bArr10 = new byte[4];
                byte[] bArr11 = new byte[4];
                System.arraycopy(this.f, 0, bArr10, 0, 4);
                System.arraycopy(this.f, 4, bArr11, 0, 4);
                int bigEndianToInt = Pack.bigEndianToInt(bArr11, 0);
                boolean constantTimeAreEqual = Arrays.constantTimeAreEqual(bArr10, this.e);
                int length2 = bArr2.length;
                if (bigEndianToInt <= length2 - 8) {
                    constantTimeAreEqual = false;
                }
                if (bigEndianToInt > length2) {
                    constantTimeAreEqual = false;
                }
                int i14 = length2 - bigEndianToInt;
                if (i14 >= bArr2.length) {
                    i14 = bArr2.length;
                    constantTimeAreEqual = false;
                }
                byte[] bArr12 = new byte[i14];
                System.arraycopy(bArr2, bArr2.length - i14, bArr12, 0, i14);
                if (!Arrays.constantTimeAreEqual(bArr12, new byte[i14])) {
                    constantTimeAreEqual = false;
                }
                if (constantTimeAreEqual) {
                    byte[] bArr13 = new byte[bigEndianToInt];
                    System.arraycopy(bArr2, 0, bArr13, 0, bigEndianToInt);
                    return bArr13;
                }
                throw new InvalidCipherTextException("checksum failed");
            } else {
                throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
            }
        } else {
            throw new IllegalStateException("not set for unwrapping");
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i, int i2) {
        if (this.c) {
            byte[] bArr2 = new byte[8];
            byte[] intToBigEndian = Pack.intToBigEndian(i2);
            byte[] bArr3 = this.e;
            int i3 = 0;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            System.arraycopy(intToBigEndian, 0, bArr2, this.e.length, intToBigEndian.length);
            byte[] bArr4 = new byte[i2];
            System.arraycopy(bArr, i, bArr4, 0, i2);
            int i4 = (8 - (i2 % 8)) % 8;
            int i5 = i2 + i4;
            byte[] bArr5 = new byte[i5];
            System.arraycopy(bArr4, 0, bArr5, 0, i2);
            if (i4 != 0) {
                System.arraycopy(new byte[i4], 0, bArr5, i2, i4);
            }
            if (i5 == 8) {
                int i6 = i5 + 8;
                byte[] bArr6 = new byte[i6];
                System.arraycopy(bArr2, 0, bArr6, 0, 8);
                System.arraycopy(bArr5, 0, bArr6, 8, i5);
                this.a.init(true, this.b);
                while (i3 < i6) {
                    this.a.processBlock(bArr6, i3, bArr6, i3);
                    i3 += this.a.getBlockSize();
                }
                return bArr6;
            }
            RFC3394WrapEngine rFC3394WrapEngine = new RFC3394WrapEngine(this.a);
            rFC3394WrapEngine.init(true, new ParametersWithIV(this.b, bArr2));
            return rFC3394WrapEngine.wrap(bArr5, 0, i5);
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
