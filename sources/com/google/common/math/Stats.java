package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class Stats implements Serializable {
    private static final long serialVersionUID = 0;
    public final long a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;

    public Stats(long j, double d2, double d3, double d4, double d5) {
        this.a = j;
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.e = d5;
    }

    public static Stats a(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public static Stats fromByteArray(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return a(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public void b(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.a).putDouble(this.b).putDouble(this.c).putDouble(this.d).putDouble(this.e);
    }

    public long count() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        if (this.a == stats.a && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(stats.b) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(stats.c) && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(stats.d) && Double.doubleToLongBits(this.e) == Double.doubleToLongBits(stats.e)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e));
    }

    public double max() {
        Preconditions.checkState(this.a != 0);
        return this.e;
    }

    public double mean() {
        Preconditions.checkState(this.a != 0);
        return this.b;
    }

    public double min() {
        Preconditions.checkState(this.a != 0);
        return this.d;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        Preconditions.checkState(this.a > 0);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        if (this.a == 1) {
            return 0.0d;
        }
        return AppCompatDelegateImpl.i.j0(this.c) / ((double) count());
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        Preconditions.checkState(this.a > 1);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        return AppCompatDelegateImpl.i.j0(this.c) / ((double) (this.a - 1));
    }

    public double sum() {
        return this.b * ((double) this.a);
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        b(order);
        return order.array();
    }

    @Override // java.lang.Object
    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("count", this.a).add("mean", this.b).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.d).add("max", this.e).toString();
        }
        return MoreObjects.toStringHelper(this).add("count", this.a).toString();
    }

    public static double meanOf(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext());
        double doubleValue = ((Number) it.next()).doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            j++;
            if (!Doubles.isFinite(doubleValue2) || !Doubles.isFinite(doubleValue)) {
                doubleValue = StatsAccumulator.a(doubleValue, doubleValue2);
            } else {
                doubleValue = ((doubleValue2 - doubleValue) / ((double) j)) + doubleValue;
            }
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(it);
        return statsAccumulator.snapshot();
    }

    public static Stats of(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(dArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d2 = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d3 = dArr[i];
            if (!Doubles.isFinite(d3) || !Doubles.isFinite(d2)) {
                d2 = StatsAccumulator.a(d2, d3);
            } else {
                d2 = ((d3 - d2) / ((double) (i + 1))) + d2;
            }
        }
        return d2;
    }

    public static Stats of(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iArr);
        return statsAccumulator.snapshot();
    }

    public static Stats of(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(jArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        double d2 = (double) iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d3 = (double) iArr[i];
            if (!Doubles.isFinite(d3) || !Doubles.isFinite(d2)) {
                d2 = StatsAccumulator.a(d2, d3);
            } else {
                d2 = ((d3 - d2) / ((double) (i + 1))) + d2;
            }
        }
        return d2;
    }

    public static double meanOf(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        double d2 = (double) jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d3 = (double) jArr[i];
            if (!Doubles.isFinite(d3) || !Doubles.isFinite(d2)) {
                d2 = StatsAccumulator.a(d2, d3);
            } else {
                d2 = ((d3 - d2) / ((double) (i + 1))) + d2;
            }
        }
        return d2;
    }
}
