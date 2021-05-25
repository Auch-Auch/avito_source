package org.spongycastle.crypto.modes;

import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
public class GOFBBlockCipher extends StreamBlockCipher {
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public final int f;
    public final BlockCipher g;
    public boolean h = true;
    public int i;
    public int j;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.g = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.f = blockSize;
        if (blockSize == 8) {
            this.b = new byte[blockCipher.getBlockSize()];
            this.c = new byte[blockCipher.getBlockSize()];
            this.d = new byte[blockCipher.getBlockSize()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    public final int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr[i2 + 2] << Ascii.DLE) & 16711680) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public final void b(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >>> 24);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3] = (byte) i2;
    }

    @Override // org.spongycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b2) {
        if (this.e == 0) {
            if (this.h) {
                this.h = false;
                this.g.processBlock(this.c, 0, this.d, 0);
                this.i = a(this.d, 0);
                this.j = a(this.d, 4);
            }
            int i2 = this.i + 16843009;
            this.i = i2;
            int i3 = this.j + 16843012;
            this.j = i3;
            if (i3 < 16843012 && i3 > 0) {
                this.j = i3 + 1;
            }
            b(i2, this.c, 0);
            b(this.j, this.c, 4);
            this.g.processBlock(this.c, 0, this.d, 0);
        }
        byte[] bArr = this.d;
        int i4 = this.e;
        int i5 = i4 + 1;
        this.e = i5;
        byte b3 = (byte) (b2 ^ bArr[i4]);
        int i6 = this.f;
        if (i5 == i6) {
            this.e = 0;
            byte[] bArr2 = this.c;
            System.arraycopy(bArr2, i6, bArr2, 0, bArr2.length - i6);
            byte[] bArr3 = this.d;
            byte[] bArr4 = this.c;
            int length = bArr4.length;
            int i7 = this.f;
            System.arraycopy(bArr3, 0, bArr4, length - i7, i7);
        }
        return b3;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.g.getAlgorithmName() + "/GCTR";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.h = true;
        this.i = 0;
        this.j = 0;
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
        this.h = true;
        this.i = 0;
        this.j = 0;
        byte[] bArr = this.b;
        System.arraycopy(bArr, 0, this.c, 0, bArr.length);
        this.e = 0;
        this.g.reset();
    }
}
