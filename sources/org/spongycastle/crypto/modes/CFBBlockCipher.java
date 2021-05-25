package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class CFBBlockCipher extends StreamBlockCipher {
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public int f;
    public BlockCipher g = null;
    public boolean h;
    public int i;

    public CFBBlockCipher(BlockCipher blockCipher, int i2) {
        super(blockCipher);
        this.g = blockCipher;
        this.f = i2 / 8;
        this.b = new byte[blockCipher.getBlockSize()];
        this.c = new byte[blockCipher.getBlockSize()];
        this.d = new byte[blockCipher.getBlockSize()];
        this.e = new byte[this.f];
    }

    @Override // org.spongycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b2) throws DataLengthException, IllegalStateException {
        byte b3;
        if (this.h) {
            if (this.i == 0) {
                this.g.processBlock(this.c, 0, this.d, 0);
            }
            byte[] bArr = this.d;
            int i2 = this.i;
            b3 = (byte) (b2 ^ bArr[i2]);
            byte[] bArr2 = this.e;
            int i3 = i2 + 1;
            this.i = i3;
            bArr2[i2] = b3;
            int i4 = this.f;
            if (i3 == i4) {
                this.i = 0;
                byte[] bArr3 = this.c;
                System.arraycopy(bArr3, i4, bArr3, 0, bArr3.length - i4);
                byte[] bArr4 = this.e;
                byte[] bArr5 = this.c;
                int length = bArr5.length;
                int i5 = this.f;
                System.arraycopy(bArr4, 0, bArr5, length - i5, i5);
            }
        } else {
            if (this.i == 0) {
                this.g.processBlock(this.c, 0, this.d, 0);
            }
            byte[] bArr6 = this.e;
            int i6 = this.i;
            bArr6[i6] = b2;
            byte[] bArr7 = this.d;
            int i7 = i6 + 1;
            this.i = i7;
            b3 = (byte) (b2 ^ bArr7[i6]);
            int i8 = this.f;
            if (i7 == i8) {
                this.i = 0;
                byte[] bArr8 = this.c;
                System.arraycopy(bArr8, i8, bArr8, 0, bArr8.length - i8);
                byte[] bArr9 = this.e;
                byte[] bArr10 = this.c;
                int length2 = bArr10.length;
                int i9 = this.f;
                System.arraycopy(bArr9, 0, bArr10, length2 - i9, i9);
            }
        }
        return b3;
    }

    public int decryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i2, this.f, bArr2, i3);
        return this.f;
    }

    public int encryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i2, this.f, bArr2, i3);
        return this.f;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.g.getAlgorithmName() + "/CFB" + (this.f * 8);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.c);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.h = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.b;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i2 = 0;
                while (true) {
                    byte[] bArr2 = this.b;
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
            if (parametersWithIV.getParameters() != null) {
                this.g.init(true, parametersWithIV.getParameters());
                return;
            }
            return;
        }
        reset();
        if (cipherParameters != null) {
            this.g.init(true, cipherParameters);
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i2, this.f, bArr2, i3);
        return this.f;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.b;
        System.arraycopy(bArr, 0, this.c, 0, bArr.length);
        Arrays.fill(this.e, (byte) 0);
        this.i = 0;
        this.g.reset();
    }
}
