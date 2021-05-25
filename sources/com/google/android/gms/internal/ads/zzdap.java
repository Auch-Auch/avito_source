package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
public final class zzdap implements zzden<Object> {
    private static final Object lock = new Object();
    private final String zzciq;
    private final String zzdpz;
    private final zzdln zzfqn;
    private final zzbqq zzgta;
    private final zzdmk zzgtb;

    public zzdap(String str, String str2, zzbqq zzbqq, zzdmk zzdmk, zzdln zzdln) {
        this.zzdpz = str;
        this.zzciq = str2;
        this.zzgta = zzbqq;
        this.zzgtb = zzdmk;
        this.zzfqn = zzdln;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<Object> zzaqs() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcur)).booleanValue()) {
            this.zzgta.zzf(this.zzfqn.zzhbu);
            bundle.putAll(this.zzgtb.zzatb());
        }
        return zzdvl.zzaf(new zzdek(this, bundle) { // from class: com.google.android.gms.internal.ads.zzdao
            private final Bundle zzdxf;
            private final zzdap zzgsz;

            {
                this.zzgsz = r1;
                this.zzdxf = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdek
            public final void zzs(Object obj) {
                this.zzgsz.zzb(this.zzdxf, (Bundle) obj);
            }
        });
    }

    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcur)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuq)).booleanValue()) {
                synchronized (lock) {
                    this.zzgta.zzf(this.zzfqn.zzhbu);
                    bundle2.putBundle("quality_signals", this.zzgtb.zzatb());
                }
            } else {
                this.zzgta.zzf(this.zzfqn.zzhbu);
                bundle2.putBundle("quality_signals", this.zzgtb.zzatb());
            }
        }
        bundle2.putString("seq_num", this.zzdpz);
        bundle2.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.zzciq);
    }
}
