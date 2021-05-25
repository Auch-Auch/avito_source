package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class CBCBlockCipher implements BlockCipher {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;
    public BlockCipher e = null;
    public boolean f;

    public CBCBlockCipher(BlockCipher blockCipher) {
        this.e = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.d = blockSize;
        this.a = new byte[blockSize];
        this.b = new byte[blockSize];
        this.c = new byte[blockSize];
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.e.getAlgorithmName() + "/CBC";
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
        boolean z2 = this.f;
        this.f = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length == this.d) {
                System.arraycopy(iv, 0, this.a, 0, iv.length);
                reset();
                if (parametersWithIV.getParameters() != null) {
                    this.e.init(z, parametersWithIV.getParameters());
                } else if (z2 != z) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                }
            } else {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
        } else {
            reset();
            if (cipherParameters != null) {
                this.e.init(z, cipherParameters);
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        if (!this.f) {
            int i3 = this.d;
            if (i + i3 <= bArr.length) {
                System.arraycopy(bArr, i, this.c, 0, i3);
                int processBlock = this.e.processBlock(bArr, i, bArr2, i2);
                for (int i4 = 0; i4 < this.d; i4++) {
                    int i5 = i2 + i4;
                    bArr2[i5] = (byte) (bArr2[i5] ^ this.b[i4]);
                }
                byte[] bArr3 = this.b;
                this.b = this.c;
                this.c = bArr3;
                return processBlock;
            }
            throw new DataLengthException("input buffer too short");
        } else if (this.d + i <= bArr.length) {
            for (int i6 = 0; i6 < this.d; i6++) {
                byte[] bArr4 = this.b;
                bArr4[i6] = (byte) (bArr4[i6] ^ bArr[i + i6]);
            }
            int processBlock2 = this.e.processBlock(this.b, 0, bArr2, i2);
            byte[] bArr5 = this.b;
            System.arraycopy(bArr2, i2, bArr5, 0, bArr5.length);
            return processBlock2;
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.a;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        Arrays.fill(this.c, (byte) 0);
        this.e.reset();
    }
}
