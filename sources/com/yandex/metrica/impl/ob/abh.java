package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.yandex.metrica.MetricaService;
public class abh {
    private static final ado a = new ado();

    public static final class a implements Runnable {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            abh.a(this.a);
        }
    }

    public static void a(Context context, ComponentName componentName) {
        a.a(context, componentName, 1, 1);
    }

    @SuppressLint({"InlinedApi"})
    public static void b(Context context) {
        try {
            ServiceInfo[] serviceInfoArr = a.a(context, context.getPackageName(), 516).services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (MetricaService.class.getName().equals(serviceInfo.name) && !serviceInfo.enabled) {
                        a(context, new ComponentName(context, MetricaService.class));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        b(context);
    }
}
