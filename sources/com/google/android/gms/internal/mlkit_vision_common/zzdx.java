package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class zzdx {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzdx zzc;
    private static final zzdx zzd = new zzdx(true);
    private final Map<Object, Object> zze;

    public zzdx() {
        this.zze = new HashMap();
    }

    public static zzdx zza() {
        zzdx zzdx = zzc;
        if (zzdx == null) {
            synchronized (zzdx.class) {
                zzdx = zzc;
                if (zzdx == null) {
                    zzdx = zzd;
                    zzc = zzdx;
                }
            }
        }
        return zzdx;
    }

    private zzdx(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
