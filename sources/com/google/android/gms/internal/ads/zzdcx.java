package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Set;
import java.util.concurrent.Callable;
public final class zzdcx implements zzden<zzdcu> {
    private final zzdvw zzgse;
    private final Set<String> zzgss;
    private final Context zzvr;

    public zzdcx(zzdvw zzdvw, Context context, Set<String> set) {
        this.zzgse = zzdvw;
        this.zzvr = context;
        this.zzgss = set;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdcu> zzaqs() {
        return this.zzgse.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcw
            private final zzdcx zzguf;

            {
                this.zzguf = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguf.zzarb();
            }
        });
    }

    public final /* synthetic */ zzdcu zzarb() throws Exception {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue() || !zzdcu.zzf(this.zzgss)) {
            return new zzdcu(null);
        }
        return new zzdcu(zzp.zzle().getVersion(this.zzvr));
    }
}
