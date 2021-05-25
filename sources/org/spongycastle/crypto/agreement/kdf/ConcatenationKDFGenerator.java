package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KDFParameters;
public class ConcatenationKDFGenerator implements DerivationFunction {
    public Digest a;
    public byte[] b;
    public byte[] c;
    public int d;

    public ConcatenationKDFGenerator(Digest digest) {
        this.a = digest;
        this.d = digest.getDigestSize();
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
        int i4;
        if (bArr.length - i2 >= i) {
            byte[] bArr2 = new byte[this.d];
            byte[] bArr3 = new byte[4];
            this.a.reset();
            int i5 = 1;
            if (i2 > this.d) {
                i3 = 0;
                while (true) {
                    a(i5, bArr3);
                    this.a.update(bArr3, 0, 4);
                    Digest digest = this.a;
                    byte[] bArr4 = this.b;
                    digest.update(bArr4, 0, bArr4.length);
                    Digest digest2 = this.a;
                    byte[] bArr5 = this.c;
                    digest2.update(bArr5, 0, bArr5.length);
                    this.a.doFinal(bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i + i3, this.d);
                    int i6 = this.d;
                    i3 += i6;
                    i4 = i5 + 1;
                    if (i5 >= i2 / i6) {
                        break;
                    }
                    i5 = i4;
                }
                i5 = i4;
            } else {
                i3 = 0;
            }
            if (i3 < i2) {
                a(i5, bArr3);
                this.a.update(bArr3, 0, 4);
                Digest digest3 = this.a;
                byte[] bArr6 = this.b;
                digest3.update(bArr6, 0, bArr6.length);
                Digest digest4 = this.a;
                byte[] bArr7 = this.c;
                digest4.update(bArr7, 0, bArr7.length);
                this.a.doFinal(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i + i3, i2 - i3);
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
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.b = kDFParameters.getSharedSecret();
            this.c = kDFParameters.getIV();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
