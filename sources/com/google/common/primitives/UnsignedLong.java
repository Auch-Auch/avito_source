package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public final long a;

    public UnsignedLong(long j) {
        this.a = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j) {
        Preconditions.checkArgument(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.a & Long.MAX_VALUE);
        return this.a < 0 ? valueOf.setBit(63) : valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.a, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j = this.a;
        double d = (double) (Long.MAX_VALUE & j);
        return j < 0 ? d + 9.223372036854776E18d : d;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof UnsignedLong) || this.a != ((UnsignedLong) obj).a) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j = this.a;
        float f = (float) (Long.MAX_VALUE & j);
        return j < 0 ? f + 9.223372E18f : f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Longs.hashCode(this.a);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.a;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.a - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).a);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.a, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).a));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.a + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).a);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.a * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).a);
    }

    @Override // java.lang.Object
    public String toString() {
        return UnsignedLongs.toString(this.a);
    }

    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.a, unsignedLong.a);
    }

    public String toString(int i) {
        return UnsignedLongs.toString(this.a, i);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i));
    }
}
