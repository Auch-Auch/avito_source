package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;
public class GF2nONBField extends GF2nField {
    public int a;
    public int b;
    public int c;
    public int[][] d;

    public GF2nONBField(int i, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        int i2;
        int i3;
        int i4;
        if (i >= 3) {
            this.mDegree = i;
            int i5 = i / 64;
            this.a = i5;
            int i6 = i & 63;
            this.b = i6;
            if (i6 == 0) {
                this.b = 64;
            } else {
                this.a = i5 + 1;
            }
            if ((i & 7) != 0) {
                this.c = 1;
                int i7 = 0;
                while (i7 != 1) {
                    int i8 = (this.c * this.mDegree) + 1;
                    if (IntegerFunctions.isPrime(i8)) {
                        int order = IntegerFunctions.order(2, i8);
                        int i9 = this.c;
                        int i10 = this.mDegree;
                        i7 = IntegerFunctions.gcd((i9 * i10) / order, i10);
                    }
                    this.c++;
                }
                int i11 = this.c - 1;
                this.c = i11;
                if (i11 == 1) {
                    int i12 = (this.mDegree << 1) + 1;
                    if (IntegerFunctions.isPrime(i12)) {
                        int order2 = IntegerFunctions.order(2, i12);
                        int i13 = this.mDegree;
                        if (IntegerFunctions.gcd((i13 << 1) / order2, i13) == 1) {
                            this.c++;
                        }
                    }
                }
                if (this.c < 3) {
                    int i14 = this.mDegree;
                    int[] iArr = new int[2];
                    iArr[1] = 2;
                    iArr[0] = i14;
                    this.d = (int[][]) Array.newInstance(int.class, iArr);
                    int i15 = 0;
                    while (true) {
                        i2 = this.mDegree;
                        if (i15 >= i2) {
                            break;
                        }
                        int[][] iArr2 = this.d;
                        iArr2[i15][0] = -1;
                        iArr2[i15][1] = -1;
                        i15++;
                    }
                    int i16 = this.c;
                    if ((i16 & 7) != 0) {
                        int i17 = (i2 * i16) + 1;
                        int[] iArr3 = new int[i17];
                        if (i16 == 1) {
                            i3 = 1;
                        } else if (i16 == 2) {
                            i3 = i17 - 1;
                        } else {
                            Random random = new Random();
                            int i18 = 0;
                            while (i18 == 0) {
                                int i19 = i17 - 1;
                                i18 = random.nextInt() % i19;
                                if (i18 < 0) {
                                    i18 += i19;
                                }
                            }
                            int order3 = IntegerFunctions.order(i18, i17);
                            while (true) {
                                if (order3 % i16 == 0 && order3 != 0) {
                                    break;
                                }
                                while (i18 == 0) {
                                    int i20 = i17 - 1;
                                    i18 = random.nextInt() % i20;
                                    if (i18 < 0) {
                                        i18 += i20;
                                    }
                                }
                                order3 = IntegerFunctions.order(i18, i17);
                            }
                            int i21 = i16 / order3;
                            int i22 = i18;
                            for (int i23 = 2; i23 <= i21; i23++) {
                                i22 *= i18;
                            }
                            i3 = i22;
                        }
                        int i24 = 0;
                        int i25 = 1;
                        while (true) {
                            i4 = this.c;
                            if (i24 >= i4) {
                                break;
                            }
                            int i26 = i25;
                            for (int i27 = 0; i27 < this.mDegree; i27++) {
                                iArr3[i26] = i27;
                                i26 = (i26 << 1) % i17;
                                if (i26 < 0) {
                                    i26 += i17;
                                }
                            }
                            i25 = (i25 * i3) % i17;
                            if (i25 < 0) {
                                i25 += i17;
                            }
                            i24++;
                        }
                        if (i4 == 1) {
                            int i28 = 1;
                            while (i28 < i17 - 1) {
                                int[][] iArr4 = this.d;
                                int i29 = i28 + 1;
                                if (iArr4[iArr3[i29]][0] == -1) {
                                    iArr4[iArr3[i29]][0] = iArr3[i17 - i28];
                                } else {
                                    iArr4[iArr3[i29]][1] = iArr3[i17 - i28];
                                }
                                i28 = i29;
                            }
                            int i30 = this.mDegree >> 1;
                            for (int i31 = 1; i31 <= i30; i31++) {
                                int[][] iArr5 = this.d;
                                int i32 = i31 - 1;
                                if (iArr5[i32][0] == -1) {
                                    iArr5[i32][0] = (i30 + i31) - 1;
                                } else {
                                    iArr5[i32][1] = (i30 + i31) - 1;
                                }
                                int i33 = (i30 + i31) - 1;
                                if (iArr5[i33][0] == -1) {
                                    iArr5[i33][0] = i32;
                                } else {
                                    iArr5[i33][1] = i32;
                                }
                            }
                        } else if (i4 == 2) {
                            int i34 = 1;
                            while (i34 < i17 - 1) {
                                int[][] iArr6 = this.d;
                                int i35 = i34 + 1;
                                if (iArr6[iArr3[i35]][0] == -1) {
                                    iArr6[iArr3[i35]][0] = iArr3[i17 - i34];
                                } else {
                                    iArr6[iArr3[i35]][1] = iArr3[i17 - i34];
                                }
                                i34 = i35;
                            }
                        } else {
                            throw new RuntimeException("only type 1 or type 2 implemented");
                        }
                        computeFieldPolynomial();
                        this.fields = new Vector();
                        this.matrices = new Vector();
                        return;
                    }
                    throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
                }
                StringBuilder L = a.L("\nThe type of this field is ");
                L.append(this.c);
                throw new RuntimeException(L.toString());
            }
            throw new RuntimeException("The extension degree is divisible by 8!");
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: org.spongycastle.pqc.math.linearalgebra.GF2nPolynomialElement[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: org.spongycastle.pqc.math.linearalgebra.GF2nPolynomialElement */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: org.spongycastle.pqc.math.linearalgebra.GF2nPolynomialElement */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        int i = this.mDegree;
        if (i == gF2nField.mDegree) {
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i];
            for (int i2 = 0; i2 < this.mDegree; i2++) {
                gF2PolynomialArr[i2] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            GF2nPolynomialElement[] gF2nPolynomialElementArr = new GF2nPolynomialElement[this.mDegree];
            gF2nPolynomialElementArr[0] = (GF2nElement) randomRoot.clone();
            for (int i3 = 1; i3 < this.mDegree; i3++) {
                gF2nPolynomialElementArr[i3] = gF2nPolynomialElementArr[i3 - 1].square();
            }
            for (int i4 = 0; i4 < this.mDegree; i4++) {
                for (int i5 = 0; i5 < this.mDegree; i5++) {
                    if (gF2nPolynomialElementArr[i4].b(i5)) {
                        int i6 = this.mDegree;
                        gF2PolynomialArr[(i6 - i5) - 1].setBit((i6 - i4) - 1);
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    public void computeFieldPolynomial() {
        int i = this.c;
        if (i == 1) {
            this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1, "ALL");
        } else if (i == 2) {
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1, "ONE");
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 1, "X");
            gF2Polynomial2.addToThis(gF2Polynomial);
            GF2Polynomial gF2Polynomial3 = gF2Polynomial;
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            int i2 = 1;
            while (i2 < this.mDegree) {
                GF2Polynomial shiftLeft = gF2Polynomial4.shiftLeft();
                shiftLeft.addToThis(gF2Polynomial3);
                i2++;
                gF2Polynomial3 = gF2Polynomial4;
                gF2Polynomial4 = shiftLeft;
            }
            this.fieldPolynomial = gF2Polynomial4;
        }
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
                GF2nONBElement gF2nONBElement = new GF2nONBElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, GF2nONBElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nONBElement);
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
}
