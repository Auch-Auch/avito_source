package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzou {
    private final Map<String, String> zzbjd = new HashMap();
    private Map<String, String> zzbje;

    public final synchronized Map<String, String> zzir() {
        if (this.zzbje == null) {
            this.zzbje = Collections.unmodifiableMap(new HashMap(this.zzbjd));
        }
        return this.zzbje;
    }
}
