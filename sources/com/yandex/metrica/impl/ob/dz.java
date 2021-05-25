package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.SparseArray;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(21)
public class dz {
    @NonNull
    private final abt a;
    @NonNull
    private final abr b;

    public dz() {
        this(new abs(), new abr());
    }

    public JSONObject a(int i) throws JSONException {
        return new JSONObject().put("error_code", i);
    }

    @VisibleForTesting
    public dz(@NonNull abt abt, @NonNull abr abr) {
        this.a = abt;
        this.b = abr;
    }

    public JSONObject a(@NonNull ScanResult scanResult, @Nullable Integer num) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (num != null) {
            jSONObject.put("callback_type", num);
        }
        jSONObject.put("event_timestamp", this.a.b());
        jSONObject.put("rssi", scanResult.getRssi());
        jSONObject.put("observed_scan_result_offset", this.b.a(scanResult.getTimestampNanos(), TimeUnit.NANOSECONDS));
        if (dl.a(26)) {
            jSONObject.put("ad_ssid", scanResult.getAdvertisingSid());
            jSONObject.put("periodic_ad_interval", scanResult.getPeriodicAdvertisingInterval());
            jSONObject.put("primary_phy", scanResult.getPrimaryPhy());
            jSONObject.put("secondary_phy", scanResult.getSecondaryPhy());
            jSONObject.put("tx_power", scanResult.getTxPower());
        }
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null) {
            a(scanRecord, jSONObject);
        }
        BluetoothDevice device = scanResult.getDevice();
        if (device != null) {
            a(device, jSONObject);
        }
        return jSONObject;
    }

    private void a(@NonNull BluetoothDevice bluetoothDevice, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("device_address", bluetoothDevice.getAddress());
    }

    private void a(ScanRecord scanRecord, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("device_name", scanRecord.getDeviceName());
        if (scanRecord.getManufacturerSpecificData() != null) {
            jSONObject.put("manufacturer_data", a(scanRecord.getManufacturerSpecificData()));
        }
        if (scanRecord.getServiceData() != null) {
            jSONObject.put("service_data", a(scanRecord.getServiceData()));
        }
        jSONObject.put("packet_tx_power_level", scanRecord.getTxPowerLevel());
    }

    private JSONObject a(@NonNull SparseArray<byte[]> sparseArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < sparseArray.size(); i++) {
            jSONObject.put(String.valueOf(sparseArray.keyAt(i)), dh.a(sparseArray.valueAt(i)));
        }
        return jSONObject;
    }

    private JSONObject a(@NonNull Map<ParcelUuid, byte[]> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<ParcelUuid, byte[]> entry : map.entrySet()) {
            jSONObject.put(entry.getKey().toString(), dh.a(entry.getValue()));
        }
        return jSONObject;
    }
}
