package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class sx {
    private Context a;

    public sx(Context context) {
        this.a = context;
    }

    private void b(SharedPreferences sharedPreferences) {
        th thVar = tf.d;
        String string = sharedPreferences.getString(thVar.a(), null);
        tf tfVar = new tf(this.a);
        if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(tfVar.a((String) null))) {
            tfVar.j(string).j();
            sharedPreferences.edit().remove(thVar.a()).apply();
        }
    }

    private void c(lx lxVar, SharedPreferences sharedPreferences) {
        mr mrVar = new mr(lxVar, this.a.getPackageName());
        boolean z = sharedPreferences.getBoolean(tf.f.a(), false);
        if (z) {
            mrVar.a(z).q();
        }
    }

    public void a() {
        SharedPreferences a3 = ti.a(this.a, "_bidoptpreferences");
        if (a3.getAll().size() > 0) {
            b(a3);
            a(a3);
            a3.edit().clear().apply();
        }
    }

    private void a(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all.size() > 0) {
            for (String str : a(all, tf.e.a())) {
                String string = sharedPreferences.getString(new th(tf.e.a(), str).b(), null);
                tf tfVar = new tf(this.a, str);
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(tfVar.b(null))) {
                    tfVar.i(string).j();
                }
            }
        }
    }

    public void b() {
        lx e = lv.a(this.a).e();
        SharedPreferences a3 = ti.a(this.a, "_startupserviceinfopreferences");
        b(e, a3);
        c(e, a3);
        a(e, this.a.getPackageName());
        a(e, a3);
    }

    private void b(lx lxVar, SharedPreferences sharedPreferences) {
        mr mrVar = new mr(lxVar, null);
        th thVar = tf.d;
        String string = sharedPreferences.getString(thVar.a(), null);
        if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(mrVar.a().b)) {
            mrVar.b(string).q();
            sharedPreferences.edit().remove(thVar.a()).apply();
        }
    }

    private List<String> a(Map<String, ?> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2.replace(str, ""));
            }
        }
        return arrayList;
    }

    private void a(lx lxVar, SharedPreferences sharedPreferences) {
        for (String str : a(sharedPreferences.getAll(), tf.e.a())) {
            a(lxVar, str);
        }
    }

    private void a(lx lxVar, String str) {
        mr mrVar = new mr(lxVar, str);
        tf tfVar = new tf(this.a, str);
        String b = tfVar.b(null);
        if (!TextUtils.isEmpty(b)) {
            mrVar.a(b);
        }
        String a3 = tfVar.a();
        if (!TextUtils.isEmpty(a3)) {
            mrVar.h(a3);
        }
        String d = tfVar.d(null);
        if (!TextUtils.isEmpty(d)) {
            mrVar.g(d);
        }
        String f = tfVar.f(null);
        if (!TextUtils.isEmpty(f)) {
            mrVar.e(f);
        }
        String g = tfVar.g(null);
        if (!TextUtils.isEmpty(g)) {
            mrVar.d(g);
        }
        String c = tfVar.c(null);
        if (!TextUtils.isEmpty(c)) {
            mrVar.f(c);
        }
        long a4 = tfVar.a(-1);
        if (a4 != -1) {
            mrVar.a(a4);
        }
        String e = tfVar.e(null);
        if (!TextUtils.isEmpty(e)) {
            mrVar.c(e);
        }
        mrVar.q();
        tfVar.b();
    }
}
