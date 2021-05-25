package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
@TargetApi(21)
public class dt {
    @NonNull
    private final Context a;

    public dt(@NonNull Context context) {
        this.a = context;
    }

    @Nullable
    public BluetoothLeScanner a() {
        BluetoothAdapter bluetoothAdapter;
        BluetoothManager bluetoothManager = (BluetoothManager) this.a.getSystemService("bluetooth");
        if (bluetoothManager == null || (bluetoothAdapter = (BluetoothAdapter) dl.a(new aca<BluetoothManager, BluetoothAdapter>() { // from class: com.yandex.metrica.impl.ob.dt.1
            public BluetoothAdapter a(@NonNull BluetoothManager bluetoothManager2) throws Throwable {
                return bluetoothManager2.getAdapter();
            }
        }, bluetoothManager, "getting adapter", "BluetoothManager")) == null || !bluetoothAdapter.isEnabled()) {
            return null;
        }
        return (BluetoothLeScanner) dl.a(new aca<BluetoothAdapter, BluetoothLeScanner>() { // from class: com.yandex.metrica.impl.ob.dt.2
            public BluetoothLeScanner a(@NonNull BluetoothAdapter bluetoothAdapter2) throws Throwable {
                return bluetoothAdapter2.getBluetoothLeScanner();
            }
        }, bluetoothAdapter, "Get bluetooth LE scanner", "BluetoothAdapter");
    }
}
