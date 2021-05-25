package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzakp implements zzahf<zzali> {
    private final /* synthetic */ zzalb zzdgu;
    private final /* synthetic */ zzajx zzdgv;
    private final /* synthetic */ zzakk zzdgw;

    public zzakp(zzakk zzakk, zzalb zzalb, zzajx zzajx) {
        this.zzdgw = zzakk;
        this.zzdgu = zzalb;
        this.zzdgv = zzajx;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzali zzali, Map map) {
        synchronized (zzakk.zza(this.zzdgw)) {
            if (this.zzdgu.getStatus() != -1) {
                if (this.zzdgu.getStatus() != 1) {
                    zzakk.zza(this.zzdgw, 0);
                    zzakk.zzc(this.zzdgw).zzh(this.zzdgv);
                    this.zzdgu.zzm(this.zzdgv);
                    zzakk.zza(this.zzdgw, this.zzdgu);
                    zzaxy.zzei("Successfully loaded JS Engine.");
                }
            }
        }
    }
}
