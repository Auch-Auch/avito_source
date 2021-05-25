package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class KCTRBlockCipher extends StreamBlockCipher {
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public boolean f;
    public BlockCipher g;

    public KCTRBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.g = blockCipher;
        this.b = new byte[blockCipher.getBlockSize()];
        this.c = new byte[blockCipher.getBlockSize()];
        this.d = new byte[blockCipher.getBlockSize()];
    }

    @Override // org.spongycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b2) {
        byte[] bArr;
        int i = this.e;
        if (i == 0) {
            int i2 = 0;
            while (true) {
                bArr = this.c;
                if (i2 >= bArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                byte b3 = (byte) (bArr[i2] + 1);
                bArr[i2] = b3;
                if (b3 != 0) {
                    break;
                }
                i2 = i3;
            }
            this.g.processBlock(bArr, 0, this.d, 0);
            byte[] bArr2 = this.d;
            int i4 = this.e;
            this.e = i4 + 1;
            return (byte) (b2 ^ bArr2[i4]);
        }
        byte[] bArr3 = this.d;
        int i5 = i + 1;
        this.e = i5;
        byte b4 = (byte) (b2 ^ bArr3[i]);
        if (i5 == this.c.length) {
            this.e = 0;
        }
        return b4;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.g.getAlgorithmName() + "/KCTR";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.g.getBlockSize();
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f = true;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.b;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(iv, 0, this.b, bArr.length - iv.length, iv.length);
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters != null) {
                this.g.init(true, parameters);
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        if (bArr.length - i < getBlockSize()) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i2 >= getBlockSize()) {
            processBytes(bArr, i, getBlockSize(), bArr2, i2);
            return getBlockSize();
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        if (this.f) {
            this.g.processBlock(this.b, 0, this.c, 0);
        }
        this.g.reset();
        this.e = 0;
    }
}
