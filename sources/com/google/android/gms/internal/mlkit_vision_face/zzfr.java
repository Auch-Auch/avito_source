package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class zzfr {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzfr zzc;
    private static final zzfr zzd = new zzfr(true);
    private final Map<Object, Object> zze;

    public zzfr() {
        this.zze = new HashMap();
    }

    public static zzfr zza() {
        zzfr zzfr = zzc;
        if (zzfr == null) {
            synchronized (zzfr.class) {
                zzfr = zzc;
                if (zzfr == null) {
                    zzfr = zzd;
                    zzc = zzfr;
                }
            }
        }
        return zzfr;
    }

    private zzfr(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
