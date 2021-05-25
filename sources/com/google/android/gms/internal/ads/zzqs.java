package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class zzqs extends BroadcastReceiver {
    private final /* synthetic */ zzqq zzbry;

    public zzqs(zzqq zzqq) {
        this.zzbry = zzqq;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzbry.zzbu(3);
    }
}
