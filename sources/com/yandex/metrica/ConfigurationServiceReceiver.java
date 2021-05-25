package com.yandex.metrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.yandex.metrica.impl.ob.dl;
import com.yandex.metrica.impl.ob.kc;
public class ConfigurationServiceReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.yandex.metrica.configuration.service.PLC".equals(intent.getAction()) && dl.a(26)) {
            new kc(context).b(intent.getExtras());
        }
    }
}
