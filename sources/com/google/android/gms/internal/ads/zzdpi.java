package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzdpi extends zzbxe<zzdpl> implements zzdpd<zzdpg> {
    public zzdpi(Set<zzbys<zzdpl>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final void zza(zzdos<zzdpg, ?> zzdos) {
        zza(new zzbxg(zzdos) { // from class: com.google.android.gms.internal.ads.zzdph
            private final zzdos zzhib;

            {
                this.zzhib = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                zzdos zzdos2 = this.zzhib;
                ((zzdpl) obj).zza((zzdpg) zzdos2.zzaux(), zzdos2.zzauy());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final void zzb(zzdos<zzdpg, ?> zzdos) {
        zza(new zzbxg(zzdos) { // from class: com.google.android.gms.internal.ads.zzdpk
            private final zzdos zzhib;

            {
                this.zzhib = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                zzdos zzdos2 = this.zzhib;
                ((zzdpl) obj).zzb((zzdpg) zzdos2.zzaux(), zzdos2.zzauy());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final void zzc(zzdos<zzdpg, ?> zzdos) {
        zza(new zzbxg(zzdos) { // from class: com.google.android.gms.internal.ads.zzdpm
            private final zzdos zzhib;

            {
                this.zzhib = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                zzdos zzdos2 = this.zzhib;
                ((zzdpl) obj).zzc((zzdpg) zzdos2.zzaux(), zzdos2.zzauy());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final void zza(zzdos<zzdpg, ?> zzdos, Throwable th) {
        zza(new zzbxg(zzdos, th) { // from class: com.google.android.gms.internal.ads.zzdpj
            private final zzdos zzhib;
            private final Throwable zzhic;

            {
                this.zzhib = r1;
                this.zzhic = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                zzdos zzdos2 = this.zzhib;
                ((zzdpl) obj).zza((zzdpg) zzdos2.zzaux(), zzdos2.zzauy(), this.zzhic);
            }
        });
    }
}
