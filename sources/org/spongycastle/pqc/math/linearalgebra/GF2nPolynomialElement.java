package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;
import org.spongycastle.asn1.cmc.BodyPartID;
public class GF2nPolynomialElement extends GF2nElement {
    public static final int[] b = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
    public GF2Polynomial a;

    public GF2nPolynomialElement(GF2nPolynomialField gF2nPolynomialField, Random random) {
        this.mField = gF2nPolynomialField;
        this.mDegree = gF2nPolynomialField.getDegree();
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree);
        this.a = gF2Polynomial;
        gF2Polynomial.expandN(this.mDegree);
        this.a.randomize(random);
    }

    public static GF2nPolynomialElement ONE(GF2nPolynomialField gF2nPolynomialField) {
        return new GF2nPolynomialElement(gF2nPolynomialField, new GF2Polynomial(gF2nPolynomialField.getDegree(), new int[]{1}));
    }

    public static GF2nPolynomialElement ZERO(GF2nPolynomialField gF2nPolynomialField) {
        return new GF2nPolynomialElement(gF2nPolynomialField, new GF2Polynomial(gF2nPolynomialField.getDegree()));
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void a() {
        this.a.assignZero();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.addToThis(gFElement);
        return gF2nPolynomialElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nPolynomialElement) {
            GF2nPolynomialElement gF2nPolynomialElement = (GF2nPolynomialElement) gFElement;
            if (this.mField.equals(gF2nPolynomialElement.mField)) {
                this.a.addToThis(gF2nPolynomialElement.a);
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean b(int i) {
        return this.a.testBit(i);
    }

    public final void c() {
        if (this.a.getLength() > this.mDegree) {
            boolean isTrinomial = ((GF2nPolynomialField) this.mField).isTrinomial();
            long j = BodyPartID.bodyIdMax;
            char c = 0;
            if (isTrinomial) {
                try {
                    int tc = ((GF2nPolynomialField) this.mField).getTc();
                    if (this.mDegree - tc > 32) {
                        int length = this.a.getLength();
                        int i = this.mDegree;
                        if (length <= (i << 1)) {
                            GF2Polynomial gF2Polynomial = this.a;
                            int i2 = i >>> 5;
                            int i3 = i & 31;
                            int i4 = 32 - i3;
                            int i5 = i - tc;
                            int i6 = i5 >>> 5;
                            int i7 = 32 - (i5 & 31);
                            int i8 = ((i << 1) - 2) >>> 5;
                            while (i8 > i2) {
                                int[] iArr = gF2Polynomial.c;
                                long j2 = ((long) iArr[i8]) & j;
                                int i9 = i8 - i2;
                                int i10 = i9 - 1;
                                iArr[i10] = iArr[i10] ^ ((int) (j2 << i4));
                                iArr[i9] = (int) (((long) iArr[i9]) ^ (j2 >>> (32 - i4)));
                                int i11 = i8 - i6;
                                int i12 = i11 - 1;
                                iArr[i12] = iArr[i12] ^ ((int) (j2 << i7));
                                iArr[i11] = (int) ((j2 >>> (32 - i7)) ^ ((long) iArr[i11]));
                                iArr[i8] = 0;
                                i8--;
                                i4 = i4;
                                i6 = i6;
                                j = BodyPartID.bodyIdMax;
                            }
                            int[] iArr2 = gF2Polynomial.c;
                            long j3 = ((long) iArr2[i2]) & BodyPartID.bodyIdMax & (BodyPartID.bodyIdMax << i3);
                            iArr2[0] = (int) (((long) iArr2[0]) ^ (j3 >>> (32 - i4)));
                            int i13 = i2 - i6;
                            int i14 = i13 - 1;
                            if (i14 >= 0) {
                                iArr2[i14] = iArr2[i14] ^ ((int) (j3 << i7));
                            }
                            iArr2[i13] = (int) ((j3 >>> (32 - i7)) ^ ((long) iArr2[i13]));
                            iArr2[i2] = iArr2[i2] & GF2Polynomial.h[i3];
                            gF2Polynomial.b = ((i - 1) >>> 5) + 1;
                            gF2Polynomial.a = i;
                            return;
                        }
                    }
                    int i15 = this.mDegree - tc;
                    int length2 = this.a.getLength();
                    while (true) {
                        length2--;
                        if (length2 < this.mDegree) {
                            this.a.reduceN();
                            this.a.expandN(this.mDegree);
                            return;
                        } else if (this.a.testBit(length2)) {
                            this.a.xorBit(length2);
                            this.a.xorBit(length2 - i15);
                            this.a.xorBit(length2 - this.mDegree);
                        }
                    }
                } catch (RuntimeException unused) {
                    throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a trinomial");
                }
            } else if (((GF2nPolynomialField) this.mField).isPentanomial()) {
                try {
                    int[] pc = ((GF2nPolynomialField) this.mField).getPc();
                    if (this.mDegree - pc[2] > 32) {
                        int length3 = this.a.getLength();
                        int i16 = this.mDegree;
                        if (length3 <= (i16 << 1)) {
                            GF2Polynomial gF2Polynomial2 = this.a;
                            Objects.requireNonNull(gF2Polynomial2);
                            int i17 = i16 >>> 5;
                            int i18 = i16 & 31;
                            int i19 = 32 - i18;
                            int i20 = (i16 - pc[0]) >>> 5;
                            int i21 = 32 - ((i16 - pc[0]) & 31);
                            int i22 = (i16 - pc[1]) >>> 5;
                            int i23 = 32 - ((i16 - pc[1]) & 31);
                            int i24 = (i16 - pc[2]) >>> 5;
                            int i25 = 32 - ((i16 - pc[2]) & 31);
                            int i26 = ((i16 << 1) - 2) >>> 5;
                            while (i26 > i17) {
                                int[] iArr3 = gF2Polynomial2.c;
                                long j4 = ((long) iArr3[i26]) & BodyPartID.bodyIdMax;
                                int i27 = i26 - i17;
                                int i28 = i27 - 1;
                                iArr3[i28] = iArr3[i28] ^ ((int) (j4 << i19));
                                iArr3[i27] = (int) (((long) iArr3[i27]) ^ (j4 >>> (32 - i19)));
                                int i29 = i26 - i20;
                                int i30 = i29 - 1;
                                iArr3[i30] = iArr3[i30] ^ ((int) (j4 << i21));
                                iArr3[i29] = (int) (((long) iArr3[i29]) ^ (j4 >>> (32 - i21)));
                                int i31 = i26 - i22;
                                int i32 = i31 - 1;
                                iArr3[i32] = iArr3[i32] ^ ((int) (j4 << i23));
                                iArr3[i31] = (int) (((long) iArr3[i31]) ^ (j4 >>> (32 - i23)));
                                int i33 = i26 - i24;
                                int i34 = i33 - 1;
                                iArr3[i34] = iArr3[i34] ^ ((int) (j4 << i25));
                                iArr3[i33] = (int) ((j4 >>> (32 - i25)) ^ ((long) iArr3[i33]));
                                c = 0;
                                iArr3[i26] = 0;
                                i26--;
                                i21 = i21;
                                i16 = i16;
                                i19 = i19;
                                i20 = i20;
                                i17 = i17;
                                i18 = i18;
                            }
                            int[] iArr4 = gF2Polynomial2.c;
                            long j5 = ((long) iArr4[i17]) & BodyPartID.bodyIdMax & (BodyPartID.bodyIdMax << i18);
                            iArr4[c] = (int) (((long) iArr4[c]) ^ (j5 >>> (32 - i19)));
                            int i35 = i17 - i20;
                            int i36 = i35 - 1;
                            if (i36 >= 0) {
                                iArr4[i36] = iArr4[i36] ^ ((int) (j5 << i21));
                            }
                            iArr4[i35] = (int) (((long) iArr4[i35]) ^ (j5 >>> (32 - i21)));
                            int i37 = i17 - i22;
                            int i38 = i37 - 1;
                            if (i38 >= 0) {
                                iArr4[i38] = iArr4[i38] ^ ((int) (j5 << i23));
                            }
                            iArr4[i37] = (int) (((long) iArr4[i37]) ^ (j5 >>> (32 - i23)));
                            int i39 = i17 - i24;
                            int i40 = i39 - 1;
                            if (i40 >= 0) {
                                iArr4[i40] = iArr4[i40] ^ ((int) (j5 << i25));
                            }
                            iArr4[i39] = (int) ((j5 >>> (32 - i25)) ^ ((long) iArr4[i39]));
                            iArr4[i17] = iArr4[i17] & GF2Polynomial.h[i18];
                            gF2Polynomial2.b = ((i16 - 1) >>> 5) + 1;
                            gF2Polynomial2.a = i16;
                            return;
                        }
                    }
                    int i41 = this.mDegree;
                    int i42 = i41 - pc[2];
                    int i43 = i41 - pc[1];
                    int i44 = i41 - pc[0];
                    for (int length4 = this.a.getLength() - 1; length4 >= this.mDegree; length4--) {
                        if (this.a.testBit(length4)) {
                            this.a.xorBit(length4);
                            this.a.xorBit(length4 - i42);
                            this.a.xorBit(length4 - i43);
                            this.a.xorBit(length4 - i44);
                            this.a.xorBit(length4 - this.mDegree);
                        }
                    }
                    this.a.reduceN();
                    this.a.expandN(this.mDegree);
                } catch (RuntimeException unused2) {
                    throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a pentanomial");
                }
            } else {
                GF2Polynomial remainder = this.a.remainder(this.mField.getFieldPolynomial());
                this.a = remainder;
                remainder.expandN(this.mDegree);
            }
        } else {
            int length5 = this.a.getLength();
            int i45 = this.mDegree;
            if (length5 < i45) {
                this.a.expandN(i45);
            }
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement, org.spongycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nPolynomialElement(this);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nPolynomialElement)) {
            return false;
        }
        GF2nPolynomialElement gF2nPolynomialElement = (GF2nPolynomialElement) obj;
        GF2nField gF2nField = this.mField;
        if (gF2nField == gF2nPolynomialElement.mField || gF2nField.getFieldPolynomial().equals(gF2nPolynomialElement.mField.getFieldPolynomial())) {
            return this.a.equals(gF2nPolynomialElement.a);
        }
        return false;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return this.a.hashCode() + this.mField.hashCode();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.increaseThis();
        return gF2nPolynomialElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() {
        this.a.increaseThis();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws ArithmeticException {
        return invertMAIA();
    }

    public GF2nPolynomialElement invertEEA() throws ArithmeticException {
        if (!isZero()) {
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 32, "ONE");
            gF2Polynomial.reduceN();
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 32);
            gF2Polynomial2.reduceN();
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this.a);
            GF2Polynomial fieldPolynomial = this.mField.getFieldPolynomial();
            gF2Polynomial3.reduceN();
            while (!gF2Polynomial3.isOne()) {
                gF2Polynomial3.reduceN();
                fieldPolynomial.reduceN();
                int length = gF2Polynomial3.getLength() - fieldPolynomial.getLength();
                if (length < 0) {
                    length = -length;
                    gF2Polynomial.reduceN();
                    gF2Polynomial2 = gF2Polynomial;
                    gF2Polynomial = gF2Polynomial2;
                    fieldPolynomial = gF2Polynomial3;
                    gF2Polynomial3 = fieldPolynomial;
                }
                gF2Polynomial3.shiftLeftAddThis(fieldPolynomial, length);
                gF2Polynomial.shiftLeftAddThis(gF2Polynomial2, length);
            }
            gF2Polynomial.reduceN();
            return new GF2nPolynomialElement((GF2nPolynomialField) this.mField, gF2Polynomial);
        }
        throw new ArithmeticException();
    }

    public GF2nPolynomialElement invertMAIA() throws ArithmeticException {
        if (!isZero()) {
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree, "ONE");
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree);
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this.a);
            GF2Polynomial fieldPolynomial = this.mField.getFieldPolynomial();
            while (true) {
                if (!gF2Polynomial3.testBit(0)) {
                    gF2Polynomial3.shiftRightThis();
                    if (!gF2Polynomial.testBit(0)) {
                        gF2Polynomial.shiftRightThis();
                    } else {
                        gF2Polynomial.addToThis(this.mField.getFieldPolynomial());
                        gF2Polynomial.shiftRightThis();
                    }
                } else if (gF2Polynomial3.isOne()) {
                    return new GF2nPolynomialElement((GF2nPolynomialField) this.mField, gF2Polynomial);
                } else {
                    gF2Polynomial3.reduceN();
                    fieldPolynomial.reduceN();
                    if (gF2Polynomial3.getLength() < fieldPolynomial.getLength()) {
                        gF2Polynomial2 = gF2Polynomial;
                        gF2Polynomial = gF2Polynomial2;
                        fieldPolynomial = gF2Polynomial3;
                        gF2Polynomial3 = fieldPolynomial;
                    }
                    gF2Polynomial3.addToThis(fieldPolynomial);
                    gF2Polynomial.addToThis(gF2Polynomial2);
                }
            }
        } else {
            throw new ArithmeticException();
        }
    }

    public GF2nPolynomialElement invertSquare() throws ArithmeticException {
        if (!isZero()) {
            int degree = this.mField.getDegree() - 1;
            GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
            gF2nPolynomialElement.a.expandN((this.mDegree << 1) + 32);
            gF2nPolynomialElement.a.reduceN();
            int i = 1;
            for (int floorLog = IntegerFunctions.floorLog(degree) - 1; floorLog >= 0; floorLog--) {
                GF2nPolynomialElement gF2nPolynomialElement2 = new GF2nPolynomialElement(gF2nPolynomialElement);
                for (int i2 = 1; i2 <= i; i2++) {
                    gF2nPolynomialElement2.squareThisPreCalc();
                }
                gF2nPolynomialElement.multiplyThisBy(gF2nPolynomialElement2);
                i <<= 1;
                if ((b[floorLog] & degree) != 0) {
                    gF2nPolynomialElement.squareThisPreCalc();
                    gF2nPolynomialElement.multiplyThisBy(this);
                    i++;
                }
            }
            gF2nPolynomialElement.squareThisPreCalc();
            return gF2nPolynomialElement;
        }
        throw new ArithmeticException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        return this.a.isOne();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        return this.a.isZero();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.multiplyThisBy(gFElement);
        return gF2nPolynomialElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public void multiplyThisBy(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nPolynomialElement) {
            GF2nPolynomialElement gF2nPolynomialElement = (GF2nPolynomialElement) gFElement;
            if (!this.mField.equals(gF2nPolynomialElement.mField)) {
                throw new RuntimeException();
            } else if (equals(gFElement)) {
                squareThis();
            } else {
                this.a = this.a.multiply(gF2nPolynomialElement.a);
                c();
            }
        } else {
            throw new RuntimeException();
        }
    }

    public GF2nPolynomialElement power(int i) {
        if (i == 1) {
            return new GF2nPolynomialElement(this);
        }
        GF2nPolynomialElement ONE = ONE((GF2nPolynomialField) this.mField);
        if (i == 0) {
            return ONE;
        }
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.a.expandN((gF2nPolynomialElement.mDegree << 1) + 32);
        gF2nPolynomialElement.a.reduceN();
        for (int i2 = 0; i2 < this.mDegree; i2++) {
            if (((1 << i2) & i) != 0) {
                ONE.multiplyThisBy(gF2nPolynomialElement);
            }
            gF2nPolynomialElement.square();
        }
        return ONE;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        GF2nPolynomialElement ZERO;
        GF2nPolynomialElement gF2nPolynomialElement;
        if (isZero()) {
            return ZERO((GF2nPolynomialField) this.mField);
        }
        int i = this.mDegree;
        if ((i & 1) != 1) {
            do {
                GF2nPolynomialElement gF2nPolynomialElement2 = new GF2nPolynomialElement((GF2nPolynomialField) this.mField, new Random());
                ZERO = ZERO((GF2nPolynomialField) this.mField);
                gF2nPolynomialElement = (GF2nPolynomialElement) gF2nPolynomialElement2.clone();
                for (int i2 = 1; i2 < this.mDegree; i2++) {
                    ZERO.squareThis();
                    gF2nPolynomialElement.squareThis();
                    ZERO.addToThis(gF2nPolynomialElement.multiply(this));
                    gF2nPolynomialElement.addToThis(gF2nPolynomialElement2);
                }
            } while (gF2nPolynomialElement.isZero());
            if (equals(ZERO.square().add(ZERO))) {
                return ZERO;
            }
            throw new RuntimeException();
        } else if ((i & 1) != 0) {
            GF2nPolynomialElement gF2nPolynomialElement3 = new GF2nPolynomialElement(this);
            for (int i3 = 1; i3 <= ((this.mDegree - 1) >> 1); i3++) {
                gF2nPolynomialElement3.squareThis();
                gF2nPolynomialElement3.squareThis();
                gF2nPolynomialElement3.addToThis(this);
            }
            return gF2nPolynomialElement3;
        } else {
            throw new RuntimeException();
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        return squarePreCalc();
    }

    public GF2nPolynomialElement squareBitwise() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.squareThisBitwise();
        gF2nPolynomialElement.c();
        return gF2nPolynomialElement;
    }

    public GF2nPolynomialElement squareMatrix() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.squareThisMatrix();
        gF2nPolynomialElement.c();
        return gF2nPolynomialElement;
    }

    public GF2nPolynomialElement squarePreCalc() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.squareThisPreCalc();
        gF2nPolynomialElement.c();
        return gF2nPolynomialElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        gF2nPolynomialElement.squareRootThis();
        return gF2nPolynomialElement;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        this.a.expandN((this.mDegree << 1) + 32);
        this.a.reduceN();
        for (int i = 0; i < this.mField.getDegree() - 1; i++) {
            squareThis();
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        squareThisPreCalc();
    }

    public void squareThisBitwise() {
        this.a.squareThisBitwise();
        c();
    }

    public void squareThisMatrix() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree);
        int i = 0;
        while (true) {
            int i2 = this.mDegree;
            if (i < i2) {
                if (this.a.vectorMult(((GF2nPolynomialField) this.mField).a[(i2 - i) - 1])) {
                    gF2Polynomial.setBit(i);
                }
                i++;
            } else {
                this.a = gF2Polynomial;
                return;
            }
        }
    }

    public void squareThisPreCalc() {
        this.a.squareThisPreCalc();
        c();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        return this.a.testBit(0);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        return this.a.toByteArray();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return this.a.toFlexiBigInt();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return this.a.toString(16);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this);
        for (int i = 1; i < this.mDegree; i++) {
            gF2nPolynomialElement.squareThis();
            gF2nPolynomialElement.addToThis(this);
        }
        if (gF2nPolynomialElement.isOne()) {
            return 1;
        }
        return 0;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GFElement
    public String toString(int i) {
        return this.a.toString(i);
    }

    public GF2nPolynomialElement(GF2nPolynomialField gF2nPolynomialField, GF2Polynomial gF2Polynomial) {
        this.mField = gF2nPolynomialField;
        this.mDegree = gF2nPolynomialField.getDegree();
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(gF2Polynomial);
        this.a = gF2Polynomial2;
        gF2Polynomial2.expandN(this.mDegree);
    }

    public GF2nPolynomialElement(GF2nPolynomialField gF2nPolynomialField, byte[] bArr) {
        this.mField = gF2nPolynomialField;
        this.mDegree = gF2nPolynomialField.getDegree();
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree, bArr);
        this.a = gF2Polynomial;
        gF2Polynomial.expandN(this.mDegree);
    }

    public GF2nPolynomialElement(GF2nPolynomialField gF2nPolynomialField, int[] iArr) {
        this.mField = gF2nPolynomialField;
        this.mDegree = gF2nPolynomialField.getDegree();
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree, iArr);
        this.a = gF2Polynomial;
        gF2Polynomial.expandN(gF2nPolynomialField.mDegree);
    }

    public GF2nPolynomialElement(GF2nPolynomialElement gF2nPolynomialElement) {
        this.mField = gF2nPolynomialElement.mField;
        this.mDegree = gF2nPolynomialElement.mDegree;
        this.a = new GF2Polynomial(gF2nPolynomialElement.a);
    }
}
