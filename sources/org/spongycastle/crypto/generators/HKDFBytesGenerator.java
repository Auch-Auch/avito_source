package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.HKDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
public class HKDFBytesGenerator implements DerivationFunction {
    public HMac a;
    public int b;
    public byte[] c;
    public byte[] d;
    public int e;

    public HKDFBytesGenerator(Digest digest) {
        this.a = new HMac(digest);
        this.b = digest.getDigestSize();
    }

    public final void a() throws DataLengthException {
        int i = this.e;
        int i2 = this.b;
        int i3 = (i / i2) + 1;
        if (i3 < 256) {
            if (i != 0) {
                this.a.update(this.d, 0, i2);
            }
            HMac hMac = this.a;
            byte[] bArr = this.c;
            hMac.update(bArr, 0, bArr.length);
            this.a.update((byte) i3);
            this.a.doFinal(this.d, 0);
            return;
        }
        throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        int i3 = this.e;
        int i4 = i3 + i2;
        int i5 = this.b;
        if (i4 <= i5 * 255) {
            if (i3 % i5 == 0) {
                a();
            }
            int i6 = this.e;
            int i7 = this.b;
            int i8 = i6 % i7;
            int min = Math.min(i7 - (i6 % i7), i2);
            System.arraycopy(this.d, i8, bArr, i, min);
            this.e += min;
            int i9 = i2 - min;
            while (true) {
                i += min;
                if (i9 <= 0) {
                    return i2;
                }
                a();
                min = Math.min(this.b, i9);
                System.arraycopy(this.d, 0, bArr, i, min);
                this.e += min;
                i9 -= min;
            }
        } else {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
    }

    public Digest getDigest() {
        return this.a.getUnderlyingDigest();
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof HKDFParameters) {
            HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
            if (hKDFParameters.skipExtract()) {
                this.a.init(new KeyParameter(hKDFParameters.getIKM()));
            } else {
                HMac hMac = this.a;
                byte[] salt = hKDFParameters.getSalt();
                byte[] ikm = hKDFParameters.getIKM();
                if (salt == null) {
                    this.a.init(new KeyParameter(new byte[this.b]));
                } else {
                    this.a.init(new KeyParameter(salt));
                }
                this.a.update(ikm, 0, ikm.length);
                byte[] bArr = new byte[this.b];
                this.a.doFinal(bArr, 0);
                hMac.init(new KeyParameter(bArr));
            }
            this.c = hKDFParameters.getInfo();
            this.e = 0;
            this.d = new byte[this.b];
            return;
        }
        throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
    }
}
