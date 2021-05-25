package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class zzbao extends BroadcastReceiver {
    private final /* synthetic */ zzbap zzecr;

    public zzbao(zzbap zzbap) {
        this.zzecr = zzbap;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzecr.zzc(context, intent);
    }
}
