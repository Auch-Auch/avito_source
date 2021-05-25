package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbse;
import java.util.concurrent.Executor;
public final class zzdit<R extends zzbse<? extends zzbpd>> {
    private final Executor executor;
    private final zzdjb<R> zzgyn;
    private final zzdna zzgyr;
    private final zzdiy zzgyy;
    private zzdix zzgyz;

    public zzdit(zzdna zzdna, zzdiy zzdiy, zzdjb<R> zzdjb, Executor executor2) {
        this.zzgyr = zzdna;
        this.zzgyy = zzdiy;
        this.zzgyn = zzdjb;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdnk zzash() {
        zzdln zzafj = this.zzgyn.zzc(this.zzgyy).zzael().zzafj();
        return this.zzgyr.zza(zzafj.zzhbu, zzafj.zzhbv, zzafj.zzhby);
    }

    public final zzdvt<zzdix> zzasg() {
        zzdvt zzdvt;
        zzdix zzdix = this.zzgyz;
        if (zzdix != null) {
            return zzdvl.zzaf(zzdix);
        }
        if (!zzacs.zzdbg.get().booleanValue()) {
            zzdix zzdix2 = new zzdix(null, zzash(), null);
            this.zzgyz = zzdix2;
            zzdvt = zzdvl.zzaf(zzdix2);
        } else {
            zzdvt = zzdvc.zzg(this.zzgyn.zzc(this.zzgyy).zza(new zzdij(this.zzgyr.zzatl().zzhem)).zzael().zzafc().zza(this.zzgyr.zzatl())).zza(new zzdiu(this), this.executor).zza(zzcpa.class, new zzdiv(this), this.executor);
        }
        return zzdvl.zzb(zzdvt, zzdis.zzdwg, this.executor);
    }
}
