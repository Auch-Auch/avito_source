package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
public final class zzdfh implements zzden<zzdfe> {
    private final Executor executor;
    @Nullable
    private final PackageInfo zzdpx;
    private final zzaxg zzgvu;
    private final String zzgvx;

    public zzdfh(zzaxg zzaxg, Executor executor2, String str, @Nullable PackageInfo packageInfo) {
        this.zzgvu = zzaxg;
        this.executor = executor2;
        this.zzgvx = str;
        this.zzdpx = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdfe> zzaqs() {
        return zzdvl.zzb(zzdvl.zzb(this.zzgvu.zza(this.zzgvx, this.zzdpx), zzdfg.zzdwg, this.executor), Throwable.class, new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzdfj
            private final zzdfh zzgvz;

            {
                this.zzgvz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgvz.zzg((Throwable) obj);
            }
        }, this.executor);
    }

    public final /* synthetic */ zzdvt zzg(Throwable th) throws Exception {
        return zzdvl.zzaf(new zzdfe(this.zzgvx));
    }
}
