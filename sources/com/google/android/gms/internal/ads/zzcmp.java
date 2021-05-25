package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.Nullable;
public final class zzcmp implements zzdvi<String> {
    public final /* synthetic */ zzcmi zzggp;

    public zzcmp(zzcmi zzcmi) {
        this.zzggp = zzcmi;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        String str2 = str;
        synchronized (this) {
            this.zzggp.zzggc = true;
            this.zzggp.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzp.zzkw().elapsedRealtime() - this.zzggp.zzggd));
            this.zzggp.executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.zzcms
                private final String zzdft;
                private final zzcmp zzggu;

                {
                    this.zzggu = r1;
                    this.zzdft = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcmp zzcmp = this.zzggu;
                    zzcmp.zzggp.zzgl(this.zzdft);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        synchronized (this) {
            this.zzggp.zzggc = true;
            this.zzggp.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzp.zzkw().elapsedRealtime() - this.zzggp.zzggd));
            this.zzggp.zzgge.setException(new Exception());
        }
    }
}
