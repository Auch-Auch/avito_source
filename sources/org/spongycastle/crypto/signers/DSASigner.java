package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
public class DSASigner implements DSA {
    public final DSAKCalculator a;
    public DSAKeyParameters b;
    public SecureRandom c;

    public DSASigner() {
        this.a = new RandomDSAKCalculator();
    }

    public final BigInteger a(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int bitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(bArr, 0, bArr2, 0, bitLength);
        return new BigInteger(1, bArr2);
    }

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        DSAParameters parameters = this.b.getParameters();
        BigInteger q = parameters.getQ();
        BigInteger a3 = a(q, bArr);
        BigInteger x = ((DSAPrivateKeyParameters) this.b).getX();
        if (this.a.isDeterministic()) {
            this.a.init(q, x, bArr);
        } else {
            this.a.init(q, this.c);
        }
        BigInteger nextK = this.a.nextK();
        BigInteger g = parameters.getG();
        SecureRandom secureRandom = this.c;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        BigInteger mod = g.modPow(nextK.add(new BigInteger(7, secureRandom).add(BigInteger.valueOf(128)).multiply(q)), parameters.getP()).mod(q);
        return new BigInteger[]{mod, nextK.modInverse(q).multiply(a3.add(x.multiply(mod))).mod(q)};
    }

    @Override // org.spongycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (!z) {
            this.b = (DSAPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.b = (DSAPrivateKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
            this.c = initSecureRandom(!z && !this.a.isDeterministic(), secureRandom);
        } else {
            this.b = (DSAPrivateKeyParameters) cipherParameters;
        }
        secureRandom = null;
        this.c = initSecureRandom(!z && !this.a.isDeterministic(), secureRandom);
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (!z) {
            return null;
        }
        return secureRandom != null ? secureRandom : new SecureRandom();
    }

    @Override // org.spongycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.b.getParameters();
        BigInteger q = parameters.getQ();
        BigInteger a3 = a(q, bArr);
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || q.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || q.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger2.modInverse(q);
        BigInteger mod = a3.multiply(modInverse).mod(q);
        BigInteger mod2 = bigInteger.multiply(modInverse).mod(q);
        BigInteger p = parameters.getP();
        return parameters.getG().modPow(mod, p).multiply(((DSAPublicKeyParameters) this.b).getY().modPow(mod2, p)).mod(p).mod(q).equals(bigInteger);
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.a = dSAKCalculator;
    }
}
