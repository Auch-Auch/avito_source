package com.google.android.gms.internal.ads;
public final class zzcbo implements zzelo<zzcdg> {
    private final zzcbj zzfvo;

    private zzcbo(zzcbj zzcbj) {
        this.zzfvo = zzcbj;
    }

    public static zzcbo zzd(zzcbj zzcbj) {
        return new zzcbo(zzcbj);
    }

    public static zzcdg zze(zzcbj zzcbj) {
        return (zzcdg) zzelu.zza(zzcbj.zzaku(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zze(this.zzfvo);
    }
}
