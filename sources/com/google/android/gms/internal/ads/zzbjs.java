package com.google.android.gms.internal.ads;
public final class zzbjs {
    private zzbke zzerw;
    private zzbih zzerx;
    private zzdpq zzfht;
    private zzbkn zzfhu;
    private zzdmg zzfhv;

    private zzbjs() {
    }

    public final zzbjs zza(zzbke zzbke) {
        this.zzerw = (zzbke) zzelu.checkNotNull(zzbke);
        return this;
    }

    public final zzbii zzafx() {
        zzelu.zza(this.zzerx, zzbih.class);
        zzelu.zza(this.zzerw, zzbke.class);
        if (this.zzfht == null) {
            this.zzfht = new zzdpq();
        }
        if (this.zzfhu == null) {
            this.zzfhu = new zzbkn();
        }
        if (this.zzfhv == null) {
            this.zzfhv = new zzdmg();
        }
        return new zzbjc(this.zzerx, this.zzerw, this.zzfht, this.zzfhu, this.zzfhv);
    }

    public final zzbjs zzc(zzbih zzbih) {
        this.zzerx = (zzbih) zzelu.checkNotNull(zzbih);
        return this;
    }
}
