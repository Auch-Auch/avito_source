package com.my.target;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
public final class fa extends fb {
    public volatile boolean b = true;
    public volatile boolean c = true;

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            fa faVar = fa.this;
            Context context = this.a;
            if (!faVar.b) {
                faVar.removeAll();
                return;
            }
            HashMap hashMap = new HashMap();
            if (fb.a("android.permission.ACCESS_FINE_LOCATION", context) || fb.a("android.permission.ACCESS_COARSE_LOCATION", context)) {
                float f = Float.MAX_VALUE;
                long j = 0;
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                    Location location = null;
                    String str = null;
                    for (String str2 : locationManager.getAllProviders()) {
                        try {
                            Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
                            if (lastKnownLocation != null) {
                                ae.a("locationProvider: " + str2);
                                float accuracy = lastKnownLocation.getAccuracy();
                                long time = lastKnownLocation.getTime();
                                if (location == null || (time > j && accuracy < f)) {
                                    str = str2;
                                    location = lastKnownLocation;
                                    f = accuracy;
                                    j = time;
                                }
                            }
                        } catch (Throwable unused) {
                            ae.a("No permissions for get geo data");
                        }
                    }
                    if (location != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(location.getLatitude());
                        sb.append(",");
                        sb.append(location.getLongitude());
                        sb.append(",");
                        sb.append(location.getAccuracy());
                        sb.append(",");
                        sb.append(location.getSpeed());
                        sb.append(",");
                        long j2 = j / 1000;
                        sb.append(j2);
                        hashMap.put("location", sb.toString());
                        hashMap.put("location_provider", str);
                        ae.a("location: " + location.getLatitude() + ", " + location.getLongitude() + " accuracy = " + location.getAccuracy() + " speed = " + location.getSpeed() + " time = " + j2 + "  provider: " + str);
                    }
                }
            }
            if (faVar.c && fb.a("android.permission.ACCESS_WIFI_STATE", context)) {
                d dVar = new d(context);
                WifiInfo wifiInfo = dVar.a;
                if (wifiInfo != null) {
                    String bssid = wifiInfo.getBSSID();
                    if (bssid == null) {
                        bssid = "";
                    }
                    int linkSpeed = wifiInfo.getLinkSpeed();
                    int networkId = wifiInfo.getNetworkId();
                    int rssi = wifiInfo.getRssi();
                    String ssid = wifiInfo.getSSID();
                    if (ssid == null) {
                        ssid = "";
                    }
                    hashMap.put("wifi", bssid + "," + ssid + "," + rssi + "," + networkId + "," + linkSpeed);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mac: ");
                    sb2.append(wifiInfo.getMacAddress());
                    ae.a(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("ip: ");
                    sb3.append(wifiInfo.getIpAddress());
                    ae.a(sb3.toString());
                    ae.a("wifi: " + bssid + "," + ssid + "," + rssi + "," + networkId + "," + linkSpeed);
                }
                List<ScanResult> list = dVar.b;
                if (list != null) {
                    int i2 = 1;
                    for (ScanResult scanResult : list) {
                        if (i2 < 6) {
                            ae.a(scanResult.level + "");
                            String str3 = scanResult.BSSID;
                            if (str3 == null) {
                                str3 = "";
                            }
                            String str4 = scanResult.SSID;
                            if (str4 == null) {
                                str4 = "";
                            }
                            hashMap.put(a2.b.a.a.a.M2("wifi", i2), str3 + "," + str4 + "," + scanResult.level);
                            ae.a("wifi" + i2 + ": " + str3 + "," + str4 + "," + scanResult.level);
                            i2++;
                        }
                    }
                }
            }
            if (faVar.c && fb.a("android.permission.ACCESS_COARSE_LOCATION", context)) {
                b bVar = new b(context);
                if (bVar.a != null) {
                    int i3 = 0;
                    while (i3 < bVar.a.size()) {
                        StringBuilder sb4 = new StringBuilder();
                        c cVar = bVar.a.get(i3);
                        if (!"cdma".equals(cVar.a)) {
                            sb4.append(cVar.a);
                            sb4.append(",");
                            sb4.append(cVar.b);
                            sb4.append(",");
                            sb4.append(cVar.c);
                            sb4.append(",");
                            sb4.append(cVar.d);
                            sb4.append(",");
                            sb4.append(cVar.e);
                            sb4.append(",");
                            sb4.append(cVar.f);
                            sb4.append(",");
                            sb4.append(cVar.g);
                            sb4.append(",");
                            sb4.append(cVar.h);
                            sb4.append(",");
                            sb4.append(cVar.i);
                            sb4.append(",");
                            sb4.append(cVar.j);
                            sb4.append(",");
                            sb4.append(cVar.k);
                            sb4.append(",");
                            sb4.append(cVar.l);
                            sb4.append(",");
                            i = cVar.m;
                        } else {
                            sb4.append(cVar.n);
                            sb4.append(",");
                            sb4.append(cVar.o);
                            sb4.append(",");
                            sb4.append(cVar.p);
                            sb4.append(",");
                            sb4.append(cVar.q);
                            sb4.append(",");
                            sb4.append(cVar.r);
                            sb4.append(",");
                            sb4.append(cVar.s);
                            sb4.append(",");
                            sb4.append(cVar.f);
                            sb4.append(",");
                            sb4.append(cVar.t);
                            sb4.append(",");
                            sb4.append(cVar.h);
                            sb4.append(",");
                            sb4.append(cVar.u);
                            sb4.append(",");
                            sb4.append(cVar.g);
                            sb4.append(",");
                            sb4.append(cVar.v);
                            sb4.append(",");
                            sb4.append(cVar.w);
                            sb4.append(",");
                            sb4.append(cVar.x);
                            sb4.append(",");
                            i = cVar.y;
                        }
                        sb4.append(i);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("cell");
                        sb5.append(i3 != 0 ? Integer.valueOf(i3) : "");
                        hashMap.put(sb5.toString(), sb4.toString());
                        i3++;
                    }
                }
            }
            synchronized (faVar) {
                faVar.removeAll();
                faVar.addParams(hashMap);
            }
        }
    }

    public static class b {
        @Nullable
        public ArrayList<c> a = null;

        public b(@NonNull Context context) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    int i = Build.VERSION.SDK_INT;
                    if ((i < 29 && fb.a("android.permission.ACCESS_COARSE_LOCATION", context)) || fb.a("android.permission.ACCESS_FINE_LOCATION", context)) {
                        this.a = b(telephonyManager);
                    }
                    ArrayList<c> arrayList = this.a;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        return;
                    }
                    if ((i < 29 && fb.a("android.permission.ACCESS_COARSE_LOCATION", context)) || fb.a("android.permission.ACCESS_FINE_LOCATION", context)) {
                        this.a = a(telephonyManager);
                    }
                } catch (Throwable th) {
                    a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Environment provider error "));
                }
            }
        }

        @Nullable
        @SuppressLint({"MissingPermission"})
        public final ArrayList<c> a(@NonNull TelephonyManager telephonyManager) {
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (!(cellLocation instanceof GsmCellLocation)) {
                return null;
            }
            ArrayList<c> arrayList = new ArrayList<>();
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c cVar = new c("gsm");
            arrayList.add(cVar);
            cVar.b = gsmCellLocation.getCid();
            cVar.c = gsmCellLocation.getLac();
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!(networkOperator == null || networkOperator.length() == 0)) {
                try {
                    cVar.d = Integer.parseInt(networkOperator.substring(0, 3));
                    cVar.e = Integer.parseInt(networkOperator.substring(3));
                } catch (Throwable unused) {
                    a2.b.a.a.a.U0("unable to substring network operator ", networkOperator);
                }
            }
            StringBuilder L = a2.b.a.a.a.L("current cell: ");
            L.append(cVar.b);
            L.append(",");
            L.append(cVar.c);
            L.append(",");
            L.append(cVar.d);
            L.append(",");
            L.append(cVar.e);
            ae.a(L.toString());
            return arrayList;
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @TargetApi(17)
        public final ArrayList<c> b(@NonNull TelephonyManager telephonyManager) {
            c cVar;
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null) {
                return null;
            }
            ArrayList<c> arrayList = new ArrayList<>();
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    if (cellInfo instanceof CellInfoLte) {
                        cVar = new c("lte");
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                        cVar.b = cellIdentity.getCi();
                        cVar.c = Integer.MAX_VALUE;
                        cVar.d = cellIdentity.getMcc();
                        cVar.e = cellIdentity.getMnc();
                        cVar.f = cellSignalStrength.getLevel();
                        cVar.g = cellSignalStrength.getDbm();
                        cVar.h = cellSignalStrength.getAsuLevel();
                        cVar.i = cellSignalStrength.getTimingAdvance();
                        if (Build.VERSION.SDK_INT >= 24) {
                            cVar.j = cellIdentity.getEarfcn();
                        }
                        cVar.k = Integer.MAX_VALUE;
                        cVar.l = Integer.MAX_VALUE;
                        cVar.m = cellIdentity.getTac();
                    } else if (cellInfo instanceof CellInfoGsm) {
                        cVar = new c("gsm");
                        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                        CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                        CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                        cVar.b = cellIdentity2.getCid();
                        cVar.c = cellIdentity2.getLac();
                        cVar.d = cellIdentity2.getMcc();
                        cVar.e = cellIdentity2.getMnc();
                        cVar.f = cellSignalStrength2.getLevel();
                        cVar.g = cellSignalStrength2.getDbm();
                        cVar.h = cellSignalStrength2.getAsuLevel();
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 26) {
                            cVar.i = cellSignalStrength2.getTimingAdvance();
                        } else {
                            cVar.i = Integer.MAX_VALUE;
                        }
                        cVar.j = Integer.MAX_VALUE;
                        if (i >= 24) {
                            cVar.k = cellIdentity2.getBsic();
                        }
                        cVar.l = cellIdentity2.getPsc();
                        cVar.m = Integer.MAX_VALUE;
                    } else {
                        int i2 = Build.VERSION.SDK_INT;
                        if (cellInfo instanceof CellInfoWcdma) {
                            c cVar2 = new c("wcdma");
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                            CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                            CellSignalStrengthWcdma cellSignalStrength3 = cellInfoWcdma.getCellSignalStrength();
                            cVar2.b = cellIdentity3.getCid();
                            cVar2.c = cellIdentity3.getLac();
                            cVar2.d = cellIdentity3.getMcc();
                            cVar2.e = cellIdentity3.getMnc();
                            cVar2.f = cellSignalStrength3.getLevel();
                            cVar2.g = cellSignalStrength3.getDbm();
                            cVar2.h = cellSignalStrength3.getAsuLevel();
                            cVar2.i = Integer.MAX_VALUE;
                            if (i2 >= 24) {
                                cVar2.j = cellIdentity3.getUarfcn();
                            }
                            cVar2.k = Integer.MAX_VALUE;
                            cVar2.l = cellIdentity3.getPsc();
                            cVar2.m = Integer.MAX_VALUE;
                            cVar = cVar2;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            cVar = new c("cdma");
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            CellIdentityCdma cellIdentity4 = cellInfoCdma.getCellIdentity();
                            CellSignalStrengthCdma cellSignalStrength4 = cellInfoCdma.getCellSignalStrength();
                            cVar.n = cellIdentity4.getNetworkId();
                            cVar.o = cellIdentity4.getSystemId();
                            cVar.p = cellIdentity4.getBasestationId();
                            cVar.q = cellIdentity4.getLatitude();
                            cVar.r = cellIdentity4.getLongitude();
                            cVar.s = cellSignalStrength4.getCdmaLevel();
                            cVar.f = cellSignalStrength4.getLevel();
                            cVar.t = cellSignalStrength4.getEvdoLevel();
                            cVar.h = cellSignalStrength4.getAsuLevel();
                            cVar.u = cellSignalStrength4.getCdmaDbm();
                            cVar.g = cellSignalStrength4.getDbm();
                            cVar.v = cellSignalStrength4.getEvdoDbm();
                            cVar.w = cellSignalStrength4.getEvdoEcio();
                            cVar.x = cellSignalStrength4.getCdmaEcio();
                            cVar.y = cellSignalStrength4.getEvdoSnr();
                        }
                    }
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    public static class c {
        public final String a;
        public int b = Integer.MAX_VALUE;
        public int c = Integer.MAX_VALUE;
        public int d = Integer.MAX_VALUE;
        public int e = Integer.MAX_VALUE;
        public int f = Integer.MAX_VALUE;
        public int g = Integer.MAX_VALUE;
        public int h = Integer.MAX_VALUE;
        public int i = Integer.MAX_VALUE;
        public int j = Integer.MAX_VALUE;
        public int k = Integer.MAX_VALUE;
        public int l = Integer.MAX_VALUE;
        public int m = Integer.MAX_VALUE;
        public int n = Integer.MAX_VALUE;
        public int o = Integer.MAX_VALUE;
        public int p = Integer.MAX_VALUE;
        public int q = Integer.MAX_VALUE;
        public int r = Integer.MAX_VALUE;
        public int s = Integer.MAX_VALUE;
        public int t = Integer.MAX_VALUE;
        public int u = Integer.MAX_VALUE;
        public int v = Integer.MAX_VALUE;
        public int w = Integer.MAX_VALUE;
        public int x = Integer.MAX_VALUE;
        public int y = Integer.MAX_VALUE;

        public c(String str) {
            this.a = str;
        }
    }

    public static class d {
        public WifiInfo a;
        public List<ScanResult> b;

        public class a implements Comparator<ScanResult> {
            public a(d dVar) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public int compare(ScanResult scanResult, ScanResult scanResult2) {
                int i = scanResult.level;
                int i2 = scanResult2.level;
                if (i < i2) {
                    return 1;
                }
                return i > i2 ? -1 : 0;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            if (r4 == false) goto L_0x0040;
         */
        @android.annotation.SuppressLint({"MissingPermission"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(@androidx.annotation.NonNull android.content.Context r4) {
            /*
                r3 = this;
                r3.<init>()
                android.content.Context r0 = r4.getApplicationContext()     // Catch:{ all -> 0x004d }
                java.lang.String r1 = "wifi"
                java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x004d }
                android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch:{ all -> 0x004d }
                if (r0 != 0) goto L_0x0012
                return
            L_0x0012:
                boolean r1 = r0.isWifiEnabled()     // Catch:{ all -> 0x004d }
                if (r1 == 0) goto L_0x0052
                android.net.wifi.WifiInfo r1 = r0.getConnectionInfo()     // Catch:{ all -> 0x004d }
                r3.a = r1     // Catch:{ all -> 0x004d }
                int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x004d }
                r2 = 24
                if (r1 < r2) goto L_0x003a
                java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
                boolean r1 = com.my.target.fb.a(r1, r4)     // Catch:{ all -> 0x004d }
                if (r1 != 0) goto L_0x0037
                java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
                boolean r4 = com.my.target.fb.a(r1, r4)     // Catch:{ all -> 0x004d }
                if (r4 == 0) goto L_0x0035
                goto L_0x0037
            L_0x0035:
                r4 = 0
                goto L_0x0038
            L_0x0037:
                r4 = 1
            L_0x0038:
                if (r4 == 0) goto L_0x0040
            L_0x003a:
                java.util.List r4 = r0.getScanResults()     // Catch:{ all -> 0x004d }
                r3.b = r4     // Catch:{ all -> 0x004d }
            L_0x0040:
                java.util.List<android.net.wifi.ScanResult> r4 = r3.b     // Catch:{ all -> 0x004d }
                if (r4 == 0) goto L_0x0052
                com.my.target.fa$d$a r0 = new com.my.target.fa$d$a     // Catch:{ all -> 0x004d }
                r0.<init>(r3)     // Catch:{ all -> 0x004d }
                java.util.Collections.sort(r4, r0)     // Catch:{ all -> 0x004d }
                goto L_0x0052
            L_0x004d:
                java.lang.String r4 = "No permissions for access to wifi state"
                com.my.target.ae.a(r4)
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.fa.d.<init>(android.content.Context):void");
        }
    }

    public void A(boolean z) {
        this.c = z;
    }

    public void B(boolean z) {
        this.b = z;
    }

    @Override // com.my.target.fb
    public void collectData(@NonNull Context context) {
        af.b(new a(context));
    }
}
