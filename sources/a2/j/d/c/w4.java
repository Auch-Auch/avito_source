package a2.j.d.c;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class w4<K, V> extends m4<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 0;

    public w4(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
        super(sortedMap, obj);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        Comparator<? super K> comparator;
        synchronized (this.b) {
            comparator = d().comparator();
        }
        return comparator;
    }

    /* renamed from: e */
    public SortedMap<K, V> d() {
        return (SortedMap) ((Map) this.a);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        K firstKey;
        synchronized (this.b) {
            firstKey = d().firstKey();
        }
        return firstKey;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k) {
        w4 w4Var;
        synchronized (this.b) {
            w4Var = new w4(d().headMap(k), this.b);
        }
        return w4Var;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        K lastKey;
        synchronized (this.b) {
            lastKey = d().lastKey();
        }
        return lastKey;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k, K k2) {
        w4 w4Var;
        synchronized (this.b) {
            w4Var = new w4(d().subMap(k, k2), this.b);
        }
        return w4Var;
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k) {
        w4 w4Var;
        synchronized (this.b) {
            w4Var = new w4(d().tailMap(k), this.b);
        }
        return w4Var;
    }
}
