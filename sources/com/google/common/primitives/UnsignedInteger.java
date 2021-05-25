package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtCompatible(emulated = true)
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger ZERO = fromIntBits(0);
    public final int a;

    public UnsignedInteger(int i) {
        this.a = i & -1;
    }

    public static UnsignedInteger fromIntBits(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger valueOf(long j) {
        Preconditions.checkArgument((BodyPartID.bodyIdMax & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.divide(this.a, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (double) longValue();
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof UnsignedInteger) || this.a != ((UnsignedInteger) obj).a) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) longValue();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.toLong(this.a);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.a - ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).a);
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.remainder(this.a, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).a));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.a + ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).a);
    }

    @GwtIncompatible
    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.a * ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).a);
    }

    @Override // java.lang.Object
    public String toString() {
        return toString(10);
    }

    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        return UnsignedInts.compare(this.a, unsignedInteger.a);
    }

    public String toString(int i) {
        return UnsignedInts.toString(this.a, i);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i) {
        return fromIntBits(UnsignedInts.parseUnsignedInt(str, i));
    }
}
