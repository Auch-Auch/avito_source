package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
public final class zzct extends ContentObserver {
    public zzct(zzcr zzcr, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzcw.zza();
    }
}
