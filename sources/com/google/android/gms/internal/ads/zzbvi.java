package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;
public final class zzbvi extends AdMetadataListener implements AppEventListener, zzbsu, zzbti, zzbtm, zzbuo, zzbuy, zzut {
    private final zzbwh zzftg = new zzbwh(this);
    @Nullable
    private zzcxm zzfth;
    @Nullable
    private zzcxj zzfti;
    @Nullable
    private zzcxl zzftj;
    @Nullable
    private zzcxh zzftk;
    @Nullable
    private zzdht zzftl;
    @Nullable
    private zzdje zzftm;

    private static <T> void zza(T t, zzbwg<T> zzbwg) {
        if (t != null) {
            zzbwg.zzq(t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void onAdClicked() {
        zza(this.zzfth, zzbvp.zzftn);
        zza(this.zzfti, zzbvo.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
        zza(this.zzfth, zzbvx.zzftn);
        zza(this.zzftm, zzbvz.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void onAdImpression() {
        zza(this.zzfth, zzbvs.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
        zza(this.zzfth, zzbvy.zzftn);
        zza(this.zzftm, zzbwb.zzftn);
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zza(this.zzftm, zzbvu.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
        zza(this.zzfth, zzbvl.zzftn);
        zza(this.zzftm, zzbvk.zzftn);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(this.zzftj, new zzbwg(str, str2) { // from class: com.google.android.gms.internal.ads.zzbvr
            private final String zzdft;
            private final String zzdgb;

            {
                this.zzdgb = r1;
                this.zzdft = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                ((zzcxl) obj).onAppEvent(this.zzdgb, this.zzdft);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
        zza(this.zzfth, zzbvn.zzftn);
        zza(this.zzftm, zzbvm.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
        zza(this.zzfth, zzbwa.zzftn);
        zza(this.zzftm, zzbwd.zzftn);
    }

    public final zzbwh zzaio() {
        return this.zzftg;
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzajl() {
        zza(this.zzftl, zzbvv.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
        zza(this.zzfth, new zzbwg(zzatj, str, str2) { // from class: com.google.android.gms.internal.ads.zzbwc
            private final String zzdft;
            private final String zzdin;
            private final zzatj zzfsy;

            {
                this.zzfsy = r1;
                this.zzdft = r2;
                this.zzdin = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                zzcxm zzcxm = (zzcxm) obj;
            }
        });
        zza(this.zzftm, new zzbwg(zzatj, str, str2) { // from class: com.google.android.gms.internal.ads.zzbwf
            private final String zzdft;
            private final String zzdin;
            private final zzatj zzfsy;

            {
                this.zzfsy = r1;
                this.zzdft = r2;
                this.zzdin = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                ((zzdje) obj).zzb(this.zzfsy, this.zzdft, this.zzdin);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final void zzf(zzuw zzuw) {
        zza(this.zzftm, new zzbwg(zzuw) { // from class: com.google.android.gms.internal.ads.zzbvw
            private final zzuw zzfsu;

            {
                this.zzfsu = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                ((zzdje) obj).zzf(this.zzfsu);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzb(zzvl zzvl) {
        zza(this.zzftk, new zzbwg(zzvl) { // from class: com.google.android.gms.internal.ads.zzbvq
            private final zzvl zzfto;

            {
                this.zzfto = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                ((zzcxh) obj).zzb(this.zzfto);
            }
        });
        zza(this.zzftm, new zzbwg(zzvl) { // from class: com.google.android.gms.internal.ads.zzbvt
            private final zzvl zzfto;

            {
                this.zzfto = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwg
            public final void zzq(Object obj) {
                ((zzdje) obj).zzb(this.zzfto);
            }
        });
    }
}
