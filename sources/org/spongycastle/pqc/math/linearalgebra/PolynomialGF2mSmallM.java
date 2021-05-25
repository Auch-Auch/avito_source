package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import java.security.SecureRandom;
public class PolynomialGF2mSmallM {
    public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
    public GF2mField a;
    public int b;
    public int[] c;

    public PolynomialGF2mSmallM(GF2mField gF2mField) {
        this.a = gF2mField;
        this.b = -1;
        this.c = new int[1];
    }

    public static int b(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public static int f(int[] iArr) {
        int b2 = b(iArr);
        if (b2 == -1) {
            return 0;
        }
        return iArr[b2];
    }

    public static boolean g(int[] iArr, int[] iArr2) {
        int b2 = b(iArr);
        if (b2 != b(iArr2)) {
            return false;
        }
        for (int i = 0; i <= b2; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] l(int[] iArr, int i) {
        int b2 = b(iArr);
        if (b2 == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[(b2 + i + 1)];
        System.arraycopy(iArr, 0, iArr2, i, b2 + 1);
        return iArr2;
    }

    public static int[] n(int[] iArr) {
        int b2 = b(iArr);
        if (b2 == -1) {
            return new int[1];
        }
        int i = b2 + 1;
        if (iArr.length == i) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    public final int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.a.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    public PolynomialGF2mSmallM add(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.a, a(this.c, polynomialGF2mSmallM.c));
    }

    public PolynomialGF2mSmallM addMonomial(int i) {
        int[] iArr = new int[(i + 1)];
        iArr[i] = 1;
        return new PolynomialGF2mSmallM(this.a, a(this.c, iArr));
    }

    public void addToThis(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.c = a(this.c, polynomialGF2mSmallM.c);
        c();
    }

    public final void c() {
        this.b = this.c.length - 1;
        while (true) {
            int i = this.b;
            if (i >= 0 && this.c[i] == 0) {
                this.b = i - 1;
            } else {
                return;
            }
        }
    }

    public final int[][] d(int[] iArr, int[] iArr2) {
        int b2 = b(iArr2);
        int b3 = b(iArr) + 1;
        if (b2 != -1) {
            int[][] iArr3 = {new int[1], new int[b3]};
            int inverse = this.a.inverse(f(iArr2));
            iArr3[0][0] = 0;
            System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
            while (b2 <= b(iArr3[1])) {
                int[] iArr4 = {this.a.mult(f(iArr3[1]), inverse)};
                int[] k = k(iArr2, iArr4[0]);
                int b4 = b(iArr3[1]) - b2;
                int[] l = l(k, b4);
                iArr3[0] = a(l(iArr4, b4), iArr3[0]);
                iArr3[1] = a(l, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[][] d = d(this.c, polynomialGF2mSmallM.c);
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.a, d[0]), new PolynomialGF2mSmallM(this.a, d[1])};
    }

    public final int[] e(int[] iArr, int[] iArr2) {
        if (b(iArr) == -1) {
            return iArr2;
        }
        while (b(iArr2) != -1) {
            int[] h = h(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = h.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(h, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return k(iArr, this.a.inverse(f(iArr)));
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PolynomialGF2mSmallM)) {
            PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
            if (this.a.equals(polynomialGF2mSmallM.a) && this.b == polynomialGF2mSmallM.b && g(this.c, polynomialGF2mSmallM.c)) {
                return true;
            }
        }
        return false;
    }

    public int evaluateAt(int i) {
        int[] iArr = this.c;
        int i2 = this.b;
        int i3 = iArr[i2];
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            i3 = this.a.mult(i3, i) ^ this.c[i4];
        }
        return i3;
    }

    public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.a, e(this.c, polynomialGF2mSmallM.c));
    }

    public int getCoefficient(int i) {
        if (i < 0 || i > this.b) {
            return 0;
        }
        return this.c[i];
    }

    public int getDegree() {
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i = 8;
        int i2 = 1;
        while (this.a.getDegree() > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[(this.c.length * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < this.c.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.c[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public int getHeadCoefficient() {
        int i = this.b;
        if (i == -1) {
            return 0;
        }
        return this.c[i];
    }

    public final int[] h(int[] iArr, int[] iArr2) {
        int b2 = b(iArr2);
        if (b2 != -1) {
            int length = iArr.length;
            int[] iArr3 = new int[length];
            int inverse = this.a.inverse(f(iArr2));
            System.arraycopy(iArr, 0, iArr3, 0, length);
            while (b2 <= b(iArr3)) {
                iArr3 = a(k(l(iArr2, b(iArr3) - b2), this.a.mult(f(iArr3), inverse)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i];
            i++;
        }
    }

    public final int[] i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] n = n(iArr3);
        int[] h = h(iArr2, iArr3);
        int[] iArr4 = {0};
        int[] h2 = h(iArr, iArr3);
        while (b(h) != -1) {
            int[][] d = d(n, h);
            int[] n2 = n(h);
            int[] n3 = n(d[1]);
            int[] a3 = a(iArr4, j(d[0], h2, iArr3));
            iArr4 = n(h2);
            h2 = n(a3);
            n = n2;
            h = n3;
        }
        return k(iArr4, this.a.inverse(f(n)));
    }

    public final int[] j(int[] iArr, int[] iArr2, int[] iArr3) {
        return h(m(iArr, iArr2), iArr3);
    }

    public final int[] k(int[] iArr, int i) {
        int b2 = b(iArr);
        if (b2 == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[(b2 + 1)];
        while (b2 >= 0) {
            iArr2[b2] = this.a.mult(iArr[b2], i);
            b2--;
        }
        return iArr2;
    }

    public final int[] m(int[] iArr, int[] iArr2) {
        if (b(iArr) < b(iArr2)) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] n = n(iArr);
        int[] n2 = n(iArr2);
        if (n2.length == 1) {
            return k(n, n2[0]);
        }
        int length = n.length;
        int length2 = n2.length;
        int[] iArr3 = new int[((length + length2) - 1)];
        if (length2 != length) {
            int[] iArr4 = new int[length2];
            int i = length - length2;
            int[] iArr5 = new int[i];
            System.arraycopy(n, 0, iArr4, 0, length2);
            System.arraycopy(n, length2, iArr5, 0, i);
            return a(m(iArr4, n2), l(m(iArr5, n2), length2));
        }
        int i2 = (length + 1) >>> 1;
        int i3 = length - i2;
        int[] iArr6 = new int[i2];
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i3];
        int[] iArr9 = new int[i3];
        System.arraycopy(n, 0, iArr6, 0, i2);
        System.arraycopy(n, i2, iArr8, 0, i3);
        System.arraycopy(n2, 0, iArr7, 0, i2);
        System.arraycopy(n2, i2, iArr9, 0, i3);
        int[] a3 = a(iArr6, iArr8);
        int[] a4 = a(iArr7, iArr9);
        int[] m = m(iArr6, iArr7);
        int[] m2 = m(a3, a4);
        int[] m3 = m(iArr8, iArr9);
        return a(l(a(a(a(m2, m), m3), l(m3, i2)), i2), m);
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.a, h(this.c, polynomialGF2mSmallM.c));
    }

    public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.a, i(this.c, polynomialGF2mSmallM.c, polynomialGF2mSmallM2.c));
    }

    public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.a, i(new int[]{1}, this.c, polynomialGF2mSmallM.c));
    }

    public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.a, j(this.c, polynomialGF2mSmallM.c, polynomialGF2mSmallM2.c));
    }

    public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i = polynomialGF2mSmallM.b >> 1;
        int[] n = n(polynomialGF2mSmallM.c);
        int[] h = h(this.c, polynomialGF2mSmallM.c);
        int[] iArr = {0};
        int[] iArr2 = {1};
        while (b(h) > i) {
            int[][] d = d(n, h);
            int[] iArr3 = d[1];
            int[] a3 = a(iArr, h(m(d[0], iArr2), polynomialGF2mSmallM.c));
            iArr = iArr2;
            iArr2 = a3;
            n = h;
            h = iArr3;
        }
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.a, h), new PolynomialGF2mSmallM(this.a, iArr2)};
    }

    public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i = 0;
        while (true) {
            int[] iArr3 = this.c;
            if (i >= iArr3.length) {
                break;
            }
            iArr2[i] = this.a.mult(iArr3[i], iArr3[i]);
            i++;
        }
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 < polynomialGF2mSmallMArr[i3].c.length) {
                    iArr[i2] = this.a.add(iArr[i2], this.a.mult(polynomialGF2mSmallMArr[i3].c[i2], iArr2[i3]));
                }
            }
        }
        return new PolynomialGF2mSmallM(this.a, iArr);
    }

    public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[] clone = IntUtils.clone(this.c);
        int[] j = j(clone, clone, polynomialGF2mSmallM.c);
        while (!g(j, this.c)) {
            clone = n(j);
            j = j(clone, clone, polynomialGF2mSmallM.c);
        }
        return new PolynomialGF2mSmallM(this.a, clone);
    }

    public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (i < polynomialGF2mSmallMArr[i2].c.length) {
                    int[] iArr2 = this.c;
                    if (i2 < iArr2.length) {
                        iArr[i] = this.a.add(iArr[i], this.a.mult(polynomialGF2mSmallMArr[i2].c[i], iArr2[i2]));
                    }
                }
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.sqRoot(iArr[i3]);
        }
        return new PolynomialGF2mSmallM(this.a, iArr);
    }

    public void multThisWithElement(int i) {
        if (this.a.isElementOfThisField(i)) {
            this.c = k(this.c, i);
            c();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int i) {
        if (this.a.isElementOfThisField(i)) {
            return new PolynomialGF2mSmallM(this.a, k(this.c, i));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithMonomial(int i) {
        return new PolynomialGF2mSmallM(this.a, l(this.c, i));
    }

    public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.a, m(this.c, polynomialGF2mSmallM.c));
    }

    public String toString() {
        StringBuilder L = a.L(" Polynomial over ");
        L.append(this.a.toString());
        L.append(": \n");
        String sb = L.toString();
        for (int i = 0; i < this.c.length; i++) {
            StringBuilder L2 = a.L(sb);
            L2.append(this.a.elementToStr(this.c[i]));
            L2.append("Y^");
            L2.append(i);
            L2.append("+");
            sb = L2.toString();
        }
        return a.c3(sb, ";");
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i, char c2, SecureRandom secureRandom) {
        boolean z;
        this.a = gF2mField;
        if (c2 == 'I') {
            int[] iArr = new int[(i + 1)];
            iArr[i] = 1;
            iArr[0] = gF2mField.getRandomNonZeroElement(secureRandom);
            for (int i2 = 1; i2 < i; i2++) {
                iArr[i2] = this.a.getRandomElement(secureRandom);
            }
            while (true) {
                if (iArr[0] != 0) {
                    int b2 = b(iArr) >> 1;
                    int[] iArr2 = {0, 1};
                    int[] iArr3 = {0, 1};
                    int degree = this.a.getDegree();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= b2) {
                            z = true;
                            break;
                        }
                        for (int i4 = degree - 1; i4 >= 0; i4--) {
                            iArr2 = h(m(iArr2, iArr2), iArr);
                        }
                        iArr2 = n(iArr2);
                        if (b(e(a(iArr2, iArr3), iArr)) != 0) {
                            break;
                        }
                        i3++;
                    }
                }
                z = false;
                if (!z) {
                    int a3 = RandUtils.a(secureRandom, i);
                    if (a3 == 0) {
                        iArr[0] = this.a.getRandomNonZeroElement(secureRandom);
                    } else {
                        iArr[a3] = this.a.getRandomElement(secureRandom);
                    }
                } else {
                    this.c = iArr;
                    c();
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException(a.L2(" Error: type ", c2, " is not defined for GF2smallmPolynomial"));
        }
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i) {
        this.a = gF2mField;
        this.b = i;
        int[] iArr = new int[(i + 1)];
        this.c = iArr;
        iArr[i] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.a = gF2mField;
        this.c = n(iArr);
        c();
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.a = gF2mField;
        int i = 8;
        int i2 = 1;
        while (gF2mField.getDegree() > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 == 0) {
            this.c = new int[(bArr.length / i2)];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr = this.c;
                if (i3 < iArr.length) {
                    int i5 = 0;
                    while (i5 < i) {
                        int[] iArr2 = this.c;
                        iArr2[i3] = ((bArr[i4] & 255) << i5) ^ iArr2[i3];
                        i5 += 8;
                        i4++;
                    }
                    if (this.a.isElementOfThisField(this.c[i3])) {
                        i3++;
                    } else {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                } else if (iArr.length == 1 || iArr[iArr.length - 1] != 0) {
                    c();
                    return;
                } else {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.a = polynomialGF2mSmallM.a;
        this.b = polynomialGF2mSmallM.b;
        this.c = IntUtils.clone(polynomialGF2mSmallM.c);
    }

    public PolynomialGF2mSmallM(GF2mVector gF2mVector) {
        this(gF2mVector.getField(), gF2mVector.getIntArrayForm());
    }
}
