package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzgb extends zzgm {
    private final boolean zzabf;

    public zzgb(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 61);
        this.zzabf = zzex.zzcb();
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabm.invoke(null, this.zzwg.getContext(), Boolean.valueOf(this.zzabf))).longValue();
        synchronized (this.zzabc) {
            this.zzabc.zzah(longValue);
        }
    }
}
