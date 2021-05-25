package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class CacheStats {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 < 0 ? false : z);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public double averageLoadPenalty() {
        long saturatedAdd = LongMath.saturatedAdd(this.c, this.d);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return ((double) this.e) / ((double) saturatedAdd);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.a == cacheStats.a && this.b == cacheStats.b && this.c == cacheStats.c && this.d == cacheStats.d && this.e == cacheStats.e && this.f == cacheStats.f) {
            return true;
        }
        return false;
    }

    public long evictionCount() {
        return this.f;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public long hitCount() {
        return this.a;
    }

    public double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return ((double) this.a) / ((double) requestCount);
    }

    public long loadCount() {
        return LongMath.saturatedAdd(this.c, this.d);
    }

    public long loadExceptionCount() {
        return this.d;
    }

    public double loadExceptionRate() {
        long saturatedAdd = LongMath.saturatedAdd(this.c, this.d);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return ((double) this.d) / ((double) saturatedAdd);
    }

    public long loadSuccessCount() {
        return this.c;
    }

    public CacheStats minus(CacheStats cacheStats) {
        return new CacheStats(Math.max(0L, LongMath.saturatedSubtract(this.a, cacheStats.a)), Math.max(0L, LongMath.saturatedSubtract(this.b, cacheStats.b)), Math.max(0L, LongMath.saturatedSubtract(this.c, cacheStats.c)), Math.max(0L, LongMath.saturatedSubtract(this.d, cacheStats.d)), Math.max(0L, LongMath.saturatedSubtract(this.e, cacheStats.e)), Math.max(0L, LongMath.saturatedSubtract(this.f, cacheStats.f)));
    }

    public long missCount() {
        return this.b;
    }

    public double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return ((double) this.b) / ((double) requestCount);
    }

    public CacheStats plus(CacheStats cacheStats) {
        return new CacheStats(LongMath.saturatedAdd(this.a, cacheStats.a), LongMath.saturatedAdd(this.b, cacheStats.b), LongMath.saturatedAdd(this.c, cacheStats.c), LongMath.saturatedAdd(this.d, cacheStats.d), LongMath.saturatedAdd(this.e, cacheStats.e), LongMath.saturatedAdd(this.f, cacheStats.f));
    }

    public long requestCount() {
        return LongMath.saturatedAdd(this.a, this.b);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.a).add("missCount", this.b).add("loadSuccessCount", this.c).add("loadExceptionCount", this.d).add("totalLoadTime", this.e).add("evictionCount", this.f).toString();
    }

    public long totalLoadTime() {
        return this.e;
    }
}
