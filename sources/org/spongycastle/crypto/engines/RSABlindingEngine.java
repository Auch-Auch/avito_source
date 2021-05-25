package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import x6.e.b.a.a;
public class RSABlindingEngine implements AsymmetricBlockCipher {
    public a a = new a();
    public RSAKeyParameters b;
    public BigInteger c;
    public boolean d;

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
        RSABlindingParameters rSABlindingParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSABlindingParameters = (RSABlindingParameters) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            rSABlindingParameters = (RSABlindingParameters) cipherParameters;
        }
        this.a.e(z, rSABlindingParameters.getPublicKey());
        this.d = z;
        this.b = rSABlindingParameters.getPublicKey();
        this.c = rSABlindingParameters.getBlindingFactor();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigInteger;
        BigInteger a3 = this.a.a(bArr, i, i2);
        if (this.d) {
            bigInteger = a3.multiply(this.c.modPow(this.b.getExponent(), this.b.getModulus())).mod(this.b.getModulus());
        } else {
            BigInteger modulus = this.b.getModulus();
            bigInteger = a3.multiply(this.c.modInverse(modulus)).mod(modulus);
        }
        return this.a.b(bigInteger);
    }
}
