package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.util.BigIntegers;
import x6.e.b.a.a;
public class RSABlindedEngine implements AsymmetricBlockCipher {
    public static final BigInteger d = BigInteger.valueOf(1);
    public a a = new a();
    public RSAKeyParameters b;
    public SecureRandom c;

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.a.c();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.a.d();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.a.e(z, cipherParameters);
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.b = (RSAKeyParameters) parametersWithRandom.getParameters();
            this.c = parametersWithRandom.getRandom();
            return;
        }
        this.b = (RSAKeyParameters) cipherParameters;
        this.c = new SecureRandom();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigInteger;
        if (this.b != null) {
            BigInteger a3 = this.a.a(bArr, i, i2);
            RSAKeyParameters rSAKeyParameters = this.b;
            if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
                BigInteger publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
                if (publicExponent != null) {
                    BigInteger modulus = rSAPrivateCrtKeyParameters.getModulus();
                    BigInteger bigInteger2 = d;
                    BigInteger createRandomInRange = BigIntegers.createRandomInRange(bigInteger2, modulus.subtract(bigInteger2), this.c);
                    bigInteger = this.a.f(createRandomInRange.modPow(publicExponent, modulus).multiply(a3).mod(modulus)).multiply(createRandomInRange.modInverse(modulus)).mod(modulus);
                    if (!a3.equals(bigInteger.modPow(publicExponent, modulus))) {
                        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                    }
                } else {
                    bigInteger = this.a.f(a3);
                }
            } else {
                bigInteger = this.a.f(a3);
            }
            return this.a.b(bigInteger);
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
