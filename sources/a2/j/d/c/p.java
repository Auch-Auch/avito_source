package a2.j.d.c;

import a2.j.d.c.e;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class p<K, V> extends l<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public p(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e
    public Collection t(Collection collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e
    public Collection<V> u(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new e.m(k, (NavigableSet) collection, null);
        }
        return new e.o(k, (SortedSet) collection, null);
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public abstract SortedSet<V> x();

    /* renamed from: y */
    public SortedSet<V> w() {
        SortedSet<V> x = x();
        if (x instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) x);
        }
        return Collections.unmodifiableSortedSet(x);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public SortedSet<V> mo118get(@NullableDecl K k) {
        return (SortedSet) super.mo118get((p<K, V>) k);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public SortedSet<V> mo119removeAll(@NullableDecl Object obj) {
        return (SortedSet) super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.l, a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public SortedSet<V> mo120replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.mo120replaceValues((p<K, V>) k, (Iterable) iterable);
    }
}
