package com.google.android.gms.internal.vision;

import java.io.IOException;
public abstract class zzkx<T, B> {
    public abstract void zza(B b, int i, long j);

    public abstract void zza(B b, int i, zzgs zzgs);

    public abstract void zza(B b, int i, T t);

    public abstract void zza(T t, zzlq zzlq) throws IOException;

    public abstract boolean zza(zzkc zzkc);

    public final boolean zza(B b, zzkc zzkc) throws IOException {
        int tag = zzkc.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzkc.zzer());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzkc.zzet());
            return true;
        } else if (i2 == 2) {
            zza((zzkx<T, B>) b, i, zzkc.zzex());
            return true;
        } else if (i2 == 3) {
            B zzjd = zzjd();
            int i3 = 4 | (i << 3);
            while (zzkc.zzeo() != Integer.MAX_VALUE && zza(zzjd, zzkc)) {
            }
            if (i3 == zzkc.getTag()) {
                zza((zzkx<T, B>) b, i, (int) zzq(zzjd));
                return true;
            }
            throw zzin.zzhl();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzd(b, i, zzkc.zzeu());
                return true;
            }
            throw zzin.zzhm();
        }
    }

    public abstract int zzaa(T t);

    public abstract void zzb(B b, int i, long j);

    public abstract void zzc(T t, zzlq zzlq) throws IOException;

    public abstract void zzd(B b, int i, int i2);

    public abstract void zzf(Object obj, T t);

    public abstract void zzg(Object obj, B b);

    public abstract T zzh(T t, T t2);

    public abstract void zzj(Object obj);

    public abstract B zzjd();

    public abstract T zzq(B b);

    public abstract int zzu(T t);

    public abstract T zzy(Object obj);

    public abstract B zzz(Object obj);
}
