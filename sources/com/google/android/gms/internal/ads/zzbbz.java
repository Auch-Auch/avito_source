package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzbbz implements zzdvi<T> {
    private final /* synthetic */ zzbbu zzeej;
    private final /* synthetic */ zzbbs zzeek;

    public zzbbz(zzbbx zzbbx, zzbbu zzbbu, zzbbs zzbbs) {
        this.zzeej = zzbbu;
        this.zzeek = zzbbs;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void onSuccess(@Nullable T t) {
        this.zzeej.zzh(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzeek.run();
    }
}
