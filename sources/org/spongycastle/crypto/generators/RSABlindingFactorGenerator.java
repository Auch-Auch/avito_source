package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
public class RSABlindingFactorGenerator {
    public static BigInteger c = BigInteger.valueOf(0);
    public static BigInteger d = BigInteger.valueOf(1);
    public RSAKeyParameters a;
    public SecureRandom b;

    public BigInteger generateBlindingFactor() {
        RSAKeyParameters rSAKeyParameters = this.a;
        if (rSAKeyParameters != null) {
            BigInteger modulus = rSAKeyParameters.getModulus();
            int bitLength = modulus.bitLength() - 1;
            while (true) {
                BigInteger bigInteger = new BigInteger(bitLength, this.b);
                BigInteger gcd = bigInteger.gcd(modulus);
                if (!bigInteger.equals(c) && !bigInteger.equals(d) && gcd.equals(d)) {
                    return bigInteger;
                }
            }
        } else {
            throw new IllegalStateException("generator not initialised");
        }
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = (RSAKeyParameters) parametersWithRandom.getParameters();
            this.b = parametersWithRandom.getRandom();
        } else {
            this.a = (RSAKeyParameters) cipherParameters;
            this.b = new SecureRandom();
        }
        if (this.a instanceof RSAPrivateCrtKeyParameters) {
            throw new IllegalArgumentException("generator requires RSA public key");
        }
    }
}
