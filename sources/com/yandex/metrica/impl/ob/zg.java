package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class zg implements zl<List<String>> {
    @NonNull
    private final ze a;
    @NonNull
    private so b;

    public zg(@NonNull ze zeVar, @NonNull so soVar) {
        this.a = zeVar;
        this.b = soVar;
    }

    @NonNull
    @TargetApi(23)
    private List<String> c() {
        if (dl.a(29)) {
            return new ArrayList();
        }
        return (List) dl.a(new aca<TelephonyManager, List<String>>() { // from class: com.yandex.metrica.impl.ob.zg.2
            public List<String> a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                HashSet hashSet = new HashSet();
                if (zg.this.b.d(zg.this.a.d())) {
                    for (int i = 0; i < 10; i++) {
                        String deviceId = telephonyManager.getDeviceId(i);
                        if (deviceId != null) {
                            hashSet.add(deviceId);
                        }
                    }
                }
                return new ArrayList(hashSet);
            }
        }, this.a.c(), "getting all imeis", "TelephonyManager", new ArrayList());
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    @Nullable
    private String b() {
        return (String) dl.a(new aca<TelephonyManager, String>() { // from class: com.yandex.metrica.impl.ob.zg.1
            public String a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                if (zg.this.b.d(zg.this.a.d())) {
                    return telephonyManager.getDeviceId();
                }
                return null;
            }
        }, this.a.c(), "getting imei", "TelephonyManager");
    }

    @Nullable
    /* renamed from: a */
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        if (this.a.g()) {
            if (dl.a(23)) {
                arrayList.addAll(c());
            } else {
                arrayList.add(b());
            }
        }
        return arrayList;
    }
}
