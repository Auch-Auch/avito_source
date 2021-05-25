package com.google.android.gms.internal.gtm;

import java.util.Iterator;
public final class zzoj implements Iterator<zzoa<?>> {
    private final /* synthetic */ Iterator zzaur;
    private final /* synthetic */ Iterator zzaus;

    public zzoj(zzoh zzoh, Iterator it, Iterator it2) {
        this.zzaur = it;
        this.zzaus = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzaur.hasNext() || this.zzaus.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        if (this.zzaur.hasNext()) {
            return (zzoa) this.zzaur.next();
        }
        return (zzoa) this.zzaus.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
