package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;
public class BigIntPolynomial {
    public static final double b = Math.log10(2.0d);
    public BigInteger[] a;

    public BigIntPolynomial(int i) {
        this.a = new BigInteger[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.a[i2] = Constants.a;
        }
    }

    public final BigInteger a() {
        BigInteger abs = this.a[0].abs();
        int i = 1;
        while (true) {
            BigInteger[] bigIntegerArr = this.a;
            if (i >= bigIntegerArr.length) {
                return abs;
            }
            BigInteger abs2 = bigIntegerArr[i].abs();
            if (abs2.compareTo(abs) > 0) {
                abs = abs2;
            }
            i++;
        }
    }

    public void add(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = bigIntPolynomial.a;
        int length = bigIntegerArr.length;
        BigInteger[] bigIntegerArr2 = this.a;
        if (length > bigIntegerArr2.length) {
            int length2 = bigIntegerArr2.length;
            this.a = Arrays.copyOf(bigIntegerArr2, bigIntegerArr.length);
            while (true) {
                BigInteger[] bigIntegerArr3 = this.a;
                if (length2 >= bigIntegerArr3.length) {
                    break;
                }
                bigIntegerArr3[length2] = Constants.a;
                length2++;
            }
        }
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr4 = bigIntPolynomial.a;
            if (i < bigIntegerArr4.length) {
                BigInteger[] bigIntegerArr5 = this.a;
                bigIntegerArr5[i] = bigIntegerArr5[i].add(bigIntegerArr4[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final BigIntPolynomial b(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = this.a;
        BigInteger[] bigIntegerArr2 = bigIntPolynomial.a;
        int length = bigIntegerArr2.length;
        int i = 0;
        if (length <= 1) {
            BigInteger[] clone = Arrays.clone(bigIntegerArr);
            for (int i2 = 0; i2 < this.a.length; i2++) {
                clone[i2] = clone[i2].multiply(bigIntPolynomial.a[0]);
            }
            return new BigIntPolynomial(clone);
        }
        int i3 = length / 2;
        BigIntPolynomial bigIntPolynomial2 = new BigIntPolynomial(Arrays.copyOf(bigIntegerArr, i3));
        BigIntPolynomial bigIntPolynomial3 = new BigIntPolynomial(Arrays.copyOfRange(bigIntegerArr, i3, length));
        BigIntPolynomial bigIntPolynomial4 = new BigIntPolynomial(Arrays.copyOf(bigIntegerArr2, i3));
        BigIntPolynomial bigIntPolynomial5 = new BigIntPolynomial(Arrays.copyOfRange(bigIntegerArr2, i3, length));
        BigIntPolynomial bigIntPolynomial6 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial6.add(bigIntPolynomial3);
        BigIntPolynomial bigIntPolynomial7 = (BigIntPolynomial) bigIntPolynomial4.clone();
        bigIntPolynomial7.add(bigIntPolynomial5);
        BigIntPolynomial b2 = bigIntPolynomial2.b(bigIntPolynomial4);
        BigIntPolynomial b3 = bigIntPolynomial3.b(bigIntPolynomial5);
        BigIntPolynomial b4 = bigIntPolynomial6.b(bigIntPolynomial7);
        b4.sub(b2);
        b4.sub(b3);
        BigIntPolynomial bigIntPolynomial8 = new BigIntPolynomial((length * 2) - 1);
        int i4 = 0;
        while (true) {
            BigInteger[] bigIntegerArr3 = b2.a;
            if (i4 >= bigIntegerArr3.length) {
                break;
            }
            bigIntPolynomial8.a[i4] = bigIntegerArr3[i4];
            i4++;
        }
        int i5 = 0;
        while (true) {
            BigInteger[] bigIntegerArr4 = b4.a;
            if (i5 >= bigIntegerArr4.length) {
                break;
            }
            BigInteger[] bigIntegerArr5 = bigIntPolynomial8.a;
            int i6 = i3 + i5;
            bigIntegerArr5[i6] = bigIntegerArr5[i6].add(bigIntegerArr4[i5]);
            i5++;
        }
        while (true) {
            BigInteger[] bigIntegerArr6 = b3.a;
            if (i >= bigIntegerArr6.length) {
                return bigIntPolynomial8;
            }
            BigInteger[] bigIntegerArr7 = bigIntPolynomial8.a;
            int i7 = (i3 * 2) + i;
            bigIntegerArr7[i7] = bigIntegerArr7[i7].add(bigIntegerArr6[i]);
            i++;
        }
    }

    public Object clone() {
        return new BigIntPolynomial((BigInteger[]) this.a.clone());
    }

    public void div(BigInteger bigInteger) {
        BigInteger divide = bigInteger.add(Constants.b).divide(BigInteger.valueOf(2));
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr = this.a;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = bigIntegerArr[i].compareTo(Constants.a) > 0 ? this.a[i].add(divide) : this.a[i].add(divide.negate());
                BigInteger[] bigIntegerArr2 = this.a;
                bigIntegerArr2[i] = bigIntegerArr2[i].divide(bigInteger);
                i++;
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.areEqual(this.a, ((BigIntPolynomial) obj).a);
    }

    public BigInteger[] getCoeffs() {
        return Arrays.clone(this.a);
    }

    public int getMaxCoeffLength() {
        return ((int) (((double) a().bitLength()) * b)) + 1;
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.a);
    }

    public void mod(BigInteger bigInteger) {
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr = this.a;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = bigIntegerArr[i].mod(bigInteger);
                i++;
            } else {
                return;
            }
        }
    }

    public BigIntPolynomial mult(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr;
        int length = this.a.length;
        if (bigIntPolynomial.a.length == length) {
            BigIntPolynomial b2 = b(bigIntPolynomial);
            if (b2.a.length > length) {
                int i = length;
                while (true) {
                    bigIntegerArr = b2.a;
                    if (i >= bigIntegerArr.length) {
                        break;
                    }
                    int i2 = i - length;
                    bigIntegerArr[i2] = bigIntegerArr[i2].add(bigIntegerArr[i]);
                    i++;
                }
                b2.a = Arrays.copyOf(bigIntegerArr, length);
            }
            return b2;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    public void sub(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = bigIntPolynomial.a;
        int length = bigIntegerArr.length;
        BigInteger[] bigIntegerArr2 = this.a;
        if (length > bigIntegerArr2.length) {
            int length2 = bigIntegerArr2.length;
            this.a = Arrays.copyOf(bigIntegerArr2, bigIntegerArr.length);
            while (true) {
                BigInteger[] bigIntegerArr3 = this.a;
                if (length2 >= bigIntegerArr3.length) {
                    break;
                }
                bigIntegerArr3[length2] = Constants.a;
                length2++;
            }
        }
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr4 = bigIntPolynomial.a;
            if (i < bigIntegerArr4.length) {
                BigInteger[] bigIntegerArr5 = this.a;
                bigIntegerArr5[i] = bigIntegerArr5[i].subtract(bigIntegerArr4[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public BigIntPolynomial(BigInteger[] bigIntegerArr) {
        this.a = bigIntegerArr;
    }

    public BigDecimalPolynomial div(BigDecimal bigDecimal, int i) {
        BigDecimal divide = Constants.c.divide(bigDecimal, ((int) (((double) a().bitLength()) * b)) + 1 + i + 1, 6);
        BigDecimalPolynomial bigDecimalPolynomial = new BigDecimalPolynomial(this.a.length);
        for (int i2 = 0; i2 < this.a.length; i2++) {
            bigDecimalPolynomial.a[i2] = new BigDecimal(this.a[i2]).multiply(divide).setScale(i, 6);
        }
        return bigDecimalPolynomial;
    }

    public BigIntPolynomial(IntegerPolynomial integerPolynomial) {
        this.a = new BigInteger[integerPolynomial.coeffs.length];
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr = this.a;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = BigInteger.valueOf((long) integerPolynomial.coeffs[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public void mult(BigInteger bigInteger) {
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr = this.a;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = bigIntegerArr[i].multiply(bigInteger);
                i++;
            } else {
                return;
            }
        }
    }
}
