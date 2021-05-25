package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
public class zj implements zl<List<zi>> {
    @NonNull
    private final ze a;
    @NonNull
    private so b;

    public zj(@NonNull ze zeVar, @NonNull so soVar) {
        this.a = zeVar;
        this.b = soVar;
    }

    @Nullable
    private Integer c() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zj.1
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                String simOperator = telephonyManager.getSimOperator();
                String substring = !TextUtils.isEmpty(simOperator) ? simOperator.substring(0, 3) : null;
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(substring));
            }
        }, this.a.c(), "getting SimMcc", "TelephonyManager");
    }

    @Nullable
    private Integer e() {
        return (Integer) dl.a(new aca<TelephonyManager, Integer>() { // from class: com.yandex.metrica.impl.ob.zj.2
            public Integer a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                String simOperator = telephonyManager.getSimOperator();
                String substring = !TextUtils.isEmpty(simOperator) ? simOperator.substring(3) : null;
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(substring));
            }
        }, this.a.c(), "getting SimMnc", "TelephonyManager");
    }

    @Nullable
    private String f() {
        return (String) dl.a(new aca<TelephonyManager, String>() { // from class: com.yandex.metrica.impl.ob.zj.3
            public String a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                return telephonyManager.getSimOperatorName();
            }
        }, this.a.c(), "getting SimOperatorName", "TelephonyManager");
    }

    @NonNull
    @TargetApi(23)
    private List<zi> g() {
        ArrayList arrayList = new ArrayList();
        if (this.b.d(this.a.d())) {
            try {
                List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(this.a.d()).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null) {
                    for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                        arrayList.add(new zi(subscriptionInfo));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private boolean h() {
        return ((Boolean) dl.a(new aca<TelephonyManager, Boolean>() { // from class: com.yandex.metrica.impl.ob.zj.4
            public Boolean a(@NonNull TelephonyManager telephonyManager) throws Throwable {
                if (zj.this.b.d(zj.this.a.d())) {
                    return Boolean.valueOf(telephonyManager.isNetworkRoaming());
                }
                return null;
            }
        }, this.a.c(), "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE)).booleanValue();
    }

    private zi b() {
        return new zi(c(), e(), h(), f(), null);
    }

    @Nullable
    /* renamed from: a */
    public List<zi> d() {
        ArrayList arrayList = new ArrayList();
        if (this.a.h()) {
            if (dl.a(23)) {
                arrayList.addAll(g());
                if (arrayList.size() == 0) {
                    arrayList.add(b());
                }
            } else {
                arrayList.add(b());
            }
        }
        return arrayList;
    }
}
