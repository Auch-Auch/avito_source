package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzfs extends zzgm {
    private long startTime;

    public zzfs(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, long j, int i, int i2) {
        super(zzex, str, str2, zza, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabm.invoke(null, new Object[0])).longValue();
        synchronized (this.zzabc) {
            this.zzabc.zzak(longValue);
            long j = this.startTime;
            if (j != 0) {
                this.zzabc.zzm(longValue - j);
                this.zzabc.zzp(this.startTime);
            }
        }
    }
}
