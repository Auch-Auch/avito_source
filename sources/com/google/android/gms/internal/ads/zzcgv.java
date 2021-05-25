package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
public final class zzcgv implements zzadk {
    private final /* synthetic */ zzcgw zzgcg;

    public zzcgv(zzcgw zzcgw) {
        this.zzgcg = zzcgw;
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzse() {
        if (this.zzgcg.zzfyz != null) {
            this.zzgcg.zzfyz.zzfz(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
        }
    }
}
