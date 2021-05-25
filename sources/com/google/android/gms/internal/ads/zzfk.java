package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class zzfk extends BroadcastReceiver {
    private final /* synthetic */ zzfi zzaag;

    public zzfk(zzfi zzfi) {
        this.zzaag = zzfi;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzaag.zzcv();
    }
}
