package com.google.common.cache;

import a2.j.d.b.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
    public static final Supplier<? extends AbstractCache.StatsCounter> q = Suppliers.ofInstance(new a());
    public static final CacheStats r = new CacheStats(0, 0, 0, 0, 0, 0);
    public static final Supplier<AbstractCache.StatsCounter> s = new b();
    public static final Ticker t = new c();
    public static final Logger u = Logger.getLogger(CacheBuilder.class.getName());
    public boolean a = true;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    public long e = -1;
    @MonotonicNonNullDecl
    public Weigher<? super K, ? super V> f;
    @MonotonicNonNullDecl
    public a.t g;
    @MonotonicNonNullDecl
    public a.t h;
    public long i = -1;
    public long j = -1;
    public long k = -1;
    @MonotonicNonNullDecl
    public Equivalence<Object> l;
    @MonotonicNonNullDecl
    public Equivalence<Object> m;
    @MonotonicNonNullDecl
    public RemovalListener<? super K, ? super V> n;
    @MonotonicNonNullDecl
    public Ticker o;
    public Supplier<? extends AbstractCache.StatsCounter> p = q;

    public static class a implements AbstractCache.StatsCounter {
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.r;
        }
    }

    public static class b implements Supplier<AbstractCache.StatsCounter> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    }

    public static class c extends Ticker {
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0;
        }
    }

    public enum d implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum e implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        Objects.requireNonNull(cacheBuilderSpec);
        CacheBuilder<Object, Object> newBuilder = newBuilder();
        Integer num = cacheBuilderSpec.a;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l2 = cacheBuilderSpec.b;
        if (l2 != null) {
            newBuilder.maximumSize(l2.longValue());
        }
        Long l3 = cacheBuilderSpec.c;
        if (l3 != null) {
            newBuilder.maximumWeight(l3.longValue());
        }
        Integer num2 = cacheBuilderSpec.d;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        a.t tVar = cacheBuilderSpec.e;
        if (tVar != null) {
            if (tVar.ordinal() == 2) {
                newBuilder.weakKeys();
            } else {
                throw new AssertionError();
            }
        }
        a.t tVar2 = cacheBuilderSpec.f;
        if (tVar2 != null) {
            int ordinal = tVar2.ordinal();
            if (ordinal == 1) {
                newBuilder.softValues();
            } else if (ordinal == 2) {
                newBuilder.weakValues();
            } else {
                throw new AssertionError();
            }
        }
        Boolean bool = cacheBuilderSpec.g;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = cacheBuilderSpec.i;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(cacheBuilderSpec.h, timeUnit);
        }
        TimeUnit timeUnit2 = cacheBuilderSpec.k;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(cacheBuilderSpec.j, timeUnit2);
        }
        TimeUnit timeUnit3 = cacheBuilderSpec.m;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(cacheBuilderSpec.l, timeUnit3);
        }
        newBuilder.a = false;
        return newBuilder;
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public final void a() {
        boolean z = true;
        if (this.f == null) {
            if (this.e != -1) {
                z = false;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.a) {
            if (this.e == -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.e == -1) {
            u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> b(a.t tVar) {
        a.t tVar2 = this.g;
        Preconditions.checkState(tVar2 == null, "Key strength was already set to %s", tVar2);
        this.g = (a.t) Preconditions.checkNotNull(tVar);
        return this;
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        a();
        return new a.n(this, cacheLoader);
    }

    public CacheBuilder<K, V> c(a.t tVar) {
        a.t tVar2 = this.h;
        Preconditions.checkState(tVar2 == null, "Value strength was already set to %s", tVar2);
        this.h = (a.t) Preconditions.checkNotNull(tVar);
        return this;
    }

    public CacheBuilder<K, V> concurrencyLevel(int i2) {
        int i3 = this.c;
        boolean z = true;
        Preconditions.checkState(i3 == -1, "concurrency level was already set to %s", i3);
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.c = i2;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j2, TimeUnit timeUnit) {
        long j3 = this.j;
        boolean z = true;
        Preconditions.checkState(j3 == -1, "expireAfterAccess was already set to %s ns", j3);
        if (j2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.j = timeUnit.toNanos(j2);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j2, TimeUnit timeUnit) {
        long j3 = this.i;
        boolean z = true;
        Preconditions.checkState(j3 == -1, "expireAfterWrite was already set to %s ns", j3);
        if (j2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.i = timeUnit.toNanos(j2);
        return this;
    }

    public CacheBuilder<K, V> initialCapacity(int i2) {
        int i3 = this.b;
        boolean z = true;
        Preconditions.checkState(i3 == -1, "initial capacity was already set to %s", i3);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.b = i2;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j2) {
        long j3 = this.d;
        boolean z = true;
        Preconditions.checkState(j3 == -1, "maximum size was already set to %s", j3);
        long j4 = this.e;
        Preconditions.checkState(j4 == -1, "maximum weight was already set to %s", j4);
        Preconditions.checkState(this.f == null, "maximum size can not be combined with weigher");
        if (j2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "maximum size must not be negative");
        this.d = j2;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j2) {
        long j3 = this.e;
        boolean z = true;
        Preconditions.checkState(j3 == -1, "maximum weight was already set to %s", j3);
        long j4 = this.d;
        Preconditions.checkState(j4 == -1, "maximum size was already set to %s", j4);
        this.e = j2;
        if (j2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "maximum weight must not be negative");
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.p = s;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        long j3 = this.k;
        boolean z = true;
        Preconditions.checkState(j3 == -1, "refresh was already set to %s ns", j3);
        if (j2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration must be positive: %s %s", j2, timeUnit);
        this.k = timeUnit.toNanos(j2);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.checkState(this.n == null);
        this.n = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        c(a.t.SOFT);
        return this;
    }

    public CacheBuilder<K, V> ticker(Ticker ticker) {
        Preconditions.checkState(this.o == null);
        this.o = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i2 = this.b;
        if (i2 != -1) {
            stringHelper.add("initialCapacity", i2);
        }
        int i3 = this.c;
        if (i3 != -1) {
            stringHelper.add("concurrencyLevel", i3);
        }
        long j2 = this.d;
        if (j2 != -1) {
            stringHelper.add("maximumSize", j2);
        }
        long j3 = this.e;
        if (j3 != -1) {
            stringHelper.add("maximumWeight", j3);
        }
        if (this.i != -1) {
            stringHelper.add("expireAfterWrite", a2.b.a.a.a.l(new StringBuilder(), this.i, "ns"));
        }
        if (this.j != -1) {
            stringHelper.add("expireAfterAccess", a2.b.a.a.a.l(new StringBuilder(), this.j, "ns"));
        }
        a.t tVar = this.g;
        if (tVar != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(tVar.toString()));
        }
        a.t tVar2 = this.h;
        if (tVar2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(tVar2.toString()));
        }
        if (this.l != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.m != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.n != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        b(a.t.WEAK);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        c(a.t.WEAK);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        boolean z = true;
        Preconditions.checkState(this.f == null);
        if (this.a) {
            long j2 = this.d;
            if (j2 != -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher can not be combined with maximum size", j2);
        }
        this.f = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        a();
        Preconditions.checkState(this.k == -1, "refreshAfterWrite requires a LoadingCache");
        return new a.o(this);
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }
}
