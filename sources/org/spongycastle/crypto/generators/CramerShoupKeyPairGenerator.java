package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.CramerShoupKeyGenerationParameters;
import org.spongycastle.crypto.params.CramerShoupParameters;
import org.spongycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.spongycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.spongycastle.util.BigIntegers;
public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final BigInteger b = BigInteger.valueOf(1);
    public CramerShoupKeyGenerationParameters a;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        CramerShoupParameters parameters = this.a.getParameters();
        SecureRandom random = this.a.getRandom();
        BigInteger p = parameters.getP();
        BigInteger bigInteger = b;
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = new CramerShoupPrivateKeyParameters(parameters, BigIntegers.createRandomInRange(bigInteger, p.subtract(bigInteger), random), BigIntegers.createRandomInRange(bigInteger, p.subtract(bigInteger), random), BigIntegers.createRandomInRange(bigInteger, p.subtract(bigInteger), random), BigIntegers.createRandomInRange(bigInteger, p.subtract(bigInteger), random), BigIntegers.createRandomInRange(bigInteger, p.subtract(bigInteger), random));
        BigInteger g1 = parameters.getG1();
        BigInteger g2 = parameters.getG2();
        BigInteger p2 = parameters.getP();
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = new CramerShoupPublicKeyParameters(parameters, g1.modPow(cramerShoupPrivateKeyParameters.getX1(), p2).multiply(g2.modPow(cramerShoupPrivateKeyParameters.getX2(), p2)), g1.modPow(cramerShoupPrivateKeyParameters.getY1(), p2).multiply(g2.modPow(cramerShoupPrivateKeyParameters.getY2(), p2)), g1.modPow(cramerShoupPrivateKeyParameters.getZ(), p2));
        cramerShoupPrivateKeyParameters.setPk(cramerShoupPublicKeyParameters);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) cramerShoupPublicKeyParameters, (AsymmetricKeyParameter) cramerShoupPrivateKeyParameters);
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = (CramerShoupKeyGenerationParameters) keyGenerationParameters;
    }
}
