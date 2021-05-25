package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
public final class zzabt {
    private MotionEvent zzcyx = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzcyy = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zzcyx.getEventTime()) {
            this.zzcyx = motionEvent;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzcyy.getEventTime()) {
            this.zzcyy = motionEvent;
        }
    }

    public final MotionEvent zzrs() {
        return this.zzcyx;
    }

    public final MotionEvent zzrt() {
        return this.zzcyy;
    }
}
