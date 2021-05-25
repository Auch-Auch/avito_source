package com.google.android.gms.internal.ads;
public final class zzdke implements zzdvi<zzchu> {
    private final /* synthetic */ zzcya zzgre;
    private final /* synthetic */ zzdkj zzgzp;
    public final /* synthetic */ zzdkd zzgzq;

    public zzdke(zzdkd zzdkd, zzcya zzcya, zzdkj zzdkj) {
        this.zzgzq = zzdkd;
        this.zzgre = zzcya;
        this.zzgzp = zzdkj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzchu zzchu) {
        zzchu zzchu2 = zzchu;
        synchronized (this.zzgzq) {
            zzaai<Boolean> zzaai = zzaat.zzcxq;
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                zzchu2.zzaio().zza(this.zzgzq.zzgzn);
            }
            this.zzgre.onSuccess(zzchu2);
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                this.zzgzq.zzfmk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkh
                    private final zzdke zzgzr;

                    {
                        this.zzgzr = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgzr.zzgzq.zzgzn.onAdLoaded();
                    }
                });
            }
            this.zzgzq.zzgzn.onAdMetadataChanged();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        synchronized (this.zzgzq) {
            zzchx zzchx = (zzchx) this.zzgzq.zzgwx.zzasb();
            if (zzchx != null) {
                zzchx.zzafd().zzg(zze);
                if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxq)).booleanValue()) {
                    this.zzgzq.zzfmk.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdkg
                        private final zzuw zzgqk;
                        private final zzdke zzgzr;

                        {
                            this.zzgzr = r1;
                            this.zzgqk = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdke zzdke = this.zzgzr;
                            zzdke.zzgzq.zzgzn.zzg(this.zzgqk);
                        }
                    });
                }
            } else {
                this.zzgzq.zzgzn.zzg(zze);
                this.zzgzq.zze(this.zzgzp).zzage().zzafc().zzaiw().zzajs();
            }
            zzdly.zza(zze.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzgre.zzaqe();
        }
    }
}
