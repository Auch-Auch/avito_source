package com.google.android.gms.internal.ads;
public final class zzakt implements zzbbu<zzajx> {
    private final /* synthetic */ zzakk zzdgw;
    private final /* synthetic */ zzalb zzdha;

    public zzakt(zzakk zzakk, zzalb zzalb) {
        this.zzdgw = zzakk;
        this.zzdha = zzalb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbu
    public final /* synthetic */ void zzh(zzajx zzajx) {
        synchronized (zzakk.zza(this.zzdgw)) {
            zzakk.zza(this.zzdgw, 0);
            if (!(zzakk.zzb(this.zzdgw) == null || this.zzdha == zzakk.zzb(this.zzdgw))) {
                zzaxy.zzei("New JS engine is loaded, marking previous one as destroyable.");
                zzakk.zzb(this.zzdgw).zzti();
            }
            zzakk.zza(this.zzdgw, this.zzdha);
        }
    }
}
