package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Vector;
public class GF2nPolynomialField extends GF2nField {
    public GF2Polynomial[] a;
    public boolean b;
    public boolean c;
    public int d;
    public int[] e;

    public GF2nPolynomialField(int i, SecureRandom secureRandom) {
        super(secureRandom);
        this.b = false;
        this.c = false;
        this.e = new int[3];
        if (i >= 3) {
            this.mDegree = i;
            computeFieldPolynomial();
            a();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public final void a() {
        int i = this.mDegree;
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[(i - 1)];
        this.a = new GF2Polynomial[i];
        int i2 = 0;
        while (true) {
            GF2Polynomial[] gF2PolynomialArr2 = this.a;
            if (i2 >= gF2PolynomialArr2.length) {
                break;
            }
            gF2PolynomialArr2[i2] = new GF2Polynomial(this.mDegree, "ZERO");
            i2++;
        }
        for (int i3 = 0; i3 < this.mDegree - 1; i3++) {
            gF2PolynomialArr[i3] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + i3).remainder(this.fieldPolynomial);
        }
        for (int i4 = 1; i4 <= Math.abs(this.mDegree >> 1); i4++) {
            int i5 = 1;
            while (true) {
                int i6 = this.mDegree;
                if (i5 > i6) {
                    break;
                }
                if (gF2PolynomialArr[i6 - (i4 << 1)].testBit(i6 - i5)) {
                    this.a[i5 - 1].setBit(this.mDegree - i4);
                }
                i5++;
            }
        }
        int abs = Math.abs(this.mDegree >> 1) + 1;
        while (true) {
            int i7 = this.mDegree;
            if (abs <= i7) {
                this.a[((abs << 1) - i7) - 1].setBit(i7 - abs);
                abs++;
            } else {
                return;
            }
        }
    }

    public final boolean b() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        int i = 1;
        boolean z = false;
        while (i <= this.mDegree - 3 && !z) {
            this.fieldPolynomial.setBit(i);
            int i2 = i + 1;
            int i3 = i2;
            while (i3 <= this.mDegree - 2 && !z) {
                this.fieldPolynomial.setBit(i3);
                int i4 = i3 + 1;
                for (int i5 = i4; i5 <= this.mDegree - 1 && !z; i5++) {
                    this.fieldPolynomial.setBit(i5);
                    if (((!(((this.mDegree & 1) != 0) | ((i & 1) != 0)) && !((i3 & 1) != 0)) && !((i5 & 1) != 0)) || !(z = this.fieldPolynomial.isIrreducible())) {
                        this.fieldPolynomial.resetBit(i5);
                    } else {
                        this.c = true;
                        int[] iArr = this.e;
                        iArr[0] = i;
                        iArr[1] = i3;
                        iArr[2] = i5;
                        return z;
                    }
                }
                this.fieldPolynomial.resetBit(i3);
                i3 = i4;
            }
            this.fieldPolynomial.resetBit(i);
            i = i2;
        }
        return z;
    }

    public final boolean c() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
        do {
            this.fieldPolynomial.randomize();
            this.fieldPolynomial.setBit(this.mDegree);
            this.fieldPolynomial.setBit(0);
        } while (!this.fieldPolynomial.isIrreducible());
        return true;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        GF2nElement[] gF2nElementArr;
        int i = this.mDegree;
        if (i == gF2nField.mDegree) {
            boolean z = gF2nField instanceof GF2nONBField;
            if (z) {
                gF2nField.computeCOBMatrix(this);
                return;
            }
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i];
            for (int i2 = 0; i2 < this.mDegree; i2++) {
                gF2PolynomialArr[i2] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            if (randomRoot instanceof GF2nONBElement) {
                int i3 = this.mDegree;
                gF2nElementArr = new GF2nONBElement[i3];
                gF2nElementArr[i3 - 1] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
            } else {
                int i4 = this.mDegree;
                gF2nElementArr = new GF2nPolynomialElement[i4];
                gF2nElementArr[i4 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
            }
            int i5 = this.mDegree;
            gF2nElementArr[i5 - 2] = randomRoot;
            for (int i6 = i5 - 3; i6 >= 0; i6--) {
                gF2nElementArr[i6] = (GF2nElement) gF2nElementArr[i6 + 1].multiply(randomRoot);
            }
            if (z) {
                for (int i7 = 0; i7 < this.mDegree; i7++) {
                    int i8 = 0;
                    while (true) {
                        int i9 = this.mDegree;
                        if (i8 >= i9) {
                            break;
                        }
                        if (gF2nElementArr[i7].b((i9 - i8) - 1)) {
                            int i10 = this.mDegree;
                            gF2PolynomialArr[(i10 - i8) - 1].setBit((i10 - i7) - 1);
                        }
                        i8++;
                    }
                }
            } else {
                for (int i11 = 0; i11 < this.mDegree; i11++) {
                    for (int i12 = 0; i12 < this.mDegree; i12++) {
                        if (gF2nElementArr[i11].b(i12)) {
                            int i13 = this.mDegree;
                            gF2PolynomialArr[(i13 - i12) - 1].setBit((i13 - i11) - 1);
                        }
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    public void computeFieldPolynomial() {
        if (!d() && !b()) {
            c();
        }
    }

    public void computeFieldPolynomial2() {
        if (!d() && !b()) {
            c();
        }
    }

    public final boolean d() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        boolean z = false;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        for (int i = 1; i < this.mDegree && !z; i++) {
            this.fieldPolynomial.setBit(i);
            boolean isIrreducible = this.fieldPolynomial.isIrreducible();
            if (isIrreducible) {
                this.b = true;
                this.d = i;
                return isIrreducible;
            }
            this.fieldPolynomial.resetBit(i);
            z = this.fieldPolynomial.isIrreducible();
        }
        return z;
    }

    public int[] getPc() throws RuntimeException {
        if (this.c) {
            int[] iArr = new int[3];
            System.arraycopy(this.e, 0, iArr, 0, 3);
            return iArr;
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, this);
        int degree3 = gF2nPolynomial.getDegree();
        while (degree3 > 1) {
            while (true) {
                GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, GF2nPolynomialElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nPolynomialElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i = 1; i <= this.mDegree - 1; i++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (!(degree == 0 || degree == degree2)) {
                    break;
                }
            }
            if ((degree << 1) > degree2) {
                gF2nPolynomial = gF2nPolynomial.quotient(gcd);
            } else {
                gF2nPolynomial = new GF2nPolynomial(gcd);
            }
            degree3 = gF2nPolynomial.getDegree();
        }
        return gF2nPolynomial.at(0);
    }

    public GF2Polynomial getSquaringVector(int i) {
        return new GF2Polynomial(this.a[i]);
    }

    public int getTc() throws RuntimeException {
        if (this.b) {
            return this.d;
        }
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.c;
    }

    public boolean isTrinomial() {
        return this.b;
    }

    public GF2nPolynomialField(int i, SecureRandom secureRandom, boolean z) {
        super(secureRandom);
        this.b = false;
        this.c = false;
        this.e = new int[3];
        if (i >= 3) {
            this.mDegree = i;
            if (z) {
                computeFieldPolynomial();
            } else {
                computeFieldPolynomial2();
            }
            a();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int i, SecureRandom secureRandom, GF2Polynomial gF2Polynomial) throws RuntimeException {
        super(secureRandom);
        this.b = false;
        this.c = false;
        this.e = new int[3];
        if (i < 3) {
            throw new IllegalArgumentException("degree must be at least 3");
        } else if (gF2Polynomial.getLength() != i + 1) {
            throw new RuntimeException();
        } else if (gF2Polynomial.isIrreducible()) {
            this.mDegree = i;
            this.fieldPolynomial = gF2Polynomial;
            a();
            int i2 = 2;
            for (int i3 = 1; i3 < this.fieldPolynomial.getLength() - 1; i3++) {
                if (this.fieldPolynomial.testBit(i3)) {
                    i2++;
                    if (i2 == 3) {
                        this.d = i3;
                    }
                    if (i2 <= 5) {
                        this.e[i2 - 3] = i3;
                    }
                }
            }
            if (i2 == 3) {
                this.b = true;
            }
            if (i2 == 5) {
                this.c = true;
            }
            this.fields = new Vector();
            this.matrices = new Vector();
        } else {
            throw new RuntimeException();
        }
    }
}
