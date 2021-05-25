package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbjt implements zzbop {
    private zzelx<zzdkx> zzeui;
    private zzelx<Set<zzbys<zzbtp>>> zzeuu;
    private zzelx<zzbto> zzeuv;
    private zzelx<zzbvi> zzeuw;
    private zzelx<zzdlj> zzeuy;
    private zzelx<Set<zzbys<zzbuj>>> zzewe;
    private zzelx<zzbue> zzewf;
    private zzelx<String> zzeww;
    private zzelx<zzbsp> zzewx;
    private zzelx<zzbpg> zzewy;
    private final /* synthetic */ zzbjr zzfhb;
    private final zzbos zzfhw;
    private zzelx<zzafq> zzfhx;
    private zzelx<Runnable> zzfhy;
    private zzelx<zzboo> zzfhz;

    private zzbjt(zzbjr zzbjr, zzbpt zzbpt, zzbos zzbos) {
        this.zzfhb = zzbjr;
        this.zzfhw = zzbos;
        this.zzeuy = zzbpy.zze(zzbpt);
        this.zzeui = zzbpw.zzc(zzbpt);
        zzelt zzbjo = zzelt.zzar(0, 2).zzav(zzbjr.zzfcz).zzav(zzbjr.zzfda).zzbjo();
        this.zzeuu = zzbjo;
        this.zzeuv = zzell.zzas(zzbtv.zzj(zzbjo));
        zzelt zzbjo2 = zzelt.zzar(4, 3).zzau(zzbjr.zzfdn).zzau(zzbjr.zzfdo).zzau(zzbjr.zzfdp).zzav(zzbjr.zzfdq).zzav(zzbjr.zzfdr).zzav(zzbjr.zzfds).zzau(zzbjr.zzfdt).zzbjo();
        this.zzewe = zzbjo2;
        this.zzewf = zzell.zzas(zzbug.zzl(zzbjo2));
        zzbpv zza = zzbpv.zza(zzbpt);
        this.zzeww = zza;
        this.zzewx = zzbso.zzt(this.zzeui, zza);
        this.zzeuw = zzell.zzas(zzbwj.zzajr());
        this.zzewy = zzbqy.zza(this.zzeuy, this.zzeui, this.zzeuv, this.zzewf, zzbjr.zzfeb, this.zzewx, this.zzeuw);
        this.zzfhx = new zzbou(zzbos);
        zzbor zzbor = new zzbor(zzbos);
        this.zzfhy = zzbor;
        this.zzfhz = zzell.zzas(new zzbot(this.zzewy, this.zzfhx, zzbor, zzbjr.zzeud.zzery));
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbni zzafy() {
        return (zzbni) zzelu.zza(this.zzfhz.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
