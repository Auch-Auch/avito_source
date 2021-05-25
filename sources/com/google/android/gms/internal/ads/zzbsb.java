package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
public final class zzbsb implements zzelo<zzbrz> {
    private final zzelx<zzaya> zzeyo;
    private final zzelx<zzdem<Bundle>> zzfbk;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<zzdpf> zzfow;
    private final zzelx<ApplicationInfo> zzfsb;
    private final zzelx<String> zzfsc;
    private final zzelx<List<String>> zzfsd;
    private final zzelx<PackageInfo> zzfse;
    private final zzelx<zzdvt<String>> zzfsf;
    private final zzelx<String> zzfsg;

    private zzbsb(zzelx<zzdpf> zzelx, zzelx<zzbbg> zzelx2, zzelx<ApplicationInfo> zzelx3, zzelx<String> zzelx4, zzelx<List<String>> zzelx5, zzelx<PackageInfo> zzelx6, zzelx<zzdvt<String>> zzelx7, zzelx<zzaya> zzelx8, zzelx<String> zzelx9, zzelx<zzdem<Bundle>> zzelx10) {
        this.zzfow = zzelx;
        this.zzfnd = zzelx2;
        this.zzfsb = zzelx3;
        this.zzfsc = zzelx4;
        this.zzfsd = zzelx5;
        this.zzfse = zzelx6;
        this.zzfsf = zzelx7;
        this.zzeyo = zzelx8;
        this.zzfsg = zzelx9;
        this.zzfbk = zzelx10;
    }

    public static zzbsb zzb(zzelx<zzdpf> zzelx, zzelx<zzbbg> zzelx2, zzelx<ApplicationInfo> zzelx3, zzelx<String> zzelx4, zzelx<List<String>> zzelx5, zzelx<PackageInfo> zzelx6, zzelx<zzdvt<String>> zzelx7, zzelx<zzaya> zzelx8, zzelx<String> zzelx9, zzelx<zzdem<Bundle>> zzelx10) {
        return new zzbsb(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9, zzelx10);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbrz(this.zzfow.get(), this.zzfnd.get(), this.zzfsb.get(), this.zzfsc.get(), this.zzfsd.get(), this.zzfse.get(), zzell.zzat(this.zzfsf), this.zzeyo.get(), this.zzfsg.get(), this.zzfbk.get());
    }
}
