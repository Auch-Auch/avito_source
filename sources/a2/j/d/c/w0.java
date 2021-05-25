package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class w0<K, V> extends x0<K, V> implements ListMultimap<K, V> {
    public w0(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    @Override // a2.j.d.c.x0, a2.j.d.c.z0
    /* renamed from: a */
    public Multimap mo31a() {
        return (ListMultimap) this.f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection mo118get(Object obj) {
        return (List) super.mo118get((w0<K, V>) obj);
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection mo119removeAll(@NullableDecl Object obj) {
        return (List) super.mo119removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public Collection mo120replaceValues(Object obj, Iterable iterable) {
        return (List) super.mo120replaceValues((w0<K, V>) obj, iterable);
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get  reason: collision with other method in class */
    public List<V> mo118get(K k) {
        return (List) super.mo118get((w0<K, V>) k);
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll  reason: collision with other method in class */
    public List<V> mo119removeAll(@NullableDecl Object obj) {
        return (List) super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues  reason: collision with other method in class */
    public List<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.mo120replaceValues((w0<K, V>) k, (Iterable) iterable);
    }
}
