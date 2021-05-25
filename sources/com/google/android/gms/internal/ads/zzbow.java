package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public final class zzbow implements zzbtm, zzbuj {
    private final zzbbg zzbpa;
    @Nullable
    private final zzbfq zzdgc;
    private final zzdkx zzfpf;
    @Nullable
    @GuardedBy("this")
    private IObjectWrapper zzfpg;
    @GuardedBy("this")
    private boolean zzfph;
    private final Context zzvr;

    public zzbow(Context context, @Nullable zzbfq zzbfq, zzdkx zzdkx, zzbbg zzbbg) {
        this.zzvr = context;
        this.zzdgc = zzbfq;
        this.zzfpf = zzdkx;
        this.zzbpa = zzbbg;
    }

    private final synchronized void zzaii() {
        if (this.zzfpf.zzdsr) {
            if (this.zzdgc != null) {
                if (zzp.zzle().zzp(this.zzvr)) {
                    zzbbg zzbbg = this.zzbpa;
                    int i = zzbbg.zzedq;
                    int i2 = zzbbg.zzedr;
                    StringBuilder sb = new StringBuilder(23);
                    sb.append(i);
                    sb.append(".");
                    sb.append(i2);
                    this.zzfpg = zzp.zzle().zza(sb.toString(), this.zzdgc.getWebView(), "", "javascript", this.zzfpf.zzhay.getVideoEventsOwner());
                    View view = this.zzdgc.getView();
                    if (!(this.zzfpg == null || view == null)) {
                        zzp.zzle().zza(this.zzfpg, view);
                        this.zzdgc.zzap(this.zzfpg);
                        zzp.zzle().zzab(this.zzfpg);
                        this.zzfph = true;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void onAdImpression() {
        zzbfq zzbfq;
        if (!this.zzfph) {
            zzaii();
        }
        if (!(!this.zzfpf.zzdsr || this.zzfpg == null || (zzbfq = this.zzdgc) == null)) {
            zzbfq.zza("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (!this.zzfph) {
            zzaii();
        }
    }
}
