package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zap;
public final class zaaw extends zap {
    private final /* synthetic */ zaap zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaw(zaap zaap, Looper looper) {
        super(looper);
        this.zaa = zaap;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zaa.zaf();
        } else if (i == 2) {
            this.zaa.zae();
        }
    }
}
