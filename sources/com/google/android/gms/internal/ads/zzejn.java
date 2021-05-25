package com.google.android.gms.internal.ads;

import java.io.IOException;
public abstract class zzejn<T, B> {
    public abstract void zza(B b, int i, long j);

    public abstract void zza(B b, int i, zzeff zzeff);

    public abstract void zza(B b, int i, T t);

    public abstract void zza(T t, zzekk zzekk) throws IOException;

    public abstract boolean zza(zzeip zzeip);

    public final boolean zza(B b, zzeip zzeip) throws IOException {
        int tag = zzeip.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzeip.zzbdv());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzeip.zzbdx());
            return true;
        } else if (i2 == 2) {
            zza((zzejn<T, B>) b, i, zzeip.zzbeb());
            return true;
        } else if (i2 == 3) {
            B zzbhy = zzbhy();
            int i3 = 4 | (i << 3);
            while (zzeip.zzber() != Integer.MAX_VALUE && zza(zzbhy, zzeip)) {
            }
            if (i3 == zzeip.getTag()) {
                zza((zzejn<T, B>) b, i, (int) zzar(zzbhy));
                return true;
            }
            throw zzegz.zzbgf();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzeip.zzbdy());
                return true;
            }
            throw zzegz.zzbgg();
        }
    }

    public abstract void zzaj(Object obj);

    public abstract T zzar(B b);

    public abstract int zzat(T t);

    public abstract T zzax(Object obj);

    public abstract B zzay(Object obj);

    public abstract int zzaz(T t);

    public abstract void zzb(B b, int i, long j);

    public abstract B zzbhy();

    public abstract void zzc(B b, int i, int i2);

    public abstract void zzc(T t, zzekk zzekk) throws IOException;

    public abstract void zzi(Object obj, T t);

    public abstract void zzj(Object obj, B b);

    public abstract T zzk(T t, T t2);
}
