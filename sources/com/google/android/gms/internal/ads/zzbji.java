package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;
public final class zzbji extends zzdff {
    private final /* synthetic */ zzbjc zzeud;
    private zzelx<String> zzeyj;
    private zzelx<zzcku> zzeyz;
    private zzelx<Map<zzdpg, zzcku>> zzezb;
    private zzelx<Set<zzbys<zzdpl>>> zzezd;
    private zzelx<Set<zzbys<zzdpl>>> zzezk;
    private zzelx zzezl;
    private zzelx<zzdpf> zzezm;
    private zzelx<ApplicationInfo> zzezw;
    private zzelx<zzdgj> zzfbb;
    private final zzdgo zzfeg;
    private zzelx<zzdfb> zzfeh;
    private zzelx<String> zzfei;
    private zzelx<zzdfl> zzfej;
    private zzelx<Integer> zzfek;
    private zzelx<zzdfp> zzfel;
    private zzelx<zzdfv> zzfem;
    private zzelx<zzdga> zzfen;
    private zzelx<Boolean> zzfeo;
    private zzelx<zzdgn> zzfep;
    private zzelx<zzdhb> zzfeq;
    private zzelx<zzcku> zzfer;
    private zzelx<zzcku> zzfes;
    private zzelx<zzcku> zzfet;

    private zzbji(zzbjc zzbjc, zzdgo zzdgo) {
        this.zzeud = zzbjc;
        this.zzfeg = zzdgo;
        this.zzfeh = new zzdfc(zzblc.zzagw(), zzbjc.zzf(zzbjc), zzbjc.zza(zzbjc), zzdof.zzaul());
        this.zzfei = new zzdgr(zzdgo);
        this.zzfej = new zzdfn(zzbix.zzers, zzbjc.zzf(zzbjc), this.zzfei, zzdof.zzaul());
        this.zzfek = new zzdgs(zzdgo);
        this.zzfel = new zzdft(zzblc.zzagw(), this.zzfek, zzbjc.zzf(zzbjc), zzbjc.zzd(zzbjc), zzbjc.zza(zzbjc), zzdof.zzaul());
        this.zzfem = new zzdfx(zzbkw.zzagr(), zzdof.zzaul(), zzbjc.zzf(zzbjc));
        this.zzfen = new zzdgc(zzbky.zzagt(), zzdof.zzaul(), this.zzfei);
        this.zzfeo = new zzdgt(zzdgo);
        this.zzezw = new zzdgq(zzdgo);
        this.zzfbb = new zzdgl(zzbjc.zzg(zzbjc), zzbjc.zza(zzbjc), this.zzfeo, this.zzezw);
        this.zzfep = new zzdgp(zzbla.zzagv(), zzbjc.zza(zzbjc), zzbjc.zzf(zzbjc));
        this.zzfeq = new zzdhd(zzdof.zzaul());
        this.zzeyj = new zzdgv(zzdgo);
        this.zzeyz = zzell.zzas(zzckj.zzaoe());
        this.zzfer = zzell.zzas(zzckh.zzaod());
        this.zzfes = zzell.zzas(zzckl.zzaog());
        this.zzfet = zzell.zzas(zzckn.zzaoi());
        this.zzezb = ((zzels) ((zzels) ((zzels) ((zzels) zzelq.zzic(4).zza(zzdpg.GMS_SIGNALS, this.zzeyz)).zza(zzdpg.BUILD_URL, this.zzfer)).zza(zzdpg.HTTP, this.zzfes)).zza(zzdpg.PRE_PROCESS, this.zzfet)).zzbjn();
        this.zzezd = zzell.zzas(new zzckp(this.zzeyj, zzbjc.zzf(zzbjc), zzdof.zzaul(), this.zzezb));
        zzelt zzbjo = zzelt.zzar(0, 1).zzav(this.zzezd).zzbjo();
        this.zzezk = zzbjo;
        this.zzezl = zzdpn.zzar(zzbjo);
        this.zzezm = zzell.zzas(zzdpo.zzv(zzdof.zzaul(), zzbjc.zza(zzbjc), this.zzezl));
    }

    private final zzdge zzafe() {
        return new zzdge((zzaag) zzelu.zza(new zzaag(), "Cannot return null from a non-@Nullable @Provides method"), zzdof.zzaum(), (List) zzelu.zza(this.zzfeg.zzarr(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzdfh zzaff() {
        return new zzdfh(zzbkz.zzagu(), zzdof.zzaum(), (String) zzelu.zza(this.zzfeg.zzaro(), "Cannot return null from a non-@Nullable @Provides method"), this.zzfeg.zzarp());
    }

    @Override // com.google.android.gms.internal.ads.zzdff
    public final zzdem<JSONObject> zzafg() {
        return zzder.zza(zzdof.zzaum(), zzdtn.zza((zzden) zzelu.zza(new zzdcy(new zzdga(zzbkv.zzagq(), zzdof.zzaum(), zzdgr.zzc(this.zzfeg)), 0, (ScheduledExecutorService) zzbjc.zza(this.zzeud).get()), "Cannot return null from a non-@Nullable @Provides method"), (zzden) zzelu.zza(new zzdcy(new zzdgj(zzbki.zzb(zzbjc.zzb(this.zzeud)), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get(), this.zzfeg.zzarq(), zzdgq.zzb(this.zzfeg)), ((Long) zzwe.zzpu().zzd(zzaat.zzcsa)).longValue(), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get()), "Cannot return null from a non-@Nullable @Provides method"), (zzden) zzelu.zza(new zzdcy(new zzdgn(zzbkx.zzags(), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get(), zzbik.zza(zzbjc.zzc(this.zzeud))), ((Long) zzwe.zzpu().zzd(zzaat.zzcsi)).longValue(), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get()), "Cannot return null from a non-@Nullable @Provides method"), (zzden) zzelu.zza(new zzdcy(new zzdfb(zzbkz.zzagu(), zzbik.zza(zzbjc.zzc(this.zzeud)), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get(), zzdof.zzaum()), 0, (ScheduledExecutorService) zzbjc.zza(this.zzeud).get()), "Cannot return null from a non-@Nullable @Provides method"), (zzden) zzelu.zza(new zzdcy(new zzdhb(zzdof.zzaum()), 0, (ScheduledExecutorService) zzbjc.zza(this.zzeud).get()), "Cannot return null from a non-@Nullable @Provides method"), (zzden) zzelu.zza(zzdgu.zzarv(), "Cannot return null from a non-@Nullable @Provides method"), new zzdfl(null, zzbik.zza(zzbjc.zzc(this.zzeud)), zzdgr.zzc(this.zzfeg), zzdof.zzaum()), new zzdfv(zzbkt.zzago(), zzdof.zzaum(), zzbik.zza(zzbjc.zzc(this.zzeud))), zzafe(), zzaff(), new zzdfp(zzbkz.zzagu(), this.zzfeg.zzaru(), zzbik.zza(zzbjc.zzc(this.zzeud)), (zzaxk) zzbjc.zzd(this.zzeud).get(), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get(), zzdof.zzaum()), (zzden) zzbjc.zze(this.zzeud).get()));
    }

    @Override // com.google.android.gms.internal.ads.zzdff
    public final zzdem<JSONObject> zzafh() {
        return zzdgz.zza(zzbkv.zzagq(), zzbjc.zze(this.zzeud).get(), zzaff(), zzafe(), zzell.zzat(this.zzfeh), zzell.zzat(this.zzfej), zzell.zzat(this.zzfel), zzell.zzat(this.zzfem), zzell.zzat(this.zzfen), zzell.zzat(this.zzfbb), zzell.zzat(this.zzfep), zzell.zzat(this.zzfeq), zzdof.zzaum(), (ScheduledExecutorService) zzbjc.zza(this.zzeud).get());
    }

    @Override // com.google.android.gms.internal.ads.zzdff
    public final zzdpf zzafi() {
        return this.zzezm.get();
    }
}
