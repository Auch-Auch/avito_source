package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
public class OFBBlockCipher extends StreamBlockCipher {
    public int b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public final int f;
    public final BlockCipher g;

    public OFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.g = blockCipher;
        this.f = i / 8;
        this.c = new byte[blockCipher.getBlockSize()];
        this.d = new byte[blockCipher.getBlockSize()];
        this.e = new byte[blockCipher.getBlockSize()];
    }

    @Override // org.spongycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b2) throws DataLengthException, IllegalStateException {
        if (this.b == 0) {
            this.g.processBlock(this.d, 0, this.e, 0);
        }
        byte[] bArr = this.e;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b3 = (byte) (b2 ^ bArr[i]);
        int i3 = this.f;
        if (i2 == i3) {
            this.b = 0;
            byte[] bArr2 = this.d;
            System.arraycopy(bArr2, i3, bArr2, 0, bArr2.length - i3);
            byte[] bArr3 = this.e;
            byte[] bArr4 = this.d;
            int length = bArr4.length;
            int i4 = this.f;
            System.arraycopy(bArr3, 0, bArr4, length - i4, i4);
        }
        return b3;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.g.getAlgorithmName() + "/OFB" + (this.f * 8);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.c;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.c;
                    if (i >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i] = 0;
                    i++;
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
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i, this.f, bArr2, i2);
        return this.f;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.c;
        System.arraycopy(bArr, 0, this.d, 0, bArr.length);
        this.b = 0;
        this.g.reset();
    }
}
