package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
public final class zzgc extends zzgm {
    private List<Long> zzabg = null;

    public zzgc(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 31);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzq(-1);
        this.zzabc.zzr(-1);
        if (this.zzabg == null) {
            this.zzabg = (List) this.zzabm.invoke(null, this.zzwg.getContext());
        }
        List<Long> list = this.zzabg;
        if (list != null && list.size() == 2) {
            synchronized (this.zzabc) {
                this.zzabc.zzq(this.zzabg.get(0).longValue());
                this.zzabc.zzr(this.zzabg.get(1).longValue());
            }
        }
    }
}
