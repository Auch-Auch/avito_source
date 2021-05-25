package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;
@GwtIncompatible
public abstract class d0 extends RateLimiter {
    public double c;
    public double d;
    public double e;
    public long f = 0;

    public static final class b extends d0 {
        public final double g;

        public b(RateLimiter.a aVar, double d) {
            super(aVar, null);
            this.g = d;
        }

        @Override // a2.j.d.l.a.d0
        public double f() {
            return this.e;
        }

        @Override // a2.j.d.l.a.d0
        public void g(double d, double d2) {
            double d3 = this.d;
            double d4 = this.g * d;
            this.d = d4;
            if (d3 == Double.POSITIVE_INFINITY) {
                this.c = d4;
                return;
            }
            double d5 = 0.0d;
            if (d3 != 0.0d) {
                d5 = (this.c * d4) / d3;
            }
            this.c = d5;
        }

        @Override // a2.j.d.l.a.d0
        public long i(double d, double d2) {
            return 0;
        }
    }

    public static final class c extends d0 {
        public final long g;
        public double h;
        public double i;
        public double j;

        public c(RateLimiter.a aVar, long j2, TimeUnit timeUnit, double d) {
            super(aVar, null);
            this.g = timeUnit.toMicros(j2);
            this.j = d;
        }

        @Override // a2.j.d.l.a.d0
        public double f() {
            return ((double) this.g) / this.d;
        }

        @Override // a2.j.d.l.a.d0
        public void g(double d, double d2) {
            double d3 = this.d;
            double d4 = this.j * d2;
            long j2 = this.g;
            double d5 = (((double) j2) * 0.5d) / d2;
            this.i = d5;
            double d6 = ((((double) j2) * 2.0d) / (d2 + d4)) + d5;
            this.d = d6;
            this.h = (d4 - d2) / (d6 - d5);
            if (d3 == Double.POSITIVE_INFINITY) {
                this.c = 0.0d;
                return;
            }
            if (d3 != 0.0d) {
                d6 = (this.c * d6) / d3;
            }
            this.c = d6;
        }

        @Override // a2.j.d.l.a.d0
        public long i(double d, double d2) {
            long j2;
            double d3 = d - this.i;
            if (d3 > 0.0d) {
                double min = Math.min(d3, d2);
                double d4 = this.e;
                double d5 = this.h;
                j2 = (long) (((((d3 * d5) + d4) + (((d3 - min) * d5) + d4)) * min) / 2.0d);
                d2 -= min;
            } else {
                j2 = 0;
            }
            return j2 + ((long) (this.e * d2));
        }
    }

    public d0(RateLimiter.a aVar, a aVar2) {
        super(aVar);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double a() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.e;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void b(double d2, long j) {
        h(j);
        double micros = ((double) TimeUnit.SECONDS.toMicros(1)) / d2;
        this.e = micros;
        g(d2, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long d(long j) {
        return this.f;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long e(int i, long j) {
        h(j);
        long j2 = this.f;
        double d2 = (double) i;
        double min = Math.min(d2, this.c);
        this.f = LongMath.saturatedAdd(this.f, i(this.c, min) + ((long) ((d2 - min) * this.e)));
        this.c -= min;
        return j2;
    }

    public abstract double f();

    public abstract void g(double d2, double d3);

    public void h(long j) {
        long j2 = this.f;
        if (j > j2) {
            this.c = Math.min(this.d, this.c + (((double) (j - j2)) / f()));
            this.f = j;
        }
    }

    public abstract long i(double d2, double d3);
}
