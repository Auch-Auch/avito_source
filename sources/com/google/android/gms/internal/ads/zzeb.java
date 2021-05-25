package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
public final class zzeb implements Runnable {
    private final /* synthetic */ MotionEvent zzxs;

    public zzeb(zzdy zzdy, MotionEvent motionEvent) {
        this.zzxs = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(this.zzxs);
        } catch (Exception e) {
            zzdy.zzxg.zza(2022, -1, e);
        }
    }
}
