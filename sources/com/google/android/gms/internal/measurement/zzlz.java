package com.google.android.gms.internal.measurement;
public final class zzlz implements zzma {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Long> zzb;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.attribution.cache", true);
        zzb = zzdf.zza("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // com.google.android.gms.internal.measurement.zzma
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzma
    public final long zzb() {
        return zzb.zzc().longValue();
    }
}
