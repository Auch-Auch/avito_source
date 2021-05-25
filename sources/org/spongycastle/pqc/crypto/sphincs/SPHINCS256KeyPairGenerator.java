package org.spongycastle.pqc.crypto.sphincs;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import x6.e.f.a.c.a;
import x6.e.f.a.c.c;
public class SPHINCS256KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public SecureRandom a;
    public Digest b;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        c.a aVar = new c.a();
        byte[] bArr = new byte[1088];
        this.a.nextBytes(bArr);
        byte[] bArr2 = new byte[1056];
        System.arraycopy(bArr, 32, bArr2, 0, 1024);
        aVar.a = 11;
        aVar.b = 0;
        aVar.c = 0;
        c.b(new a(this.b), bArr2, 1024, 5, bArr, aVar, bArr2, 0);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SPHINCSPublicKeyParameters(bArr2), (AsymmetricKeyParameter) new SPHINCSPrivateKeyParameters(bArr));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = keyGenerationParameters.getRandom();
        this.b = ((SPHINCS256KeyGenerationParameters) keyGenerationParameters).getTreeDigest();
    }
}
