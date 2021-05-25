package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
public final class zzbtb extends zzbxe<zzbsy> implements zzbsy {
    public zzbtb(zzbtf zzbtf, Set<zzbys<zzbsy>> set, Executor executor) {
        super(set);
        zza(zzbtf, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zza(zzcbc zzcbc) {
        zza(new zzbxg(zzcbc) { // from class: com.google.android.gms.internal.ads.zzbtd
            private final zzcbc zzfsv;

            {
                this.zzfsv = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbsy) obj).zza(this.zzfsv);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzajk() {
        zza(zzbtc.zzfst);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzh(zzuw zzuw) {
        zza(new zzbxg(zzuw) { // from class: com.google.android.gms.internal.ads.zzbta
            private final zzuw zzfsu;

            {
                this.zzfsu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbsy) obj).zzh(this.zzfsu);
            }
        });
    }
}
