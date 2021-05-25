package com.yandex.metrica;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ks;
import com.yandex.metrica.impl.ob.ky;
import com.yandex.metrica.impl.ob.ld;
import com.yandex.metrica.impl.ob.vl;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;
public class g {
    @NonNull
    public final vl a;

    public g(@NonNull vl vlVar) {
        this.a = vlVar;
    }

    @NonNull
    public Throwable a(@NonNull String str, @Nullable Throwable th) {
        if (th != null) {
            return th;
        }
        ks ksVar = new ks();
        ksVar.fillInStackTrace();
        return ksVar;
    }

    public void a() {
    }

    public void a(@Nullable Activity activity) {
    }

    public void a(@NonNull Application application) {
    }

    public void a(@NonNull Context context, @NonNull f fVar) {
    }

    public void a(@NonNull Context context, boolean z) {
    }

    public void a(@Nullable Location location) {
    }

    public void a(@NonNull AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
    }

    public void a(@NonNull DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
    }

    public void a(@NonNull ReporterConfig reporterConfig) {
    }

    public void a(@NonNull Revenue revenue) {
    }

    public void a(@NonNull ky kyVar) {
    }

    public void a(@NonNull ld ldVar) {
    }

    public void a(@NonNull UserProfile userProfile) {
    }

    public void a(@NonNull String str) {
    }

    public void a(@Nullable String str, @Nullable String str2) {
    }

    public void a(@NonNull String str, @Nullable Map<String, Object> map) {
    }

    public void a(@NonNull Throwable th) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    public void b(@NonNull Activity activity) {
    }

    public void b(@NonNull Context context, boolean z) {
    }

    public void b(@Nullable String str) {
    }

    public void b(@NonNull String str, @Nullable String str2) {
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public void c(@NonNull Activity activity) {
    }

    public void c(@NonNull String str) {
    }

    public void c(@NonNull String str, @Nullable String str2) {
    }

    public void d() {
    }

    public void d(@NonNull String str) {
    }

    public void a(@NonNull Context context, @NonNull YandexMetricaConfig yandexMetricaConfig) {
        this.a.a(context, j.a(yandexMetricaConfig));
    }
}
