package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbfx implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavu zzemm;
    private final /* synthetic */ zzbft zzemo;

    public zzbfx(zzbft zzbft, zzavu zzavu) {
        this.zzemo = zzbft;
        this.zzemm = zzavu;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzemo.zza(view, this.zzemm, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
