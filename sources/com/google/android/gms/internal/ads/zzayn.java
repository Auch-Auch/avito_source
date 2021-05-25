package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class zzayn extends BroadcastReceiver {
    private final /* synthetic */ zzayh zzean;

    private zzayn(zzayh zzayh) {
        this.zzean = zzayh;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzean.zzyq = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzean.zzyq = false;
        }
    }

    public /* synthetic */ zzayn(zzayh zzayh, zzayj zzayj) {
        this(zzayh);
    }
}
