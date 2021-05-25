package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzft extends zzgm {
    private static final Object zzaba = new Object();
    private static volatile Long zzabb;

    public zzft(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (zzabb == null) {
            synchronized (zzaba) {
                if (zzabb == null) {
                    zzabb = (Long) this.zzabm.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabc) {
            this.zzabc.zzo(zzabb.longValue());
        }
    }
}
