package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
@Beta
@GwtIncompatible
public final class StatsAccumulator {
    public long a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public double d = Double.NaN;
    public double e = Double.NaN;

    public static double a(double d2, double d3) {
        if (Doubles.isFinite(d2)) {
            return d3;
        }
        if (Doubles.isFinite(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }

    public void add(double d2) {
        long j = this.a;
        if (j == 0) {
            this.a = 1;
            this.b = d2;
            this.d = d2;
            this.e = d2;
            if (!Doubles.isFinite(d2)) {
                this.c = Double.NaN;
                return;
            }
            return;
        }
        this.a = j + 1;
        if (!Doubles.isFinite(d2) || !Doubles.isFinite(this.b)) {
            this.b = a(this.b, d2);
            this.c = Double.NaN;
        } else {
            double d3 = this.b;
            double d4 = d2 - d3;
            double d5 = (d4 / ((double) this.a)) + d3;
            this.b = d5;
            this.c = ((d2 - d5) * d4) + this.c;
        }
        this.d = Math.min(this.d, d2);
        this.e = Math.max(this.e, d2);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            add(number.doubleValue());
        }
    }

    public long count() {
        return this.a;
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

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        Preconditions.checkState(this.a != 0);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        if (this.a == 1) {
            return 0.0d;
        }
        return AppCompatDelegateImpl.i.j0(this.c) / ((double) this.a);
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.a > 1);
        if (Double.isNaN(this.c)) {
            return Double.NaN;
        }
        return AppCompatDelegateImpl.i.j0(this.c) / ((double) (this.a - 1));
    }

    public Stats snapshot() {
        return new Stats(this.a, this.b, this.c, this.d, this.e);
    }

    public final double sum() {
        return this.b * ((double) this.a);
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(((Number) it.next()).doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d2 : dArr) {
            add(d2);
        }
    }

    public void addAll(int... iArr) {
        for (int i : iArr) {
            add((double) i);
        }
    }

    public void addAll(long... jArr) {
        for (long j : jArr) {
            add((double) j);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() != 0) {
            long j = this.a;
            if (j == 0) {
                this.a = stats.count();
                this.b = stats.mean();
                this.c = stats.c;
                this.d = stats.min();
                this.e = stats.max();
                return;
            }
            this.a = stats.count() + j;
            if (!Doubles.isFinite(this.b) || !Doubles.isFinite(stats.mean())) {
                this.b = a(this.b, stats.mean());
                this.c = Double.NaN;
            } else {
                double mean = stats.mean();
                double d2 = this.b;
                double d3 = mean - d2;
                this.b = ((((double) stats.count()) * d3) / ((double) this.a)) + d2;
                this.c = ((stats.mean() - this.b) * d3 * ((double) stats.count())) + stats.c + this.c;
            }
            this.d = Math.min(this.d, stats.min());
            this.e = Math.max(this.e, stats.max());
        }
    }
}
