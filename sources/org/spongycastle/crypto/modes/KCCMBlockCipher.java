package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class KCCMBlockCipher implements AEADBlockCipher {
    public BlockCipher a;
    public int b;
    public boolean c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public a l;
    public a m;
    public int n;

    public class a extends ByteArrayOutputStream {
        public a(KCCMBlockCipher kCCMBlockCipher) {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, 4);
    }

    public final void a(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            for (int i4 = 0; i4 < this.a.getBlockSize(); i4++) {
                byte[] bArr2 = this.f;
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr[i2 + i4]);
            }
            BlockCipher blockCipher = this.a;
            byte[] bArr3 = this.f;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            i3 -= this.a.getBlockSize();
            i2 += this.a.getBlockSize();
        }
    }

    public final void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        while (true) {
            byte[] bArr3 = this.k;
            if (i4 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.j;
            bArr4[i4] = (byte) (bArr4[i4] + bArr3[i4]);
            i4++;
        }
        this.a.processBlock(this.j, 0, this.i, 0);
        for (int i5 = 0; i5 < this.a.getBlockSize(); i5++) {
            bArr2[i3 + i5] = (byte) (this.i[i5] ^ bArr[i2 + i5]);
        }
    }

    public final void c(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >> 24);
        bArr[i3 + 2] = (byte) (i2 >> 16);
        bArr[i3 + 1] = (byte) (i2 >> 8);
        bArr[i3] = (byte) i2;
    }

    public final void d(byte[] bArr, int i2, int i3, int i4) {
        if (i3 - i2 < this.a.getBlockSize()) {
            throw new IllegalArgumentException("authText buffer too short");
        } else if (i3 % this.a.getBlockSize() == 0) {
            byte[] bArr2 = this.g;
            System.arraycopy(bArr2, 0, this.h, 0, (bArr2.length - this.n) - 1);
            c(i4, this.i, 0);
            System.arraycopy(this.i, 0, this.h, (this.g.length - this.n) - 1, 4);
            byte[] bArr3 = this.h;
            int length = bArr3.length - 1;
            int i5 = this.b;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("1");
            if (i5 == 8) {
                stringBuffer.append("010");
            } else if (i5 == 16) {
                stringBuffer.append("011");
            } else if (i5 == 32) {
                stringBuffer.append("100");
            } else if (i5 == 48) {
                stringBuffer.append("101");
            } else if (i5 == 64) {
                stringBuffer.append("110");
            }
            String binaryString = Integer.toBinaryString(this.n - 1);
            while (binaryString.length() < 4) {
                binaryString = new StringBuffer(binaryString).insert(0, "0").toString();
            }
            stringBuffer.append(binaryString);
            bArr3[length] = (byte) Integer.parseInt(stringBuffer.toString(), 2);
            this.a.processBlock(this.h, 0, this.f, 0);
            c(i3, this.i, 0);
            if (i3 <= this.a.getBlockSize() - this.n) {
                for (int i6 = 0; i6 < i3; i6++) {
                    byte[] bArr4 = this.i;
                    int i7 = this.n + i6;
                    bArr4[i7] = (byte) (bArr4[i7] ^ bArr[i2 + i6]);
                }
                for (int i8 = 0; i8 < this.a.getBlockSize(); i8++) {
                    byte[] bArr5 = this.f;
                    bArr5[i8] = (byte) (bArr5[i8] ^ this.i[i8]);
                }
                BlockCipher blockCipher = this.a;
                byte[] bArr6 = this.f;
                blockCipher.processBlock(bArr6, 0, bArr6, 0);
                return;
            }
            for (int i9 = 0; i9 < this.a.getBlockSize(); i9++) {
                byte[] bArr7 = this.f;
                bArr7[i9] = (byte) (bArr7[i9] ^ this.i[i9]);
            }
            BlockCipher blockCipher2 = this.a;
            byte[] bArr8 = this.f;
            blockCipher2.processBlock(bArr8, 0, bArr8, 0);
            while (i3 != 0) {
                for (int i10 = 0; i10 < this.a.getBlockSize(); i10++) {
                    byte[] bArr9 = this.f;
                    bArr9[i10] = (byte) (bArr9[i10] ^ bArr[i10 + i2]);
                }
                BlockCipher blockCipher3 = this.a;
                byte[] bArr10 = this.f;
                blockCipher3.processBlock(bArr10, 0, bArr10, 0);
                i2 += this.a.getBlockSize();
                i3 -= this.a.getBlockSize();
            }
        } else {
            throw new IllegalArgumentException("padding not supported");
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        int processPacket = processPacket(this.m.a(), 0, this.m.size(), bArr, i2);
        reset();
        return processPacket;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/KCCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        return Arrays.clone(this.e);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        return i2 + this.b;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        return i2;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            if (aEADParameters.getMacSize() > 512 || aEADParameters.getMacSize() < 64 || aEADParameters.getMacSize() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.g = aEADParameters.getNonce();
            this.b = aEADParameters.getMacSize() / 8;
            this.d = aEADParameters.getAssociatedText();
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.g = parametersWithIV.getIV();
            this.b = this.a.getBlockSize();
            this.d = null;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameters specified");
        }
        this.e = new byte[this.b];
        this.c = z;
        this.a.init(true, cipherParameters2);
        this.k[0] = 1;
        byte[] bArr = this.d;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        this.l.write(b2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        this.l.write(bArr, i2, i3);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        this.m.write(b2);
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i2 + i3) {
            this.m.write(bArr, i2, i3);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public int processPacket(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalStateException, InvalidCipherTextException {
        int i5;
        if (bArr.length - i2 < i3) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i4 >= i3) {
            if (this.l.size() > 0) {
                if (this.c) {
                    d(this.l.a(), 0, this.l.size(), this.m.size());
                } else {
                    d(this.l.a(), 0, this.l.size(), this.m.size() - this.b);
                }
            }
            if (this.c) {
                if (i3 % this.a.getBlockSize() == 0) {
                    a(bArr, i2, i3);
                    this.a.processBlock(this.g, 0, this.j, 0);
                    int i6 = i3;
                    while (i6 > 0) {
                        b(bArr, i2, bArr2, i4);
                        i6 -= this.a.getBlockSize();
                        i2 += this.a.getBlockSize();
                        i4 += this.a.getBlockSize();
                    }
                    int i7 = 0;
                    while (true) {
                        byte[] bArr3 = this.k;
                        if (i7 >= bArr3.length) {
                            break;
                        }
                        byte[] bArr4 = this.j;
                        bArr4[i7] = (byte) (bArr4[i7] + bArr3[i7]);
                        i7++;
                    }
                    this.a.processBlock(this.j, 0, this.i, 0);
                    int i8 = 0;
                    while (true) {
                        int i9 = this.b;
                        if (i8 < i9) {
                            bArr2[i4 + i8] = (byte) (this.i[i8] ^ this.f[i8]);
                            i8++;
                        } else {
                            System.arraycopy(this.f, 0, this.e, 0, i9);
                            reset();
                            return i3 + this.b;
                        }
                    }
                } else {
                    throw new DataLengthException("partial blocks not supported");
                }
            } else if ((i3 - this.b) % this.a.getBlockSize() == 0) {
                this.a.processBlock(this.g, 0, this.j, 0);
                int blockSize = i3 / this.a.getBlockSize();
                for (int i10 = 0; i10 < blockSize; i10++) {
                    b(bArr, i2, bArr2, i4);
                    i2 += this.a.getBlockSize();
                    i4 += this.a.getBlockSize();
                }
                if (i3 > i2) {
                    int i11 = 0;
                    while (true) {
                        byte[] bArr5 = this.k;
                        if (i11 >= bArr5.length) {
                            break;
                        }
                        byte[] bArr6 = this.j;
                        bArr6[i11] = (byte) (bArr6[i11] + bArr5[i11]);
                        i11++;
                    }
                    this.a.processBlock(this.j, 0, this.i, 0);
                    int i12 = 0;
                    while (true) {
                        i5 = this.b;
                        if (i12 >= i5) {
                            break;
                        }
                        bArr2[i4 + i12] = (byte) (this.i[i12] ^ bArr[i2 + i12]);
                        i12++;
                    }
                    i4 += i5;
                }
                int i13 = 0;
                while (true) {
                    byte[] bArr7 = this.k;
                    if (i13 >= bArr7.length) {
                        break;
                    }
                    byte[] bArr8 = this.j;
                    bArr8[i13] = (byte) (bArr8[i13] + bArr7[i13]);
                    i13++;
                }
                this.a.processBlock(this.j, 0, this.i, 0);
                int i14 = this.b;
                System.arraycopy(bArr2, i4 - i14, this.i, 0, i14);
                a(bArr2, 0, i4 - this.b);
                System.arraycopy(this.f, 0, this.e, 0, this.b);
                int i15 = this.b;
                byte[] bArr9 = new byte[i15];
                System.arraycopy(this.i, 0, bArr9, 0, i15);
                if (Arrays.constantTimeAreEqual(this.e, bArr9)) {
                    reset();
                    return i3 - this.b;
                }
                throw new InvalidCipherTextException("mac check failed");
            } else {
                throw new DataLengthException("partial blocks not supported");
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        Arrays.fill(this.h, (byte) 0);
        Arrays.fill(this.i, (byte) 0);
        Arrays.fill(this.k, (byte) 0);
        Arrays.fill(this.f, (byte) 0);
        this.k[0] = 1;
        this.m.reset();
        this.l.reset();
        byte[] bArr = this.d;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher, int i2) {
        this.l = new a(this);
        this.m = new a(this);
        this.n = 4;
        this.a = blockCipher;
        this.b = blockCipher.getBlockSize();
        this.g = new byte[blockCipher.getBlockSize()];
        this.d = new byte[blockCipher.getBlockSize()];
        this.e = new byte[blockCipher.getBlockSize()];
        this.f = new byte[blockCipher.getBlockSize()];
        this.h = new byte[blockCipher.getBlockSize()];
        this.i = new byte[blockCipher.getBlockSize()];
        this.j = new byte[blockCipher.getBlockSize()];
        this.k = new byte[blockCipher.getBlockSize()];
        if (i2 == 4 || i2 == 6 || i2 == 8) {
            this.n = i2;
            return;
        }
        throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
    }
}
