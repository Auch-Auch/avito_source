package com.yandex.runtime.sensors.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Handler;
import android.os.Looper;
import com.yandex.runtime.NativeObject;
import java.util.List;
public class BleSubscription {
    private static final String LOG_TAG = "com.yandex.runtime.sensors.internal.BleSubscription";
    private Object callback_ = null;
    private boolean isScanning_ = false;
    private NativeObject nativeObject_;

    public BleSubscription(NativeObject nativeObject) {
        this.nativeObject_ = nativeObject;
        start();
    }

    /* access modifiers changed from: private */
    public static BluetoothAdapter getBluetoothAdapter() {
        try {
            return BluetoothAdapter.getDefaultAdapter();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean isBleScanAvailable() {
        return getBluetoothAdapter() != null;
    }

    /* access modifiers changed from: private */
    public static native void scanFailed(NativeObject nativeObject);

    /* access modifiers changed from: private */
    public static native void scanResultAvailable(NativeObject nativeObject, String str, int i, byte[] bArr);

    /* access modifiers changed from: private */
    public static boolean useNewScanApi() {
        return false;
    }

    public void start() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.BleSubscription.1
            @Override // java.lang.Runnable
            public void run() {
                BluetoothAdapter bluetoothAdapter = BleSubscription.getBluetoothAdapter();
                if (bluetoothAdapter == null) {
                    BleSubscription.scanFailed(BleSubscription.this.nativeObject_);
                } else if (BleSubscription.useNewScanApi()) {
                    BleSubscription.this.callback_ = new ScanCallback() { // from class: com.yandex.runtime.sensors.internal.BleSubscription.1.1
                        @Override // android.bluetooth.le.ScanCallback
                        public void onBatchScanResults(List<ScanResult> list) {
                            for (ScanResult scanResult : list) {
                                BleSubscription.scanResultAvailable(BleSubscription.this.nativeObject_, scanResult.getDevice().getAddress(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
                            }
                        }

                        @Override // android.bluetooth.le.ScanCallback
                        public void onScanFailed(int i) {
                            BleSubscription.this.stop();
                            BleSubscription.scanFailed(BleSubscription.this.nativeObject_);
                        }

                        @Override // android.bluetooth.le.ScanCallback
                        public void onScanResult(int i, ScanResult scanResult) {
                            BleSubscription.scanResultAvailable(BleSubscription.this.nativeObject_, scanResult.getDevice().getAddress(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
                        }
                    };
                    bluetoothAdapter.getBluetoothLeScanner().startScan((ScanCallback) BleSubscription.this.callback_);
                    BleSubscription.this.isScanning_ = true;
                } else {
                    BleSubscription.this.callback_ = new BluetoothAdapter.LeScanCallback() { // from class: com.yandex.runtime.sensors.internal.BleSubscription.1.2
                        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
                        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                            BleSubscription.scanResultAvailable(BleSubscription.this.nativeObject_, bluetoothDevice.getAddress(), i, bArr);
                        }
                    };
                    bluetoothAdapter.startLeScan((BluetoothAdapter.LeScanCallback) BleSubscription.this.callback_);
                    BleSubscription.this.isScanning_ = true;
                }
            }
        });
    }

    public void stop() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.BleSubscription.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothAdapter bluetoothAdapter = BleSubscription.getBluetoothAdapter();
                if (bluetoothAdapter != null && BleSubscription.this.isScanning_) {
                    if (BleSubscription.useNewScanApi()) {
                        bluetoothAdapter.getBluetoothLeScanner().stopScan((ScanCallback) BleSubscription.this.callback_);
                    } else {
                        bluetoothAdapter.stopLeScan((BluetoothAdapter.LeScanCallback) BleSubscription.this.callback_);
                    }
                    BleSubscription.this.isScanning_ = false;
                    BleSubscription.this.callback_ = null;
                }
            }
        });
    }
}
