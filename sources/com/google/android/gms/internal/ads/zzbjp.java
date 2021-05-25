package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbjp implements zzdhr {
    private final /* synthetic */ zzbjc zzeud;
    private zzelx<Context> zzfgd;
    private zzelx<String> zzfge;
    private zzelx<zzdiz<zzbmw, zzbnc>> zzfgf;
    private zzelx<zzdht> zzfgg;
    private zzelx<zzdhc> zzfgh;
    private zzelx<zzdhl> zzfgi;

    private zzbjp(zzbjc zzbjc, Context context, String str) {
        this.zzeud = zzbjc;
        this.zzfgd = zzeln.zzba(context);
        this.zzfge = zzeln.zzba(str);
        this.zzfgf = new zzdjd(this.zzfgd, zzbjc.zzetu, zzbjc.zzetv);
        this.zzfgg = zzell.zzas(new zzdhz(zzbjc.zzetu));
        this.zzfgh = zzell.zzas(new zzdhi(this.zzfgd, zzbjc.zzery, zzbjc.zzerp, this.zzfgf, this.zzfgg, zzdlo.zzasq()));
        this.zzfgi = zzell.zzas(new zzdho(zzbjc.zzerp, this.zzfgd, this.zzfge, this.zzfgh, this.zzfgg, zzbjc.zzesg));
    }

    @Override // com.google.android.gms.internal.ads.zzdhr
    public final zzdhl zzafq() {
        return this.zzfgi.get();
    }
}
