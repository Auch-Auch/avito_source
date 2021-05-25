package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class ISO9797Alg3Mac implements Mac {
    public byte[] a;
    public byte[] b;
    public int c;
    public BlockCipher d;
    public BlockCipherPadding e;
    public int f;
    public KeyParameter g;
    public KeyParameter h;

    public ISO9797Alg3Mac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8, null);
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
        DESEngine dESEngine = new DESEngine();
        dESEngine.init(false, this.g);
        byte[] bArr2 = this.a;
        dESEngine.processBlock(bArr2, 0, bArr2, 0);
        dESEngine.init(true, this.h);
        byte[] bArr3 = this.a;
        dESEngine.processBlock(bArr3, 0, bArr3, 0);
        System.arraycopy(this.a, 0, bArr, i, this.f);
        reset();
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "ISO9797Alg3";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        KeyParameter keyParameter2;
        reset();
        boolean z = cipherParameters instanceof KeyParameter;
        if (z || (cipherParameters instanceof ParametersWithIV)) {
            if (z) {
                keyParameter = (KeyParameter) cipherParameters;
            } else {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters();
            }
            byte[] key = keyParameter.getKey();
            if (key.length == 16) {
                keyParameter2 = new KeyParameter(key, 0, 8);
                this.g = new KeyParameter(key, 8, 8);
                this.h = keyParameter2;
            } else if (key.length == 24) {
                keyParameter2 = new KeyParameter(key, 0, 8);
                this.g = new KeyParameter(key, 8, 8);
                this.h = new KeyParameter(key, 16, 8);
            } else {
                throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
            }
            if (cipherParameters instanceof ParametersWithIV) {
                this.d.init(true, new ParametersWithIV(keyParameter2, ((ParametersWithIV) cipherParameters).getIV()));
            } else {
                this.d.init(true, keyParameter2);
            }
        } else {
            throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
        }
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

    public ISO9797Alg3Mac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, blockCipher.getBlockSize() * 8, blockCipherPadding);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, null);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (blockCipher instanceof DESEngine) {
            this.d = new CBCBlockCipher(blockCipher);
            this.e = blockCipherPadding;
            this.f = i / 8;
            this.a = new byte[blockCipher.getBlockSize()];
            this.b = new byte[blockCipher.getBlockSize()];
            this.c = 0;
        } else {
            throw new IllegalArgumentException("cipher must be instance of DESEngine");
        }
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
