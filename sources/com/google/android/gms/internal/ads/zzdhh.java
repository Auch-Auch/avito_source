package com.google.android.gms.internal.ads;
public final class zzdhh implements zzdvi<zzbnc> {
    private final /* synthetic */ zzcya zzgre;
    private final /* synthetic */ zzdhj zzgxa;
    public final /* synthetic */ zzdhc zzgxb;

    public zzdhh(zzdhc zzdhc, zzcya zzcya, zzdhj zzdhj) {
        this.zzgxb = zzdhc;
        this.zzgre = zzcya;
        this.zzgxa = zzdhj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbnc zzbnc) {
        zzbnc zzbnc2 = zzbnc;
        synchronized (this.zzgxb) {
            this.zzgxb.zzgqd = null;
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxr)).booleanValue()) {
                zzbnc2.zzaio().zza(this.zzgxb.zzgww);
            }
            this.zzgre.onSuccess(zzbnc2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        synchronized (this.zzgxb) {
            this.zzgxb.zzgqd = null;
            zzbmw zzbmw = (zzbmw) this.zzgxb.zzgwx.zzasb();
            if (zzbmw != null) {
                zzbmw.zzafd().zzg(zze);
                if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxr)).booleanValue()) {
                    this.zzgxb.zzfmk.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdhg
                        private final zzuw zzgqk;
                        private final zzdhh zzgwz;

                        {
                            this.zzgwz = r1;
                            this.zzgqk = r2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdhh zzdhh = this.zzgwz;
                            zzdhh.zzgxb.zzgww.zzg(this.zzgqk);
                        }
                    });
                }
            } else {
                this.zzgxb.zzgww.zzg(zze);
                this.zzgxb.zzb(this.zzgxa).zzafl().zzafc().zzaiw().zzajs();
            }
            zzdly.zza(zze.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzgre.zzaqe();
        }
    }
}
