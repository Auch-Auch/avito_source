package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
@TargetApi(21)
public class dv implements dx {
    private static final long f = new ve.a.C0352a().d;
    @NonNull
    private final dt a;
    @NonNull
    private final ea b;
    @NonNull
    private final dy c;
    @NonNull
    private ScanCallback d;
    private long e;

    public dv(@NonNull Context context) {
        this(new dt(context), new ea(), new dy(), new eb(f));
    }

    @VisibleForTesting
    public dv(@NonNull dt dtVar, @NonNull ea eaVar, @NonNull dy dyVar, @NonNull ScanCallback scanCallback) {
        this.e = f;
        this.a = dtVar;
        this.b = eaVar;
        this.c = dyVar;
        this.d = scanCallback;
    }

    @Override // com.yandex.metrica.impl.ob.dx
    public synchronized void a(@NonNull final xi xiVar) {
        BluetoothLeScanner a3 = this.a.a();
        if (a3 != null) {
            a();
            long j = xiVar.c;
            if (this.e != j) {
                this.e = j;
                this.d = new eb(this.e);
            }
            dl.a(new abz<BluetoothLeScanner>() { // from class: com.yandex.metrica.impl.ob.dv.1
                public void a(@NonNull BluetoothLeScanner bluetoothLeScanner) {
                    bluetoothLeScanner.startScan(dv.this.c.a(xiVar.b), dv.this.b.a(xiVar.a), dv.this.d);
                }
            }, a3, "startScan", "BluetoothLeScanner");
        }
    }

    @Override // com.yandex.metrica.impl.ob.dx
    public synchronized void a() {
        BluetoothLeScanner a3 = this.a.a();
        if (a3 != null) {
            dl.a(new abz<BluetoothLeScanner>() { // from class: com.yandex.metrica.impl.ob.dv.2
                public void a(@NonNull BluetoothLeScanner bluetoothLeScanner) {
                    bluetoothLeScanner.stopScan(dv.this.d);
                }
            }, a3, "stopScan", "BluetoothLeScanner");
        }
    }
}
