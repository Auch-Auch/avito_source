package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.ConfigurationServiceReceiver;
@TargetApi(26)
public class dw implements dx {
    @NonNull
    private final dt a;
    @NonNull
    private final ea b;
    @NonNull
    private final dy c;
    @NonNull
    private final PendingIntent d;

    public dw(@NonNull Context context) {
        this(new dt(context), new ea(), new dy(), PendingIntent.getBroadcast(context.getApplicationContext(), 7695436, new Intent("com.yandex.metrica.configuration.service.PLC").setClass(context, ConfigurationServiceReceiver.class), 134217728));
    }

    @Override // com.yandex.metrica.impl.ob.dx
    @SuppressLint({"MissingPermission"})
    public synchronized void a(@NonNull final xi xiVar) {
        BluetoothLeScanner a3 = this.a.a();
        if (a3 != null) {
            a();
            Integer num = (Integer) dl.a(new aca<BluetoothLeScanner, Integer>() { // from class: com.yandex.metrica.impl.ob.dw.1
                public Integer a(@NonNull BluetoothLeScanner bluetoothLeScanner) throws Exception {
                    return Integer.valueOf(bluetoothLeScanner.startScan(dw.this.c.a(xiVar.b), dw.this.b.a(xiVar.a), dw.this.d));
                }
            }, a3, "startScan", "BluetoothLeScanner");
        }
    }

    @VisibleForTesting
    public dw(@NonNull dt dtVar, @NonNull ea eaVar, @NonNull dy dyVar, @NonNull PendingIntent pendingIntent) {
        this.a = dtVar;
        this.b = eaVar;
        this.c = dyVar;
        this.d = pendingIntent;
    }

    @Override // com.yandex.metrica.impl.ob.dx
    @SuppressLint({"MissingPermission"})
    public synchronized void a() {
        BluetoothLeScanner a3 = this.a.a();
        if (a3 != null) {
            dl.a(new abz<BluetoothLeScanner>() { // from class: com.yandex.metrica.impl.ob.dw.2
                public void a(@NonNull BluetoothLeScanner bluetoothLeScanner) {
                    bluetoothLeScanner.stopScan(dw.this.d);
                }
            }, a3, "stopScan", "BluetoothLeScanner");
        }
    }
}
