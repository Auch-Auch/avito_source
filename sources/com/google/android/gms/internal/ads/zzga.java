package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzga extends zzgm {
    public zzga(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        zzek zzek = new zzek((String) this.zzabm.invoke(null, this.zzwg.getContext(), Boolean.valueOf(((Boolean) zzwe.zzpu().zzd(zzaat.zzcqp)).booleanValue())));
        synchronized (this.zzabc) {
            this.zzabc.zze(zzek.zzyk);
            this.zzabc.zzag(zzek.zzyl);
        }
    }
}
