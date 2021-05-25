package a2.j.d.c;

import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class y4<K, V> extends v4<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;

    public y4(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
        super(sortedSetMultimap, obj);
    }

    /* renamed from: f */
    public SortedSetMultimap<K, V> e() {
        return (SortedSetMultimap) super.d();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public Comparator<? super V> valueComparator() {
        Comparator<? super V> valueComparator;
        synchronized (this.b) {
            valueComparator = e().valueComparator();
        }
        return valueComparator;
    }

    @Override // a2.j.d.c.v4, a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public SortedSet<V> mo118get(K k) {
        x4 x4Var;
        synchronized (this.b) {
            x4Var = new x4(e().mo118get((SortedSetMultimap<K, V>) k), this.b);
        }
        return x4Var;
    }

    @Override // a2.j.d.c.v4, a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public SortedSet<V> mo119removeAll(Object obj) {
        SortedSet<V> removeAll;
        synchronized (this.b) {
            removeAll = e().mo119removeAll(obj);
        }
        return removeAll;
    }

    @Override // a2.j.d.c.v4, a2.j.d.c.n4, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public SortedSet<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        SortedSet<V> replaceValues;
        synchronized (this.b) {
            replaceValues = e().mo120replaceValues((SortedSetMultimap<K, V>) k, (Iterable) iterable);
        }
        return replaceValues;
    }
}
