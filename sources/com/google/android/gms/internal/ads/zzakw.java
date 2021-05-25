package com.google.android.gms.internal.ads;
public final class zzakw implements zzbbs {
    private final /* synthetic */ zzakk zzdgw;
    private final /* synthetic */ zzalb zzdha;

    public zzakw(zzakk zzakk, zzalb zzalb) {
        this.zzdgw = zzakk;
        this.zzdha = zzalb;
    }

    @Override // com.google.android.gms.internal.ads.zzbbs
    public final void run() {
        synchronized (zzakk.zza(this.zzdgw)) {
            zzakk.zza(this.zzdgw, 1);
            zzaxy.zzei("Failed loading new engine. Marking new engine destroyable.");
            this.zzdha.zzti();
        }
    }
}
