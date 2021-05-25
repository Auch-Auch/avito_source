package com.google.android.gms.internal.mlkit_vision_face;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public abstract class zzai<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzaf zzd;

    private zzai(zzaf zzaf) {
        this.zzd = zzaf;
        this.zza = zzaf.zzf;
        this.zzb = zzaf.zzd();
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (hasNext()) {
            int i = this.zzb;
            this.zzc = i;
            T zza2 = zza(i);
            this.zzb = this.zzd.zza(this.zzb);
            return zza2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        zza();
        zzj.zza(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzaf zzaf = this.zzd;
        zzaf.remove(zzaf.zzb[this.zzc]);
        this.zzb = zzaf.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    public abstract T zza(int i);

    public /* synthetic */ zzai(zzaf zzaf, zzae zzae) {
        this(zzaf);
    }
}
