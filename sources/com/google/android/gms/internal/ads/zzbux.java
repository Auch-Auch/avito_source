package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzbux extends zzbxe<zzbuy> implements zzbtm, zzbuo {
    private final zzdkx zzflh;
    private AtomicBoolean zzftb = new AtomicBoolean();

    public zzbux(Set<zzbys<zzbuy>> set, zzdkx zzdkx) {
        super(set);
        this.zzflh = zzdkx;
    }

    private final void zzajm() {
        zzvl zzvl;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxg)).booleanValue() && this.zzftb.compareAndSet(false, true) && (zzvl = this.zzflh.zzhbc) != null && zzvl.type == 3) {
            zza(new zzbxg(this) { // from class: com.google.android.gms.internal.ads.zzbuw
                private final zzbux zzfta;

                {
                    this.zzfta = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzbxg
                public final void zzp(Object obj) {
                    this.zzfta.zza((zzbuy) obj);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void onAdImpression() {
        int i = this.zzflh.zzhag;
        if (i == 2 || i == 5 || i == 4) {
            zzajm();
        }
    }

    public final /* synthetic */ void zza(zzbuy zzbuy) throws Exception {
        zzbuy.zzb(this.zzflh.zzhbc);
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzajl() {
        if (this.zzflh.zzhag == 1) {
            zzajm();
        }
    }
}
