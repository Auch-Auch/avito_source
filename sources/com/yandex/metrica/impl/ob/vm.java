package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.f;
import com.yandex.metrica.g;
import com.yandex.metrica.j;
import com.yandex.metrica.profile.UserProfile;
import java.util.List;
import java.util.Map;
public final class vm extends vh {
    private final vo a;
    private final vn b;

    public vm(@NonNull act act) {
        this(new vl(), act, new vo(), new vn());
    }

    public void a(@NonNull final Context context, @NonNull YandexMetricaConfig yandexMetricaConfig) {
        this.a.a(context, yandexMetricaConfig);
        final j a3 = this.b.a(j.a(yandexMetricaConfig));
        d().a(context, a3);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.1
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().b(context, j.a(a3));
            }
        });
        b().b();
    }

    public void b(@Nullable final Activity activity) {
        c().a();
        this.a.pauseSession();
        d().b(activity);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.18
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().c(activity);
            }
        });
    }

    public void c(@NonNull final Activity activity) {
        c().a();
        this.a.a(activity);
        d().c(activity);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.4
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().a(activity);
            }
        });
    }

    public void d(@NonNull final String str) {
        c().a();
        this.a.c(str);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.6
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().f(str);
            }
        });
    }

    public void e(@Nullable final String str) {
        c().a();
        this.a.setUserProfileID(str);
        d().b(str);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.11
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().setUserProfileID(str);
            }
        });
    }

    public void f() {
        c().a();
        this.a.sendEventsBuffer();
        d().a();
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.12
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().sendEventsBuffer();
            }
        });
    }

    private vm(@NonNull vl vlVar, @NonNull act act, @NonNull vo voVar, @NonNull vn vnVar) {
        this(vlVar, act, voVar, vnVar, new vg(vlVar), new g(vlVar), vj.a());
    }

    @VisibleForTesting
    public vm(@NonNull vl vlVar, @NonNull act act, @NonNull vo voVar, @NonNull vn vnVar, @NonNull vg vgVar, @NonNull g gVar, @NonNull vj vjVar) {
        super(vlVar, act, vgVar, gVar, vjVar);
        this.b = vnVar;
        this.a = voVar;
    }

    public void b(@NonNull final String str) {
        c().a();
        this.a.a(str);
        d().c(str);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.3
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().c(str);
            }
        });
    }

    public void c(@NonNull final String str) {
        c().a();
        this.a.b(str);
        d().d(str);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.5
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().e(str);
            }
        });
    }

    public void a(@Nullable final Activity activity) {
        c().a();
        this.a.resumeSession();
        d().a(activity);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.17
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().b(activity);
            }
        });
    }

    public void b(@NonNull final Context context, final boolean z) {
        this.a.b(context, z);
        d().b(context, z);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.10
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().b(context, z);
            }
        });
    }

    public void a(@NonNull final Application application) {
        c().a();
        this.a.a(application);
        d().a(application);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.19
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().a(application, vm.this.a());
            }
        });
    }

    public void a(@NonNull final String str) {
        c().a();
        this.a.reportEvent(str);
        d().a(str);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.20
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportEvent(str);
            }
        });
    }

    public void a(@NonNull final String str, @Nullable final String str2) {
        c().a();
        this.a.reportEvent(str, str2);
        d().b(str, str2);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.21
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportEvent(str, str2);
            }
        });
    }

    public void a(@NonNull final String str, @Nullable Map<String, Object> map) {
        c().a();
        this.a.reportEvent(str, map);
        d().a(str, map);
        final List c = dl.c(map);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.22
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportEvent(str, dl.a(c));
            }
        });
    }

    public void a(@NonNull final String str, @Nullable Throwable th) {
        c().a();
        this.a.reportError(str, th);
        final Throwable a3 = d().a(str, th);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.23
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportError(str, a3);
            }
        });
    }

    public void a(@NonNull final Throwable th) {
        c().a();
        this.a.reportUnhandledException(th);
        d().a(th);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.2
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportUnhandledException(th);
            }
        });
    }

    public void a(@Nullable final Location location) {
        this.a.a(location);
        d().a(location);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.7
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().a(location);
            }
        });
    }

    public void a(final boolean z) {
        this.a.a(z);
        d().b(z);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.8
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().a(z);
            }
        });
    }

    public void a(@NonNull final Context context, final boolean z) {
        this.a.a(context, z);
        d().a(context, z);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.9
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().a(context, z);
            }
        });
    }

    public void a(@NonNull final UserProfile userProfile) {
        c().a();
        this.a.reportUserProfile(userProfile);
        d().a(userProfile);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.13
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportUserProfile(userProfile);
            }
        });
    }

    public void a(@NonNull final Revenue revenue) {
        c().a();
        this.a.reportRevenue(revenue);
        d().a(revenue);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.14
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().f().reportRevenue(revenue);
            }
        });
    }

    public void a(@NonNull final DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        c().a();
        this.a.a(deferredDeeplinkParametersListener);
        d().a(deferredDeeplinkParametersListener);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.15
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().g().a(deferredDeeplinkParametersListener);
            }
        });
    }

    public void a(@NonNull final AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        c().a();
        this.a.a(appMetricaDeviceIDListener);
        d().a(appMetricaDeviceIDListener);
        a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.vm.16
            @Override // java.lang.Runnable
            public void run() {
                vm.this.b().g().a(appMetricaDeviceIDListener);
            }
        });
    }

    @NonNull
    public IReporter a(@NonNull Context context, @NonNull String str) {
        this.a.a(context, str);
        return e().a(context, str);
    }

    public void a(@NonNull Context context, @NonNull ReporterConfig reporterConfig) {
        this.a.a(context, reporterConfig);
        f a3 = f.a(reporterConfig);
        d().a(context, a3);
        e().a(context, a3);
    }
}
