package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class sy {
    public static final Map<String, String> a = Collections.unmodifiableMap(new HashMap<String, String>() { // from class: com.yandex.metrica.impl.ob.sy.1
        {
            put("20799a27-fa80-4b36-b2db-0f8141f24180", "13");
            put("01528cc0-dd34-494d-9218-24af1317e1ee", "17233");
            put("4e610cd2-753f-4bfc-9b05-772ce8905c5e", "21952");
            put("67bb016b-be40-4c08-a190-96a3f3b503d3", "22675");
            put("e4250327-8d3c-4d35-b9e8-3c1720a64b91", "22678");
            put("6c5f504e-8928-47b5-bfb5-73af8d8bf4b4", "30404");
            put("7d962ba4-a392-449a-a02d-6c5be5613928", "30407");
        }
    });
    private sz b;

    public sy(sz szVar) {
        this.b = szVar;
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str) && "DONE".equals(this.b.g().get(sz.f(str)));
    }

    public void a() {
        if (f()) {
            g();
            h();
        }
    }

    public void b() {
        String d = d();
        if (c(d)) {
            a(d);
        }
    }

    public String d() {
        return a.get(this.b.i());
    }

    public String e() {
        Map<String, ?> g = this.b.g();
        for (String str : a.values()) {
            g.remove(sz.f(str));
        }
        LinkedList linkedList = new LinkedList();
        for (String str2 : g.keySet()) {
            try {
                linkedList.add(Integer.valueOf(Integer.parseInt(sz.g(str2))));
            } catch (Throwable unused) {
            }
        }
        if (linkedList.size() == 1) {
            return ((Integer) linkedList.getFirst()).toString();
        }
        return null;
    }

    public boolean f() {
        return this.b.a(null) != null;
    }

    public void g() {
        this.b.a();
    }

    public void h() {
        this.b.b();
    }

    public void a(String str) {
        if (str != null) {
            b(str);
            g();
        }
    }

    public void b(String str) {
        this.b.d(str);
    }

    public void c() {
        a(e());
    }
}
