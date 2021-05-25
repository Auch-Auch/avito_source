package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzblu implements zzahf<Object> {
    public final /* synthetic */ zzblr zzfmb;

    public zzblu(zzblr zzblr) {
        this.zzfmb = zzblr;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfmb.zzm(map)) {
            this.zzfmb.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzblt
                private final zzblu zzfma;

                {
                    this.zzfma = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfma.zzfmb.zzflr.zzagy();
                }
            });
        }
    }
}
