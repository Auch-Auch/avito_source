package com.google.android.gms.internal.p002firebaseiid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;
/* renamed from: com.google.android.gms.internal.firebase-iid.zze  reason: invalid package */
public class zze extends Handler {
    private static zzg propagator;

    public zze() {
    }

    private void prepare(Message message, long j) {
        zzg zzg = propagator;
        if (zzg != null) {
            zzg.zza(this, message, j);
        }
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zzg zzg = propagator;
        if (zzg == null) {
            dispatchMessageTraced(message);
            return;
        }
        Object zza = zzg.zza(this, message);
        try {
            dispatchMessageTraced(message);
            zzg.zza(this, message, zza);
        } catch (Throwable th) {
            zzg.zza(this, message, zza);
            throw th;
        }
    }

    @CallSuper
    public void dispatchMessageTraced(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j) {
        prepare(message, j);
        return super.sendMessageAtTime(message, j);
    }

    public zze(Looper looper) {
        super(looper);
    }

    public zze(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
