package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.params.CramerShoupParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.BigIntegers;
public class CramerShoupParametersGenerator {
    public static final BigInteger d = BigInteger.valueOf(1);
    public int a;
    public int b;
    public SecureRandom c;

    public static class a {
        public static final BigInteger a = BigInteger.valueOf(2);

        public static BigInteger a(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(a);
            do {
                BigInteger bigInteger2 = a;
                modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (modPow.equals(CramerShoupParametersGenerator.d));
            return modPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger bigInteger;
        BigInteger add;
        int i = this.a;
        int i2 = this.b;
        SecureRandom secureRandom = this.c;
        BigInteger bigInteger2 = a.a;
        int i3 = i - 1;
        while (true) {
            bigInteger = new BigInteger(i3, 2, secureRandom);
            add = bigInteger.shiftLeft(1).add(d);
            if (!add.isProbablePrime(i2) || (i2 > 2 && !bigInteger.isProbablePrime(i2))) {
            }
        }
        BigInteger bigInteger3 = new BigInteger[]{add, bigInteger}[1];
        BigInteger a3 = a.a(bigInteger3, this.c);
        BigInteger a4 = a.a(bigInteger3, this.c);
        while (a3.equals(a4)) {
            a4 = a.a(bigInteger3, this.c);
        }
        return new CramerShoupParameters(bigInteger3, a3, a4, new SHA256Digest());
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        this.c = secureRandom;
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g = dHParameters.getG();
        BigInteger a3 = a.a(p, this.c);
        while (g.equals(a3)) {
            a3 = a.a(p, this.c);
        }
        return new CramerShoupParameters(p, g, a3, new SHA256Digest());
    }
}
