package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzgd extends zzgm {
    public zzgd(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzabc) {
            zzey zzey = new zzey((String) this.zzabm.invoke(null, new Object[0]));
            this.zzabc.zzac(zzey.zzzi.longValue());
            this.zzabc.zzad(zzey.zzzj.longValue());
        }
    }
}
