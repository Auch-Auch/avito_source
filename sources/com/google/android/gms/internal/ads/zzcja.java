package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
public final class zzcja implements zzbtp {
    @Nullable
    private final zzbfq zzdgc;

    public zzcja(@Nullable zzbfq zzbfq) {
        this.zzdgc = !((Boolean) zzwe.zzpu().zzd(zzaat.zzcnx)).booleanValue() ? null : zzbfq;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzbz(@Nullable Context context) {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            zzbfq.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzca(@Nullable Context context) {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            zzbfq.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcb(@Nullable Context context) {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            zzbfq.destroy();
        }
    }
}
