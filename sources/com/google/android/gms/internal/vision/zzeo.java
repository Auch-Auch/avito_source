package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;
public final class zzeo extends zzfa<T> {
    private boolean zzni;
    private final /* synthetic */ Object zznj;

    public zzeo(Object obj) {
        this.zznj = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzni;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zzni) {
            this.zzni = true;
            return (T) this.zznj;
        }
        throw new NoSuchElementException();
    }
}
