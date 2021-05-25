package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
public final class zzhi extends Handler {
    private final /* synthetic */ zzhj zzaek;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhi(zzhj zzhj, Looper looper) {
        super(looper);
        this.zzaek = zzhj;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzaek.zza(message);
    }
}
