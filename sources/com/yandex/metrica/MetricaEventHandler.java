package com.yandex.metrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.yandex.metrica.impl.ob.abd;
import com.yandex.metrica.impl.ob.abl;
import com.yandex.metrica.impl.ob.adr;
import com.yandex.metrica.impl.ob.ads;
import com.yandex.metrica.impl.ob.adw;
import com.yandex.metrica.impl.ob.dr;
import java.util.HashSet;
import java.util.Set;
public final class MetricaEventHandler extends BroadcastReceiver {
    public static final Set<BroadcastReceiver> a = new HashSet();
    public static final adw<BroadcastReceiver[]> b = new ads(new adr("Broadcast receivers"));

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(Constants.REFERRER);
            if (!TextUtils.isEmpty(stringExtra)) {
                dr.b(context).a(stringExtra);
            }
        }
        abl a3 = abd.a();
        for (BroadcastReceiver broadcastReceiver : a) {
            String format = String.format("Sending referrer to %s", broadcastReceiver.getClass().getName());
            if (a3.c()) {
                a3.a(format);
            }
            broadcastReceiver.onReceive(context, intent);
        }
    }
}
