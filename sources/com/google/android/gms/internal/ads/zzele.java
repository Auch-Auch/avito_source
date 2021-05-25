package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class zzele<E> extends AbstractList<E> {
    private static final zzelg zzdc = zzelg.zzn(zzele.class);
    public List<E> zziqo;
    public Iterator<E> zziqp;

    public zzele(List<E> list, Iterator<E> it) {
        this.zziqo = list;
        this.zziqp = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.zziqo.size() > i) {
            return this.zziqo.get(i);
        }
        if (this.zziqp.hasNext()) {
            this.zziqo.add(this.zziqp.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new zzeld(this);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        zzelg zzelg = zzdc;
        zzelg.zzik("potentially expensive size() call");
        zzelg.zzik("blowup running");
        while (this.zziqp.hasNext()) {
            this.zziqo.add(this.zziqp.next());
        }
        return this.zziqo.size();
    }
}
