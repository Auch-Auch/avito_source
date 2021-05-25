package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHValidationParameters;
import x6.e.b.b.b;
public class DHParametersGenerator {
    public static final BigInteger d = BigInteger.valueOf(2);
    public int a;
    public int b;
    public SecureRandom c;

    public DHParameters generateParameters() {
        BigInteger[] a3 = b.a(this.a, this.b, this.c);
        BigInteger bigInteger = a3[0];
        return new DHParameters(bigInteger, b.b(bigInteger, this.c), a3[1], d, (DHValidationParameters) null);
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        this.c = secureRandom;
    }
}
