package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbsx extends zzbxe<zzbsz> implements zzbsz {
    public zzbsx(Set<zzbys<zzbsz>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        zza(new zzbxg(zzuw) { // from class: com.google.android.gms.internal.ads.zzbsw
            private final zzuw zzfsu;

            {
                this.zzfsu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbsz) obj).zzg(this.zzfsu);
            }
        });
    }
}
