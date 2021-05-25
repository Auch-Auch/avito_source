package com.google.common.collect;

import a2.j.d.c.f3;
import a2.j.d.c.i0;
import a2.j.d.c.s3;
import a2.j.d.c.t3;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    public static final ImmutableRangeMap<Comparable<?>, Object> c = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    public final transient ImmutableList<Range<K>> a;
    public final transient ImmutableList<V> b;

    public static final class Builder<K extends Comparable<?>, V> {
        public final List<Map.Entry<Range<K>, V>> a = Lists.newArrayList();

        public ImmutableRangeMap<K, V> build() {
            List<Map.Entry<Range<K>, V>> list = this.a;
            Range<Comparable> range = Range.c;
            Collections.sort(list, Range.b.a.a());
            ImmutableList.Builder builder = new ImmutableList.Builder(this.a.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(this.a.size());
            for (int i = 0; i < this.a.size(); i++) {
                Range<K> key = this.a.get(i).getKey();
                if (i > 0) {
                    Range<K> key2 = this.a.get(i - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                builder.add((ImmutableList.Builder) key);
                builder2.add((ImmutableList.Builder) this.a.get(i).getValue());
            }
            return new ImmutableRangeMap<>(builder.build(), builder2.build());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.a.add(Maps.immutableEntry(range, v));
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableRangeMap$Builder<K extends java.lang.Comparable<?>, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public class a extends ImmutableList<Range<K>> {
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Range e;

        public a(int i, int i2, Range range) {
            this.c = i;
            this.d = i2;
            this.e = range;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.c);
            if (i == 0 || i == this.c - 1) {
                return ImmutableRangeMap.this.a.get(i + this.d).intersection(this.e);
            }
            return ImmutableRangeMap.this.a.get(i + this.d);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c;
        }
    }

    public class b extends ImmutableRangeMap<K, V> {
        public final /* synthetic */ Range d;
        public final /* synthetic */ ImmutableRangeMap e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
            super(immutableList, immutableList2);
            this.d = range;
            this.e = immutableRangeMap2;
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
            return ImmutableRangeMap.super.asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return ImmutableRangeMap.super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
        public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
            if (this.d.isConnected(range)) {
                return this.e.subRangeMap((Range) range.intersection(this.d));
            }
            return ImmutableRangeMap.of();
        }
    }

    public static class c<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableMap<Range<K>, V> a;

        public c(ImmutableMap<Range<K>, V> immutableMap) {
            this.a = immutableMap;
        }

        public Object readResolve() {
            if (this.a.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            Builder builder = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> it = this.a.entrySet().mo99iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                builder.put(next.getKey(), next.getValue());
            }
            return builder.build();
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.a = immutableList;
        this.b = immutableList2;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        ImmutableList.Builder builder = new ImmutableList.Builder(asMapOfRanges.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            builder.add((ImmutableList.Builder) entry.getKey());
            builder2.add((ImmutableList.Builder) entry.getValue());
        }
        return new ImmutableRangeMap<>(builder.build(), builder2.build());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) c;
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public V get(K k) {
        ImmutableList<Range<K>> immutableList = this.a;
        Range<Comparable> range = Range.c;
        int n = AppCompatDelegateImpl.i.n(immutableList, Range.a.a, new i0.d(k), t3.ANY_PRESENT, s3.NEXT_LOWER);
        if (n != -1 && this.a.get(n).contains(k)) {
            return this.b.get(n);
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    @NullableDecl
    public Map.Entry<Range<K>, V> getEntry(K k) {
        ImmutableList<Range<K>> immutableList = this.a;
        Range<Comparable> range = Range.c;
        int n = AppCompatDelegateImpl.i.n(immutableList, Range.a.a, new i0.d(k), t3.ANY_PRESENT, s3.NEXT_LOWER);
        if (n == -1) {
            return null;
        }
        Range<K> range2 = this.a.get(n);
        if (range2.contains(k)) {
            return Maps.immutableEntry(range2, this.b.get(n));
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        if (!this.a.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.a;
            return new Range<>(this.a.get(0).a, immutableList.get(immutableList.size() - 1).b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap, java.lang.Object
    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new c(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.a.isEmpty()) {
            return ImmutableMap.of();
        }
        ImmutableList<Range<K>> reverse = this.a.reverse();
        Range<Comparable> range = Range.c;
        return new ImmutableSortedMap(new f3(reverse, Range.b.a.reverse()), this.b.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.a.isEmpty()) {
            return ImmutableMap.of();
        }
        ImmutableList<Range<K>> immutableList = this.a;
        Range<Comparable> range = Range.c;
        return new ImmutableSortedMap(new f3(immutableList, Range.b.a), this.b);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
        if (((Range) Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.a.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.a;
        Range<Comparable> range2 = Range.c;
        Range.c cVar = Range.c.a;
        i0<C> i0Var = range.a;
        t3 t3Var = t3.FIRST_AFTER;
        s3 s3Var = s3.NEXT_HIGHER;
        int n = AppCompatDelegateImpl.i.n(immutableList, cVar, i0Var, t3Var, s3Var);
        int n2 = AppCompatDelegateImpl.i.n(this.a, Range.a.a, range.b, t3.ANY_PRESENT, s3Var);
        if (n >= n2) {
            return of();
        }
        return new b(this, new a(n2 - n, n, range), this.b.subList(n, n2), range, this);
    }
}
