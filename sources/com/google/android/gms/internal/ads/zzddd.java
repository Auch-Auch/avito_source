package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
public final class zzddd implements zzelo<zzdda> {
    private final zzelx<PackageInfo> zzfse;
    private final zzelx<ApplicationInfo> zzghj;

    private zzddd(zzelx<ApplicationInfo> zzelx, zzelx<PackageInfo> zzelx2) {
        this.zzghj = zzelx;
        this.zzfse = zzelx2;
    }

    public static zzdda zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdda(applicationInfo, packageInfo);
    }

    public static zzddd zzbd(zzelx<ApplicationInfo> zzelx, zzelx<PackageInfo> zzelx2) {
        return new zzddd(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzghj.get(), this.zzfse.get());
    }
}
