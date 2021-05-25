package com.google.android.gms.internal.gtm;

import java.util.Iterator;
public final class zzob implements Iterator<zzoa<?>> {
    private final /* synthetic */ Iterator zzaue;

    public zzob(zzoa zzoa, Iterator it) {
        this.zzaue = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzaue.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        return new zzom((String) this.zzaue.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzaue.remove();
    }
}
