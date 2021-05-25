package org.spongycastle.pqc.math.ntru.polynomial;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;
public class SparseTernaryPolynomial implements TernaryPolynomial {
    public int a;
    public int[] b;
    public int[] c;

    public SparseTernaryPolynomial(int i, int[] iArr, int[] iArr2) {
        this.a = i;
        this.b = iArr;
        this.c = iArr2;
    }

    public static SparseTernaryPolynomial fromBinary(InputStream inputStream, int i, int i2, int i3) throws IOException {
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(2047);
        return new SparseTernaryPolynomial(i, ArrayEncoder.decodeModQ(Util.readFullLength(inputStream, ((i2 * numberOfLeadingZeros) + 7) / 8), i2, 2048), ArrayEncoder.decodeModQ(Util.readFullLength(inputStream, ((numberOfLeadingZeros * i3) + 7) / 8), i3, 2048));
    }

    public static SparseTernaryPolynomial generateRandom(int i, int i2, int i3, SecureRandom secureRandom) {
        return new SparseTernaryPolynomial(Util.generateRandomTernary(i, i2, i3, secureRandom));
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public void clear() {
        int i = 0;
        while (true) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                break;
            }
            iArr[i] = 0;
            i++;
        }
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.c;
            if (i2 < iArr2.length) {
                iArr2[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SparseTernaryPolynomial sparseTernaryPolynomial = (SparseTernaryPolynomial) obj;
        return this.a == sparseTernaryPolynomial.a && Arrays.areEqual(this.c, sparseTernaryPolynomial.c) && Arrays.areEqual(this.b, sparseTernaryPolynomial.b);
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int[] getNegOnes() {
        return this.c;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int[] getOnes() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.c);
        return Arrays.hashCode(this.b) + ((hashCode + ((this.a + 31) * 31)) * 31);
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial, org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial) {
        int[] iArr = integerPolynomial.coeffs;
        int length = iArr.length;
        int i = this.a;
        if (length == i) {
            int[] iArr2 = new int[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr3 = this.b;
                if (i3 == iArr3.length) {
                    break;
                }
                int i4 = iArr3[i3];
                int i5 = this.a;
                int i6 = (i5 - 1) - i4;
                for (int i7 = i5 - 1; i7 >= 0; i7--) {
                    iArr2[i7] = iArr2[i7] + iArr[i6];
                    i6--;
                    if (i6 < 0) {
                        i6 = this.a - 1;
                    }
                }
                i3++;
            }
            while (true) {
                int[] iArr4 = this.c;
                if (i2 == iArr4.length) {
                    return new IntegerPolynomial(iArr2);
                }
                int i8 = iArr4[i2];
                int i9 = this.a;
                int i10 = (i9 - 1) - i8;
                for (int i11 = i9 - 1; i11 >= 0; i11--) {
                    iArr2[i11] = iArr2[i11] - iArr[i10];
                    i10--;
                    if (i10 < 0) {
                        i10 = this.a - 1;
                    }
                }
                i2++;
            }
        } else {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int size() {
        return this.a;
    }

    public byte[] toBinary() {
        byte[] encodeModQ = ArrayEncoder.encodeModQ(this.b, 2048);
        byte[] encodeModQ2 = ArrayEncoder.encodeModQ(this.c, 2048);
        byte[] copyOf = Arrays.copyOf(encodeModQ, encodeModQ.length + encodeModQ2.length);
        System.arraycopy(encodeModQ2, 0, copyOf, encodeModQ.length, encodeModQ2.length);
        return copyOf;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial toIntegerPolynomial() {
        int[] iArr = new int[this.a];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.b;
            if (i2 == iArr2.length) {
                break;
            }
            iArr[iArr2[i2]] = 1;
            i2++;
        }
        while (true) {
            int[] iArr3 = this.c;
            if (i == iArr3.length) {
                return new IntegerPolynomial(iArr);
            }
            iArr[iArr3[i]] = -1;
            i++;
        }
    }

    public SparseTernaryPolynomial(IntegerPolynomial integerPolynomial) {
        this(integerPolynomial.coeffs);
    }

    public SparseTernaryPolynomial(int[] iArr) {
        int length = iArr.length;
        this.a = length;
        this.b = new int[length];
        this.c = new int[length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = iArr[i3];
            if (i4 == -1) {
                this.c[i2] = i3;
                i2++;
            } else if (i4 == 0) {
                continue;
            } else if (i4 == 1) {
                this.b[i] = i3;
                i++;
            } else {
                throw new IllegalArgumentException(a.Q2("Illegal value: ", i4, ", must be one of {-1, 0, 1}"));
            }
        }
        this.b = Arrays.copyOf(this.b, i);
        this.c = Arrays.copyOf(this.c, i2);
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i) {
        IntegerPolynomial mult = mult(integerPolynomial);
        mult.mod(i);
        return mult;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public BigIntPolynomial mult(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = bigIntPolynomial.a;
        int length = bigIntegerArr.length;
        int i = this.a;
        if (length == i) {
            BigInteger[] bigIntegerArr2 = new BigInteger[i];
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                bigIntegerArr2[i3] = BigInteger.ZERO;
            }
            int i4 = 0;
            while (true) {
                int[] iArr = this.b;
                if (i4 == iArr.length) {
                    break;
                }
                int i5 = iArr[i4];
                int i6 = this.a;
                int i7 = (i6 - 1) - i5;
                for (int i8 = i6 - 1; i8 >= 0; i8--) {
                    bigIntegerArr2[i8] = bigIntegerArr2[i8].add(bigIntegerArr[i7]);
                    i7--;
                    if (i7 < 0) {
                        i7 = this.a - 1;
                    }
                }
                i4++;
            }
            while (true) {
                int[] iArr2 = this.c;
                if (i2 == iArr2.length) {
                    return new BigIntPolynomial(bigIntegerArr2);
                }
                int i9 = iArr2[i2];
                int i10 = this.a;
                int i11 = (i10 - 1) - i9;
                for (int i12 = i10 - 1; i12 >= 0; i12--) {
                    bigIntegerArr2[i12] = bigIntegerArr2[i12].subtract(bigIntegerArr[i11]);
                    i11--;
                    if (i11 < 0) {
                        i11 = this.a - 1;
                    }
                }
                i2++;
            }
        } else {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
    }
}
