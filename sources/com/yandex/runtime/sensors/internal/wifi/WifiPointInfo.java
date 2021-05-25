package com.yandex.runtime.sensors.internal.wifi;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class WifiPointInfo implements Serializable {
    private String bssid;
    private int level;
    private String ssid;

    public WifiPointInfo(ScanResult scanResult) {
        this.bssid = scanResult.BSSID;
        this.ssid = scanResult.SSID;
        this.level = scanResult.level;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.bssid = archive.add(this.bssid, false);
        this.ssid = archive.add(this.ssid, false);
        this.level = archive.add(this.level);
    }

    public WifiPointInfo(WifiInfo wifiInfo) {
        this.bssid = wifiInfo.getBSSID();
        String ssid2 = wifiInfo.getSSID();
        this.ssid = ssid2;
        if (ssid2.startsWith("\"") && this.ssid.endsWith("\"")) {
            String str = this.ssid;
            this.ssid = str.substring(1, str.length() - 1);
        }
        this.level = wifiInfo.getRssi();
    }
}
