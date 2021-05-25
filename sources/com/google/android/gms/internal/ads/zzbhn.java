package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbhn implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavu zzemm;
    private final /* synthetic */ zzbhi zzepq;

    public zzbhn(zzbhi zzbhi, zzavu zzavu) {
        this.zzepq = zzbhi;
        this.zzemm = zzavu;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        zzbhi.zza(this.zzepq, view, this.zzemm, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
