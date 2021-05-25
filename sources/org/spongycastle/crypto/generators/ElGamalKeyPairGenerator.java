package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import x6.e.b.b.a;
public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public ElGamalKeyGenerationParameters a;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        a aVar = a.a;
        ElGamalParameters parameters = this.a.getParameters();
        DHParameters dHParameters = new DHParameters(parameters.getP(), parameters.getG(), null, parameters.getL());
        BigInteger a3 = a.a(dHParameters, this.a.getRandom());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ElGamalPublicKeyParameters(a.b(dHParameters, a3), parameters), (AsymmetricKeyParameter) new ElGamalPrivateKeyParameters(a3, parameters));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = (ElGamalKeyGenerationParameters) keyGenerationParameters;
    }
}
