package com.google.android.gms.internal.measurement;
public final class zzqc implements zzpz {
    private static final zzcw<Boolean> zza = new zzdf(zzcx.zza("com.google.android.gms.measurement")).zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzpz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpz
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
