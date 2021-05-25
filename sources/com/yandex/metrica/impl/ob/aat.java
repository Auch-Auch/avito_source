package com.yandex.metrica.impl.ob;

import android.support.annotation.VisibleForTesting;
import android.util.Log;
public abstract class aat {
    private volatile boolean a = false;

    public aat(boolean z) {
        this.a = z;
    }

    private static String e(String str) {
        return str == null ? "" : str;
    }

    private String e(String str, Object[] objArr) {
        try {
            return g() + d(e(str), objArr);
        } catch (Throwable unused) {
            return e();
        }
    }

    public void a() {
        this.a = true;
    }

    public void b() {
        this.a = false;
    }

    public boolean c() {
        return this.a;
    }

    public abstract String d(String str, Object[] objArr);

    public boolean d() {
        return this.a;
    }

    public abstract String f();

    public abstract String g();

    private String d(String str) {
        return g() + e(str);
    }

    public void a(String str) {
        a(4, str);
    }

    public void b(String str) {
        a(5, str);
    }

    public void c(String str) {
        a(6, str);
    }

    public void a(String str, Object... objArr) {
        a(4, str, objArr);
    }

    public void b(String str, Object... objArr) {
        a(5, str, objArr);
    }

    public void c(String str, Object... objArr) {
        Log.println(5, f(), e(str, objArr));
    }

    @VisibleForTesting
    public String e() {
        return g();
    }

    public void a(Throwable th, String str, Object... objArr) {
        String f = f();
        Log.println(6, f, e(str, objArr) + "\n" + Log.getStackTraceString(th));
    }

    public void a(int i, String str) {
        if (d()) {
            Log.println(i, f(), d(str));
        }
    }

    public void a(int i, String str, Object... objArr) {
        if (d()) {
            Log.println(i, f(), e(str, objArr));
        }
    }
}
