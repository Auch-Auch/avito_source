package com.google.android.gms.internal.measurement;
public final class zznp implements zznq {
    private static final zzcw<Boolean> zza = new zzdf(zzcx.zza("com.google.android.gms.measurement")).zza("measurement.service.use_appinfo_modified", false);

    @Override // com.google.android.gms.internal.measurement.zznq
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznq
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
