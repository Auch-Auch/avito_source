package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbve extends zzbxe<zzbvj> implements zzbvj {
    public zzbve(Set<zzbys<zzbvj>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzb(zzdlj zzdlj) {
        zza(new zzbxg(zzdlj) { // from class: com.google.android.gms.internal.ads.zzbvg
            private final zzdlj zzfte;

            {
                this.zzfte = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbvj) obj).zzb(this.zzfte);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzd(zzasp zzasp) {
        zza(new zzbxg(zzasp) { // from class: com.google.android.gms.internal.ads.zzbvh
            private final zzasp zzftf;

            {
                this.zzftf = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbvj) obj).zzd(this.zzftf);
            }
        });
    }
}
