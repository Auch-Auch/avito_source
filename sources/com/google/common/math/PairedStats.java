package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;
    public final Stats a;
    public final Stats b;
    public final double c;

    public PairedStats(Stats stats, Stats stats2, double d) {
        this.a = stats;
        this.b = stats2;
        this.c = d;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.a(order), Stats.a(order), order.getDouble());
    }

    public long count() {
        return this.a.count();
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        if (!this.a.equals(pairedStats.a) || !this.b.equals(pairedStats.b) || Double.doubleToLongBits(this.c) != Double.doubleToLongBits(pairedStats.c)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.a, this.b, Double.valueOf(this.c));
    }

    public LinearTransformation leastSquaresFit() {
        boolean z = true;
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.c)) {
            return LinearTransformation.forNaN();
        }
        Stats stats = this.a;
        double d = stats.c;
        if (d > 0.0d) {
            Stats stats2 = this.b;
            if (stats2.c > 0.0d) {
                return LinearTransformation.mapping(stats.mean(), this.b.mean()).withSlope(this.c / d);
            }
            return LinearTransformation.horizontal(stats2.mean());
        }
        if (this.b.c <= 0.0d) {
            z = false;
        }
        Preconditions.checkState(z);
        return LinearTransformation.vertical(this.a.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z = true;
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        double d = xStats().c;
        double d2 = yStats().c;
        Preconditions.checkState(d > 0.0d);
        if (d2 <= 0.0d) {
            z = false;
        }
        Preconditions.checkState(z);
        double d3 = d * d2;
        if (d3 <= 0.0d) {
            d3 = Double.MIN_VALUE;
        }
        double sqrt = this.c / Math.sqrt(d3);
        double d4 = 1.0d;
        if (sqrt < 1.0d) {
            d4 = -1.0d;
            if (sqrt > -1.0d) {
                return sqrt;
            }
        }
        return d4;
    }

    public double populationCovariance() {
        Preconditions.checkState(count() != 0);
        return this.c / ((double) count());
    }

    public double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        return this.c / ((double) (count() - 1));
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.a.b(order);
        this.b.b(order);
        order.putDouble(this.c);
        return order.array();
    }

    @Override // java.lang.Object
    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("xStats", this.a).add("yStats", this.b).add("populationCovariance", populationCovariance()).toString();
        }
        return MoreObjects.toStringHelper(this).add("xStats", this.a).add("yStats", this.b).toString();
    }

    public Stats xStats() {
        return this.a;
    }

    public Stats yStats() {
        return this.b;
    }
}
