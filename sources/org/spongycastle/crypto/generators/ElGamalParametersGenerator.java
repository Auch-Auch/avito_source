package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.ElGamalParameters;
import x6.e.b.b.b;
public class ElGamalParametersGenerator {
    public int a;
    public int b;
    public SecureRandom c;

    public ElGamalParameters generateParameters() {
        BigInteger[] a3 = b.a(this.a, this.b, this.c);
        BigInteger bigInteger = a3[0];
        BigInteger bigInteger2 = a3[1];
        return new ElGamalParameters(bigInteger, b.b(bigInteger, this.c));
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        this.c = secureRandom;
    }
}
