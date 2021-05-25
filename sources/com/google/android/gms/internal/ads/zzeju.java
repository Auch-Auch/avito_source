package com.google.android.gms.internal.ads;

import java.util.Iterator;
public final class zzeju implements Iterator<String> {
    private final /* synthetic */ zzejs zzikj;
    private Iterator<String> zzilf;

    public zzeju(zzejs zzejs) {
        this.zzikj = zzejs;
        this.zzilf = zzejs.zzikk.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzilf.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzilf.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
