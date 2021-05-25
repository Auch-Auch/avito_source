package a2.j.d.c;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class l4<K, V> extends n4<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 0;

    public l4(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
        super(listMultimap, obj);
    }

    /* renamed from: e */
    public ListMultimap<K, V> d() {
        return (ListMultimap) ((Multimap) this.a);
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public List<V> mo118get(K k) {
        List<V> t4Var;
        synchronized (this.b) {
            List<V> list = d().mo118get((ListMultimap<K, V>) k);
            Object obj = this.b;
            t4Var = list instanceof RandomAccess ? new t4<>(list, obj) : new k4<>(list, obj);
        }
        return t4Var;
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public List<V> mo119removeAll(Object obj) {
        List<V> removeAll;
        synchronized (this.b) {
            removeAll = d().mo119removeAll(obj);
        }
        return removeAll;
    }

    @Override // a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public List<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> replaceValues;
        synchronized (this.b) {
            replaceValues = d().mo120replaceValues((ListMultimap<K, V>) k, (Iterable) iterable);
        }
        return replaceValues;
    }
}
