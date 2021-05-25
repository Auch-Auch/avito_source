package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Callable;
public final class zzbrz {
    private final String packageName;
    private final zzbbg zzbop;
    private final PackageInfo zzdpx;
    private final List<String> zzdqh;
    private final String zzdtf;
    private final zzaya zzdza;
    private final zzdpf zzfqo;
    private final ApplicationInfo zzfrx;
    private final zzeli<zzdvt<String>> zzfry;
    private final zzdem<Bundle> zzfrz;

    public zzbrz(zzdpf zzdpf, zzbbg zzbbg, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, zzeli<zzdvt<String>> zzeli, zzaya zzaya, String str2, zzdem<Bundle> zzdem) {
        this.zzfqo = zzdpf;
        this.zzbop = zzbbg;
        this.zzfrx = applicationInfo;
        this.packageName = str;
        this.zzdqh = list;
        this.zzdpx = packageInfo;
        this.zzfry = zzeli;
        this.zzdza = zzaya;
        this.zzdtf = str2;
        this.zzfrz = zzdem;
    }

    public final zzdvt<Bundle> zzajc() {
        return this.zzfqo.zzu(zzdpg.SIGNALS).zze(this.zzfrz.zzt(new Bundle())).zzauz();
    }

    public final zzdvt<zzasp> zzajd() {
        zzdvt<Bundle> zzajc = zzajc();
        return this.zzfqo.zza((zzdpf) zzdpg.REQUEST_PARCEL, zzajc, this.zzfry.get()).zzb(new Callable(this, zzajc) { // from class: com.google.android.gms.internal.ads.zzbsc
            private final zzbrz zzfsh;
            private final zzdvt zzfsi;

            {
                this.zzfsh = r1;
                this.zzfsi = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzfsh.zzc(this.zzfsi);
            }
        }).zzauz();
    }

    public final /* synthetic */ zzasp zzc(zzdvt zzdvt) throws Exception {
        return new zzasp((Bundle) zzdvt.get(), this.zzbop, this.zzfrx, this.packageName, this.zzdqh, this.zzdpx, this.zzfry.get().get(), this.zzdza.zzxc(), this.zzdtf, null, null);
    }
}
