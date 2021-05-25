package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzfj extends zzgm {
    private final Activity zzaas;
    private final View zzaat;

    public zzfj(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, View view, Activity activity) {
        super(zzex, str, str2, zza, i, 62);
        this.zzaat = view;
        this.zzaas = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaat != null) {
            boolean booleanValue = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcqm)).booleanValue();
            Object[] objArr = (Object[]) this.zzabm.invoke(null, this.zzaat, this.zzaas, Boolean.valueOf(booleanValue));
            synchronized (this.zzabc) {
                this.zzabc.zzai(((Long) objArr[0]).longValue());
                this.zzabc.zzaj(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzabc.zzab((String) objArr[2]);
                }
            }
        }
    }
}
