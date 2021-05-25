package com.google.android.gms.internal.ads;
public final class zzdnu implements zzdvi<zzdnh<AdT>> {
    private final /* synthetic */ zzdnp zzhfy;

    public zzdnu(zzdnp zzdnp) {
        this.zzhfy = zzdnp;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnh<?> zzdnh = (zzdnh) obj;
        synchronized (this.zzhfy) {
            this.zzhfy.zzhfs.zza(zzdnh);
            if (this.zzhfy.zzhfr != zzdnf.zzhfa) {
                this.zzhfy.zzgyr.zza(this.zzhfy.zzhfo.zzasd(), zzdnh);
            }
            int i = this.zzhfy.zzhfr;
            int i2 = zzdnf.zzhez;
            if (i == i2) {
                zzdnp zzdnp = this.zzhfy;
                zzdnp.zzd(zzdnp.zzhfo);
            }
            this.zzhfy.zzhfr = i2;
            this.zzhfy.zzhfp.set(zzdnh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        synchronized (this.zzhfy) {
            this.zzhfy.zzhfs.zzb(th);
            this.zzhfy.zzhfp.setException(th);
        }
    }
}
