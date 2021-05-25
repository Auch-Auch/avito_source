package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzrj implements Runnable {
    private final /* synthetic */ View zzbsz;
    private final /* synthetic */ zzrk zzbta;

    public zzrj(zzrk zzrk, View view) {
        this.zzbta = zzrk;
        this.zzbsz = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbta.zzj(this.zzbsz);
    }
}
