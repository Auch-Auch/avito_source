package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzcxh implements zzbuy {
    private final AtomicReference<zzya> zzgqi = new AtomicReference<>();

    public final void zzb(zzya zzya) {
        this.zzgqi.set(zzya);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzb(zzvl zzvl) {
        zzdip.zza(this.zzgqi, new zzdio(zzvl) { // from class: com.google.android.gms.internal.ads.zzcxk
            private final zzvl zzfto;

            {
                this.zzfto = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdio
            public final void zzq(Object obj) {
                ((zzya) obj).zza(this.zzfto);
            }
        });
    }
}
