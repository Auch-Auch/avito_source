package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.YandexMetricaConfig;
public class vo extends vq {
    private static final adw<YandexMetricaConfig> g = new ads(new adr("Config"));
    private static final adw<String> h = new ads(new adq("Native crash"));
    private static final adw<Activity> i = new ads(new adr("Activity"));
    private static final adw<Application> j = new ads(new adr("Application"));
    private static final adw<Context> k = new ads(new adr("Context"));
    private static final adw<DeferredDeeplinkParametersListener> l = new ads(new adr("Deeplink listener"));
    private static final adw<AppMetricaDeviceIDListener> m = new ads(new adr("DeviceID listener"));
    private static final adw<ReporterConfig> n = new ads(new adr("Reporter Config"));
    private static final adw<String> o = new ads(new adq("Deeplink"));
    private static final adw<String> p = new ads(new adq("Referral url"));
    private static final adw<String> q = new ads(new adx());

    public void a(@Nullable Location location) {
    }

    public void a(String str) {
        h.a(str);
    }

    public void a(boolean z) {
    }

    public void b(@NonNull String str) {
        o.a(str);
    }

    public void c(@NonNull String str) {
        p.a(str);
    }

    public void a(@NonNull Application application) {
        j.a(application);
    }

    public void b(@NonNull Context context, boolean z) {
        k.a(context);
    }

    public void a(@NonNull Activity activity) {
        i.a(activity);
    }

    public void a(@NonNull Context context, boolean z) {
        k.a(context);
    }

    public void a(@NonNull DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        l.a(deferredDeeplinkParametersListener);
    }

    public void a(@NonNull AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        m.a(appMetricaDeviceIDListener);
    }

    public void a(@NonNull Context context, @NonNull String str) {
        k.a(context);
        q.a(str);
    }

    public void a(@NonNull Context context, @NonNull ReporterConfig reporterConfig) {
        k.a(context);
        n.a(reporterConfig);
    }

    public void a(@NonNull Context context, @NonNull YandexMetricaConfig yandexMetricaConfig) {
        k.a(context);
        g.a(yandexMetricaConfig);
    }
}
