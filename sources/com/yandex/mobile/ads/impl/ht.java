package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.YandexMetrica;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public final class ht {
    private static final Object a = new Object();
    private static volatile ht b;
    @Nullable
    private final IReporter c;
    @NonNull
    private final hu d;
    @NonNull
    private final hs e;

    private ht(@Nullable IReporter iReporter, @NonNull hu huVar, @NonNull hs hsVar) {
        this.c = iReporter;
        this.d = huVar;
        this.e = hsVar;
        huVar.a(iReporter);
    }

    @NonNull
    public static ht a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    Context applicationContext = context.getApplicationContext();
                    String str = id.a(applicationContext) ? "322a737a-a0ca-44e0-bc85-649b1c7c1db6" : "478cb909-6ad1-4e12-84cc-b3629a789f93";
                    hu huVar = new hu(ak.a());
                    b = new ht(a(applicationContext, str, huVar), huVar, new hs());
                }
            }
        }
        return b;
    }

    @Nullable
    private static IReporter a(@NonNull Context context, @NonNull String str, @NonNull hu huVar) {
        try {
            YandexMetrica.activateReporter(context, ReporterConfig.newConfigBuilder(str).withStatisticsSending(huVar.a(context)).build());
            return YandexMetrica.getReporter(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(@NonNull hv hvVar) {
        if (fy.a().b() && this.c != null) {
            String b2 = hvVar.b();
            Map<String, Object> a3 = hvVar.a();
            try {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, Object> entry : a3.entrySet()) {
                    hashMap.put(entry.getKey(), Arrays.deepToString(new Object[]{entry.getValue()}));
                }
                this.c.reportEvent(b2, a3);
            } catch (Throwable unused) {
            }
        }
    }
}
