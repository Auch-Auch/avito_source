package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public final class zzall {
    private final Object zzdho = new Object();
    private final Object zzdhp = new Object();
    @GuardedBy("lockClient")
    private zzalu zzdhq;
    @GuardedBy("lockService")
    private zzalu zzdhr;

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzalu zza(Context context, zzbbg zzbbg) {
        zzalu zzalu;
        synchronized (this.zzdhp) {
            if (this.zzdhr == null) {
                this.zzdhr = new zzalu(zzl(context), zzbbg, zzacw.zzdbs.get());
            }
            zzalu = this.zzdhr;
        }
        return zzalu;
    }

    public final zzalu zzb(Context context, zzbbg zzbbg) {
        zzalu zzalu;
        synchronized (this.zzdho) {
            if (this.zzdhq == null) {
                this.zzdhq = new zzalu(zzl(context), zzbbg, (String) zzwe.zzpu().zzd(zzaat.zzcli));
            }
            zzalu = this.zzdhq;
        }
        return zzalu;
    }
}
