package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
public abstract class zzgm implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    public final zzcf.zza.C0192zza zzabc;
    private final String zzabk;
    public Method zzabm;
    private final int zzabq;
    private final int zzabr;
    public final zzex zzwg;

    public zzgm(zzex zzex, String str, String str2, zzcf.zza.C0192zza zza, int i, int i2) {
        this.zzwg = zzex;
        this.className = str;
        this.zzabk = str2;
        this.zzabc = zza;
        this.zzabq = i;
        this.zzabr = i2;
    }

    public abstract void zzcw() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcy */
    public Void call() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zza = this.zzwg.zza(this.className, this.zzabk);
            this.zzabm = zza;
            if (zza == null) {
                return null;
            }
            zzcw();
            zzdu zzcl = this.zzwg.zzcl();
            if (!(zzcl == null || (i = this.zzabq) == Integer.MIN_VALUE)) {
                zzcl.zza(this.zzabr, i, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
