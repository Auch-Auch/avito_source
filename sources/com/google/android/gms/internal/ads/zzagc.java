package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
public final class zzagc {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzddj;
    @Nullable
    private final NativeCustomTemplateAd.OnCustomClickListener zzddk;
    @Nullable
    @GuardedBy("this")
    private NativeCustomTemplateAd zzddl;

    public zzagc(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzddj = onCustomTemplateAdLoadedListener;
        this.zzddk = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzb(zzaes zzaes) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzddl;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzaet zzaet = new zzaet(zzaes);
        this.zzddl = zzaet;
        return zzaet;
    }

    public final zzafd zzst() {
        return new zzagd(this);
    }

    @Nullable
    public final zzafc zzsu() {
        if (this.zzddk == null) {
            return null;
        }
        return new zzage(this);
    }
}
