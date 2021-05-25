package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
public final class zzcap implements zzo {
    private final zzbur zzfvb;
    private final zzbyo zzfvc;

    public zzcap(zzbur zzbur, zzbyo zzbyo) {
        this.zzfvb = zzbur;
        this.zzfvc = zzbyo;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        this.zzfvb.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        this.zzfvb.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
        this.zzfvb.zzui();
        this.zzfvc.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
        this.zzfvb.zzuj();
        this.zzfvc.zzakg();
    }
}
