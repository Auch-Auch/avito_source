package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;
public class zzdsf extends Handler {
    private static zzdsi zzhlj;

    public zzdsf() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }

    public zzdsf(Looper looper) {
        super(looper);
    }
}
