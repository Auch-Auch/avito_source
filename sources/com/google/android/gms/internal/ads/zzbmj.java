package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbmj implements zzqu {
    private final Clock zzbpw;
    private boolean zzbvt = false;
    private zzbfq zzdgc;
    private final zzbly zzfmh;
    private final Executor zzfmk;
    private zzbmc zzfmm = new zzbmc();
    private boolean zzfnf = false;

    public zzbmj(Executor executor, zzbly zzbly, Clock clock) {
        this.zzfmk = executor;
        this.zzfmh = zzbly;
        this.zzbpw = clock;
    }

    private final void zzahb() {
        try {
            JSONObject zza = this.zzfmh.zzj(this.zzfmm);
            if (this.zzdgc != null) {
                this.zzfmk.execute(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.zzbmm
                    private final JSONObject zzfmf;
                    private final zzbmj zzfng;

                    {
                        this.zzfng = r1;
                        this.zzfmf = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzfng.zzi(this.zzfmf);
                    }
                });
            }
        } catch (JSONException e) {
            zzaxy.zza("Failed to call video active view js", e);
        }
    }

    public final void disable() {
        this.zzbvt = false;
    }

    public final void enable() {
        this.zzbvt = true;
        zzahb();
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqr) {
        zzbmc zzbmc = this.zzfmm;
        zzbmc.zzbrk = this.zzfnf ? false : zzqr.zzbrk;
        zzbmc.timestamp = this.zzbpw.elapsedRealtime();
        this.zzfmm.zzfmw = zzqr;
        if (this.zzbvt) {
            zzahb();
        }
    }

    public final void zzbf(boolean z) {
        this.zzfnf = z;
    }

    public final void zzg(zzbfq zzbfq) {
        this.zzdgc = zzbfq;
    }

    public final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdgc.zza("AFMA_updateActiveView", jSONObject);
    }
}
