package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;
public final class zzat extends ContentObserver {
    public zzat(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzaq.zzt().set(true);
    }
}
