package x6.c.b;

import java.util.AbstractList;
import java.util.List;
public final class b extends AbstractList<T> {
    public final /* synthetic */ List a;

    public b(List list) {
        this.a = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        List list = this.a;
        return (T) list.get((list.size() - i) - 1);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a.size();
    }
}
