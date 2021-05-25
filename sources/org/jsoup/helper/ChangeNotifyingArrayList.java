package org.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;
public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public ChangeNotifyingArrayList(int i) {
        super(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        onContentsChanged();
        return super.add(e);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public void clear() {
        onContentsChanged();
        super.clear();
    }

    public abstract void onContentsChanged();

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public E remove(int i) {
        onContentsChanged();
        return (E) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        onContentsChanged();
        return super.removeAll(collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int i, int i2) {
        onContentsChanged();
        super.removeRange(i, i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        onContentsChanged();
        return super.retainAll(collection);
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        onContentsChanged();
        return (E) super.set(i, e);
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        onContentsChanged();
        super.add(i, e);
    }

    @Override // java.util.ArrayList, java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(i, collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        onContentsChanged();
        return super.remove(obj);
    }
}
