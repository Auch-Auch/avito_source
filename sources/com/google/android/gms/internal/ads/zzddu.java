package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
public final class zzddu implements zzden<zzddv> {
    private final zzawb zzbqm;
    private final zzdvw zzgay;
    private final Context zzvr;

    public zzddu(zzawb zzawb, zzdvw zzdvw, Context context) {
        this.zzbqm = zzawb;
        this.zzgay = zzdvw;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzddv> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddx
            private final zzddu zzguu;

            {
                this.zzguu = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguu.zzarf();
            }
        });
    }

    public final /* synthetic */ zzddv zzarf() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zzbqm.zzac(this.zzvr)) {
            return new zzddv(null, null, null, null, null);
        }
        String zzaf = this.zzbqm.zzaf(this.zzvr);
        String str4 = zzaf == null ? "" : zzaf;
        String zzag = this.zzbqm.zzag(this.zzvr);
        if (zzag == null) {
            str = "";
        } else {
            str = zzag;
        }
        String zzah = this.zzbqm.zzah(this.zzvr);
        if (zzah == null) {
            str2 = "";
        } else {
            str2 = zzah;
        }
        String zzai = this.zzbqm.zzai(this.zzvr);
        if (zzai == null) {
            str3 = "";
        } else {
            str3 = zzai;
        }
        return new zzddv(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzwe.zzpu().zzd(zzaat.zzcng) : null);
    }
}
