package com.google.android.gms.internal.measurement;
public final class zzmx implements zzmy {
    private static final zzcw<Boolean> zza = new zzdf(zzcx.zza("com.google.android.gms.measurement")).zza("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzmy
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmy
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
