package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbtu extends zzbxe<zzbsu> {
    public zzbtu(Set<zzbys<zzbsu>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbtx.zzfst);
    }

    public final void onAdLeftApplication() {
        zza(zzbtw.zzfst);
    }

    public final void onAdOpened() {
        zza(zzbtz.zzfst);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbua.zzfst);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbty.zzfst);
    }

    public final void zzb(zzatj zzatj, String str, String str2) {
        zza(new zzbxg(zzatj, str, str2) { // from class: com.google.android.gms.internal.ads.zzbub
            private final String zzdft;
            private final String zzdin;
            private final zzatj zzfsy;

            {
                this.zzfsy = r1;
                this.zzdft = r2;
                this.zzdin = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((zzbsu) obj).zzb(this.zzfsy, this.zzdft, this.zzdin);
            }
        });
    }
}
