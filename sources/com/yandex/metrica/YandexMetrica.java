package com.yandex.metrica;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.dr;
import com.yandex.metrica.impl.ob.vm;
import com.yandex.metrica.profile.UserProfile;
import java.util.Collections;
import java.util.Map;
public final class YandexMetrica {
    public static final vm a = new vm(dr.a());

    public static void activate(@NonNull Context context, @NonNull YandexMetricaConfig yandexMetricaConfig) {
        a.a(context, yandexMetricaConfig);
    }

    public static void activateReporter(@NonNull Context context, @NonNull ReporterConfig reporterConfig) {
        a.a(context, reporterConfig);
    }

    public static void enableActivityAutoTracking(@NonNull Application application) {
        a.a(application);
    }

    public static int getLibraryApiLevel() {
        return 87;
    }

    @NonNull
    public static String getLibraryVersion() {
        return "3.13.1";
    }

    @NonNull
    public static IReporter getReporter(@NonNull Context context, @NonNull String str) {
        return a.a(context, str);
    }

    public static void pauseSession(@Nullable Activity activity) {
        a.b(activity);
    }

    public static void registerReferrerBroadcastReceivers(@NonNull BroadcastReceiver... broadcastReceiverArr) {
        MetricaEventHandler.b.a(broadcastReceiverArr);
        Collections.addAll(MetricaEventHandler.a, broadcastReceiverArr);
    }

    public static void reportAppOpen(@NonNull Activity activity) {
        a.c(activity);
    }

    public static void reportError(@NonNull String str, @Nullable Throwable th) {
        a.a(str, th);
    }

    public static void reportEvent(@NonNull String str) {
        a.a(str);
    }

    public static void reportNativeCrash(@NonNull String str) {
        a.b(str);
    }

    public static void reportReferralUrl(@NonNull String str) {
        a.d(str);
    }

    public static void reportRevenue(@NonNull Revenue revenue) {
        a.a(revenue);
    }

    public static void reportUnhandledException(@NonNull Throwable th) {
        a.a(th);
    }

    public static void reportUserProfile(@NonNull UserProfile userProfile) {
        a.a(userProfile);
    }

    public static void requestAppMetricaDeviceID(@NonNull AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        a.a(appMetricaDeviceIDListener);
    }

    public static void requestDeferredDeeplinkParameters(@NonNull DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        a.a(deferredDeeplinkParametersListener);
    }

    public static void resumeSession(@Nullable Activity activity) {
        a.a(activity);
    }

    public static void sendEventsBuffer() {
        a.f();
    }

    public static void setLocation(@Nullable Location location) {
        a.a(location);
    }

    public static void setLocationTracking(boolean z) {
        a.a(z);
    }

    public static void setStatisticsSending(@NonNull Context context, boolean z) {
        a.b(context, z);
    }

    public static void setUserProfileID(@Nullable String str) {
        a.e(str);
    }

    public static void reportAppOpen(@NonNull String str) {
        a.c(str);
    }

    public static void reportEvent(@NonNull String str, @Nullable String str2) {
        a.a(str, str2);
    }

    public static void setLocationTracking(@NonNull Context context, boolean z) {
        a.a(context, z);
    }

    public static void reportEvent(@NonNull String str, @Nullable Map<String, Object> map) {
        a.a(str, map);
    }
}
