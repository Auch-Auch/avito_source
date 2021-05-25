package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
public final class zzbll implements zzbtp {
    private final zzdlx zzfle;

    public zzbll(zzdlx zzdlx) {
        this.zzfle = zzdlx;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzbz(@Nullable Context context) {
        try {
            this.zzfle.pause();
        } catch (zzdlr e) {
            zzbbd.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzca(@Nullable Context context) {
        try {
            this.zzfle.resume();
            if (context != null) {
                this.zzfle.onContextChanged(context);
            }
        } catch (zzdlr e) {
            zzbbd.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcb(@Nullable Context context) {
        try {
            this.zzfle.destroy();
        } catch (zzdlr e) {
            zzbbd.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
