package com.google.android.gms.internal.ads;
public final class zzajp extends zzbhv {
    private final /* synthetic */ zzajj zzdfu;

    private zzajp(zzajj zzajj) {
        this.zzdfu = zzajj;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(zzbhu zzbhu) {
        if (zzajj.zza(this.zzdfu) != null) {
            zzajj.zza(this.zzdfu).zzte();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzb(zzbhu zzbhu) {
        this.zzdfu.zzg(zzbhu.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final boolean zzc(zzbhu zzbhu) {
        return this.zzdfu.zzg(zzbhu.uri);
    }
}
