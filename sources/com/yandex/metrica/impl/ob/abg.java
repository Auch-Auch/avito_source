package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
public class abg {
    private String a;

    @SuppressLint({"StaticFieldLeak"})
    private String b() {
        try {
            FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: com.yandex.metrica.impl.ob.abg.1
                /* renamed from: a */
                public String call() {
                    return abg.this.d();
                }
            });
            dr.k().d().post(futureTask);
            return (String) futureTask.get(5, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String c() {
        return d();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"PrivateApi"})
    private String d() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public String a() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        String c = c();
        this.a = c;
        return c;
    }

    public boolean a(@NonNull String str) {
        try {
            if (TextUtils.isEmpty(a())) {
                return false;
            }
            String a3 = a();
            if (a3.endsWith(":" + str)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
