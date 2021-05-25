package org.spongycastle.jce.provider;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KDFParameters;
public class BrokenKDF2BytesGenerator implements DerivationFunction {
    public Digest a;
    public byte[] b;
    public byte[] c;

    public BrokenKDF2BytesGenerator(Digest digest) {
        this.a = digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i2 >= i) {
            long j = ((long) i2) * 8;
            if (j > ((long) this.a.getDigestSize()) * 8 * 2147483648L) {
                new IllegalArgumentException("Output length to large");
            }
            int digestSize = (int) (j / ((long) this.a.getDigestSize()));
            int digestSize2 = this.a.getDigestSize();
            byte[] bArr2 = new byte[digestSize2];
            for (int i3 = 1; i3 <= digestSize; i3++) {
                Digest digest = this.a;
                byte[] bArr3 = this.b;
                digest.update(bArr3, 0, bArr3.length);
                this.a.update((byte) (i3 & 255));
                this.a.update((byte) ((i3 >> 8) & 255));
                this.a.update((byte) ((i3 >> 16) & 255));
                this.a.update((byte) ((i3 >> 24) & 255));
                Digest digest2 = this.a;
                byte[] bArr4 = this.c;
                digest2.update(bArr4, 0, bArr4.length);
                this.a.doFinal(bArr2, 0);
                int i4 = i2 - i;
                if (i4 > digestSize2) {
                    System.arraycopy(bArr2, 0, bArr, i, digestSize2);
                    i += digestSize2;
                } else {
                    System.arraycopy(bArr2, 0, bArr, i, i4);
                }
            }
            this.a.reset();
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
