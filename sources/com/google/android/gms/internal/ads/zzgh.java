package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzgh extends zzgm {
    private final View zzaat;

    public zzgh(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, View view) {
        super(zzex, str, str2, zza, i, 57);
        this.zzaat = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaat != null) {
            Boolean bool = (Boolean) zzwe.zzpu().zzd(zzaat.zzcrb);
            zzff zzff = new zzff((String) this.zzabm.invoke(null, this.zzaat, this.zzwg.getContext().getResources().getDisplayMetrics(), bool));
            zzcf.zza.zzf.C0194zza zzax = zzcf.zza.zzf.zzax();
            zzax.zzcy(zzff.zzaab.longValue()).zzcz(zzff.zzaac.longValue()).zzda(zzff.zzaad.longValue());
            if (bool.booleanValue()) {
                zzax.zzdb(zzff.zzaae.longValue());
            }
            this.zzabc.zza((zzcf.zza.zzf) ((zzegp) zzax.zzbfx()));
        }
    }
}
