package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;
public class SRP6Client {
    public BigInteger A;
    public BigInteger B;
    public BigInteger Key;
    public BigInteger M1;
    public BigInteger M2;
    public BigInteger N;
    public BigInteger S;
    public BigInteger a;
    public Digest digest;
    public BigInteger g;
    public SecureRandom random;
    public BigInteger u;
    public BigInteger x;

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.A;
        if (bigInteger3 == null || (bigInteger = this.B) == null || (bigInteger2 = this.S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger calculateM1 = SRP6Util.calculateM1(this.digest, this.N, bigInteger3, bigInteger, bigInteger2);
        this.M1 = calculateM1;
        return calculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.N, bigInteger);
        this.B = validatePublicValue;
        this.u = SRP6Util.calculateU(this.digest, this.N, this.A, validatePublicValue);
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.N, this.g);
        BigInteger modPow = this.B.subtract(this.g.modPow(this.x, this.N).multiply(calculateK).mod(this.N)).mod(this.N).modPow(this.u.multiply(this.x).add(this.a), this.N);
        this.S = modPow;
        return modPow;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.S;
        if (bigInteger == null || this.M1 == null || this.M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.x = SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.a = selectPrivateValue;
        BigInteger modPow = this.g.modPow(selectPrivateValue, this.N);
        this.A = modPow;
        return modPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.N = bigInteger;
        this.g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.A;
        if (bigInteger4 == null || (bigInteger2 = this.M1) == null || (bigInteger3 = this.S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.M2 = bigInteger;
            return true;
        }
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest2, secureRandom);
    }
}
