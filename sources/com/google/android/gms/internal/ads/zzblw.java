package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzblw implements zzahf<Object> {
    public final /* synthetic */ zzblr zzfmb;

    public zzblw(zzblr zzblr) {
        this.zzfmb = zzblr;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfmb.zzm(map)) {
            this.zzfmb.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzblv
                private final zzblw zzfmc;

                {
                    this.zzfmc = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfmc.zzfmb.zzflr.zzaha();
                }
            });
        }
    }
}
