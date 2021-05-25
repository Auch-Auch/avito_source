package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
public final class zzfh extends zzfz<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    public zzfh(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zza) {
            this.zza = true;
            return (T) this.zzb;
        }
        throw new NoSuchElementException();
    }
}
