package com.my.target;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
public final class ex extends fb {
    public static final int[] c = hw.b(260, 272, 268, 276, 516, 520, 532, 528, 524, 512, 264, 256, 280);
    @Nullable
    public Method b;

    public ex() {
        try {
            this.b = BluetoothDevice.class.getMethod("isConnected", new Class[0]);
        } catch (Throwable unused) {
        }
    }

    @Override // com.my.target.fb
    @SuppressLint({"MissingPermission"})
    public void collectData(@NonNull Context context) {
        if (this.b != null) {
            if (!fb.a("android.permission.BLUETOOTH", context)) {
                removeAll();
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                removeAll();
                return;
            }
            Method method = this.b;
            ArrayList arrayList = new ArrayList();
            try {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (Arrays.binarySearch(c, bluetoothDevice.getBluetoothClass().getDeviceClass()) < 0) {
                        if (((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue()) {
                            String name = bluetoothDevice.getName();
                            if (!TextUtils.isEmpty(name)) {
                                arrayList.add(new String(Base64.encode(name.getBytes(), 2), "UTF-8"));
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            String str = null;
            if (!arrayList.isEmpty()) {
                str = hw.f(arrayList);
            }
            addParam("bdn", str);
        }
    }
}
