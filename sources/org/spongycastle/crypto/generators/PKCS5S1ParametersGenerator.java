package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    public Digest a;

    public PKCS5S1ParametersGenerator(Digest digest) {
        this.a = digest;
    }

    public final byte[] a() {
        int digestSize = this.a.getDigestSize();
        byte[] bArr = new byte[digestSize];
        Digest digest = this.a;
        byte[] bArr2 = this.password;
        digest.update(bArr2, 0, bArr2.length);
        Digest digest2 = this.a;
        byte[] bArr3 = this.salt;
        digest2.update(bArr3, 0, bArr3.length);
        this.a.doFinal(bArr, 0);
        for (int i = 1; i < this.iterationCount; i++) {
            this.a.update(bArr, 0, digestSize);
            this.a.doFinal(bArr, 0);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        if (i2 <= this.a.getDigestSize()) {
            return new KeyParameter(a(), 0, i2);
        }
        throw new IllegalArgumentException(a.Q2("Can't generate a derived key ", i2, " bytes long."));
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        if (i5 <= this.a.getDigestSize()) {
            byte[] a3 = a();
            return new ParametersWithIV(new KeyParameter(a3, 0, i3), a3, i3, i4);
        }
        throw new IllegalArgumentException(a.Q2("Can't generate a derived key ", i5, " bytes long."));
    }
}
