package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;
public class BigDecimalPolynomial {
    public static final BigDecimal b = new BigDecimal("0");
    public static final BigDecimal c = new BigDecimal("0.5");
    public BigDecimal[] a;

    public BigDecimalPolynomial(int i) {
        this.a = new BigDecimal[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.a[i2] = b;
        }
    }

    public final BigDecimal[] a(BigDecimal[] bigDecimalArr, int i) {
        BigDecimal[] bigDecimalArr2 = new BigDecimal[i];
        if (bigDecimalArr.length < i) {
            i = bigDecimalArr.length;
        }
        System.arraycopy(bigDecimalArr, 0, bigDecimalArr2, 0, i);
        return bigDecimalArr2;
    }

    public void add(BigDecimalPolynomial bigDecimalPolynomial) {
        BigDecimal[] bigDecimalArr = bigDecimalPolynomial.a;
        int length = bigDecimalArr.length;
        BigDecimal[] bigDecimalArr2 = this.a;
        if (length > bigDecimalArr2.length) {
            int length2 = bigDecimalArr2.length;
            this.a = a(bigDecimalArr2, bigDecimalArr.length);
            while (true) {
                BigDecimal[] bigDecimalArr3 = this.a;
                if (length2 >= bigDecimalArr3.length) {
                    break;
                }
                bigDecimalArr3[length2] = b;
                length2++;
            }
        }
        int i = 0;
        while (true) {
            BigDecimal[] bigDecimalArr4 = bigDecimalPolynomial.a;
            if (i < bigDecimalArr4.length) {
                BigDecimal[] bigDecimalArr5 = this.a;
                bigDecimalArr5[i] = bigDecimalArr5[i].add(bigDecimalArr4[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final BigDecimalPolynomial b(BigDecimalPolynomial bigDecimalPolynomial) {
        BigDecimal[] bigDecimalArr = this.a;
        BigDecimal[] bigDecimalArr2 = bigDecimalPolynomial.a;
        int length = bigDecimalArr2.length;
        int i = 0;
        if (length <= 1) {
            BigDecimal[] bigDecimalArr3 = (BigDecimal[]) bigDecimalArr.clone();
            for (int i2 = 0; i2 < this.a.length; i2++) {
                bigDecimalArr3[i2] = bigDecimalArr3[i2].multiply(bigDecimalPolynomial.a[0]);
            }
            return new BigDecimalPolynomial(bigDecimalArr3);
        }
        int i3 = length / 2;
        BigDecimalPolynomial bigDecimalPolynomial2 = new BigDecimalPolynomial(a(bigDecimalArr, i3));
        int i4 = length - i3;
        BigDecimal[] bigDecimalArr4 = new BigDecimal[i4];
        System.arraycopy(bigDecimalArr, i3, bigDecimalArr4, 0, bigDecimalArr.length - i3 < i4 ? bigDecimalArr.length - i3 : i4);
        BigDecimalPolynomial bigDecimalPolynomial3 = new BigDecimalPolynomial(bigDecimalArr4);
        BigDecimalPolynomial bigDecimalPolynomial4 = new BigDecimalPolynomial(a(bigDecimalArr2, i3));
        BigDecimal[] bigDecimalArr5 = new BigDecimal[i4];
        if (bigDecimalArr2.length - i3 < i4) {
            i4 = bigDecimalArr2.length - i3;
        }
        System.arraycopy(bigDecimalArr2, i3, bigDecimalArr5, 0, i4);
        BigDecimalPolynomial bigDecimalPolynomial5 = new BigDecimalPolynomial(bigDecimalArr5);
        BigDecimalPolynomial bigDecimalPolynomial6 = (BigDecimalPolynomial) bigDecimalPolynomial2.clone();
        bigDecimalPolynomial6.add(bigDecimalPolynomial3);
        BigDecimalPolynomial bigDecimalPolynomial7 = (BigDecimalPolynomial) bigDecimalPolynomial4.clone();
        bigDecimalPolynomial7.add(bigDecimalPolynomial5);
        BigDecimalPolynomial b2 = bigDecimalPolynomial2.b(bigDecimalPolynomial4);
        BigDecimalPolynomial b3 = bigDecimalPolynomial3.b(bigDecimalPolynomial5);
        BigDecimalPolynomial b4 = bigDecimalPolynomial6.b(bigDecimalPolynomial7);
        b4.c(b2);
        b4.c(b3);
        BigDecimalPolynomial bigDecimalPolynomial8 = new BigDecimalPolynomial((length * 2) - 1);
        int i5 = 0;
        while (true) {
            BigDecimal[] bigDecimalArr6 = b2.a;
            if (i5 >= bigDecimalArr6.length) {
                break;
            }
            bigDecimalPolynomial8.a[i5] = bigDecimalArr6[i5];
            i5++;
        }
        int i6 = 0;
        while (true) {
            BigDecimal[] bigDecimalArr7 = b4.a;
            if (i6 >= bigDecimalArr7.length) {
                break;
            }
            BigDecimal[] bigDecimalArr8 = bigDecimalPolynomial8.a;
            int i7 = i3 + i6;
            bigDecimalArr8[i7] = bigDecimalArr8[i7].add(bigDecimalArr7[i6]);
            i6++;
        }
        while (true) {
            BigDecimal[] bigDecimalArr9 = b3.a;
            if (i >= bigDecimalArr9.length) {
                return bigDecimalPolynomial8;
            }
            BigDecimal[] bigDecimalArr10 = bigDecimalPolynomial8.a;
            int i8 = (i3 * 2) + i;
            bigDecimalArr10[i8] = bigDecimalArr10[i8].add(bigDecimalArr9[i]);
            i++;
        }
    }

    public void c(BigDecimalPolynomial bigDecimalPolynomial) {
        BigDecimal[] bigDecimalArr = bigDecimalPolynomial.a;
        int length = bigDecimalArr.length;
        BigDecimal[] bigDecimalArr2 = this.a;
        if (length > bigDecimalArr2.length) {
            int length2 = bigDecimalArr2.length;
            this.a = a(bigDecimalArr2, bigDecimalArr.length);
            while (true) {
                BigDecimal[] bigDecimalArr3 = this.a;
                if (length2 >= bigDecimalArr3.length) {
                    break;
                }
                bigDecimalArr3[length2] = b;
                length2++;
            }
        }
        int i = 0;
        while (true) {
            BigDecimal[] bigDecimalArr4 = bigDecimalPolynomial.a;
            if (i < bigDecimalArr4.length) {
                BigDecimal[] bigDecimalArr5 = this.a;
                bigDecimalArr5[i] = bigDecimalArr5[i].subtract(bigDecimalArr4[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public Object clone() {
        return new BigDecimalPolynomial((BigDecimal[]) this.a.clone());
    }

    public BigDecimal[] getCoeffs() {
        BigDecimal[] bigDecimalArr = this.a;
        BigDecimal[] bigDecimalArr2 = new BigDecimal[bigDecimalArr.length];
        System.arraycopy(bigDecimalArr, 0, bigDecimalArr2, 0, bigDecimalArr.length);
        return bigDecimalArr2;
    }

    public void halve() {
        int i = 0;
        while (true) {
            BigDecimal[] bigDecimalArr = this.a;
            if (i < bigDecimalArr.length) {
                bigDecimalArr[i] = bigDecimalArr[i].multiply(c);
                i++;
            } else {
                return;
            }
        }
    }

    public BigDecimalPolynomial mult(BigIntPolynomial bigIntPolynomial) {
        return mult(new BigDecimalPolynomial(bigIntPolynomial));
    }

    public BigIntPolynomial round() {
        int length = this.a.length;
        BigIntPolynomial bigIntPolynomial = new BigIntPolynomial(length);
        for (int i = 0; i < length; i++) {
            bigIntPolynomial.a[i] = this.a[i].setScale(0, 6).toBigInteger();
        }
        return bigIntPolynomial;
    }

    public BigDecimalPolynomial mult(BigDecimalPolynomial bigDecimalPolynomial) {
        BigDecimal[] bigDecimalArr;
        int length = this.a.length;
        if (bigDecimalPolynomial.a.length == length) {
            BigDecimalPolynomial b2 = b(bigDecimalPolynomial);
            if (b2.a.length > length) {
                int i = length;
                while (true) {
                    bigDecimalArr = b2.a;
                    if (i >= bigDecimalArr.length) {
                        break;
                    }
                    int i2 = i - length;
                    bigDecimalArr[i2] = bigDecimalArr[i2].add(bigDecimalArr[i]);
                    i++;
                }
                b2.a = a(bigDecimalArr, length);
            }
            return b2;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    public BigDecimalPolynomial(BigDecimal[] bigDecimalArr) {
        this.a = bigDecimalArr;
    }

    public BigDecimalPolynomial(BigIntPolynomial bigIntPolynomial) {
        int length = bigIntPolynomial.a.length;
        this.a = new BigDecimal[length];
        for (int i = 0; i < length; i++) {
            this.a[i] = new BigDecimal(bigIntPolynomial.a[i]);
        }
    }
}
