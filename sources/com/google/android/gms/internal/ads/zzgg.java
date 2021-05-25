package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzgg extends zzgm {
    private long zzaar;
    private final zzfi zzxn;

    public zzgg(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, zzfi zzfi) {
        super(zzex, str, str2, zza, i, 53);
        this.zzxn = zzfi;
        if (zzfi != null) {
            this.zzaar = zzfi.zzcu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzxn != null) {
            this.zzabc.zzae(((Long) this.zzabm.invoke(null, Long.valueOf(this.zzaar))).longValue());
        }
    }
}
