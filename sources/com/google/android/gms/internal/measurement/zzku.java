package com.google.android.gms.internal.measurement;

import java.io.IOException;
public abstract class zzku<T, B> {
    public abstract B zza();

    public abstract T zza(B b);

    public abstract void zza(B b, int i, int i2);

    public abstract void zza(B b, int i, long j);

    public abstract void zza(B b, int i, zzgt zzgt);

    public abstract void zza(B b, int i, T t);

    public abstract void zza(T t, zzln zzln) throws IOException;

    public abstract void zza(Object obj, T t);

    public abstract boolean zza(zzjz zzjz);

    public final boolean zza(B b, zzjz zzjz) throws IOException {
        int zzb = zzjz.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza(b, i, zzjz.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzjz.zzi());
            return true;
        } else if (i2 == 2) {
            zza((zzku<T, B>) b, i, zzjz.zzn());
            return true;
        } else if (i2 == 3) {
            B zza = zza();
            int i3 = 4 | (i << 3);
            while (zzjz.zza() != Integer.MAX_VALUE && zza((zzku<T, B>) zza, zzjz)) {
            }
            if (i3 == zzjz.zzb()) {
                zza((zzku<T, B>) b, i, (int) zza((zzku<T, B>) zza));
                return true;
            }
            throw zzij.zze();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zza((zzku<T, B>) b, i, zzjz.zzj());
                return true;
            }
            throw zzij.zzf();
        }
    }

    public abstract T zzb(Object obj);

    public abstract void zzb(B b, int i, long j);

    public abstract void zzb(T t, zzln zzln) throws IOException;

    public abstract void zzb(Object obj, B b);

    public abstract B zzc(Object obj);

    public abstract T zzc(T t, T t2);

    public abstract void zzd(Object obj);

    public abstract int zze(T t);

    public abstract int zzf(T t);
}
