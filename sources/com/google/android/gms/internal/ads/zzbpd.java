package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public class zzbpd {
    public final zzdlj zzflg;
    public final zzdkx zzfpf;
    private final zzbto zzfps;
    private final zzbue zzfpt;
    @Nullable
    private final zzdiw zzfpu;
    private final zzbsp zzfpv;
    private final zzbvi zzfpw;

    public zzbpd(zzbpg zzbpg) {
        this.zzflg = zzbpg.zzflg;
        this.zzfpf = zzbpg.zzfpf;
        this.zzfps = zzbpg.zzfps;
        this.zzfpt = zzbpg.zzfpt;
        this.zzfpu = zzbpg.zzfpu;
        this.zzfpv = zzbpg.zzfpv;
        this.zzfpw = zzbpg.zzfpw;
    }

    public void destroy() {
        this.zzfps.zzcb(null);
    }

    public void zzahw() {
        this.zzfpt.onAdLoaded();
    }

    public final zzbto zzail() {
        return this.zzfps;
    }

    public final zzbsp zzaim() {
        return this.zzfpv;
    }

    @Nullable
    public final zzdiw zzain() {
        return this.zzfpu;
    }

    public final zzbwh zzaio() {
        return this.zzfpw.zzaio();
    }
}
