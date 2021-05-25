package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
public final class zza implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int zza2 = zzb.zza(context, str, true);
        zza.zzb = zza2;
        if (zza2 != 0) {
            zza.zzc = 1;
        } else {
            int zza3 = zzb.zza(context, str);
            zza.zza = zza3;
            if (zza3 != 0) {
                zza.zzc = -1;
            }
        }
        return zza;
    }
}
