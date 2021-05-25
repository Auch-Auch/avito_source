package com.facebook.appevents.internal;

import a2.g.k.y.b;
import a2.g.k.y.c;
import a2.g.k.y.d;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
public class InAppPurchaseActivityLifecycleTracker {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static Boolean b = null;
    public static Boolean c = null;
    public static ServiceConnection d;
    public static Application.ActivityLifecycleCallbacks e;
    public static Intent f;
    public static Object g;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00cd: APUT  (r8v14 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r10v27 java.lang.String) */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r20, java.util.ArrayList r21, boolean r22) {
        /*
        // Method dump skipped, instructions count: 697
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker.a(android.content.Context, java.util.ArrayList, boolean):void");
    }

    public static void update() {
        if (b == null) {
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                Boolean bool = Boolean.TRUE;
                b = bool;
                try {
                    Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                    c = bool;
                } catch (ClassNotFoundException unused) {
                    c = Boolean.FALSE;
                }
                HashMap<String, Method> hashMap = d.a;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences = d.d;
                long j = sharedPreferences.getLong("LAST_CLEARED_TIME", 0);
                if (j == 0) {
                    sharedPreferences.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                } else if (currentTimeMillis - j > 604800) {
                    sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                }
                f = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                d = new b();
                e = new c();
            } catch (ClassNotFoundException unused2) {
                b = Boolean.FALSE;
            }
        }
        if (b.booleanValue() && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled() && a.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(e);
                applicationContext.bindService(f, d, 1);
            }
        }
    }
}
