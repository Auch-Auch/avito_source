package com.google.android.gms.internal.ads;
public final class zzdti<E> extends zzdtb<E> {
    private final zzdtg<E> zzhnc;

    public zzdti(zzdtg<E> zzdtg, int i) {
        super(zzdtg.size(), i);
        this.zzhnc = zzdtg;
    }

    @Override // com.google.android.gms.internal.ads.zzdtb
    public final E get(int i) {
        return this.zzhnc.get(i);
    }
}
