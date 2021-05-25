package com.google.android.gms.internal.ads;
public final class zzdwk extends zzdvs<zzdvt<V>> {
    private final /* synthetic */ zzdwh zzhqn;
    private final zzdut<V> zzhqo;

    public zzdwk(zzdwh zzdwh, zzdut<V> zzdut) {
        this.zzhqn = zzdwh;
        this.zzhqo = (zzdut) zzdsv.checkNotNull(zzdut);
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final boolean isDone() {
        return this.zzhqn.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final /* synthetic */ Object zzaxi() throws Exception {
        return (zzdvt) zzdsv.zza(this.zzhqo.zzard(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzhqo);
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final String zzaxj() {
        return this.zzhqo.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzdvt zzdvt = (zzdvt) obj;
        if (th == null) {
            this.zzhqn.setFuture(zzdvt);
        } else {
            this.zzhqn.setException(th);
        }
    }
}
