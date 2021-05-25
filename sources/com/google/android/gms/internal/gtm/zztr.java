package com.google.android.gms.internal.gtm;

import java.io.IOException;
public abstract class zztr<T, B> {
    public abstract void zza(B b, int i, long j);

    public abstract void zza(B b, int i, zzps zzps);

    public abstract void zza(B b, int i, T t);

    public abstract void zza(T t, zzum zzum) throws IOException;

    public abstract boolean zza(zzsy zzsy);

    public final boolean zza(B b, zzsy zzsy) throws IOException {
        int tag = zzsy.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzsy.zznk());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzsy.zznm());
            return true;
        } else if (i2 == 2) {
            zza((zztr<T, B>) b, i, zzsy.zznq());
            return true;
        } else if (i2 == 3) {
            B zzri = zzri();
            int i3 = 4 | (i << 3);
            while (zzsy.zzog() != Integer.MAX_VALUE && zza(zzri, zzsy)) {
            }
            if (i3 == zzsy.getTag()) {
                zza((zztr<T, B>) b, i, (int) zzaa(zzri));
                return true;
            }
            throw zzrk.zzps();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzsy.zznn());
                return true;
            }
            throw zzrk.zzpt();
        }
    }

    public abstract T zzaa(B b);

    public abstract int zzad(T t);

    public abstract T zzag(Object obj);

    public abstract B zzah(Object obj);

    public abstract int zzai(T t);

    public abstract void zzb(B b, int i, long j);

    public abstract void zzc(B b, int i, int i2);

    public abstract void zzc(T t, zzum zzum) throws IOException;

    public abstract void zzf(Object obj, T t);

    public abstract void zzg(Object obj, B b);

    public abstract T zzh(T t, T t2);

    public abstract B zzri();

    public abstract void zzt(Object obj);
}
