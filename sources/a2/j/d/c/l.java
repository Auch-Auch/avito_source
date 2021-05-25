package a2.j.d.c;

import a2.j.d.c.e;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.SetMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class l<K, V> extends e<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public l(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        return super.put(k, v);
    }

    @Override // a2.j.d.c.e
    public <E> Collection<E> t(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // a2.j.d.c.e
    public Collection<V> u(K k, Collection<V> collection) {
        return new e.n(k, (Set) collection);
    }

    /* renamed from: w */
    public Set<V> r() {
        return Collections.emptySet();
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Set<V> mo118get(@NullableDecl K k) {
        return (Set) super.mo118get((l<K, V>) k);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public Set<V> mo119removeAll(@NullableDecl Object obj) {
        return (Set) super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public Set<V> mo120replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (Set) super.mo120replaceValues((l<K, V>) k, (Iterable) iterable);
    }
}
