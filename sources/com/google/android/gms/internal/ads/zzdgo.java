package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;
public final class zzdgo {
    private final zzasp zzgid;
    private final int zzgjp;

    public zzdgo(zzasp zzasp, int i) {
        this.zzgid = zzasp;
        this.zzgjp = i;
    }

    public final String zzarn() {
        return this.zzgid.packageName;
    }

    public final String zzaro() {
        return this.zzgid.zzdtd.getString("ms");
    }

    @Nullable
    public final PackageInfo zzarp() {
        return this.zzgid.zzdpx;
    }

    public final boolean zzarq() {
        return this.zzgid.zzdte;
    }

    public final List<String> zzarr() {
        return this.zzgid.zzdqh;
    }

    public final ApplicationInfo zzars() {
        return this.zzgid.applicationInfo;
    }

    public final String zzart() {
        return this.zzgid.zzdtf;
    }

    public final int zzaru() {
        return this.zzgjp;
    }
}
