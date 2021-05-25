package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
public final class zzfx extends zzgm {
    private static final Object zzaba = new Object();
    private static volatile String zzabd;

    public zzfx(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzu(ExifInterface.LONGITUDE_EAST);
        if (zzabd == null) {
            synchronized (zzaba) {
                if (zzabd == null) {
                    zzabd = (String) this.zzabm.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabc) {
            this.zzabc.zzu(zzabd);
        }
    }
}
