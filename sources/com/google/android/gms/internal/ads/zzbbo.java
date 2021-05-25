package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
public final class zzbbo implements zzdvi<Object> {
    private final /* synthetic */ String zzeed;

    public zzbbo(String str) {
        this.zzeed = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void onSuccess(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzp.zzkt().zzb(th, this.zzeed);
    }
}
