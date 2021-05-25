package com.google.android.gms.internal.ads;
public final class zzoi {
    public final zznp zzbhs;
    public final zzod zzbht;
    public final Object zzbhu;
    public final zzhz[] zzbhv;

    public zzoi(zznp zznp, zzod zzod, Object obj, zzhz[] zzhzArr) {
        this.zzbhs = zznp;
        this.zzbht = zzod;
        this.zzbhu = obj;
        this.zzbhv = zzhzArr;
    }

    public final boolean zza(zzoi zzoi, int i) {
        if (zzoi != null && zzpq.zza(this.zzbht.zzbg(i), zzoi.zzbht.zzbg(i)) && zzpq.zza(this.zzbhv[i], zzoi.zzbhv[i])) {
            return true;
        }
        return false;
    }
}
