package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
public final class zzl implements View.OnTouchListener {
    private final /* synthetic */ zzj zzbpi;

    public zzl(zzj zzj) {
        this.zzbpi = zzj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzbpi.zzbpg == null) {
            return false;
        }
        this.zzbpi.zzbpg.zza(motionEvent);
        return false;
    }
}
