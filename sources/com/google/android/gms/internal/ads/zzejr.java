package com.google.android.gms.internal.ads;

import java.util.ListIterator;
public final class zzejr implements ListIterator<String> {
    private final /* synthetic */ int zzhoy;
    private ListIterator<String> zziki;
    private final /* synthetic */ zzejs zzikj;

    public zzejr(zzejs zzejs, int i) {
        this.zzikj = zzejs;
        this.zzhoy = i;
        this.zziki = zzejs.zzikk.listIterator(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zziki.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zziki.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zziki.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zziki.nextIndex();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zziki.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zziki.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
