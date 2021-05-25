package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;
public final class zzdje extends AdMetadataListener implements zzbsu, zzbsz, zzbti, zzbuj, zzbuy, zzdiw {
    private final zzdmt zzgxs;
    private final AtomicReference<AdMetadataListener> zzgzd = new AtomicReference<>();
    private final AtomicReference<zzaut> zzgze = new AtomicReference<>();
    private final AtomicReference<zzaum> zzgzf = new AtomicReference<>();
    private final AtomicReference<zzatt> zzgzg = new AtomicReference<>();
    private final AtomicReference<zzauu> zzgzh = new AtomicReference<>();
    private final AtomicReference<zzatk> zzgzi = new AtomicReference<>();
    private final AtomicReference<zzya> zzgzj = new AtomicReference<>();
    private zzdje zzgzk = null;

    public zzdje(zzdmt zzdmt) {
        this.zzgxs = zzdmt;
    }

    public static zzdje zzb(zzdje zzdje) {
        zzdje zzdje2 = new zzdje(zzdje.zzgxs);
        zzdje2.zzb((zzdiw) zzdje);
        return zzdje2;
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdje.zzgxs.onAdClosed();
                zzdip.zza(zzdje.zzgzf, zzdjw.zzgxx);
                zzdip.zza(zzdje.zzgzg, zzdjz.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzg, zzdjy.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgze, zzdjh.zzgxx);
                zzdip.zza(zzdje.zzgzg, zzdjg.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzdje zzdje = this.zzgzk;
        if (zzdje != null) {
            zzdje.onAdMetadataChanged();
        } else {
            zzdip.zza(this.zzgzd, zzdjr.zzgxx);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzf, zzdju.zzgxx);
                zzdip.zza(zzdje.zzgzg, zzdjx.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzg, zzdjm.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzg, zzdjj.zzgxx);
                return;
            }
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzgzd.set(adMetadataListener);
    }

    public final void zzc(zzya zzya) {
        this.zzgzj.set(zzya);
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final void zzf(zzuw zzuw) {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzf, new zzdio(zzuw) { // from class: com.google.android.gms.internal.ads.zzdjp
                    private final zzuw zzfsu;

                    {
                        this.zzfsu = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzaum) obj).zzd(this.zzfsu);
                    }
                });
                zzdip.zza(zzdje.zzgzf, new zzdio(zzuw) { // from class: com.google.android.gms.internal.ads.zzdjo
                    private final zzuw zzfsu;

                    {
                        this.zzfsu = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzaum) obj).onRewardedAdFailedToShow(this.zzfsu.errorCode);
                    }
                });
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                int i = zzuw.errorCode;
                zzdip.zza(zzdje.zzgze, new zzdio(zzuw) { // from class: com.google.android.gms.internal.ads.zzdjt
                    private final zzuw zzfsu;

                    {
                        this.zzfsu = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzaut) obj).zze(this.zzfsu);
                    }
                });
                zzdip.zza(zzdje.zzgze, new zzdio(i) { // from class: com.google.android.gms.internal.ads.zzdjs
                    private final int zzedo;

                    {
                        this.zzedo = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzaut) obj).onRewardedAdFailedToLoad(this.zzedo);
                    }
                });
                zzdip.zza(zzdje.zzgzg, new zzdio(i) { // from class: com.google.android.gms.internal.ads.zzdjv
                    private final int zzedo;

                    {
                        this.zzedo = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzatt) obj).onRewardedVideoAdFailedToLoad(this.zzedo);
                    }
                });
                return;
            }
        }
    }

    public final void zzb(zzaut zzaut) {
        this.zzgze.set(zzaut);
    }

    public final void zzb(zzaum zzaum) {
        this.zzgzf.set(zzaum);
    }

    public final void zzb(zzauu zzauu) {
        this.zzgzh.set(zzauu);
    }

    @Deprecated
    public final void zzb(zzatt zzatt) {
        this.zzgzg.set(zzatt);
    }

    @Deprecated
    public final void zzb(zzatk zzatk) {
        this.zzgzi.set(zzatk);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzf, new zzdio(zzatj) { // from class: com.google.android.gms.internal.ads.zzdji
                    private final zzatj zzfsy;

                    {
                        this.zzfsy = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        zzatj zzatj2 = this.zzfsy;
                        ((zzaum) obj).zza(new zzavh(zzatj2.getType(), zzatj2.getAmount()));
                    }
                });
                zzdip.zza(zzdje.zzgzh, new zzdio(zzatj, str, str2) { // from class: com.google.android.gms.internal.ads.zzdjl
                    private final String zzdft;
                    private final String zzdin;
                    private final zzatj zzfsy;

                    {
                        this.zzfsy = r1;
                        this.zzdft = r2;
                        this.zzdin = r3;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        zzatj zzatj2 = this.zzfsy;
                        ((zzauu) obj).zza(new zzavh(zzatj2.getType(), zzatj2.getAmount()), this.zzdft, this.zzdin);
                    }
                });
                zzdip.zza(zzdje.zzgzg, new zzdio(zzatj) { // from class: com.google.android.gms.internal.ads.zzdjk
                    private final zzatj zzfsy;

                    {
                        this.zzfsy = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzatt) obj).zza(this.zzfsy);
                    }
                });
                zzdip.zza(zzdje.zzgzi, new zzdio(zzatj, str, str2) { // from class: com.google.android.gms.internal.ads.zzdjn
                    private final String zzdft;
                    private final String zzdin;
                    private final zzatj zzfsy;

                    {
                        this.zzfsy = r1;
                        this.zzdft = r2;
                        this.zzdin = r3;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzatk) obj).zza(this.zzfsy, this.zzdft, this.zzdin);
                    }
                });
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzb(@NonNull zzvl zzvl) {
        zzdje zzdje = this;
        while (true) {
            zzdje zzdje2 = zzdje.zzgzk;
            if (zzdje2 != null) {
                zzdje = zzdje2;
            } else {
                zzdip.zza(zzdje.zzgzj, new zzdio(zzvl) { // from class: com.google.android.gms.internal.ads.zzdjq
                    private final zzvl zzfto;

                    {
                        this.zzfto = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzya) obj).zza(this.zzfto);
                    }
                });
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiw
    public final void zzb(zzdiw zzdiw) {
        this.zzgzk = (zzdje) zzdiw;
    }
}
