package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zap;
public final class zaaz extends zap {
    private final /* synthetic */ zaax zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaz(zaax zaax, Looper looper) {
        super(looper);
        this.zaa = zaax;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zaba) message.obj).zaa(this.zaa);
        } else if (i == 2) {
            throw ((RuntimeException) message.obj);
        }
    }
}
