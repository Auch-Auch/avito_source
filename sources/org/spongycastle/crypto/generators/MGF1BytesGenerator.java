package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.MGFParameters;
public class MGF1BytesGenerator implements DerivationFunction {
    public Digest a;
    public byte[] b;
    public int c;

    public MGF1BytesGenerator(Digest digest) {
        this.a = digest;
        this.c = digest.getDigestSize();
    }

    public final void a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        int i3;
        if (bArr.length - i2 >= i) {
            byte[] bArr2 = new byte[this.c];
            byte[] bArr3 = new byte[4];
            this.a.reset();
            if (i2 > this.c) {
                i3 = 0;
                do {
                    a(i3, bArr3);
                    Digest digest = this.a;
                    byte[] bArr4 = this.b;
                    digest.update(bArr4, 0, bArr4.length);
                    this.a.update(bArr3, 0, 4);
                    this.a.doFinal(bArr2, 0);
                    int i4 = this.c;
                    System.arraycopy(bArr2, 0, bArr, (i3 * i4) + i, i4);
                    i3++;
                } while (i3 < i2 / this.c);
            } else {
                i3 = 0;
            }
            if (this.c * i3 < i2) {
                a(i3, bArr3);
                Digest digest2 = this.a;
                byte[] bArr5 = this.b;
                digest2.update(bArr5, 0, bArr5.length);
                this.a.update(bArr3, 0, 4);
                this.a.doFinal(bArr2, 0);
                int i5 = this.c;
                System.arraycopy(bArr2, 0, bArr, (i3 * i5) + i, i2 - (i3 * i5));
            }
            return i2;
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof MGFParameters) {
            this.b = ((MGFParameters) derivationParameters).getSeed();
            return;
        }
        throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
    }
}
