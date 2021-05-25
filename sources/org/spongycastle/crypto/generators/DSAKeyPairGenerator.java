package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;
public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final BigInteger b = BigInteger.valueOf(1);
    public DSAKeyGenerationParameters a;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger createRandomInRange;
        DSAParameters parameters = this.a.getParameters();
        BigInteger q = parameters.getQ();
        SecureRandom random = this.a.getRandom();
        int bitLength = q.bitLength() >>> 2;
        do {
            BigInteger bigInteger = b;
            createRandomInRange = BigIntegers.createRandomInRange(bigInteger, q.subtract(bigInteger), random);
        } while (WNafUtil.getNafWeight(createRandomInRange) < bitLength);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DSAPublicKeyParameters(parameters.getG().modPow(createRandomInRange, parameters.getP()), parameters), (AsymmetricKeyParameter) new DSAPrivateKeyParameters(createRandomInRange, parameters));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = (DSAKeyGenerationParameters) keyGenerationParameters;
    }
}
