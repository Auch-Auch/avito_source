package org.spongycastle.math.field;

import java.math.BigInteger;
import x6.e.e.b.a;
import x6.e.e.b.b;
import x6.e.e.b.c;
public abstract class FiniteFields {
    public static final FiniteField a = new c(BigInteger.valueOf(2));
    public static final FiniteField b = new c(BigInteger.valueOf(3));

    public static PolynomialExtensionField getBinaryExtensionField(int[] iArr) {
        if (iArr[0] == 0) {
            for (int i = 1; i < iArr.length; i++) {
                if (iArr[i] <= iArr[i - 1]) {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new b(a, new a(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static FiniteField getPrimeField(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return a;
            }
            if (intValue == 3) {
                return b;
            }
        }
        return new c(bigInteger);
    }
}
