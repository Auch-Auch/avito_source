package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzfz extends zzgm {
    public zzfz(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zzabc.zzd(((Boolean) this.zzabm.invoke(null, new Object[]{this.zzwg.getContext()})).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzabc.zzd(zzcn.ENUM_FAILURE);
        }
    }
}
