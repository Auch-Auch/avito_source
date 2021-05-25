package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.IParamsCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class xz {
    private final Map<String, String> a = new HashMap();
    private List<String> b;
    private Map<String, String> c;
    private long d;
    private boolean e;
    @Nullable
    private aag f;
    @NonNull
    private final List<dk> g = new ArrayList();
    private final mn h;

    public xz(mn mnVar) {
        this.h = mnVar;
        Map<String, String> map = null;
        a("yandex_mobile_metrica_device_id", mnVar.b((String) null));
        a("appmetrica_device_id_hash", mnVar.c((String) null));
        a("yandex_mobile_metrica_uuid", mnVar.a((String) null));
        a("yandex_mobile_metrica_get_ad_url", mnVar.d((String) null));
        a("yandex_mobile_metrica_report_ad_url", mnVar.e((String) null));
        b(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, mnVar.f((String) null));
        this.b = mnVar.b();
        String p = mnVar.p(null);
        this.c = p != null ? abq.a(p) : map;
        this.d = mnVar.a(0);
        this.f = mnVar.i();
        h();
    }

    private void b(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            this.a.put(str, str2);
        }
    }

    private void c(Bundle bundle) {
        aag aag = (aag) bundle.getParcelable("UiAcessConfig");
        if (aag != null && aag.a()) {
            this.f = aag;
            for (dk dkVar : this.g) {
                dkVar.a(this.f);
            }
        }
    }

    private boolean d(@NonNull Bundle bundle) {
        Map<String, String> a3 = abq.a(bundle.getString("RequestClids"));
        if (dl.a((Map) this.c)) {
            return dl.a((Map) a3);
        }
        return this.c.equals(a3);
    }

    private void e(Bundle bundle) {
        b(bundle.getLong("ServerTimeOffset"));
    }

    private synchronized void f(@NonNull Bundle bundle) {
        a(bundle.getString("Uuid"));
        a("yandex_mobile_metrica_device_id", bundle.getString("DeviceId"));
        a("appmetrica_device_id_hash", bundle.getString("DeviceIdHash"));
    }

    private synchronized boolean g() {
        aag aag;
        aag = this.f;
        return aag != null && aag.a();
    }

    private void h() {
        this.h.g(this.a.get("yandex_mobile_metrica_uuid")).h(this.a.get("yandex_mobile_metrica_device_id")).i(this.a.get("appmetrica_device_id_hash")).j(this.a.get("yandex_mobile_metrica_get_ad_url")).k(this.a.get("yandex_mobile_metrica_report_ad_url")).d(this.d).l(this.a.get(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS)).o(abq.a(this.c)).a(this.f).q();
    }

    private boolean i() {
        long b2 = abu.b() - this.h.b(0);
        return b2 > 86400 || b2 < 0;
    }

    public void a(@Nullable Map<String, String> map) {
        if (!dl.a((Map) map) && !dl.a(map, this.c)) {
            this.c = new HashMap(map);
            this.e = true;
            h();
        }
    }

    private synchronized void g(Bundle bundle) {
        String string = bundle.getString("AdUrlGet");
        if (string != null) {
            b(string);
        }
        String string2 = bundle.getString("AdUrlReport");
        if (string2 != null) {
            c(string2);
        }
    }

    public synchronized boolean b() {
        return a(Arrays.asList(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, "appmetrica_device_id_hash", "yandex_mobile_metrica_device_id", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url", "yandex_mobile_metrica_uuid"));
    }

    public String e() {
        return this.a.get("yandex_mobile_metrica_device_id");
    }

    public synchronized boolean b(@NonNull List<String> list) {
        for (String str : list) {
            if (IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS.equals(str)) {
                String str2 = this.a.get(str);
                if (str2 == null || (str2.isEmpty() && !dl.a((Map) this.c))) {
                    return false;
                }
            } else if ("yandex_mobile_metrica_get_ad_url".equals(str) || "yandex_mobile_metrica_report_ad_url".equals(str)) {
                if (this.a.get(str) == null) {
                    return false;
                }
            } else if (TextUtils.isEmpty(this.a.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean a() {
        String str = this.a.get(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS);
        if (str != null && str.isEmpty()) {
            return dl.a((Map) this.c);
        }
        return true;
    }

    public aag f() {
        return this.f;
    }

    public List<String> c() {
        return this.b;
    }

    public String d() {
        return this.a.get("yandex_mobile_metrica_uuid");
    }

    public void c(List<String> list) {
        this.b = list;
        this.h.a(list);
    }

    private void a(@NonNull String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.a.put(str, str2);
        }
    }

    private synchronized void c(String str) {
        this.a.put("yandex_mobile_metrica_report_ad_url", str);
    }

    private void a(@Nullable String str) {
        if (TextUtils.isEmpty(this.a.get("yandex_mobile_metrica_uuid")) && !TextUtils.isEmpty(str)) {
            a("yandex_mobile_metrica_uuid", str);
        }
    }

    public synchronized void a(@NonNull List<String> list, Map<String, String> map) {
        for (String str : list) {
            String str2 = this.a.get(str);
            if (str2 != null) {
                map.put(str, str2);
            }
        }
    }

    private void b(Bundle bundle) {
        if (d(bundle)) {
            this.a.put(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, bundle.getString("Clids"));
            this.e = false;
        }
    }

    public synchronized boolean a(@NonNull List<String> list) {
        boolean z;
        z = false;
        boolean z2 = !b(list);
        boolean i = i();
        boolean z3 = !g();
        if (z2 || i || this.e || z3) {
            z = true;
        }
        return z;
    }

    private synchronized void b(String str) {
        this.a.put("yandex_mobile_metrica_get_ad_url", str);
    }

    private synchronized void b(long j) {
        this.d = j;
    }

    public synchronized void a(@NonNull Bundle bundle) {
        f(bundle);
        g(bundle);
        e(bundle);
        b(bundle);
        c(bundle);
        h();
    }

    public void a(@NonNull dk dkVar) {
        this.g.add(dkVar);
    }

    public void a(long j) {
        this.h.e(j).q();
    }
}
