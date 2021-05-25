package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.SparseArray;
@SuppressLint({"NewApi"})
public class zd implements zl<zb> {
    @SuppressLint({"InlineApi"})
    private static final SparseArray<String> a = new SparseArray<String>() { // from class: com.yandex.metrica.impl.ob.zd.1
        {
            put(0, null);
            put(7, "1xRTT");
            put(4, "CDMA");
            put(2, "EDGE");
            put(14, "eHRPD");
            put(5, "EVDO rev.0");
            put(6, "EVDO rev.A");
            put(12, "EVDO rev.B");
            put(1, "GPRS");
            put(8, "HSDPA");
            put(10, "HSPA");
            put(15, "HSPA+");
            put(9, "HSUPA");
            put(11, "iDen");
            put(3, "UMTS");
            put(12, "EVDO rev.B");
            if (dl.a(11)) {
                put(14, "eHRPD");
                put(13, "LTE");
                if (dl.a(13)) {
                    put(15, "HSPA+");
                }
            }
        }
    };
    @NonNull
    private final ze b;
    @NonNull
    private final sp c;
    @NonNull
    private final sp d;

    public zd(@NonNull ze zeVar, @NonNull final so soVar) {
        this.b = zeVar;
        if (dl.a(29)) {
            this.c = new sp() { // from class: com.yandex.metrica.impl.ob.zd.4
                @Override // com.yandex.metrica.impl.ob.sp
                public boolean a(@NonNull Context context) {
                    return soVar.b(context);
                }
            };
            this.d = new sp() { // from class: com.yandex.metrica.impl.ob.zd.5
                @Override // com.yandex.metrica.impl.ob.sp
                public boolean a(@NonNull Context context) {
                    return soVar.d(context);
                }
            };
            return;
        }
        this.c = new sp() { // from class: com.yandex.metrica.impl.ob.zd.6
            @Override // com.yandex.metrica.impl.ob.sp
            public boolean a(@NonNull Context context) {
                return soVar.c(context);
            }
        };
        this.d = new sp() { // from class: com.yandex.metrica.impl.ob.zd.7
            @Override // com.yandex.metrica.impl.ob.sp
            public boolean a(@NonNull Context context) {
                return true;
            }
        };
    }

    @Nullable
    private Integer f() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zd.8
            @SuppressLint({"MissingPermission"})
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                String networkOperator = telephonyManager.getNetworkOperator();
                String substring = !TextUtils.isEmpty(networkOperator) ? networkOperator.substring(0, 3) : null;
                if (!TextUtils.isEmpty(substring)) {
                    return Integer.valueOf(Integer.parseInt(substring));
                }
                return null;
            }
        }, this.b.c(), "getting phoneMcc", "TelephonyManager");
    }

    @Nullable
    private Integer g() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zd.9
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                String networkOperator = telephonyManager.getNetworkOperator();
                String substring = !TextUtils.isEmpty(networkOperator) ? networkOperator.substring(3) : null;
                if (!TextUtils.isEmpty(substring)) {
                    return Integer.valueOf(Integer.parseInt(substring));
                }
                return null;
            }
        }, this.b.c(), "getting phoneMnc", "TelephonyManager");
    }

    @NonNull
    private String h() {
        return (String) dl.a(new aca<TelephonyManager, String>() { // from class: com.yandex.metrica.impl.ob.zd.2
            public String a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                if (!zd.this.d.a(zd.this.b.d())) {
                    return "unknown";
                }
                return (String) zd.a.get(telephonyManager.getNetworkType(), "unknown");
            }
        }, this.b.c(), "getting networkType", "TelephonyManager", "unknown");
    }

    @Nullable
    private String i() {
        return (String) dl.a(new aca<TelephonyManager, String>() { // from class: com.yandex.metrica.impl.ob.zd.3
            public String a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                return telephonyManager.getNetworkOperatorName();
            }
        }, this.b.c(), "getting network operator name", "TelephonyManager");
    }

    @Nullable
    /* renamed from: a */
    public zb d() {
        if (this.b.i()) {
            return new zb(f(), g(), c(), b(), i(), h(), null, true, 0, null, null);
        }
        return null;
    }

    @VisibleForTesting
    @SuppressLint({"MissingPermission"})
    @Nullable
    public Integer b() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zd.10
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                if (!zd.this.c.a(zd.this.b.d())) {
                    return null;
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                int cid = gsmCellLocation != null ? gsmCellLocation.getCid() : 1;
                if (1 != cid) {
                    return Integer.valueOf(cid);
                }
                return null;
            }
        }, this.b.c(), "getting phoneCellId", "TelephonyManager");
    }

    @VisibleForTesting
    @SuppressLint({"MissingPermission"})
    @Nullable
    public Integer c() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zd.11
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                CellLocation cellLocation;
                int lac;
                if (!zd.this.c.a(zd.this.b.d()) || (cellLocation = telephonyManager.getCellLocation()) == null || 1 == (lac = ((GsmCellLocation) cellLocation).getLac())) {
                    return null;
                }
                return Integer.valueOf(lac);
            }
        }, this.b.c(), "getting phoneLac", "TelephonyManager");
    }
}
