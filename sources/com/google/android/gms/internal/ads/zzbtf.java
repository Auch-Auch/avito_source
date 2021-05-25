package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;
@VisibleForTesting
public final class zzbtf extends zzbxe<zzbti> implements zzbsy {
    @VisibleForTesting
    public zzbtf(Set<zzbys<zzbti>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zza(zzcbc zzcbc) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzajk() {
        zza(zzbth.zzfst);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzh(zzuw zzuw) {
        zza(new zzbxg(zzuw) { // from class: com.google.android.gms.internal.ads.zzbte
            private final zzuw zzfsu;

            {
                this.zzfsu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbti) obj).zzf(this.zzfsu);
            }
        });
    }
}
