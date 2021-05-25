package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztw;
import java.util.HashMap;
public final class zzcbb implements zzo, zzbuj {
    private final zzbbg zzbpa;
    @Nullable
    private final zzbfq zzdgc;
    private final zzdkx zzfpf;
    @Nullable
    @VisibleForTesting
    private IObjectWrapper zzfpg;
    private final zztw.zza.EnumC0204zza zzfvf;
    private final Context zzvr;

    public zzcbb(Context context, @Nullable zzbfq zzbfq, zzdkx zzdkx, zzbbg zzbbg, zztw.zza.EnumC0204zza zza) {
        this.zzvr = context;
        this.zzdgc = zzbfq;
        this.zzfpf = zzdkx;
        this.zzbpa = zzbbg;
        this.zzfvf = zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zztw.zza.EnumC0204zza zza = this.zzfvf;
        if ((zza == zztw.zza.EnumC0204zza.REWARD_BASED_VIDEO_AD || zza == zztw.zza.EnumC0204zza.INTERSTITIAL) && this.zzfpf.zzdsr && this.zzdgc != null && zzp.zzle().zzp(this.zzvr)) {
            zzbbg zzbbg = this.zzbpa;
            int i = zzbbg.zzedq;
            int i2 = zzbbg.zzedr;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            IObjectWrapper zza2 = zzp.zzle().zza(sb.toString(), this.zzdgc.getWebView(), "", "javascript", this.zzfpf.zzhay.getVideoEventsOwner());
            this.zzfpg = zza2;
            if (zza2 != null && this.zzdgc.getView() != null) {
                zzp.zzle().zza(this.zzfpg, this.zzdgc.getView());
                this.zzdgc.zzap(this.zzfpg);
                zzp.zzle().zzab(this.zzfpg);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
        this.zzfpg = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
        zzbfq zzbfq;
        if (this.zzfpg != null && (zzbfq = this.zzdgc) != null) {
            zzbfq.zza("onSdkImpression", new HashMap());
        }
    }
}
