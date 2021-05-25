package p6.b;

import java.util.AbstractList;
import java.util.RandomAccess;
public final class b<T> extends AbstractList<T> implements RandomAccess {
    public final T[] a;

    public b(T[] tArr) {
        this.a = tArr;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        for (T t : this.a) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a.length;
    }
}
