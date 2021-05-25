package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.avito.android.db.SearchSubscriptionsContract;
import com.yandex.metrica.impl.ob.r;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class dn implements r {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile dn h;
    private static final Object i = new Object();
    private final Context a;
    @Nullable
    private final WifiManager b;
    @NonNull
    private so c;
    @NonNull
    private su d;
    @NonNull
    private abr e;
    @Nullable
    private volatile BroadcastReceiver f;
    private volatile boolean g;
    private r.a<List<bx>> j;
    private yb k;
    private final sp l;
    private final sp m;
    @NonNull
    private final Cdo n;

    private dn(@NonNull Context context) {
        this(context, (WifiManager) context.getApplicationContext().getSystemService("wifi"), new su());
    }

    @Nullable
    private List<ScanResult> f() {
        return (List) dl.a(new aca<WifiManager, List<ScanResult>>() { // from class: com.yandex.metrica.impl.ob.dn.1
            public List<ScanResult> a(@NonNull WifiManager wifiManager) throws Throwable {
                return wifiManager.getScanResults();
            }
        }, this.b, "getting scan results", "WifiManager");
    }

    @Nullable
    private WifiInfo g() {
        return (WifiInfo) dl.a(new aca<WifiManager, WifiInfo>() { // from class: com.yandex.metrica.impl.ob.dn.2
            public WifiInfo a(@NonNull WifiManager wifiManager) throws Throwable {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    return connectionInfo;
                }
                if ("00:00:00:00:00:00".equals(connectionInfo.getBSSID()) || "02:00:00:00:00:00".equals(connectionInfo.getBSSID()) || connectionInfo.getIpAddress() == 0) {
                    return null;
                }
                return connectionInfo;
            }
        }, this.b, "getting connection info", "WifiManager");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NonNull
    private JSONArray h() {
        WifiInfo wifiInfo = null;
        List<ScanResult> f2 = (!m() || !this.l.a(this.a)) ? null : f();
        if (l() && this.c.e(this.a)) {
            wifiInfo = g();
        }
        return a(f2, wifiInfo);
    }

    private boolean i() {
        if (!this.c.e(this.a)) {
            return false;
        }
        return ((Boolean) dl.a(new aca<WifiManager, Boolean>() { // from class: com.yandex.metrica.impl.ob.dn.3
            public Boolean a(@NonNull WifiManager wifiManager) throws Throwable {
                return Boolean.valueOf(wifiManager.isWifiEnabled());
            }
        }, this.b, "getting wifi enabled state", "WifiManager", Boolean.FALSE)).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized boolean j() {
        return n() && this.k.o.t;
    }

    private synchronized boolean k() {
        return n() && this.k.o.s;
    }

    private synchronized boolean l() {
        return n() && this.k.o.r;
    }

    private synchronized boolean m() {
        return n() && this.k.o.q;
    }

    private synchronized boolean n() {
        return this.k != null;
    }

    @VisibleForTesting
    public synchronized void e() {
        if (this.g) {
            this.a.unregisterReceiver(this.f);
            this.g = false;
        }
    }

    @NonNull
    public JSONArray b() {
        if (!i()) {
            return new JSONArray();
        }
        return h();
    }

    public List<bx> c() {
        if (this.j.b() || this.j.c()) {
            ArrayList arrayList = new ArrayList();
            a(arrayList);
            this.j.a((r.a<List<bx>>) arrayList);
        }
        return this.j.a();
    }

    @NonNull
    public Cdo d() {
        return this.n;
    }

    private dn(@NonNull Context context, @Nullable WifiManager wifiManager, @NonNull su suVar) {
        this(context, wifiManager, suVar, new so(suVar.a()));
    }

    public static dn a(Context context) {
        if (h == null) {
            synchronized (i) {
                if (h == null) {
                    h = new dn(context.getApplicationContext());
                }
            }
        }
        return h;
    }

    @NonNull
    @TargetApi(17)
    private Long b(@NonNull ScanResult scanResult) {
        return Long.valueOf(this.e.a(scanResult.timestamp, TimeUnit.MICROSECONDS));
    }

    private dn(@NonNull Context context, @Nullable WifiManager wifiManager, @NonNull su suVar, @NonNull so soVar) {
        this(context, wifiManager, suVar, new abr(), soVar, new cf(), new Cdo());
    }

    @NonNull
    private String b(@NonNull String str) {
        return str.replace("\"", "");
    }

    @VisibleForTesting
    public dn(Context context, @Nullable WifiManager wifiManager, @NonNull su suVar, @NonNull abr abr, @NonNull so soVar, @NonNull cf cfVar, @NonNull Cdo doVar) {
        this.g = false;
        this.j = new r.a<>();
        this.a = context;
        this.b = wifiManager;
        this.d = suVar;
        this.c = soVar;
        this.l = cfVar.a(soVar);
        this.m = cfVar.b(soVar);
        this.e = abr;
        this.n = doVar;
    }

    @Nullable
    public String b(final Context context) {
        return (String) dl.a(new aca<WifiManager, String>() { // from class: com.yandex.metrica.impl.ob.dn.4
            public String a(@NonNull WifiManager wifiManager) throws Throwable {
                WifiConfiguration wifiConfiguration;
                if (!dl.a(26) && dn.this.j() && dn.this.c.e(context) && (wifiConfiguration = (WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])) != null) {
                    return wifiConfiguration.SSID;
                }
                return null;
            }
        }, this.b, "getting wifi access point name", "WifiManager");
    }

    public int c(final Context context) {
        return ((Integer) dl.a(new aca<WifiManager, Integer>() { // from class: com.yandex.metrica.impl.ob.dn.5
            public Integer a(@NonNull WifiManager wifiManager) throws Throwable {
                if (!dn.this.j() || !dn.this.c.e(context)) {
                    return null;
                }
                int intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
                if (intValue > 10) {
                    intValue -= 10;
                }
                return Integer.valueOf(intValue);
            }
        }, this.b, "getting access point state", "WifiManager", -1)).intValue();
    }

    public static synchronized void a() {
        synchronized (dn.class) {
            if (h != null) {
                h.e();
                h = null;
            }
        }
    }

    public void a(@NonNull yb ybVar) {
        this.k = ybVar;
        this.d.a(ybVar);
        this.c.a(this.d.a());
    }

    @Nullable
    private String a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US).replace(":", "");
    }

    @NonNull
    private JSONArray a(@Nullable List<ScanResult> list, @Nullable WifiInfo wifiInfo) {
        JSONObject a3;
        String str = null;
        String bssid = wifiInfo == null ? null : wifiInfo.getBSSID();
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (!(scanResult == null || "02:00:00:00:00:00".equals(scanResult.BSSID) || (a3 = a(bssid, scanResult)) == null)) {
                    jSONArray.put(a3);
                }
            }
        } else if (wifiInfo != null) {
            String a4 = a(bssid);
            String ssid = wifiInfo.getSSID();
            if (ssid != null) {
                str = b(ssid);
            }
            JSONObject a5 = a(a4, str, true, wifiInfo.getRssi(), 0L);
            if (a5 != null) {
                jSONArray.put(a5);
            }
        }
        return jSONArray;
    }

    @Nullable
    private JSONObject a(@Nullable String str, @NonNull ScanResult scanResult) {
        String str2 = null;
        boolean z = false;
        try {
            String str3 = scanResult.BSSID;
            if (str3 != null) {
                z = str3.equals(str);
                str2 = a(str3);
            }
        } catch (NoSuchFieldError unused) {
        }
        return a(str2, scanResult.SSID, z, scanResult.level, a(scanResult));
    }

    @Nullable
    private Long a(@NonNull ScanResult scanResult) {
        return b(scanResult);
    }

    @Nullable
    private JSONObject a(@Nullable String str, @Nullable String str2, boolean z, int i2, @Nullable Long l2) {
        try {
            return new JSONObject().put("mac", str).put(SearchSubscriptionsContract.Columns.SSID, str2).put("signal_strength", i2).put("is_connected", z).put("last_visible_offset_seconds", l2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(List<bx> list) {
        if (k()) {
            StringBuilder sb = new StringBuilder();
            try {
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null) {
                        for (byte b2 : hardwareAddress) {
                            sb.append(String.format(Locale.US, "%02X:", Byte.valueOf(b2)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                            list.add(new bx(networkInterface.getName(), sb.toString()));
                            sb.setLength(0);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(boolean z) {
        this.d.a(z);
        this.c.a(this.d.a());
    }

    @SuppressLint({"MissingPermission"})
    public synchronized boolean a(@NonNull final CountDownLatch countDownLatch, @NonNull final y<JSONArray> yVar) {
        if (!this.m.a(this.a)) {
            return false;
        }
        if (this.f == null) {
            this.f = new BroadcastReceiver() { // from class: com.yandex.metrica.impl.ob.dn.6
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    yVar.a(dn.this.h());
                    countDownLatch.countDown();
                    dn.this.a.unregisterReceiver(this);
                    dn.this.g = false;
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.a.registerReceiver(this.f, intentFilter);
        this.g = true;
        return aau.a((Boolean) dl.a(new aca<WifiManager, Boolean>() { // from class: com.yandex.metrica.impl.ob.dn.7
            public Boolean a(WifiManager wifiManager) throws Throwable {
                return Boolean.valueOf(wifiManager.startScan());
            }
        }, this.b, "wifi manager", "starting scan"));
    }
}
