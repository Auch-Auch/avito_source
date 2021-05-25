package a2.j.d.c;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class v4<K, V> extends n4<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> h;

    public v4(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
        super(setMultimap, obj);
    }

    /* renamed from: e */
    public SetMultimap<K, V> d() {
        return (SetMultimap) ((Multimap) this.a);
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        Set<Map.Entry<K, V>> set;
        synchronized (this.b) {
            if (this.h == null) {
                this.h = new u4(d().entries(), this.b);
            }
            set = this.h;
        }
        return set;
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Set<V> mo118get(K k) {
        u4 u4Var;
        synchronized (this.b) {
            u4Var = new u4(d().mo118get((SetMultimap<K, V>) k), this.b);
        }
        return u4Var;
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Set<V> mo119removeAll(Object obj) {
        Set<V> removeAll;
        synchronized (this.b) {
            removeAll = d().mo119removeAll(obj);
        }
        return removeAll;
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public Set<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        Set<V> replaceValues;
        synchronized (this.b) {
            replaceValues = d().mo120replaceValues((SetMultimap<K, V>) k, (Iterable) iterable);
        }
        return replaceValues;
    }
}
