package com.avito.android.di.module;

import android.app.Application;
import android.content.ContentResolver;
import com.avito.android.AnalyticsToggles;
import com.avito.android.AppConfigurationToggles;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.AnalyticsImpl;
import com.avito.android.analytics.CrashReporter;
import com.avito.android.analytics.CrashReporterImpl;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.grafana.GraphitePrefixImpl;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.DeviceIdProviderImpl;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J*\u0010\t\u001a\u00020\b2\u0011\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/di/module/CoreAnalyticsModule;", "", "", "Lcom/avito/android/analytics/EventObserver;", "Lkotlin/jvm/JvmSuppressWildcards;", "observers", "Lcom/avito/android/AnalyticsToggles;", "analyticsToggles", "Lcom/avito/android/analytics/Analytics;", "provideAnalytics", "(Ljava/util/Set;Lcom/avito/android/AnalyticsToggles;)Lcom/avito/android/analytics/Analytics;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/preferences/Preferences;", "sharedPreferences", "Lcom/avito/android/AppConfigurationToggles;", "appConfigurationToggles", "Lcom/avito/android/remote/DeviceIdProvider;", "provideDeviceIdProvider", "(Landroid/app/Application;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/AppConfigurationToggles;)Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "", "provideDeviceId", "(Lcom/avito/android/remote/DeviceIdProvider;)Ljava/lang/String;", "<init>", "()V", "Bindings", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public class CoreAnalyticsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/CoreAnalyticsModule$Bindings;", "", "Lcom/avito/android/analytics/grafana/GraphitePrefixImpl;", "prefix", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "provideGraphitePrefix", "(Lcom/avito/android/analytics/grafana/GraphitePrefixImpl;)Lcom/avito/android/analytics/grafana/GraphitePrefix;", "Lcom/avito/android/analytics/CrashReporterImpl;", "crashReporter", "Lcom/avito/android/analytics/CrashReporter;", "bindCrashReporter", "(Lcom/avito/android/analytics/CrashReporterImpl;)Lcom/avito/android/analytics/CrashReporter;", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Singleton
        @Binds
        @NotNull
        CrashReporter bindCrashReporter(@NotNull CrashReporterImpl crashReporterImpl);

        @Reusable
        @Binds
        @NotNull
        GraphitePrefix provideGraphitePrefix(@NotNull GraphitePrefixImpl graphitePrefixImpl);
    }

    @Provides
    @NotNull
    @Singleton
    public Analytics provideAnalytics(@NotNull Set<EventObserver> set, @NotNull AnalyticsToggles analyticsToggles) {
        Intrinsics.checkNotNullParameter(set, "observers");
        Intrinsics.checkNotNullParameter(analyticsToggles, "analyticsToggles");
        return new AnalyticsImpl(set, analyticsToggles.getLogAnalyticEvents().invoke().booleanValue(), !analyticsToggles.getSendGraphiteEvents().invoke().booleanValue());
    }

    @Provides
    @NotNull
    @Singleton
    @DeviceId
    public String provideDeviceId(@NotNull DeviceIdProvider deviceIdProvider) {
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        return deviceIdProvider.getValue();
    }

    @Provides
    @Reusable
    @NotNull
    public DeviceIdProvider provideDeviceIdProvider(@NotNull Application application, @NotNull Preferences preferences, @NotNull AppConfigurationToggles appConfigurationToggles) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(appConfigurationToggles, "appConfigurationToggles");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
        return new DeviceIdProviderImpl(preferences, contentResolver, appConfigurationToggles.getDeviceId().invoke());
    }
}
