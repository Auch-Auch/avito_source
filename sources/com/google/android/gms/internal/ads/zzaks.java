package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzaks implements zzahf<zzali> {
    private final /* synthetic */ zzajx zzdgv;
    private final /* synthetic */ zzakk zzdgw;
    private final /* synthetic */ zzeg zzdgy;
    private final /* synthetic */ zzbai zzdgz;

    public zzaks(zzakk zzakk, zzeg zzeg, zzajx zzajx, zzbai zzbai) {
        this.zzdgw = zzakk;
        this.zzdgy = zzeg;
        this.zzdgv = zzajx;
        this.zzdgz = zzbai;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzali zzali, Map map) {
        synchronized (zzakk.zza(this.zzdgw)) {
            zzbbd.zzfd("JS Engine is requesting an update");
            if (zzakk.zzd(this.zzdgw) == 0) {
                zzbbd.zzfd("Starting reload.");
                zzakk.zza(this.zzdgw, 2);
                this.zzdgw.zza(this.zzdgy);
            }
            this.zzdgv.zzb("/requestReload", (zzahf) this.zzdgz.get());
        }
    }
}
