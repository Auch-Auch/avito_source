package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;
public final class zzbto extends zzbxe<zzbtp> {
    public zzbto(Set<zzbys<zzbtp>> set) {
        super(set);
    }

    public final void zza(zzbzi zzbzi, Executor executor) {
        zza(zzbys.zzb(new zzbts(this, zzbzi), executor));
    }

    public final void zzbz(Context context) {
        zza(new zzbxg(context) { // from class: com.google.android.gms.internal.ads.zzbtr
            private final Context zzcxz;

            {
                this.zzcxz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbtp) obj).zzbz(this.zzcxz);
            }
        });
    }

    public final void zzca(Context context) {
        zza(new zzbxg(context) { // from class: com.google.android.gms.internal.ads.zzbtq
            private final Context zzcxz;

            {
                this.zzcxz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbtp) obj).zzca(this.zzcxz);
            }
        });
    }

    public final void zzcb(Context context) {
        zza(new zzbxg(context) { // from class: com.google.android.gms.internal.ads.zzbtt
            private final Context zzcxz;

            {
                this.zzcxz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbtp) obj).zzcb(this.zzcxz);
            }
        });
    }
}
