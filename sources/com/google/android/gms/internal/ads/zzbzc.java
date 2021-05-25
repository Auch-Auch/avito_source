package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbzc extends zzbxe<zzahp> implements zzahp {
    public zzbzc(Set<zzbys<zzahp>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zza(zzaue zzaue) {
        zza(new zzbxg(zzaue) { // from class: com.google.android.gms.internal.ads.zzbze
            private final zzaue zzfup;

            {
                this.zzfup = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzahp) obj).zza(this.zzfup);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final synchronized void zzsv() {
        zza(zzbzb.zzfst);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zzsw() {
        zza(zzbzd.zzfst);
    }
}
