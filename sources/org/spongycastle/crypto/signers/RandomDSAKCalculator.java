package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
public class RandomDSAKCalculator implements DSAKCalculator {
    public static final BigInteger c = BigInteger.valueOf(0);
    public BigInteger a;
    public SecureRandom b;

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger bigInteger, SecureRandom secureRandom) {
        this.a = bigInteger;
        this.b = secureRandom;
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public boolean isDeterministic() {
        return false;
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public BigInteger nextK() {
        int bitLength = this.a.bitLength();
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.b);
            if (!bigInteger.equals(c) && bigInteger.compareTo(this.a) < 0) {
                return bigInteger;
            }
        }
    }

    @Override // org.spongycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }
}
