package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;
public class SecP224R1FieldElement extends ECFieldElement {
    public static final BigInteger Q = SecP224R1Curve.q;
    public int[] x;

    public SecP224R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.x = SecP224R1Field.fromBigInteger(bigInteger);
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        SecP224R1Field.multiply(iArr2, iArr, iArr2);
        SecP224R1Field.twice(iArr2, iArr2);
        SecP224R1Field.square(iArr, iArr4);
        SecP224R1Field.add(iArr3, iArr4, iArr);
        SecP224R1Field.multiply(iArr3, iArr4, iArr3);
        SecP224R1Field.reduce32(Nat.shiftUpBits(7, iArr3, 2, 0), iArr3);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224R1Field.add(this.x, ((SecP224R1FieldElement) eCFieldElement).x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] create = Nat224.create();
        SecP224R1Field.addOne(this.x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        Mod.invert(SecP224R1Field.a, ((SecP224R1FieldElement) eCFieldElement).x, create);
        SecP224R1Field.multiply(create, this.x, create);
        return new SecP224R1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224R1FieldElement)) {
            return false;
        }
        return Nat224.eq(this.x, ((SecP224R1FieldElement) obj).x);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP224R1Field";
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 7);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] create = Nat224.create();
        Mod.invert(SecP224R1Field.a, this.x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.x);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.x);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224R1Field.multiply(this.x, ((SecP224R1FieldElement) eCFieldElement).x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] create = Nat224.create();
        SecP224R1Field.negate(this.x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        boolean z;
        int[] iArr = this.x;
        if (Nat224.isZero(iArr) || Nat224.isOne(iArr)) {
            return this;
        }
        int[] create = Nat224.create();
        SecP224R1Field.negate(iArr, create);
        int[] random = Mod.random(SecP224R1Field.a);
        int[] create2 = Nat224.create();
        int[] create3 = Nat224.create();
        int[] create4 = Nat224.create();
        Nat224.copy(iArr, create3);
        for (int i = 0; i < 7; i++) {
            Nat224.copy(create3, create4);
            SecP224R1Field.squareN(create3, 1 << i, create3);
            SecP224R1Field.multiply(create3, create4, create3);
        }
        SecP224R1Field.squareN(create3, 95, create3);
        if (!Nat224.isOne(create3)) {
            return null;
        }
        while (true) {
            int[] create5 = Nat224.create();
            Nat224.copy(random, create5);
            int[] create6 = Nat224.create();
            create6[0] = 1;
            int[] create7 = Nat224.create();
            Nat224.copy(create, create7);
            int[] create8 = Nat224.create();
            int[] create9 = Nat224.create();
            for (int i2 = 0; i2 < 7; i2++) {
                Nat224.copy(create5, create8);
                Nat224.copy(create6, create9);
                int i3 = 1 << i2;
                while (true) {
                    i3--;
                    if (i3 < 0) {
                        break;
                    }
                    a(create5, create6, create7, create2);
                }
                SecP224R1Field.multiply(create6, create9, create2);
                SecP224R1Field.multiply(create2, create, create2);
                SecP224R1Field.multiply(create5, create8, create7);
                SecP224R1Field.add(create7, create2, create7);
                SecP224R1Field.multiply(create5, create9, create2);
                Nat224.copy(create7, create5);
                SecP224R1Field.multiply(create6, create8, create6);
                SecP224R1Field.add(create6, create2, create6);
                SecP224R1Field.square(create6, create7);
                SecP224R1Field.multiply(create7, create, create7);
            }
            int[] create10 = Nat224.create();
            int[] create11 = Nat224.create();
            int i4 = 1;
            while (true) {
                if (i4 >= 96) {
                    z = false;
                    break;
                }
                Nat224.copy(create5, create10);
                Nat224.copy(create6, create11);
                a(create5, create6, create7, create2);
                if (Nat224.isZero(create5)) {
                    Mod.invert(SecP224R1Field.a, create11, create2);
                    SecP224R1Field.multiply(create2, create10, create2);
                    z = true;
                    break;
                }
                i4++;
            }
            if (z) {
                break;
            }
            SecP224R1Field.addOne(random, random);
        }
        SecP224R1Field.square(create2, random);
        if (Nat224.eq(iArr, random)) {
            return new SecP224R1FieldElement(create2);
        }
        return null;
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] create = Nat224.create();
        SecP224R1Field.square(this.x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224R1Field.subtract(this.x, ((SecP224R1FieldElement) eCFieldElement).x, create);
        return new SecP224R1FieldElement(create);
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat224.getBit(this.x, 0) == 1;
    }

    @Override // org.spongycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.x);
    }

    public SecP224R1FieldElement() {
        this.x = Nat224.create();
    }

    public SecP224R1FieldElement(int[] iArr) {
        this.x = iArr;
    }
}
