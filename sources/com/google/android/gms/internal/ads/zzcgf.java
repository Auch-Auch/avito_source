package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
public final class zzcgf {
    private final Executor zzfmk;
    private final zzbyr zzfvy;
    private final zzbmj zzgca;

    public zzcgf(Executor executor, zzbmj zzbmj, zzbyr zzbyr) {
        this.zzfmk = executor;
        this.zzfvy = zzbyr;
        this.zzgca = zzbmj;
    }

    public final /* synthetic */ void zzf(zzbfq zzbfq, Map map) {
        this.zzgca.disable();
    }

    public final /* synthetic */ void zzg(zzbfq zzbfq, Map map) {
        this.zzgca.enable();
    }

    public final void zzl(zzbfq zzbfq) {
        if (zzbfq != null) {
            this.zzfvy.zzv(zzbfq.getView());
            this.zzfvy.zza(new zzqu(zzbfq) { // from class: com.google.android.gms.internal.ads.zzcgi
                private final zzbfq zzepi;

                {
                    this.zzepi = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzqu
                public final void zza(zzqr zzqr) {
                    zzbhc zzabe = this.zzepi.zzabe();
                    Rect rect = zzqr.zzbrq;
                    zzabe.zza(rect.left, rect.top, false);
                }
            }, this.zzfmk);
            this.zzfvy.zza(new zzqu(zzbfq) { // from class: com.google.android.gms.internal.ads.zzcgh
                private final zzbfq zzepi;

                {
                    this.zzepi = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzqu
                public final void zza(zzqr zzqr) {
                    zzbfq zzbfq2 = this.zzepi;
                    HashMap hashMap = new HashMap();
                    hashMap.put("isVisible", zzqr.zzbrk ? "1" : "0");
                    zzbfq2.zza("onAdVisibilityChanged", hashMap);
                }
            }, this.zzfmk);
            this.zzfvy.zza(this.zzgca, this.zzfmk);
            this.zzgca.zzg(zzbfq);
            zzbfq.zza("/trackActiveViewUnit", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzcgk
                private final zzcgf zzgcb;

                {
                    this.zzgcb = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzahf
                public final void zza(Object obj, Map map) {
                    this.zzgcb.zzg((zzbfq) obj, map);
                }
            });
            zzbfq.zza("/untrackActiveViewUnit", new zzahf(this) { // from class: com.google.android.gms.internal.ads.zzcgj
                private final zzcgf zzgcb;

                {
                    this.zzgcb = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzahf
                public final void zza(Object obj, Map map) {
                    this.zzgcb.zzf((zzbfq) obj, map);
                }
            });
        }
    }
}
