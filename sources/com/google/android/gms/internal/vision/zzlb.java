package com.google.android.gms.internal.vision;

import java.util.ListIterator;
public final class zzlb implements ListIterator<String> {
    private final /* synthetic */ zzky zzacg;
    private ListIterator<String> zzach;
    private final /* synthetic */ int zzaci;

    public zzlb(zzky zzky, int i) {
        this.zzacg = zzky;
        this.zzaci = i;
        this.zzach = zzky.zzace.listIterator(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzach.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzach.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzach.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzach.nextIndex();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzach.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzach.previousIndex();
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
