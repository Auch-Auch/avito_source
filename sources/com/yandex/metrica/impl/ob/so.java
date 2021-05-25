package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class so {
    @NonNull
    private sm a;

    public so(@NonNull sm smVar) {
        this.a = smVar;
    }

    public boolean a(@NonNull Context context, String str) {
        if (!a().a(str)) {
            return false;
        }
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(@NonNull Context context) {
        return a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public boolean c(@NonNull Context context) {
        return a(context) || b(context);
    }

    public boolean d(@NonNull Context context) {
        return a(context, "android.permission.READ_PHONE_STATE");
    }

    public boolean e(@NonNull Context context) {
        return a(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public boolean f(@NonNull Context context) {
        return a(context, "android.permission.CHANGE_WIFI_STATE");
    }

    public boolean g(@NonNull Context context) {
        return a(context, "android.permission.BLUETOOTH");
    }

    public boolean h(@NonNull Context context) {
        return a(context, "android.permission.BLUETOOTH_ADMIN");
    }

    public boolean i(@NonNull Context context) {
        return g(context) && h(context);
    }

    public boolean a(@NonNull Context context) {
        return a(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public void a(@NonNull sm smVar) {
        this.a = smVar;
    }

    @VisibleForTesting
    @NonNull
    public sm a() {
        return this.a;
    }
}
