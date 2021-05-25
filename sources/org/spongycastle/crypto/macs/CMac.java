package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;
public class CMac implements Mac {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public BlockCipher f;
    public int g;
    public byte[] h;
    public byte[] i;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                int i3 = bArr[length] & 255;
                bArr2[length] = (byte) (i2 | (i3 << 1));
                i2 = (i3 >>> 7) & 1;
            } else {
                int i4 = (-i2) & 255;
                int length2 = bArr.length - 3;
                byte b2 = bArr2[length2];
                byte[] bArr3 = this.a;
                bArr2[length2] = (byte) (b2 ^ (bArr3[1] & i4));
                int length3 = bArr.length - 2;
                bArr2[length3] = (byte) ((bArr3[2] & i4) ^ bArr2[length3]);
                int length4 = bArr.length - 1;
                bArr2[length4] = (byte) ((i4 & bArr3[3]) ^ bArr2[length4]);
                return bArr2;
            }
        }
    }

    public void b(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) {
        byte[] bArr2;
        if (this.e == this.f.getBlockSize()) {
            bArr2 = this.h;
        } else {
            new ISO7816d4Padding().addPadding(this.d, this.e);
            bArr2 = this.i;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.c;
            if (i3 < bArr3.length) {
                byte[] bArr4 = this.d;
                bArr4[i3] = (byte) (bArr4[i3] ^ bArr2[i3]);
                i3++;
            } else {
                this.f.processBlock(this.d, 0, bArr3, 0);
                System.arraycopy(this.c, 0, bArr, i2, this.g);
                reset();
                return this.g;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.f.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.g;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        b(cipherParameters);
        this.f.init(true, cipherParameters);
        byte[] bArr = this.b;
        byte[] bArr2 = new byte[bArr.length];
        this.f.processBlock(bArr, 0, bArr2, 0);
        byte[] a3 = a(bArr2);
        this.h = a3;
        this.i = a(a3);
        reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i2 < bArr.length) {
                bArr[i2] = 0;
                i2++;
            } else {
                this.e = 0;
                this.f.reset();
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        int i2 = this.e;
        byte[] bArr = this.d;
        if (i2 == bArr.length) {
            this.f.processBlock(bArr, 0, this.c, 0);
            this.e = 0;
        }
        byte[] bArr2 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        bArr2[i3] = b2;
    }

    public CMac(BlockCipher blockCipher, int i2) {
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i2 <= blockCipher.getBlockSize() * 8) {
            this.f = new CBCBlockCipher(blockCipher);
            this.g = i2 / 8;
            int blockSize = blockCipher.getBlockSize() * 8;
            int i3 = 135;
            switch (blockSize) {
                case 64:
                case 320:
                    i3 = 27;
                    break;
                case 128:
                case 192:
                    break;
                case 160:
                    i3 = 45;
                    break;
                case 224:
                    i3 = 777;
                    break;
                case 256:
                    i3 = 1061;
                    break;
                case 384:
                    i3 = 4109;
                    break;
                case 448:
                    i3 = 2129;
                    break;
                case 512:
                    i3 = 293;
                    break;
                case 768:
                    i3 = 655377;
                    break;
                case 1024:
                    i3 = 524355;
                    break;
                case 2048:
                    i3 = 548865;
                    break;
                default:
                    throw new IllegalArgumentException(a.M2("Unknown block size for CMAC: ", blockSize));
            }
            this.a = Pack.intToBigEndian(i3);
            this.c = new byte[blockCipher.getBlockSize()];
            this.d = new byte[blockCipher.getBlockSize()];
            this.b = new byte[blockCipher.getBlockSize()];
            this.e = 0;
        } else {
            StringBuilder L = a.L("MAC size must be less or equal to ");
            L.append(blockCipher.getBlockSize() * 8);
            throw new IllegalArgumentException(L.toString());
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) {
        if (i3 >= 0) {
            int blockSize = this.f.getBlockSize();
            int i4 = this.e;
            int i5 = blockSize - i4;
            if (i3 > i5) {
                System.arraycopy(bArr, i2, this.d, i4, i5);
                this.f.processBlock(this.d, 0, this.c, 0);
                this.e = 0;
                i3 -= i5;
                i2 += i5;
                while (i3 > blockSize) {
                    this.f.processBlock(bArr, i2, this.c, 0);
                    i3 -= blockSize;
                    i2 += blockSize;
                }
            }
            System.arraycopy(bArr, i2, this.d, this.e, i3);
            this.e += i3;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
