package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzbbw implements zzdvi<T> {
    private final /* synthetic */ zzbbx zzeeg;

    public zzbbw(zzbbx zzbbx) {
        this.zzeeg = zzbbx;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void onSuccess(@Nullable T t) {
        this.zzeeg.zzeei.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzeeg.zzeei.set(-1);
    }
}
