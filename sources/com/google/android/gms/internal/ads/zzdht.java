package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
public final class zzdht implements zzbsz, zzbuo, zzdiw {
    private final zzdmt zzgxs;
    private final AtomicReference<zzsi> zzgxt = new AtomicReference<>();
    private final AtomicReference<zzsj> zzgxu = new AtomicReference<>();
    private final AtomicReference<zzbuo> zzgxv = new AtomicReference<>();
    private zzdht zzgxw = null;

    public zzdht(zzdmt zzdmt) {
        this.zzgxs = zzdmt;
    }

    public static zzdht zzb(zzdht zzdht) {
        zzdht zzdht2 = new zzdht(zzdht.zzgxs);
        zzdht2.zzb((zzdiw) zzdht);
        return zzdht2;
    }

    public final void onAdClosed() {
        zzdht zzdht = this;
        while (true) {
            zzdht zzdht2 = zzdht.zzgxw;
            if (zzdht2 != null) {
                zzdht = zzdht2;
            } else {
                zzdht.zzgxs.onAdClosed();
                zzdip.zza(zzdht.zzgxu, zzdhx.zzgxx);
                return;
            }
        }
    }

    public final void zza(zzbuo zzbuo) {
        this.zzgxv.set(zzbuo);
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzajl() {
        zzdht zzdht = this;
        while (true) {
            zzdht zzdht2 = zzdht.zzgxw;
            if (zzdht2 != null) {
                zzdht = zzdht2;
            } else {
                zzdip.zza(zzdht.zzgxv, zzdhw.zzgxx);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        zzdht zzdht = this;
        while (true) {
            zzdht zzdht2 = zzdht.zzgxw;
            if (zzdht2 != null) {
                zzdht = zzdht2;
            } else {
                zzdip.zza(zzdht.zzgxt, new zzdio(zzuw) { // from class: com.google.android.gms.internal.ads.zzdhv
                    private final zzuw zzfsu;

                    {
                        this.zzfsu = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzsi) obj).onAppOpenAdFailedToLoad(this.zzfsu.errorCode);
                    }
                });
                zzdip.zza(zzdht.zzgxt, new zzdio(zzuw) { // from class: com.google.android.gms.internal.ads.zzdhu
                    private final zzuw zzfsu;

                    {
                        this.zzfsu = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzsi) obj).zza(this.zzfsu);
                    }
                });
                return;
            }
        }
    }

    public final void zzb(zzsi zzsi) {
        this.zzgxt.set(zzsi);
    }

    public final void zzb(zzsj zzsj) {
        this.zzgxu.set(zzsj);
    }

    public final void zzb(zzsd zzsd) {
        zzdht zzdht = this;
        while (true) {
            zzdht zzdht2 = zzdht.zzgxw;
            if (zzdht2 != null) {
                zzdht = zzdht2;
            } else {
                zzdip.zza(zzdht.zzgxt, new zzdio(zzsd) { // from class: com.google.android.gms.internal.ads.zzdhs
                    private final zzsd zzgxr;

                    {
                        this.zzgxr = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdio
                    public final void zzq(Object obj) {
                        ((zzsi) obj).zza(this.zzgxr);
                    }
                });
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiw
    public final void zzb(zzdiw zzdiw) {
        this.zzgxw = (zzdht) zzdiw;
    }
}
