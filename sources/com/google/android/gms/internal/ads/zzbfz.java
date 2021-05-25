package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
public final class zzbfz implements zzo {
    @Nullable
    private zzo zzdor;
    private zzbfq zzemr;

    public zzbfz(zzbfq zzbfq, @Nullable zzo zzo) {
        this.zzemr = zzbfq;
        this.zzdor = zzo;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.zzui();
        }
        this.zzemr.zzaax();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.zzuj();
        }
        this.zzemr.zzuv();
    }
}
