package com.google.common.util.concurrent;

import a2.j.d.l.a.d0;
import a2.j.d.l.a.z;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@Beta
@GwtIncompatible
public abstract class RateLimiter {
    public final a a;
    @MonotonicNonNullDecl
    public volatile Object b;

    public static abstract class a {
        public abstract long a();

        public abstract void b(long j);
    }

    public RateLimiter(a aVar) {
        this.a = (a) Preconditions.checkNotNull(aVar);
    }

    public static RateLimiter create(double d, long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "warmupPeriod must not be negative: %s", j);
        d0.c cVar = new d0.c(new z(), j, timeUnit, 3.0d);
        cVar.setRate(d);
        return cVar;
    }

    public abstract double a();

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    public abstract void b(double d, long j);

    public final Object c() {
        Object obj = this.b;
        if (obj == null) {
            synchronized (this) {
                obj = this.b;
                if (obj == null) {
                    obj = new Object();
                    this.b = obj;
                }
            }
        }
        return obj;
    }

    public abstract long d(long j);

    public abstract long e(int i, long j);

    public final double getRate() {
        double a3;
        synchronized (c()) {
            a3 = a();
        }
        return a3;
    }

    public final void setRate(double d) {
        Preconditions.checkArgument(d > 0.0d && !Double.isNaN(d), "rate must be positive");
        synchronized (c()) {
            b(d, this.a.a());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) {
        return tryAcquire(1, j, timeUnit);
    }

    @CanIgnoreReturnValue
    public double acquire(int i) {
        long max;
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
        synchronized (c()) {
            long a3 = this.a.a();
            max = Math.max(e(i, a3) - a3, 0L);
        }
        this.a.b(max);
        return (((double) max) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    public boolean tryAcquire(int i) {
        return tryAcquire(i, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j), 0L);
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
        synchronized (c()) {
            long a3 = this.a.a();
            if (!(d(a3) - max <= a3)) {
                return false;
            }
            this.a.b(Math.max(e(i, a3) - a3, 0L));
            return true;
        }
    }

    public static RateLimiter create(double d) {
        d0.b bVar = new d0.b(new z(), 1.0d);
        bVar.setRate(d);
        return bVar;
    }
}
