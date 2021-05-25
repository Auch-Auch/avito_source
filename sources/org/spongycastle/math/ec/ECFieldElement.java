package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import x6.e.e.a.a;
public abstract class ECFieldElement implements ECConstants {

    public static class Fp extends ECFieldElement {
        public BigInteger a;
        public BigInteger b;
        public BigInteger c;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, a(bigInteger), bigInteger2);
        }

        public static BigInteger a(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.a, this.b, modAdd(this.c, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger add = this.c.add(ECConstants.ONE);
            if (add.compareTo(this.a) == 0) {
                add = ECConstants.ZERO;
            }
            return new Fp(this.a, this.b, add);
        }

        public final ECFieldElement b(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.a, this.b, modMult(this.c, modInverse(eCFieldElement.toBigInteger())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            if (!this.a.equals(fp.a) || !this.c.equals(fp.c)) {
                return false;
            }
            return true;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.a.bitLength();
        }

        public BigInteger getQ() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.c.hashCode();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            return new Fp(this.a, this.b, modInverse(this.c));
        }

        public BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.a) >= 0 ? add.subtract(this.a) : add;
        }

        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.a) >= 0 ? shiftLeft.subtract(this.a) : shiftLeft;
        }

        public BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.a.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.a.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modInverse(BigInteger bigInteger) {
            int fieldSize = getFieldSize();
            int i = (fieldSize + 31) >> 5;
            int[] fromBigInteger = Nat.fromBigInteger(fieldSize, this.a);
            int[] fromBigInteger2 = Nat.fromBigInteger(fieldSize, bigInteger);
            int[] create = Nat.create(i);
            Mod.invert(fromBigInteger, fromBigInteger2, create);
            return Nat.toBigInteger(i, create);
        }

        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.b == null) {
                return bigInteger.mod(this.a);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.a.bitLength();
            boolean equals = this.b.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.b);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.a) >= 0) {
                bigInteger = bigInteger.subtract(this.a);
            }
            if (!z || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return this.a.subtract(bigInteger);
        }

        public BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.a) : subtract;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.a, this.b, modMult(this.c, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.c;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.a, this.b, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.c;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.a, this.b, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            if (this.c.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.a;
            return new Fp(bigInteger, this.b, bigInteger.subtract(this.c));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            BigInteger bigInteger;
            if (isZero() || isOne()) {
                return this;
            }
            if (this.a.testBit(0)) {
                int i = 1;
                if (this.a.testBit(1)) {
                    BigInteger add = this.a.shiftRight(2).add(ECConstants.ONE);
                    BigInteger bigInteger2 = this.a;
                    return b(new Fp(bigInteger2, this.b, this.c.modPow(add, bigInteger2)));
                } else if (this.a.testBit(2)) {
                    BigInteger modPow = this.c.modPow(this.a.shiftRight(3), this.a);
                    BigInteger modMult = modMult(modPow, this.c);
                    if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                        return b(new Fp(this.a, this.b, modMult));
                    }
                    return b(new Fp(this.a, this.b, modMult(modMult, ECConstants.TWO.modPow(this.a.shiftRight(2), this.a))));
                } else {
                    BigInteger shiftRight = this.a.shiftRight(1);
                    BigInteger modPow2 = this.c.modPow(shiftRight, this.a);
                    BigInteger bigInteger3 = ECConstants.ONE;
                    if (!modPow2.equals(bigInteger3)) {
                        return null;
                    }
                    BigInteger bigInteger4 = this.c;
                    BigInteger modDouble = modDouble(modDouble(bigInteger4));
                    BigInteger add2 = shiftRight.add(bigInteger3);
                    BigInteger subtract = this.a.subtract(bigInteger3);
                    Random random = new Random();
                    while (true) {
                        BigInteger bigInteger5 = new BigInteger(this.a.bitLength(), random);
                        if (bigInteger5.compareTo(this.a) < 0 && modReduce(bigInteger5.multiply(bigInteger5).subtract(modDouble)).modPow(shiftRight, this.a).equals(subtract)) {
                            int bitLength = add2.bitLength();
                            int lowestSetBit = add2.getLowestSetBit();
                            BigInteger bigInteger6 = ECConstants.ONE;
                            int i2 = bitLength - i;
                            BigInteger bigInteger7 = bigInteger5;
                            BigInteger bigInteger8 = bigInteger6;
                            BigInteger bigInteger9 = ECConstants.TWO;
                            BigInteger bigInteger10 = bigInteger8;
                            while (i2 >= lowestSetBit + 1) {
                                bigInteger6 = modMult(bigInteger6, bigInteger10);
                                if (add2.testBit(i2)) {
                                    BigInteger modMult2 = modMult(bigInteger6, bigInteger4);
                                    bigInteger8 = modMult(bigInteger8, bigInteger7);
                                    bigInteger9 = modReduce(bigInteger7.multiply(bigInteger9).subtract(bigInteger5.multiply(bigInteger6)));
                                    bigInteger = shiftRight;
                                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger7).subtract(modMult2.shiftLeft(1)));
                                    bigInteger10 = modMult2;
                                } else {
                                    bigInteger = shiftRight;
                                    BigInteger modReduce = modReduce(bigInteger8.multiply(bigInteger9).subtract(bigInteger6));
                                    BigInteger modReduce2 = modReduce(bigInteger7.multiply(bigInteger9).subtract(bigInteger5.multiply(bigInteger6)));
                                    bigInteger9 = modReduce(bigInteger9.multiply(bigInteger9).subtract(bigInteger6.shiftLeft(1)));
                                    bigInteger8 = modReduce;
                                    bigInteger7 = modReduce2;
                                    bigInteger10 = bigInteger6;
                                }
                                i2--;
                                shiftRight = bigInteger;
                            }
                            BigInteger modMult3 = modMult(bigInteger6, bigInteger10);
                            BigInteger modMult4 = modMult(modMult3, bigInteger4);
                            BigInteger modReduce3 = modReduce(bigInteger8.multiply(bigInteger9).subtract(modMult3));
                            BigInteger modReduce4 = modReduce(bigInteger7.multiply(bigInteger9).subtract(bigInteger5.multiply(modMult3)));
                            BigInteger modMult5 = modMult(modMult3, modMult4);
                            for (int i3 = 1; i3 <= lowestSetBit; i3++) {
                                modReduce3 = modMult(modReduce3, modReduce4);
                                modReduce4 = modReduce(modReduce4.multiply(modReduce4).subtract(modMult5.shiftLeft(1)));
                                modMult5 = modMult(modMult5, modMult5);
                            }
                            i = 1;
                            BigInteger[] bigIntegerArr = {modReduce3, modReduce4};
                            BigInteger bigInteger11 = bigIntegerArr[0];
                            BigInteger bigInteger12 = bigIntegerArr[1];
                            if (modMult(bigInteger12, bigInteger12).equals(modDouble)) {
                                return new Fp(this.a, this.b, modHalfAbs(bigInteger12));
                            }
                            if (!(bigInteger11.equals(ECConstants.ONE) || bigInteger11.equals(subtract))) {
                                return null;
                            }
                            shiftRight = shiftRight;
                        }
                    }
                }
            } else {
                throw new RuntimeException("not done yet");
            }
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.a;
            BigInteger bigInteger2 = this.b;
            BigInteger bigInteger3 = this.c;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.c;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.a, this.b, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.c;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.a, this.b, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.a, this.b, modSubtract(this.c, eCFieldElement.toBigInteger()));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.c;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.a = bigInteger;
            this.b = bigInteger2;
            this.c = bigInteger3;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i) {
        ECFieldElement eCFieldElement = this;
        for (int i2 = 0; i2 < i; i2++) {
            eCFieldElement = eCFieldElement.square();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }

    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        public int a;
        public int b;
        public int[] c;
        public a d;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.a = 2;
                this.c = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.a = 3;
                this.c = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.b = i;
            this.d = new a(bigInteger);
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.a != f2m2.a) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (f2m.b != f2m2.b || !Arrays.areEqual(f2m.c, f2m2.c)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            a aVar = (a) this.d.clone();
            aVar.e(((F2m) eCFieldElement).d, 0);
            return new F2m(this.b, this.c, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            a aVar;
            int i = this.b;
            int[] iArr = this.c;
            a aVar2 = this.d;
            if (aVar2.a.length == 0) {
                aVar = new a(new long[]{1});
            } else {
                int max = Math.max(1, aVar2.m());
                long[] jArr = new long[max];
                long[] jArr2 = aVar2.a;
                System.arraycopy(jArr2, 0, jArr, 0, Math.min(jArr2.length, max));
                jArr[0] = jArr[0] ^ 1;
                aVar = new a(jArr);
            }
            return new F2m(i, iArr, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.d.h();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            if (this.b != f2m.b || this.a != f2m.a || !Arrays.areEqual(this.c, f2m.c) || !this.d.equals(f2m.d)) {
                return false;
            }
            return true;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.b;
        }

        public int getK1() {
            return this.c[0];
        }

        public int getK2() {
            int[] iArr = this.c;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.c;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.b;
        }

        public int getRepresentation() {
            return this.a;
        }

        public int hashCode() {
            return (this.d.hashCode() ^ this.b) ^ Arrays.hashCode(this.c);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int i = this.b;
            int[] iArr = this.c;
            return new F2m(i, iArr, this.d.q(i, iArr));
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isOne() {
            return this.d.o();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.d.p();
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            long[] jArr;
            int i;
            int i2 = this.b;
            int[] iArr = this.c;
            a aVar = this.d;
            a aVar2 = ((F2m) eCFieldElement).d;
            int h = aVar.h();
            if (h != 0) {
                int h2 = aVar2.h();
                if (h2 != 0) {
                    if (h > h2) {
                        h2 = h;
                        h = h2;
                    } else {
                        aVar2 = aVar;
                        aVar = aVar2;
                    }
                    int i3 = (h + 63) >>> 6;
                    int i4 = (h2 + 63) >>> 6;
                    int i5 = ((h + h2) + 62) >>> 6;
                    if (i3 == 1) {
                        long j = aVar2.a[0];
                        if (j != 1) {
                            long[] jArr2 = new long[i5];
                            a.s(j, aVar.a, i4, jArr2, 0);
                            aVar = new a(jArr2, 0, a.v(jArr2, 0, i5, i2, iArr));
                        }
                    } else {
                        int i6 = ((h2 + 7) + 63) >>> 6;
                        int[] iArr2 = new int[16];
                        int i7 = i6 << 4;
                        long[] jArr3 = new long[i7];
                        iArr2[1] = i6;
                        System.arraycopy(aVar.a, 0, jArr3, i6, i4);
                        int i8 = 2;
                        int i9 = i6;
                        for (int i10 = 16; i8 < i10; i10 = 16) {
                            i9 += i6;
                            iArr2[i8] = i9;
                            if ((i8 & 1) == 0) {
                                jArr = jArr3;
                                i = i7;
                                a.w(jArr3, i9 >>> 1, jArr, i9, i6, 1);
                            } else {
                                jArr = jArr3;
                                i = i7;
                                a.b(jArr3, i6, jArr, i9 - i6, jArr, i9, i6);
                            }
                            i8++;
                            i7 = i;
                            jArr3 = jArr;
                        }
                        long[] jArr4 = new long[i7];
                        a.w(jArr3, 0, jArr4, 0, i7, 4);
                        long[] jArr5 = aVar2.a;
                        int i11 = i5 << 3;
                        long[] jArr6 = new long[i11];
                        for (int i12 = 0; i12 < i3; i12++) {
                            long j2 = jArr5[i12];
                            int i13 = i12;
                            while (true) {
                                long j3 = j2 >>> 4;
                                a.c(jArr6, i13, jArr3, iArr2[((int) j2) & 15], jArr4, iArr2[((int) j3) & 15], i6);
                                j2 = j3 >>> 4;
                                if (j2 == 0) {
                                    break;
                                }
                                i13 += i5;
                            }
                        }
                        while (true) {
                            i11 -= i5;
                            if (i11 == 0) {
                                break;
                            }
                            a.f(jArr6, i11 - i5, jArr6, i11, i5, 8);
                        }
                        aVar2 = new a(jArr6, 0, a.v(jArr6, 0, i5, i2, iArr));
                    }
                }
                aVar = aVar2;
            }
            return new F2m(i2, iArr, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            a aVar = this.d;
            a aVar2 = ((F2m) eCFieldElement).d;
            a aVar3 = ((F2m) eCFieldElement2).d;
            a aVar4 = ((F2m) eCFieldElement3).d;
            a r = aVar.r(aVar2);
            a r2 = aVar3.r(aVar4);
            if (r == aVar || r == aVar2) {
                r = (a) r.clone();
            }
            r.e(r2, 0);
            r.t(this.b, this.c);
            return new F2m(this.b, this.c, r);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            return (this.d.p() || this.d.o()) ? this : squarePow(this.b - 1);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int i = this.b;
            int[] iArr = this.c;
            a aVar = this.d;
            int m = aVar.m();
            if (m != 0) {
                int i2 = m << 1;
                long[] jArr = new long[i2];
                int i3 = 0;
                while (i3 < i2) {
                    long j = aVar.a[i3 >>> 1];
                    int i4 = i3 + 1;
                    jArr[i3] = a.n((int) j);
                    i3 = i4 + 1;
                    jArr[i4] = a.n((int) (j >>> 32));
                }
                aVar = new a(jArr, 0, a.v(jArr, 0, i2, i, iArr));
            }
            return new F2m(i, iArr, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            a aVar;
            a aVar2 = this.d;
            a aVar3 = ((F2m) eCFieldElement).d;
            a aVar4 = ((F2m) eCFieldElement2).d;
            int m = aVar2.m();
            if (m == 0) {
                aVar = aVar2;
            } else {
                int i = m << 1;
                long[] jArr = new long[i];
                int i2 = 0;
                while (i2 < i) {
                    long j = aVar2.a[i2 >>> 1];
                    int i3 = i2 + 1;
                    jArr[i2] = a.n((int) j);
                    i2 = i3 + 1;
                    jArr[i3] = a.n((int) (j >>> 32));
                }
                aVar = new a(jArr, 0, i);
            }
            a r = aVar3.r(aVar4);
            if (aVar == aVar2) {
                aVar = (a) aVar.clone();
            }
            aVar.e(r, 0);
            aVar.t(this.b, this.c);
            return new F2m(this.b, this.c, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement squarePow(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.b;
            int[] iArr = this.c;
            a aVar = this.d;
            int m = aVar.m();
            if (m != 0) {
                int i3 = ((i2 + 63) >>> 6) << 1;
                long[] jArr = new long[i3];
                System.arraycopy(aVar.a, 0, jArr, 0, m);
                while (true) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                    int i4 = m << 1;
                    while (true) {
                        m--;
                        if (m < 0) {
                            break;
                        }
                        long j = jArr[m];
                        int i5 = i4 - 1;
                        jArr[i5] = a.n((int) (j >>> 32));
                        i4 = i5 - 1;
                        jArr[i4] = a.n((int) j);
                    }
                    m = a.v(jArr, 0, i3, i2, iArr);
                }
                aVar = new a(jArr, 0, m);
            }
            return new F2m(i2, iArr, aVar);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            long[] jArr = this.d.a;
            return jArr.length > 0 && (1 & jArr[0]) != 0;
        }

        @Override // org.spongycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.d.x();
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        public F2m(int i, int[] iArr, a aVar) {
            this.b = i;
            this.a = iArr.length == 1 ? 2 : 3;
            this.c = iArr;
            this.d = aVar;
        }
    }
}
