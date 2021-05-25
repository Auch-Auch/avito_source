package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
public final class zzchu extends zzbpd {
    private final zzaug zzdvj;
    private final WeakReference<zzbfq> zzfur;
    private final zzbyg zzfus;
    private final zzbpx zzfuu;
    private final zzdqm zzfuv;
    private final zzbtb zzfuw;
    private final zzcaz zzfuz;
    private boolean zzgce = false;
    private final zzbui zzgcs;
    private final Context zzvr;

    public zzchu(zzbpg zzbpg, Context context, @Nullable zzbfq zzbfq, zzcaz zzcaz, zzbyg zzbyg, zzbtb zzbtb, zzbui zzbui, zzbpx zzbpx, zzdkx zzdkx, zzdqm zzdqm) {
        super(zzbpg);
        this.zzvr = context;
        this.zzfuz = zzcaz;
        this.zzfur = new WeakReference<>(zzbfq);
        this.zzfus = zzbyg;
        this.zzfuw = zzbtb;
        this.zzgcs = zzbui;
        this.zzfuu = zzbpx;
        this.zzfuv = zzdqm;
        this.zzdvj = new zzavh(zzdkx.zzdsh);
    }

    public final void finalize() throws Throwable {
        try {
            zzbfq zzbfq = this.zzfur.get();
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcww)).booleanValue()) {
                if (!this.zzgce && zzbfq != null) {
                    zzbbi.zzedy.execute(zzcht.zzh(zzbfq));
                }
            } else if (zzbfq != null) {
                zzbfq.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzgcs.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzfuu.isClosed();
    }

    public final boolean zzanh() {
        return this.zzgce;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(boolean r4, @androidx.annotation.Nullable android.app.Activity r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzaai<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaat.zzcnp
            com.google.android.gms.internal.ads.zzaap r1 = com.google.android.gms.internal.ads.zzwe.zzpu()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.ads.internal.zzp.zzkp()
            android.content.Context r0 = r3.zzvr
            boolean r0 = com.google.android.gms.internal.ads.zzayh.zzav(r0)
            if (r0 == 0) goto L_0x0048
            java.lang.String r4 = "Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzbbd.zzfe(r4)
            com.google.android.gms.internal.ads.zzbtb r4 = r3.zzfuw
            r4.zzajk()
            com.google.android.gms.internal.ads.zzaai<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzaat.zzcnq
            com.google.android.gms.internal.ads.zzaap r5 = com.google.android.gms.internal.ads.zzwe.zzpu()
            java.lang.Object r4 = r5.zzd(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzdqm r4 = r3.zzfuv
            com.google.android.gms.internal.ads.zzdlj r5 = r3.zzflg
            com.google.android.gms.internal.ads.zzdlh r5 = r5.zzhbq
            com.google.android.gms.internal.ads.zzdkz r5 = r5.zzhbn
            java.lang.String r5 = r5.zzdsg
            r4.zzhc(r5)
        L_0x0047:
            return r1
        L_0x0048:
            boolean r0 = r3.zzgce
            if (r0 == 0) goto L_0x005e
            java.lang.String r4 = "The rewarded ad have been showed."
            com.google.android.gms.internal.ads.zzbbd.zzfe(r4)
            com.google.android.gms.internal.ads.zzbtb r4 = r3.zzfuw
            int r5 = com.google.android.gms.internal.ads.zzdmd.zzhcx
            r0 = 0
            com.google.android.gms.internal.ads.zzuw r5 = com.google.android.gms.internal.ads.zzdmb.zza(r5, r0, r0)
            r4.zzh(r5)
            return r1
        L_0x005e:
            r0 = 1
            r3.zzgce = r0
            com.google.android.gms.internal.ads.zzbyg r2 = r3.zzfus
            r2.zzaiz()
            if (r5 != 0) goto L_0x006a
            android.content.Context r5 = r3.zzvr
        L_0x006a:
            com.google.android.gms.internal.ads.zzcaz r2 = r3.zzfuz     // Catch:{ zzcbc -> 0x0075 }
            r2.zza(r4, r5)     // Catch:{ zzcbc -> 0x0075 }
            com.google.android.gms.internal.ads.zzbyg r4 = r3.zzfus     // Catch:{ zzcbc -> 0x0075 }
            r4.zzaix()     // Catch:{ zzcbc -> 0x0075 }
            return r0
        L_0x0075:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzbtb r5 = r3.zzfuw
            r5.zza(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchu.zzb(boolean, android.app.Activity):boolean");
    }

    public final zzaug zzqw() {
        return this.zzdvj;
    }

    public final boolean zzqx() {
        zzbfq zzbfq = this.zzfur.get();
        return zzbfq != null && !zzbfq.zzabt();
    }
}
