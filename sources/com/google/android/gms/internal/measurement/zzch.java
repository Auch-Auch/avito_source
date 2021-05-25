package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
public final class zzch extends ContentObserver {
    public zzch(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzcf.zza().set(true);
    }
}
