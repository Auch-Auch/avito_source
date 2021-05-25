package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbse;
import java.util.concurrent.Executor;
public final class zzdii<R extends zzbse<AdT>, AdT extends zzbpd> implements zzdiz<R, zzdim<AdT>> {
    private final Executor executor;
    private final zzdna zzgyr;
    private zzdvi<Void> zzgys = new zzdin(this);

    public zzdii(zzdna zzdna, Executor executor2) {
        this.zzgyr = zzdna;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final zzdvt<zzdim<AdT>> zza(zzdja zzdja, zzdjb<R> zzdjb) {
        return zzdvc.zzg(new zzdit(this.zzgyr, zzdja.zzgzc, zzdjb, this.executor).zzasg()).zzb(new zzduv(this, zzdja, zzdjb) { // from class: com.google.android.gms.internal.ads.zzdil
            private final zzdja zzgyf;
            private final zzdii zzgyu;
            private final zzdjb zzgyv;

            {
                this.zzgyu = r1;
                this.zzgyf = r2;
                this.zzgyv = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgyu.zza(this.zzgyf, this.zzgyv, (zzdix) obj);
            }
        }, this.executor).zza(Exception.class, new zzdik(this), this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final /* bridge */ /* synthetic */ Object zzasb() {
        return null;
    }

    public final /* synthetic */ zzdvt zza(zzdja zzdja, zzdjb zzdjb, zzdix zzdix) throws Exception {
        zzdnk zzdnk = zzdix.zzgyp;
        zzasp zzasp = zzdix.zzgid;
        zzdnh<?> zza = zzdnk != null ? this.zzgyr.zza(zzdnk) : null;
        if (zzdnk == null) {
            return zzdvl.zzaf(null);
        }
        if (!(zza == null || zzasp == null)) {
            zzdvl.zza(((zzbse) zzdjb.zzc(zzdja.zzgzc).zzael()).zzafc().zzc(zzasp), this.zzgys, this.executor);
        }
        return zzdvl.zzaf(new zzdim(zzdnk, zzasp, zza));
    }
}
