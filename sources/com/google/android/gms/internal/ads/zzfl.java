package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;
public final class zzfl extends zzgm {
    private static zzgl<String> zzaau = new zzgl<>();
    private final Context zzaav;

    public zzfl(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2, Context context) {
        super(zzex, str, str2, zza, i, 29);
        this.zzaav = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabc.zzx(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzat = zzaau.zzat(this.zzaav.getPackageName());
        if (zzat.get() == null) {
            synchronized (zzat) {
                if (zzat.get() == null) {
                    zzat.set((String) this.zzabm.invoke(null, this.zzaav));
                }
            }
        }
        String str = zzat.get();
        synchronized (this.zzabc) {
            this.zzabc.zzx(zzcv.zza(str.getBytes(), true));
        }
    }
}
