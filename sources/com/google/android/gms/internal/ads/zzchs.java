package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
public final class zzchs implements zzahp {
    private final zzbtu zzfqj;
    @Nullable
    private final zzaue zzgcz;
    private final String zzgda;
    private final String zzgdb;

    public zzchs(zzbtu zzbtu, zzdkx zzdkx) {
        this.zzfqj = zzbtu;
        this.zzgcz = zzdkx.zzdsh;
        this.zzgda = zzdkx.zzdjz;
        this.zzgdb = zzdkx.zzdka;
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    @ParametersAreNonnullByDefault
    public final void zza(zzaue zzaue) {
        int i;
        String str;
        zzaue zzaue2 = this.zzgcz;
        if (zzaue2 != null) {
            zzaue = zzaue2;
        }
        if (zzaue != null) {
            str = zzaue.type;
            i = zzaue.zzdva;
        } else {
            str = "";
            i = 1;
        }
        this.zzfqj.zzb(new zzath(str, i), this.zzgda, this.zzgdb);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zzsv() {
        this.zzfqj.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zzsw() {
        this.zzfqj.onRewardedVideoCompleted();
    }
}
