package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbse;
import java.util.Iterator;
import java.util.concurrent.Executor;
public final class zzdhy<R extends zzbse<AdT>, AdT extends zzbpd> implements zzdiz<R, zzdnh<AdT>> {
    private final Executor executor = zzdvv.zzaxm();
    private R zzgxy;

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final zzdvt<zzdnh<AdT>> zza(zzdja zzdja, zzdjb<R> zzdjb) {
        zzdvt<zzdlj> zzdvt;
        zzbsd<R> zzc = zzdjb.zzc(zzdja.zzgzc);
        zzc.zza(new zzdjf(true));
        R zzael = zzc.zzael();
        this.zzgxy = zzael;
        zzbqb zzafc = zzael.zzafc();
        zzdnh zzdnh = new zzdnh();
        zzasp zzasp = zzdja.zzgzb;
        if (zzasp != null) {
            zzdvt = zzafc.zza(zzasp);
        } else {
            zzdvt = zzafc.zzaiu();
        }
        return zzdvc.zzg(zzdvt).zzb(new zzduv(this, zzdnh, zzafc) { // from class: com.google.android.gms.internal.ads.zzdib
            private final zzdhy zzgyb;
            private final zzdnh zzgyc;
            private final zzbqb zzgyd;

            {
                this.zzgyb = r1;
                this.zzgyc = r2;
                this.zzgyd = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                zzdnh zzdnh2 = this.zzgyc;
                zzbqb zzbqb = this.zzgyd;
                zzdlj zzdlj = (zzdlj) obj;
                zzdnh2.zzeua = zzdlj;
                Iterator<zzdkx> it = zzdlj.zzhbq.zzhbm.iterator();
                boolean z = false;
                boolean z2 = false;
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    Iterator<String> it2 = it.next().zzhaf.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z2 = true;
                        }
                    }
                }
                if (!z) {
                    return zzdvl.zzaf(null);
                }
                return zzbqb.zzb(zzdvl.zzaf(zzdlj));
            }
        }, this.executor).zza(new zzdsl(zzdnh) { // from class: com.google.android.gms.internal.ads.zzdia
            private final zzdnh zzgya;

            {
                this.zzgya = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                zzdnh zzdnh2 = this.zzgya;
                zzdnh2.zzhfi = (AdT) ((zzbpd) obj);
                return zzdnh2;
            }
        }, this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final /* synthetic */ Object zzasb() {
        return this.zzgxy;
    }
}
