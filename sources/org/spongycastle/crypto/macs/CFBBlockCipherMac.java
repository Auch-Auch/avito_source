package org.spongycastle.crypto.macs;

import java.util.Objects;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.params.ParametersWithIV;
import x6.e.b.c.a;
public class CFBBlockCipherMac implements Mac {
    public byte[] a;
    public byte[] b;
    public int c;
    public a d;
    public BlockCipherPadding e;
    public int f;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, null);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int i2 = this.d.d;
        BlockCipherPadding blockCipherPadding = this.e;
        if (blockCipherPadding == null) {
            while (true) {
                int i3 = this.c;
                if (i3 >= i2) {
                    break;
                }
                this.b[i3] = 0;
                this.c = i3 + 1;
            }
        } else {
            blockCipherPadding.addPadding(this.b, this.c);
        }
        this.d.a(this.b, 0, this.a, 0);
        a aVar = this.d;
        aVar.e.processBlock(aVar.b, 0, this.a, 0);
        System.arraycopy(this.a, 0, bArr, i, this.f);
        reset();
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        a aVar = this.d;
        return aVar.e.getAlgorithmName() + "/CFB" + (aVar.d * 8);
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.f;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        reset();
        a aVar = this.d;
        Objects.requireNonNull(aVar);
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = aVar.a;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            aVar.b();
            aVar.e.init(true, parametersWithIV.getParameters());
            return;
        }
        aVar.b();
        aVar.e.init(true, cipherParameters);
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
                this.d.b();
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        int i = this.c;
        byte[] bArr = this.b;
        if (i == bArr.length) {
            this.d.a(bArr, 0, this.a, 0);
            this.c = 0;
        }
        byte[] bArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr2[i2] = b2;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i, int i2) {
        this(blockCipher, i, i2, null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i, int i2, BlockCipherPadding blockCipherPadding) {
        this.e = null;
        if (i2 % 8 == 0) {
            this.a = new byte[blockCipher.getBlockSize()];
            a aVar = new a(blockCipher, i);
            this.d = aVar;
            this.e = blockCipherPadding;
            this.f = i2 / 8;
            this.b = new byte[aVar.d];
            this.c = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int i3 = this.d.d;
            int i4 = this.c;
            int i5 = i3 - i4;
            if (i2 > i5) {
                System.arraycopy(bArr, i, this.b, i4, i5);
                this.d.a(this.b, 0, this.a, 0);
                this.c = 0;
                i2 -= i5;
                i += i5;
                while (i2 > i3) {
                    this.d.a(bArr, i, this.a, 0);
                    i2 -= i3;
                    i += i3;
                }
            }
            System.arraycopy(bArr, i, this.b, this.c, i2);
            this.c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
