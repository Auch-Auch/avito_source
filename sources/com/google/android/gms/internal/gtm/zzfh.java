package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import java.util.Map;
public final class zzfh implements zzkl {
    private final /* synthetic */ zzff zzapd;

    private zzfh(zzff zzff) {
        this.zzapd = zzff;
    }

    @Override // com.google.android.gms.internal.gtm.zzkl
    public final Object zza(String str, Map<String, Object> map) {
        try {
            this.zzapd.zzanh.zzb(str, map);
            return null;
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzav(valueOf.length() != 0 ? "Error calling customEvaluator proxy:".concat(valueOf) : new String("Error calling customEvaluator proxy:"));
            return null;
        }
    }

    public /* synthetic */ zzfh(zzff zzff, zzfg zzfg) {
        this(zzff);
    }
}
