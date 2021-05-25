package x6.e.f.a.a;

import java.math.BigInteger;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;
public final class a {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);

    public static GF2Vector a(int i, int i2, byte[] bArr) {
        if (i >= i2) {
            BigInteger binomial = IntegerFunctions.binomial(i, i2);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(binomial) < 0) {
                GF2Vector gF2Vector = new GF2Vector(i);
                int i3 = i;
                for (int i4 = 0; i4 < i; i4++) {
                    binomial = binomial.multiply(BigInteger.valueOf((long) (i3 - i2))).divide(BigInteger.valueOf((long) i3));
                    i3--;
                    if (binomial.compareTo(bigInteger) <= 0) {
                        gF2Vector.setBit(i4);
                        bigInteger = bigInteger.subtract(binomial);
                        i2--;
                        if (i3 == i2) {
                            binomial = b;
                        } else {
                            binomial = binomial.multiply(BigInteger.valueOf((long) (i2 + 1))).divide(BigInteger.valueOf((long) (i3 - i2)));
                        }
                    }
                }
                return gF2Vector;
            }
            throw new IllegalArgumentException("Encoded number too large.");
        }
        throw new IllegalArgumentException("n < t");
    }
}
