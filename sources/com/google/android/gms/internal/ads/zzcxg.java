package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;
public final class zzcxg implements zzdvi<zzbni> {
    private final /* synthetic */ zzboe zzgqg;
    public final /* synthetic */ zzcxd zzgqh;

    public zzcxg(zzcxd zzcxd, zzboe zzboe) {
        this.zzgqh = zzcxd;
        this.zzgqg = zzboe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbni zzbni) {
        zzbni zzbni2 = zzbni;
        synchronized (this.zzgqh) {
            this.zzgqh.zzgqd = null;
            if (this.zzgqh.zzgpm != null) {
                this.zzgqh.zzgpm.destroy();
            }
            this.zzgqh.zzgpm = zzbni2;
            this.zzgqh.zzfnx.removeAllViews();
            if (zzbni2.zzahq() != null) {
                ViewParent parent = zzbni2.zzahq().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.zzgqh.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzbbd.zzfe(sb.toString());
                    ((ViewGroup) parent).removeView(zzbni2.zzahq());
                }
            }
            zzaai<Boolean> zzaai = zzaat.zzcxp;
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                zzbni2.zzaio().zza(this.zzgqh.zzgpw).zza(this.zzgqh.zzgpx).zza(this.zzgqh.zzgpy).zza(this.zzgqh.zzgpz);
            }
            this.zzgqh.zzfnx.addView(zzbni2.zzahq());
            zzbni2.zzahw();
            if (((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue()) {
                Executor zzadj = this.zzgqh.zzgmy.zzadj();
                zzcxm zzcxm = this.zzgqh.zzgpw;
                zzcxm.getClass();
                zzadj.execute(zzcxf.zzb(zzcxm));
            }
            this.zzgqh.zzgqa.zzdw(zzbni2.zzahv());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        synchronized (this.zzgqh) {
            this.zzgqh.zzgqd = null;
            this.zzgqg.zzafd().zzg(zze);
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxp)).booleanValue()) {
                this.zzgqh.zzgmy.zzadj().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzcxi
                    private final zzcxg zzgqj;
                    private final zzuw zzgqk;

                    {
                        this.zzgqj = r1;
                        this.zzgqk = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcxg zzcxg = this.zzgqj;
                        zzcxg.zzgqh.zzgpw.zzg(this.zzgqk);
                    }
                });
            }
            this.zzgqh.zzgqa.zzdw(60);
            zzdly.zza(zze.errorCode, th, "BannerAdManagerShim.onFailure");
        }
    }
}
