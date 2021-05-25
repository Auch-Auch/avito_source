package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzaxu;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzaym;
public final class zzl extends zzaxu {
    public final /* synthetic */ zzc zzdop;

    private zzl(zzc zzc) {
        this.zzdop = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaxu
    public final void zzuy() {
        Bitmap zza = zzp.zzli().zza(Integer.valueOf(this.zzdop.zzdno.zzdoy.zzbow));
        if (zza != null) {
            zzaym zzkr = zzp.zzkr();
            zzc zzc = this.zzdop;
            Activity activity = zzc.zzaas;
            zzi zzi = zzc.zzdno.zzdoy;
            zzayh.zzeaj.post(new Runnable(this, zzkr.zza(activity, zza, zzi.zzbou, zzi.zzbov)) { // from class: com.google.android.gms.ads.internal.overlay.zzk
                private final zzl zzdon;
                private final Drawable zzdoo;

                {
                    this.zzdon = r1;
                    this.zzdoo = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzl zzl = this.zzdon;
                    zzl.zzdop.zzaas.getWindow().setBackgroundDrawable(this.zzdoo);
                }
            });
        }
    }
}
