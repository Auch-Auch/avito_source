package com.google.android.gms.internal.ads;
public final class zzcxn implements zzdvi<zzbzr> {
    private final /* synthetic */ zzcar zzgqo;
    public final /* synthetic */ zzcxo zzgqp;

    public zzcxn(zzcxo zzcxo, zzcar zzcar) {
        this.zzgqp = zzcxo;
        this.zzgqo = zzcar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbzr zzbzr) {
        zzbzr zzbzr2 = zzbzr;
        synchronized (this.zzgqp) {
            this.zzgqp.zzgqd = null;
            this.zzgqp.zzgqr = zzbzr2;
            zzaai<Boolean> zzaai = zzaat.zzcxs;
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                zzbzr2.zzaio().zza(this.zzgqp.zzgpw).zza(this.zzgqp.zzgpy).zza(this.zzgqp.zzgpz).zza(this.zzgqp.zzgqq);
            }
            zzbzr2.zzahw();
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                this.zzgqp.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcxq
                    private final zzcxn zzgqt;

                    {
                        this.zzgqt = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgqt.zzgqp.zzgpw.onAdLoaded();
                    }
                });
                this.zzgqp.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcxp
                    private final zzcxn zzgqt;

                    {
                        this.zzgqt = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgqt.zzgqp.zzgqq.onAdLoaded();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        synchronized (this.zzgqp) {
            this.zzgqp.zzgqd = null;
            this.zzgqo.zzafd().zzg(zze);
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxp)).booleanValue()) {
                this.zzgqp.zzgmy.zzadj().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzcxs
                    private final zzuw zzgqk;
                    private final zzcxn zzgqt;

                    {
                        this.zzgqt = r1;
                        this.zzgqk = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcxn zzcxn = this.zzgqt;
                        zzcxn.zzgqp.zzgpw.zzg(this.zzgqk);
                    }
                });
                this.zzgqp.zzgmy.zzadj().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzcxr
                    private final zzuw zzgqk;
                    private final zzcxn zzgqt;

                    {
                        this.zzgqt = r1;
                        this.zzgqk = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcxn zzcxn = this.zzgqt;
                        zzcxn.zzgqp.zzgqq.zzg(this.zzgqk);
                    }
                });
            }
            zzdly.zza(zze.errorCode, th, "InterstitialAdManagerShim.onFailure");
        }
    }
}
