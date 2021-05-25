package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IParamsCallback;
import com.yandex.metrica.impl.ob.ab;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
public class xw implements xx {
    public static final Map<xv, IParamsCallback.Reason> a = Collections.unmodifiableMap(new HashMap<xv, IParamsCallback.Reason>() { // from class: com.yandex.metrica.impl.ob.xw.1
        {
            put(xv.UNKNOWN, IParamsCallback.Reason.UNKNOWN);
            put(xv.NETWORK, IParamsCallback.Reason.NETWORK);
            put(xv.PARSE, IParamsCallback.Reason.INVALID_RESPONSE);
        }
    });
    private final List<String> b;
    private final cs c;
    private final xz d;
    @NonNull
    private final Handler e;
    @Nullable
    private abl f;
    private final ab.a g;
    private final Object h;
    private final Map<xm, List<String>> i;
    private Map<String, String> j;

    public xw(cs csVar, mn mnVar, @NonNull Handler handler) {
        this(csVar, new xz(mnVar), handler);
    }

    private void e() {
        WeakHashMap weakHashMap = new WeakHashMap();
        for (Map.Entry<xm, List<String>> entry : this.i.entrySet()) {
            if (this.d.b(entry.getValue())) {
                weakHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : weakHashMap.entrySet()) {
            xm xmVar = (xm) entry2.getKey();
            if (xmVar != null) {
                a(xmVar);
            }
        }
        weakHashMap.clear();
    }

    @Override // com.yandex.metrica.impl.ob.xx
    public String a() {
        return this.d.d();
    }

    public String b() {
        return this.d.e();
    }

    public void c() {
        synchronized (this.h) {
            if (this.d.b()) {
                b(this.j);
            }
        }
    }

    @Nullable
    public aag d() {
        return this.d.f();
    }

    @VisibleForTesting
    public xw(cs csVar, @NonNull xz xzVar, @NonNull Handler handler) {
        this.b = Arrays.asList("yandex_mobile_metrica_uuid", "yandex_mobile_metrica_device_id", "appmetrica_device_id_hash", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url", IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS);
        this.h = new Object();
        this.i = new WeakHashMap();
        this.c = csVar;
        this.d = xzVar;
        this.e = handler;
        this.g = new ab.a() { // from class: com.yandex.metrica.impl.ob.xw.2
            @Override // com.yandex.metrica.impl.ob.ab.a
            public void a(int i2, @NonNull Bundle bundle) {
            }
        };
    }

    private void b(@Nullable Map<String, String> map) {
        a(this.b, map);
    }

    public void a(IIdentifierCallback iIdentifierCallback, @NonNull List<String> list, @Nullable Map<String, String> map) {
        a(new xj(iIdentifierCallback), list, map);
    }

    private void a(final xm xmVar, @NonNull List<String> list, @Nullable Map<String, String> map) {
        synchronized (this.h) {
            this.d.a(map);
            b(xmVar, list);
            if (this.d.a(list)) {
                a(list, new ab.a() { // from class: com.yandex.metrica.impl.ob.xw.3
                    @Override // com.yandex.metrica.impl.ob.ab.a
                    public void a(int i2, Bundle bundle) {
                        xw.this.a(i2, bundle, xmVar);
                    }
                }, map);
            } else {
                a(xmVar);
            }
        }
    }

    public void b(@Nullable String str) {
        synchronized (this.h) {
            this.c.c(str);
        }
    }

    @Nullable
    private Map<String, String> b(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        this.d.a(list, hashMap);
        return hashMap;
    }

    private void b(xm xmVar, List<String> list) {
        if (this.i.isEmpty()) {
            this.c.c();
        }
        this.i.put(xmVar, list);
    }

    private void b(xm xmVar) {
        this.i.remove(xmVar);
        if (this.i.isEmpty()) {
            this.c.d();
        }
    }

    public void a(int i2, @NonNull Bundle bundle) {
        a(i2, bundle, (xm) null);
    }

    public void a(int i2, @NonNull Bundle bundle, @Nullable xm xmVar) {
        synchronized (this.h) {
            a(bundle, i2);
            e();
            if (xmVar != null) {
                a(xmVar, bundle);
            }
        }
    }

    public void a(@NonNull abl abl) {
        this.f = abl;
    }

    private void a(@NonNull List<String> list, @Nullable Map<String, String> map) {
        a(list, this.g, map);
    }

    private void a(@NonNull List<String> list, @NonNull ab.a aVar, @Nullable Map<String, String> map) {
        this.c.a(list, new ab(this.e, aVar), map);
    }

    @SuppressLint({"VisibleForTests"})
    private void a(@NonNull Bundle bundle, int i2) {
        this.d.a(bundle);
        if (i2 == 1) {
            this.d.a(abu.b());
        }
        e();
    }

    public void a(List<String> list) {
        synchronized (this.h) {
            List<String> c2 = this.d.c();
            if (dl.a((Collection) list)) {
                if (!dl.a((Collection) c2)) {
                    this.d.c((List<String>) null);
                    this.c.a((List<String>) null);
                }
            } else if (!dl.a(list, c2)) {
                this.d.c(list);
                this.c.a(list);
            } else {
                this.c.a(c2);
            }
        }
    }

    public void a(Map<String, String> map) {
        if (!dl.a((Map) map)) {
            synchronized (this.h) {
                Map<String, String> c2 = abq.c(map);
                this.j = c2;
                this.c.a(c2);
                this.d.a(c2);
            }
        }
    }

    public void a(String str) {
        synchronized (this.h) {
            this.c.b(str);
        }
    }

    public void a(@NonNull dk dkVar) {
        this.d.a(dkVar);
    }

    private void a(@NonNull xm xmVar) {
        a(xmVar, new Bundle());
    }

    private void a(@NonNull xm xmVar, @NonNull Bundle bundle) {
        if (this.i.containsKey(xmVar)) {
            List<String> list = this.i.get(xmVar);
            if (this.d.b(list)) {
                a(xmVar, list);
            } else {
                xv b2 = xv.b(bundle);
                IParamsCallback.Reason reason = null;
                if (b2 == null) {
                    if (!this.d.a()) {
                        abl abl = this.f;
                        if (abl != null) {
                            abl.b("Clids error. Passed clids: %s, and clids from server are empty.", this.j);
                        }
                        reason = IParamsCallback.Reason.INCONSISTENT_CLIDS;
                    } else {
                        b2 = xv.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (IParamsCallback.Reason) dl.a(a, b2, IParamsCallback.Reason.UNKNOWN);
                }
                a(xmVar, list, reason);
            }
            b(xmVar);
        }
    }

    private void a(@NonNull xm xmVar, @NonNull List<String> list) {
        xmVar.a(b(list));
    }

    private void a(@NonNull xm xmVar, @NonNull List<String> list, @NonNull IParamsCallback.Reason reason) {
        xmVar.a(reason, b(list));
    }
}
