package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
public abstract class zzgi<E> extends AbstractList<E> implements zzik<E> {
    private boolean zztf = true;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        zzek();
        return super.add(e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        zzek();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        zzek();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        zzek();
        return (E) super.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        zzek();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzek();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        zzek();
        return (E) super.set(i, e);
    }

    @Override // com.google.android.gms.internal.vision.zzik
    public boolean zzei() {
        return this.zztf;
    }

    @Override // com.google.android.gms.internal.vision.zzik
    public final void zzej() {
        this.zztf = false;
    }

    public final void zzek() {
        if (!this.zztf) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        zzek();
        super.add(i, e);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzek();
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        zzek();
        return super.remove(obj);
    }
}
