package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzge extends zzgm {
    private final StackTraceElement[] zzabh;

    public zzge(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzex, str, str2, zza, i, 45);
        this.zzabh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        zzcn zzcn;
        StackTraceElement[] stackTraceElementArr = this.zzabh;
        if (stackTraceElementArr != null) {
            zzet zzet = new zzet((String) this.zzabm.invoke(null, stackTraceElementArr));
            synchronized (this.zzabc) {
                this.zzabc.zzab(zzet.zzyn.longValue());
                if (zzet.zzyo.booleanValue()) {
                    zzcf.zza.C0192zza zza = this.zzabc;
                    if (zzet.zzyp.booleanValue()) {
                        zzcn = zzcn.ENUM_FALSE;
                    } else {
                        zzcn = zzcn.ENUM_TRUE;
                    }
                    zza.zzc(zzcn);
                } else {
                    this.zzabc.zzc(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
