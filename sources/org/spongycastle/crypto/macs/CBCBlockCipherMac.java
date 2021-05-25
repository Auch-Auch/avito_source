package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
public class CBCBlockCipherMac implements Mac {
    public byte[] a;
    public byte[] b;
    public int c;
    public BlockCipher d;
    public BlockCipherPadding e;
    public int f;

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, null);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int blockSize = this.d.getBlockSize();
        if (this.e == null) {
            while (true) {
                int i2 = this.c;
                if (i2 >= blockSize) {
                    break;
                }
                this.b[i2] = 0;
                this.c = i2 + 1;
            }
        } else {
            if (this.c == blockSize) {
                this.d.processBlock(this.b, 0, this.a, 0);
                this.c = 0;
            }
            this.e.addPadding(this.b, this.c);
        }
        this.d.processBlock(this.b, 0, this.a, 0);
        System.arraycopy(this.a, 0, bArr, i, this.f);
        reset();
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.d.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        reset();
        this.d.init(true, cipherParameters);
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.c = 0;
                this.d.reset();
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        int i = this.c;
        byte[] bArr = this.b;
        if (i == bArr.length) {
            this.d.processBlock(bArr, 0, this.a, 0);
            this.c = 0;
        }
        byte[] bArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr2[i2] = b2;
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 == 0) {
            this.d = new CBCBlockCipher(blockCipher);
            this.e = blockCipherPadding;
            this.f = i / 8;
            this.a = new byte[blockCipher.getBlockSize()];
            this.b = new byte[blockCipher.getBlockSize()];
            this.c = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.d.getBlockSize();
            int i3 = this.c;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.b, i3, i4);
                this.d.processBlock(this.b, 0, this.a, 0);
                this.c = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    this.d.processBlock(bArr, i, this.a, 0);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.b, this.c, i2);
            this.c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
