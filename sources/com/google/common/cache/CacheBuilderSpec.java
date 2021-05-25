package com.google.common.cache;

import a2.j.d.b.a;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class CacheBuilderSpec {
    public static final Splitter o = Splitter.on(',').trimResults();
    public static final Splitter p = Splitter.on('=').trimResults();
    public static final ImmutableMap<String, l> q;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public Integer a;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public Long b;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public Long c;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public Integer d;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public a.t e;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public a.t f;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public Boolean g;
    @VisibleForTesting
    public long h;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public TimeUnit i;
    @VisibleForTesting
    public long j;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public TimeUnit k;
    @VisibleForTesting
    public long l;
    @VisibleForTesting
    @MonotonicNonNullDecl
    public TimeUnit m;
    public final String n;

    public static class a extends c {
        @Override // com.google.common.cache.CacheBuilderSpec.c
        public void b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.k == null, "expireAfterAccess already set");
            cacheBuilderSpec.j = j;
            cacheBuilderSpec.k = timeUnit;
        }
    }

    public static class b extends e {
        @Override // com.google.common.cache.CacheBuilderSpec.e
        public void b(CacheBuilderSpec cacheBuilderSpec, int i) {
            Integer num = cacheBuilderSpec.d;
            Preconditions.checkArgument(num == null, "concurrency level was already set to ", num);
            cacheBuilderSpec.d = Integer.valueOf(i);
        }
    }

    public static abstract class c implements l {
        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            TimeUnit timeUnit;
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", str);
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else if (charAt == 's') {
                    timeUnit = TimeUnit.SECONDS;
                } else {
                    throw new IllegalArgumentException(CacheBuilderSpec.a("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[]{str, str2}));
                }
                b(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.a("key %s value set to %s, must be integer", new Object[]{str, str2}));
            }
        }

        public abstract void b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);
    }

    public static class d extends e {
        @Override // com.google.common.cache.CacheBuilderSpec.e
        public void b(CacheBuilderSpec cacheBuilderSpec, int i) {
            Integer num = cacheBuilderSpec.a;
            Preconditions.checkArgument(num == null, "initial capacity was already set to ", num);
            cacheBuilderSpec.a = Integer.valueOf(i);
        }
    }

    public static abstract class e implements l {
        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", str);
            try {
                b(cacheBuilderSpec, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.a("key %s value set to %s, must be integer", new Object[]{str, str2}), e);
            }
        }

        public abstract void b(CacheBuilderSpec cacheBuilderSpec, int i);
    }

    public static class f implements l {
        public f(a.t tVar) {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z = false;
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            a.t tVar = cacheBuilderSpec.e;
            if (tVar == null) {
                z = true;
            }
            Preconditions.checkArgument(z, "%s was already set to %s", str, tVar);
            cacheBuilderSpec.e = a.t.WEAK;
        }
    }

    public static abstract class g implements l {
        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", str);
            try {
                b(cacheBuilderSpec, Long.parseLong(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.a("key %s value set to %s, must be integer", new Object[]{str, str2}), e);
            }
        }

        public abstract void b(CacheBuilderSpec cacheBuilderSpec, long j);
    }

    public static class h extends g {
        @Override // com.google.common.cache.CacheBuilderSpec.g
        public void b(CacheBuilderSpec cacheBuilderSpec, long j) {
            Long l = cacheBuilderSpec.b;
            boolean z = true;
            Preconditions.checkArgument(l == null, "maximum size was already set to ", l);
            Long l2 = cacheBuilderSpec.c;
            if (l2 != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum weight was already set to ", l2);
            cacheBuilderSpec.b = Long.valueOf(j);
        }
    }

    public static class i extends g {
        @Override // com.google.common.cache.CacheBuilderSpec.g
        public void b(CacheBuilderSpec cacheBuilderSpec, long j) {
            Long l = cacheBuilderSpec.c;
            boolean z = true;
            Preconditions.checkArgument(l == null, "maximum weight was already set to ", l);
            Long l2 = cacheBuilderSpec.b;
            if (l2 != null) {
                z = false;
            }
            Preconditions.checkArgument(z, "maximum size was already set to ", l2);
            cacheBuilderSpec.c = Long.valueOf(j);
        }
    }

    public static class j implements l {
        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z = false;
            Preconditions.checkArgument(str2 == null, "recordStats does not take values");
            if (cacheBuilderSpec.g == null) {
                z = true;
            }
            Preconditions.checkArgument(z, "recordStats already set");
            cacheBuilderSpec.g = Boolean.TRUE;
        }
    }

    public static class k extends c {
        @Override // com.google.common.cache.CacheBuilderSpec.c
        public void b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.m == null, "refreshAfterWrite already set");
            cacheBuilderSpec.l = j;
            cacheBuilderSpec.m = timeUnit;
        }
    }

    public interface l {
        void a(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2);
    }

    public static class m implements l {
        public final a.t a;

        public m(a.t tVar) {
            this.a = tVar;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.l
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            boolean z = false;
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            a.t tVar = cacheBuilderSpec.f;
            if (tVar == null) {
                z = true;
            }
            Preconditions.checkArgument(z, "%s was already set to %s", str, tVar);
            cacheBuilderSpec.f = this.a;
        }
    }

    public static class n extends c {
        @Override // com.google.common.cache.CacheBuilderSpec.c
        public void b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.i == null, "expireAfterWrite already set");
            cacheBuilderSpec.h = j;
            cacheBuilderSpec.i = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder put = ImmutableMap.builder().put("initialCapacity", new d()).put("maximumSize", new h()).put("maximumWeight", new i()).put("concurrencyLevel", new b());
        a.t tVar = a.t.WEAK;
        q = put.put("weakKeys", new f(tVar)).put("softValues", new m(a.t.SOFT)).put("weakValues", new m(tVar)).put("recordStats", new j()).put("expireAfterAccess", new a()).put("expireAfterWrite", new n()).put("refreshAfterWrite", new k()).put("refreshInterval", new k()).build();
    }

    public CacheBuilderSpec(String str) {
        this.n = str;
    }

    public static String a(String str, Object[] objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @NullableDecl
    public static Long b(long j2, @NullableDecl TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j2));
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    public static CacheBuilderSpec parse(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str2 : o.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(p.split(str2));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                boolean z = false;
                Preconditions.checkArgument(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) copyOf.get(0);
                l lVar = q.get(str3);
                if (lVar != null) {
                    z = true;
                }
                Preconditions.checkArgument(z, "unknown key %s", str3);
                lVar.a(cacheBuilderSpec, str3, copyOf.size() == 1 ? null : (String) copyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        if (!Objects.equal(this.a, cacheBuilderSpec.a) || !Objects.equal(this.b, cacheBuilderSpec.b) || !Objects.equal(this.c, cacheBuilderSpec.c) || !Objects.equal(this.d, cacheBuilderSpec.d) || !Objects.equal(this.e, cacheBuilderSpec.e) || !Objects.equal(this.f, cacheBuilderSpec.f) || !Objects.equal(this.g, cacheBuilderSpec.g) || !Objects.equal(b(this.h, this.i), b(cacheBuilderSpec.h, cacheBuilderSpec.i)) || !Objects.equal(b(this.j, this.k), b(cacheBuilderSpec.j, cacheBuilderSpec.k)) || !Objects.equal(b(this.l, this.m), b(cacheBuilderSpec.l, cacheBuilderSpec.m))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, this.d, this.e, this.f, this.g, b(this.h, this.i), b(this.j, this.k), b(this.l, this.m));
    }

    public String toParsableString() {
        return this.n;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
