package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class y0<K, V> extends x0<K, V> implements b1<K, V> {

    public class a extends x0<K, V>.c implements Set<Map.Entry<K, V>> {
        public a(y0 y0Var) {
            super();
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    public y0(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    @Override // a2.j.d.c.x0, a2.j.d.c.z0
    /* renamed from: a */
    public Multimap mo31a() {
        return (SetMultimap) this.f;
    }

    @Override // a2.j.d.c.x0, a2.j.d.c.h
    public Collection d() {
        return new a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection mo118get(Object obj) {
        return (Set) super.mo118get((y0<K, V>) obj);
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection mo119removeAll(Object obj) {
        return (Set) super.mo119removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public Collection mo120replaceValues(Object obj, Iterable iterable) {
        return (Set) super.mo120replaceValues((y0<K, V>) obj, iterable);
    }

    @Override // a2.j.d.c.x0, a2.j.d.c.z0
    /* renamed from: a  reason: collision with other method in class */
    public SetMultimap<K, V> mo31a() {
        return (SetMultimap) this.f;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get  reason: collision with other method in class */
    public Set<V> mo118get(K k) {
        return (Set) super.mo118get((y0<K, V>) k);
    }

    @Override // a2.j.d.c.x0, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll  reason: collision with other method in class */
    public Set<V> mo119removeAll(Object obj) {
        return (Set) super.mo119removeAll(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues  reason: collision with other method in class */
    public Set<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.mo120replaceValues((y0<K, V>) k, (Iterable) iterable);
    }
}
