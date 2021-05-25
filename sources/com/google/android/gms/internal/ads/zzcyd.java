package com.google.android.gms.internal.ads;
public final class zzcyd implements zzdvi<zzbpd> {
    private final /* synthetic */ zzcya zzgre;
    private final /* synthetic */ zzcbn zzgrf;
    public final /* synthetic */ zzcyc zzgrg;

    public zzcyd(zzcyc zzcyc, zzcya zzcya, zzcbn zzcbn) {
        this.zzgrg = zzcyc;
        this.zzgre = zzcya;
        this.zzgrf = zzcbn;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbpd zzbpd) {
        zzbpd zzbpd2 = zzbpd;
        synchronized (this.zzgrg) {
            zzaai<Boolean> zzaai = zzaat.zzcxt;
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                zzbpd2.zzaio().zza(this.zzgrg.zzgrc.zzaqg());
            }
            this.zzgre.onSuccess(zzbpd2);
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                this.zzgrg.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcyg
                    private final zzcyd zzgrh;

                    {
                        this.zzgrh = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgrh.zzgrg.zzgrc.zzaqi().onAdLoaded();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        this.zzgrf.zzafd().zzg(zze);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxt)).booleanValue()) {
            this.zzgrg.zzgmy.zzadj().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzcyf
                private final zzuw zzgqk;
                private final zzcyd zzgrh;

                {
                    this.zzgrh = r1;
                    this.zzgqk = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcyd zzcyd = this.zzgrh;
                    zzcyd.zzgrg.zzgrc.zzaqj().zzg(this.zzgqk);
                }
            });
        }
        zzdly.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzgre.zzaqe();
    }
}
