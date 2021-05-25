package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
@Beta
@GwtIncompatible
public final class PairedStatsAccumulator {
    public final StatsAccumulator a = new StatsAccumulator();
    public final StatsAccumulator b = new StatsAccumulator();
    public double c = 0.0d;

    public void add(double d, double d2) {
        this.a.add(d);
        if (!Doubles.isFinite(d) || !Doubles.isFinite(d2)) {
            this.c = Double.NaN;
        } else if (this.a.count() > 1) {
            this.c = ((d2 - this.b.mean()) * (d - this.a.mean())) + this.c;
        }
        this.b.add(d2);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() != 0) {
            this.a.addAll(pairedStats.xStats());
            if (this.b.count() == 0) {
                this.c = pairedStats.c;
            } else {
                this.c = ((pairedStats.yStats().mean() - this.b.mean()) * (pairedStats.xStats().mean() - this.a.mean()) * ((double) pairedStats.count())) + pairedStats.c + this.c;
            }
            this.b.addAll(pairedStats.yStats());
        }
    }

    public long count() {
        return this.a.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean z = true;
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.c)) {
            return LinearTransformation.forNaN();
        }
        StatsAccumulator statsAccumulator = this.a;
        double d = statsAccumulator.c;
        if (d > 0.0d) {
            StatsAccumulator statsAccumulator2 = this.b;
            if (statsAccumulator2.c > 0.0d) {
                return LinearTransformation.mapping(statsAccumulator.mean(), this.b.mean()).withSlope(this.c / d);
            }
            return LinearTransformation.horizontal(statsAccumulator2.mean());
        }
        if (this.b.c <= 0.0d) {
            z = false;
        }
        Preconditions.checkState(z);
        return LinearTransformation.vertical(this.a.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean z = true;
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        double d = this.a.c;
        double d2 = this.b.c;
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

    public final double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        return this.c / ((double) (count() - 1));
    }

    public PairedStats snapshot() {
        return new PairedStats(this.a.snapshot(), this.b.snapshot(), this.c);
    }

    public Stats xStats() {
        return this.a.snapshot();
    }

    public Stats yStats() {
        return this.b.snapshot();
    }
}
