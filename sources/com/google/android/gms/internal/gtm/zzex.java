package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public class zzex extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzabm = zzex.class.getName();
    private final zzfn zzaof;

    public zzex(zzfn zzfn) {
        this.zzaof = zzfn;
    }

    public static void zzn(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzabm, true);
        context.sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (NetworkChangeReceiver.CONNECTIVITY_ACTION.equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.zzaof.zzf(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzabm)) {
            this.zzaof.zzjp();
        }
    }
}
