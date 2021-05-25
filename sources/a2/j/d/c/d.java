package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ListMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class d<K, V> extends e<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    public d(Map<K, Collection<V>> map) {
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
    public Collection r() {
        return Collections.emptyList();
    }

    @Override // a2.j.d.c.e
    public <E> Collection<E> t(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // a2.j.d.c.e
    public Collection<V> u(K k, Collection<V> collection) {
        return v(k, (List) collection, null);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public List<V> mo118get(@NullableDecl K k) {
        return (List) super.mo118get((d<K, V>) k);
    }

    @Override // a2.j.d.c.e, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public List<V> mo119removeAll(@NullableDecl Object obj) {
        return (List) super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.e, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public List<V> mo120replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (List) super.mo120replaceValues((d<K, V>) k, (Iterable) iterable);
    }
}
