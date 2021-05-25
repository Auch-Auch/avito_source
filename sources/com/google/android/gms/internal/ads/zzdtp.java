package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
public final class zzdtp extends zzdub<T> {
    private boolean zzhnk;
    private final /* synthetic */ Object zzhnl;

    public zzdtp(Object obj) {
        this.zzhnl = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzhnk;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zzhnk) {
            this.zzhnk = true;
            return (T) this.zzhnl;
        }
        throw new NoSuchElementException();
    }
}
