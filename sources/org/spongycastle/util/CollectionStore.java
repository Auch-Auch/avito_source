package org.spongycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class CollectionStore<T> implements Store<T>, Iterable<T> {
    public Collection<T> a;

    public CollectionStore(Collection<T> collection) {
        this.a = new ArrayList(collection);
    }

    @Override // org.spongycastle.util.Store
    public Collection<T> getMatches(Selector<T> selector) {
        if (selector == null) {
            return new ArrayList(this.a);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : this.a) {
            if (selector.match(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // org.spongycastle.util.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        return getMatches(null).iterator();
    }
}
