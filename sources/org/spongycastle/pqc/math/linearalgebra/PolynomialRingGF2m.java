package org.spongycastle.pqc.math.linearalgebra;
public class PolynomialRingGF2m {
    public GF2mField a;
    public PolynomialGF2mSmallM b;
    public PolynomialGF2mSmallM[] sqMatrix;
    public PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i;
        int coefficient;
        this.a = gF2mField;
        this.b = polynomialGF2mSmallM;
        int degree = polynomialGF2mSmallM.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[degree];
        int i2 = 0;
        while (true) {
            i = degree >> 1;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 << 1;
            int[] iArr = new int[(i3 + 1)];
            iArr[i3] = 1;
            this.sqMatrix[i2] = new PolynomialGF2mSmallM(this.a, iArr);
            i2++;
        }
        while (i < degree) {
            int i4 = i << 1;
            int[] iArr2 = new int[(i4 + 1)];
            iArr2[i4] = 1;
            this.sqMatrix[i] = new PolynomialGF2mSmallM(this.a, iArr2).mod(this.b);
            i++;
        }
        int degree2 = this.b.getDegree();
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr = new PolynomialGF2mSmallM[degree2];
        int i5 = degree2 - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            polynomialGF2mSmallMArr[i6] = new PolynomialGF2mSmallM(this.sqMatrix[i6]);
        }
        this.sqRootMatrix = new PolynomialGF2mSmallM[degree2];
        while (i5 >= 0) {
            this.sqRootMatrix[i5] = new PolynomialGF2mSmallM(this.a, i5);
            i5--;
        }
        for (int i7 = 0; i7 < degree2; i7++) {
            if (polynomialGF2mSmallMArr[i7].getCoefficient(i7) == 0) {
                int i8 = i7 + 1;
                boolean z = false;
                while (i8 < degree2) {
                    if (polynomialGF2mSmallMArr[i8].getCoefficient(i7) != 0) {
                        PolynomialGF2mSmallM polynomialGF2mSmallM2 = polynomialGF2mSmallMArr[i7];
                        polynomialGF2mSmallMArr[i7] = polynomialGF2mSmallMArr[i8];
                        polynomialGF2mSmallMArr[i8] = polynomialGF2mSmallM2;
                        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr2 = this.sqRootMatrix;
                        PolynomialGF2mSmallM polynomialGF2mSmallM3 = polynomialGF2mSmallMArr2[i7];
                        polynomialGF2mSmallMArr2[i7] = polynomialGF2mSmallMArr2[i8];
                        polynomialGF2mSmallMArr2[i8] = polynomialGF2mSmallM3;
                        i8 = degree2;
                        z = true;
                    }
                    i8++;
                }
                if (!z) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int inverse = this.a.inverse(polynomialGF2mSmallMArr[i7].getCoefficient(i7));
            polynomialGF2mSmallMArr[i7].multThisWithElement(inverse);
            this.sqRootMatrix[i7].multThisWithElement(inverse);
            for (int i9 = 0; i9 < degree2; i9++) {
                if (!(i9 == i7 || (coefficient = polynomialGF2mSmallMArr[i9].getCoefficient(i7)) == 0)) {
                    PolynomialGF2mSmallM multWithElement = polynomialGF2mSmallMArr[i7].multWithElement(coefficient);
                    PolynomialGF2mSmallM multWithElement2 = this.sqRootMatrix[i7].multWithElement(coefficient);
                    polynomialGF2mSmallMArr[i9].addToThis(multWithElement);
                    this.sqRootMatrix[i9].addToThis(multWithElement2);
                }
            }
        }
    }

    public PolynomialGF2mSmallM[] getSquareRootMatrix() {
        return this.sqRootMatrix;
    }

    public PolynomialGF2mSmallM[] getSquaringMatrix() {
        return this.sqMatrix;
    }
}
