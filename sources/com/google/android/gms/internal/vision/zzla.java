package com.google.android.gms.internal.vision;

import java.util.Iterator;
public final class zzla implements Iterator<String> {
    private Iterator<String> zzacf;
    private final /* synthetic */ zzky zzacg;

    public zzla(zzky zzky) {
        this.zzacg = zzky;
        this.zzacf = zzky.zzace.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzacf.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzacf.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
