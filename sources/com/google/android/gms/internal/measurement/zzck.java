package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
public final class zzck extends ContentObserver {
    private final /* synthetic */ zzci zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzck(zzci zzci, Handler handler) {
        super(null);
        this.zza = zzci;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
