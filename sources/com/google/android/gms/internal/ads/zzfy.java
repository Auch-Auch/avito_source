package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzfy extends zzgm {
    private long zzabe = -1;

    public zzfy(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 12);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzi(-1);
        this.zzabc.zzi(((Long) this.zzabm.invoke(null, this.zzwg.getContext())).longValue());
    }
}
