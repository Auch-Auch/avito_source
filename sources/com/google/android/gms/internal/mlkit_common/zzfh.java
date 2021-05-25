package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class zzfh {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzfh zzc;
    private static final zzfh zzd = new zzfh(true);
    private final Map<Object, Object> zze;

    public zzfh() {
        this.zze = new HashMap();
    }

    public static zzfh zza() {
        zzfh zzfh = zzc;
        if (zzfh == null) {
            synchronized (zzfh.class) {
                zzfh = zzc;
                if (zzfh == null) {
                    zzfh = zzd;
                    zzc = zzfh;
                }
            }
        }
        return zzfh;
    }

    private zzfh(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
