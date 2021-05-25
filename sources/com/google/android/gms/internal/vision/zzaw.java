package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;
public final class zzaw extends ContentObserver {
    private final /* synthetic */ zzau zzfx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaw(zzau zzau, Handler handler) {
        super(null);
        this.zzfx = zzau;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zzfx.zzw();
    }
}
