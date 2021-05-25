package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
public class EAXBlockCipher implements AEADBlockCipher {
    public SICBlockCipher a;
    public boolean b;
    public int c;
    public Mac d;
    public byte[] e;
    public byte[] f;
    public byte[] g = new byte[this.c];
    public int h;
    public byte[] i;
    public int j;
    public boolean k;
    public byte[] l;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.c = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.d = cMac;
        this.f = new byte[cMac.getMacSize()];
        this.e = new byte[this.d.getMacSize()];
        this.a = new SICBlockCipher(blockCipher);
    }

    public final void a() {
        byte[] bArr = new byte[this.c];
        int i2 = 0;
        this.d.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.g;
            if (i2 < bArr2.length) {
                bArr2[i2] = (byte) ((this.e[i2] ^ this.f[i2]) ^ bArr[i2]);
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b() {
        if (!this.k) {
            this.k = true;
            this.d.doFinal(this.f, 0);
            int i2 = this.c;
            byte[] bArr = new byte[i2];
            bArr[i2 - 1] = 2;
            this.d.update(bArr, 0, i2);
        }
    }

    public final int c(byte b2, byte[] bArr, int i2) {
        int i3;
        byte[] bArr2 = this.i;
        int i4 = this.j;
        int i5 = i4 + 1;
        this.j = i5;
        bArr2[i4] = b2;
        if (i5 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i6 = this.c;
        if (length >= i2 + i6) {
            if (this.b) {
                i3 = this.a.processBlock(bArr2, 0, bArr, i2);
                this.d.update(bArr, i2, this.c);
            } else {
                this.d.update(bArr2, 0, i6);
                i3 = this.a.processBlock(this.i, 0, bArr, i2);
            }
            this.j = 0;
            if (!this.b) {
                byte[] bArr3 = this.i;
                System.arraycopy(bArr3, this.c, bArr3, 0, this.h);
                this.j = this.h;
            }
            return i3;
        }
        throw new OutputLengthException("Output buffer is too short");
    }

    public final void d(boolean z) {
        this.a.reset();
        this.d.reset();
        this.j = 0;
        Arrays.fill(this.i, (byte) 0);
        if (z) {
            Arrays.fill(this.g, (byte) 0);
        }
        int i2 = this.c;
        byte[] bArr = new byte[i2];
        bArr[i2 - 1] = 1;
        this.d.update(bArr, 0, i2);
        this.k = false;
        byte[] bArr2 = this.l;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        b();
        int i3 = this.j;
        byte[] bArr2 = this.i;
        byte[] bArr3 = new byte[bArr2.length];
        this.j = 0;
        if (this.b) {
            int i4 = i2 + i3;
            if (bArr.length >= this.h + i4) {
                this.a.processBlock(bArr2, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i2, i3);
                this.d.update(bArr3, 0, i3);
                a();
                System.arraycopy(this.g, 0, bArr, i4, this.h);
                d(false);
                return i3 + this.h;
            }
            throw new OutputLengthException("Output buffer too short");
        }
        int i5 = this.h;
        if (i3 < i5) {
            throw new InvalidCipherTextException("data too short");
        } else if (bArr.length >= (i2 + i3) - i5) {
            if (i3 > i5) {
                this.d.update(bArr2, 0, i3 - i5);
                this.a.processBlock(this.i, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i2, i3 - this.h);
            }
            a();
            byte[] bArr4 = this.i;
            int i6 = i3 - this.h;
            int i7 = 0;
            for (int i8 = 0; i8 < this.h; i8++) {
                i7 |= this.g[i8] ^ bArr4[i6 + i8];
            }
            if (i7 == 0) {
                d(false);
                return i3 - this.h;
            }
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.a.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.a.getBlockSize();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i2 = this.h;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.g, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int i3 = i2 + this.j;
        if (this.b) {
            return i3 + this.h;
        }
        int i4 = this.h;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.a.getUnderlyingCipher();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.j;
        if (!this.b) {
            int i4 = this.h;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % this.c);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        this.b = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.l = aEADParameters.getAssociatedText();
            this.h = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.l = null;
            this.h = this.d.getMacSize() / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        this.i = new byte[(z ? this.c : this.c + this.h)];
        byte[] bArr2 = new byte[this.c];
        this.d.init(cipherParameters2);
        int i2 = this.c;
        bArr2[i2 - 1] = 0;
        this.d.update(bArr2, 0, i2);
        this.d.update(bArr, 0, bArr.length);
        this.d.doFinal(this.e, 0);
        this.a.init(true, new ParametersWithIV(null, this.e));
        reset();
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        if (!this.k) {
            this.d.update(b2);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        if (!this.k) {
            this.d.update(bArr, i2, i3);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
        b();
        return c(b2, bArr, i2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        b();
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 != i3; i6++) {
                i5 += c(bArr[i2 + i6], bArr2, i4 + i5);
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        d(true);
    }
}
