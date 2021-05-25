package com.google.android.gms.internal.ads;
public final class zzalz {
    private zzakk zzdie;
    private zzdvt<zzali> zzdif;

    public zzalz(zzakk zzakk) {
        this.zzdie = zzakk;
    }

    private final void zztm() {
        if (this.zzdif == null) {
            zzbbq zzbbq = new zzbbq();
            this.zzdif = zzbbq;
            this.zzdie.zzb((zzeg) null).zza(new zzbbu(zzbbq) { // from class: com.google.android.gms.internal.ads.zzamc
                private final zzbbq zzbvp;

                {
                    this.zzbvp = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzbbu
                public final void zzh(Object obj) {
                    this.zzbvp.set((zzali) obj);
                }
            }, new zzbbs(zzbbq) { // from class: com.google.android.gms.internal.ads.zzamb
                private final zzbbq zzbvp;

                {
                    this.zzbvp = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzbbs
                public final void run() {
                    this.zzbvp.setException(new zzalj("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final <I, O> zzamg<I, O> zzb(String str, zzaln<I> zzaln, zzalo<O> zzalo) {
        zztm();
        return new zzamg<>(this.zzdif, str, zzaln, zzalo);
    }

    public final void zzc(String str, zzahf<? super zzali> zzahf) {
        zztm();
        this.zzdif = zzdvl.zzb(this.zzdif, new zzduv(str, zzahf) { // from class: com.google.android.gms.internal.ads.zzame
            private final zzahf zzdfx;
            private final String zzdgb;

            {
                this.zzdgb = r1;
                this.zzdfx = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                zzali zzali = (zzali) obj;
                zzali.zza(this.zzdgb, this.zzdfx);
                return zzdvl.zzaf(zzali);
            }
        }, zzbbi.zzedz);
    }

    public final void zzd(String str, zzahf<? super zzali> zzahf) {
        this.zzdif = zzdvl.zzb(this.zzdif, new zzdsl(str, zzahf) { // from class: com.google.android.gms.internal.ads.zzamd
            private final zzahf zzdfx;
            private final String zzdgb;

            {
                this.zzdgb = r1;
                this.zzdfx = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                zzali zzali = (zzali) obj;
                zzali.zzb(this.zzdgb, this.zzdfx);
                return zzali;
            }
        }, zzbbi.zzedz);
    }
}
