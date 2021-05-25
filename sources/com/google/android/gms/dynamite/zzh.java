package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
public final class zzh implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zza = zzb.zza(context, str);
        int zza2 = zzb.zza(context, str, true);
        zza.zzb = zza2;
        int i = zza.zza;
        if (i == 0 && zza2 == 0) {
            zza.zzc = 0;
        } else if (zza2 >= i) {
            zza.zzc = 1;
        } else {
            zza.zzc = -1;
        }
        return zza;
    }
}
