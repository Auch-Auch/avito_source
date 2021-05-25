package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
public final class zzdbs implements zzden<zzdbx> {
    private final Context zzaai;
    private final zzdvw zzgay;

    public zzdbs(Context context, zzdvw zzdvw) {
        this.zzaai = context;
        this.zzgay = zzdvw;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdbx> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdbv
            private final zzdbs zzgtu;

            {
                this.zzgtu = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgtu.zzaqy();
            }
        });
    }

    public final /* synthetic */ zzdbx zzaqy() throws Exception {
        zzp.zzkp();
        String zzba = zzayh.zzba(this.zzaai);
        String str = "";
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvs)).booleanValue()) {
            str = this.zzaai.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str);
        }
        zzp.zzkp();
        return new zzdbx(zzba, str, zzayh.zzbb(this.zzaai));
    }
}
