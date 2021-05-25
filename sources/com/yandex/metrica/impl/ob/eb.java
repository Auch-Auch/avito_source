package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.List;
@TargetApi(21)
public class eb extends ScanCallback {
    @NonNull
    private final ec a;

    public eb(long j) {
        this(new ec(j));
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
        super.onBatchScanResults(list);
        this.a.a(list);
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int i) {
        super.onScanFailed(i);
        this.a.a(i);
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i, ScanResult scanResult) {
        super.onScanResult(i, scanResult);
        this.a.a(scanResult, Integer.valueOf(i));
    }

    @VisibleForTesting
    public eb(@NonNull ec ecVar) {
        this.a = ecVar;
    }
}
