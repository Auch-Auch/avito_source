package org.spongycastle.crypto.modes;

import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class CCMBlockCipher implements AEADBlockCipher {
    public BlockCipher a;
    public int b;
    public boolean c;
    public byte[] d;
    public byte[] e;
    public int f;
    public CipherParameters g;
    public byte[] h;
    public a i = new a(this);
    public a j = new a(this);

    public class a extends ByteArrayOutputStream {
        public a(CCMBlockCipher cCMBlockCipher) {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.a = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.b = blockSize;
        this.h = new byte[blockSize];
        if (blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    public final int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.a, this.f * 8);
        cBCBlockCipherMac.init(this.g);
        byte[] bArr3 = new byte[16];
        if (b()) {
            bArr3[0] = (byte) (bArr3[0] | SignedBytes.MAX_POWER_OF_TWO);
        }
        int i4 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        byte b2 = bArr3[0];
        byte[] bArr4 = this.d;
        bArr3[0] = (byte) (b2 | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i5 = i3;
        int i6 = 1;
        while (i5 > 0) {
            bArr3[16 - i6] = (byte) (i5 & 255);
            i5 >>>= 8;
            i6++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        if (b()) {
            int size = this.i.size();
            byte[] bArr5 = this.e;
            int length = size + (bArr5 == null ? 0 : bArr5.length);
            if (length < 65280) {
                cBCBlockCipherMac.update((byte) (length >> 8));
                cBCBlockCipherMac.update((byte) length);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (length >> 24));
                cBCBlockCipherMac.update((byte) (length >> 16));
                cBCBlockCipherMac.update((byte) (length >> 8));
                cBCBlockCipherMac.update((byte) length);
                i4 = 6;
            }
            byte[] bArr6 = this.e;
            if (bArr6 != null) {
                cBCBlockCipherMac.update(bArr6, 0, bArr6.length);
            }
            if (this.i.size() > 0) {
                cBCBlockCipherMac.update(this.i.a(), 0, this.i.size());
            }
            int i7 = (i4 + length) % 16;
            if (i7 != 0) {
                while (i7 != 16) {
                    cBCBlockCipherMac.update((byte) 0);
                    i7++;
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i2, i3);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    public final boolean b() {
        int size = this.i.size();
        byte[] bArr = this.e;
        return size + (bArr == null ? 0 : bArr.length) > 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        int processPacket = processPacket(this.j.a(), 0, this.j.size(), bArr, i2);
        reset();
        return processPacket;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/CCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i2 = this.f;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.h, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int size = this.j.size() + i2;
        if (this.c) {
            return size + this.f;
        }
        int i3 = this.f;
        if (size < i3) {
            return 0;
        }
        return size - i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        this.c = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.d = aEADParameters.getNonce();
            this.e = aEADParameters.getAssociatedText();
            this.f = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.d = parametersWithIV.getIV();
            this.e = null;
            this.f = this.h.length / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.E(cipherParameters, a2.b.a.a.a.L("invalid parameters passed to CCM: ")));
        }
        if (cipherParameters2 != null) {
            this.g = cipherParameters2;
        }
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        reset();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        this.i.write(b2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        this.i.write(bArr, i2, i3);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        this.j.write(b2);
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i2 + i3) {
            this.j.write(bArr, i2, i3);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public byte[] processPacket(byte[] bArr, int i2, int i3) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (this.c) {
            bArr2 = new byte[(this.f + i3)];
        } else {
            int i4 = this.f;
            if (i3 >= i4) {
                bArr2 = new byte[(i3 - i4)];
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        }
        processPacket(bArr, i2, i3, bArr2, 0);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        this.a.reset();
        this.i.reset();
        this.j.reset();
    }

    public int processPacket(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalStateException, InvalidCipherTextException, DataLengthException {
        int i5;
        if (this.g != null) {
            byte[] bArr3 = this.d;
            int length = 15 - bArr3.length;
            if (length >= 4 || i3 < (1 << (length * 8))) {
                byte[] bArr4 = new byte[this.b];
                bArr4[0] = (byte) ((length - 1) & 7);
                System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
                SICBlockCipher sICBlockCipher = new SICBlockCipher(this.a);
                sICBlockCipher.init(this.c, new ParametersWithIV(this.g, bArr4));
                if (this.c) {
                    int i6 = this.f + i3;
                    if (bArr2.length >= i6 + i4) {
                        a(bArr, i2, i3, this.h);
                        byte[] bArr5 = new byte[this.b];
                        sICBlockCipher.processBlock(this.h, 0, bArr5, 0);
                        int i7 = i2;
                        int i8 = i4;
                        while (true) {
                            int i9 = i2 + i3;
                            int i10 = this.b;
                            if (i7 < i9 - i10) {
                                sICBlockCipher.processBlock(bArr, i7, bArr2, i8);
                                int i11 = this.b;
                                i8 += i11;
                                i7 += i11;
                            } else {
                                byte[] bArr6 = new byte[i10];
                                int i12 = i9 - i7;
                                System.arraycopy(bArr, i7, bArr6, 0, i12);
                                sICBlockCipher.processBlock(bArr6, 0, bArr6, 0);
                                System.arraycopy(bArr6, 0, bArr2, i8, i12);
                                System.arraycopy(bArr5, 0, bArr2, i4 + i3, this.f);
                                return i6;
                            }
                        }
                    } else {
                        throw new OutputLengthException("Output buffer too short.");
                    }
                } else {
                    int i13 = this.f;
                    if (i3 >= i13) {
                        int i14 = i3 - i13;
                        if (bArr2.length >= i14 + i4) {
                            int i15 = i2 + i14;
                            System.arraycopy(bArr, i15, this.h, 0, i13);
                            byte[] bArr7 = this.h;
                            sICBlockCipher.processBlock(bArr7, 0, bArr7, 0);
                            int i16 = this.f;
                            while (true) {
                                byte[] bArr8 = this.h;
                                if (i16 == bArr8.length) {
                                    break;
                                }
                                bArr8[i16] = 0;
                                i16++;
                            }
                            int i17 = i2;
                            int i18 = i4;
                            while (true) {
                                i5 = this.b;
                                if (i17 >= i15 - i5) {
                                    break;
                                }
                                sICBlockCipher.processBlock(bArr, i17, bArr2, i18);
                                int i19 = this.b;
                                i18 += i19;
                                i17 += i19;
                            }
                            byte[] bArr9 = new byte[i5];
                            int i20 = i14 - (i17 - i2);
                            System.arraycopy(bArr, i17, bArr9, 0, i20);
                            sICBlockCipher.processBlock(bArr9, 0, bArr9, 0);
                            System.arraycopy(bArr9, 0, bArr2, i18, i20);
                            byte[] bArr10 = new byte[this.b];
                            a(bArr2, i4, i14, bArr10);
                            if (Arrays.constantTimeAreEqual(this.h, bArr10)) {
                                return i14;
                            }
                            throw new InvalidCipherTextException("mac check in CCM failed");
                        }
                        throw new OutputLengthException("Output buffer too short.");
                    }
                    throw new InvalidCipherTextException("data too short");
                }
            } else {
                throw new IllegalStateException("CCM packet too large for choice of q.");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }
}
