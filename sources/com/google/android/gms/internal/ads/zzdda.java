package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
public final class zzdda implements zzdek<Bundle>, zzden<zzdek<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdpx;

    public zzdda(ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdpx = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        return zzdvl.zzaf(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdpx;
        String str2 = null;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvi)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdpx;
            if (packageInfo2 != null) {
                str2 = packageInfo2.versionName;
            }
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}
