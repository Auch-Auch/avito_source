package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
public final class zzdaz implements zzden<zzdaw> {
    private final zzdvw zzgay;
    private final Context zzvr;

    public zzdaz(zzdvw zzdvw, Context context) {
        this.zzgay = zzdvw;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdaw> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzday
            private final zzdaz zzgti;

            {
                this.zzgti = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgti.zzaqw();
            }
        });
    }

    public final /* synthetic */ zzdaw zzaqw() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzvr.getSystemService("audio");
        return new zzdaw(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzp.zzku().zzqd(), zzp.zzku().zzqe());
    }
}
