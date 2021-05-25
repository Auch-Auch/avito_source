package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
public final class zzcnj implements zzelo<PackageInfo> {
    private final zzelx<Context> zzert;
    private final zzelx<ApplicationInfo> zzghj;

    private zzcnj(zzelx<Context> zzelx, zzelx<ApplicationInfo> zzelx2) {
        this.zzert = zzelx;
        this.zzghj = zzelx2;
    }

    public static zzcnj zzaq(zzelx<Context> zzelx, zzelx<ApplicationInfo> zzelx2) {
        return new zzcnj(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return zzcmz.zza(this.zzert.get(), this.zzghj.get());
    }
}
