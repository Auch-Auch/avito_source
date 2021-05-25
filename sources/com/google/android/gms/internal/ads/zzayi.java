package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzayi implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzayh zzean;

    public zzayi(zzayh zzayh, Context context) {
        this.zzean = zzayh;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzean.zzeak) {
            this.zzean.zzbif = zzayh.zzar(this.val$context);
            this.zzean.zzeak.notifyAll();
        }
    }
}
