package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
public final class zabj extends BroadcastReceiver {
    @Nullable
    private Context zaa;
    private final zabl zab;

    public zabj(zabl zabl) {
        this.zab = zabl;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.zab.zaa();
            zaa();
        }
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final synchronized void zaa() {
        Context context = this.zaa;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.zaa = null;
    }
}
