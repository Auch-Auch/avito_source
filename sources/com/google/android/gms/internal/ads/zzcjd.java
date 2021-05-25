package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public final class zzcjd {
    @GuardedBy("this")
    private final Map<String, zzcje> zzgdt = new HashMap();

    public final synchronized void zza(String str, zzdlx zzdlx) {
        if (!this.zzgdt.containsKey(str)) {
            try {
                this.zzgdt.put(str, new zzcje(str, zzdlx.zztw(), zzdlx.zztx()));
            } catch (zzdlr unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzcje zzgg(String str) {
        return this.zzgdt.get(str);
    }

    public final synchronized void zza(String str, zzapa zzapa) {
        if (!this.zzgdt.containsKey(str)) {
            try {
                this.zzgdt.put(str, new zzcje(str, zzapa.zztw(), zzapa.zztx()));
            } catch (Throwable unused) {
            }
        }
    }
}
