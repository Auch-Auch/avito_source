package com.avito.android.di.module;

import android.content.Context;
import android.os.Build;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerService;
import com.avito.android.service.short_task.metrics.AccessibilityInfoProvider;
import com.avito.android.service.short_task.metrics.AccessibilityManagerWrapper;
import com.avito.android.service.short_task.metrics.AccessibilityManagerWrapperImpl;
import com.avito.android.service.short_task.metrics.DarkThemeDetectionProvider;
import com.avito.android.service.short_task.metrics.DataDiskUsageMetricProvider;
import com.avito.android.service.short_task.metrics.DeviceInfoMetricProvider;
import com.avito.android.service.short_task.metrics.GooglePlayServicesInfoProvider;
import com.avito.android.service.short_task.metrics.MetricProvider;
import com.avito.android.service.short_task.metrics.NetworkMetricProvider;
import com.avito.android.service.short_task.metrics.PermissionInfoProvider;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.service.short_task.metrics.SendMetricsTaskDelegate;
import com.avito.android.service.short_task.metrics.SendMetricsTaskDelegateImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDirectoryProviderFactory;
import com.avito.android.util.DataDiskUsageDelegate;
import com.avito.android.util.DataDiskUsageImpl;
import com.avito.android.util.DataDiskUsageOreoDelegate;
import com.avito.android.util.DataDiskUsagePreOreoDelegate;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b)\u0010*JW\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/di/module/SendMetricsModule;", "", "Lcom/avito/android/service/short_task/metrics/PermissionInfoProvider;", "permissionInfoProvider", "Lcom/avito/android/service/short_task/metrics/DeviceInfoMetricProvider;", "deviceInfoMetricProvider", "Lcom/avito/android/service/short_task/metrics/AccessibilityInfoProvider;", "accessibilityInfoProvider", "Lcom/avito/android/service/short_task/metrics/GooglePlayServicesInfoProvider;", "googlePlayServicesInfoProvider", "Lcom/avito/android/service/short_task/metrics/DataDiskUsageMetricProvider;", "dataDiskUsageMetricProvider", "Lcom/avito/android/service/short_task/metrics/NetworkMetricProvider;", "networkMetricProvider", "Lcom/avito/android/service/short_task/metrics/DarkThemeDetectionProvider;", "darkThemeDetectionProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/service/short_task/metrics/SendMetricsTaskDelegate;", "provideSendMetricsTaskDelegate$application_release", "(Lcom/avito/android/service/short_task/metrics/PermissionInfoProvider;Lcom/avito/android/service/short_task/metrics/DeviceInfoMetricProvider;Lcom/avito/android/service/short_task/metrics/AccessibilityInfoProvider;Lcom/avito/android/service/short_task/metrics/GooglePlayServicesInfoProvider;Lcom/avito/android/service/short_task/metrics/DataDiskUsageMetricProvider;Lcom/avito/android/service/short_task/metrics/NetworkMetricProvider;Lcom/avito/android/service/short_task/metrics/DarkThemeDetectionProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/service/short_task/metrics/SendMetricsTaskDelegate;", "provideSendMetricsTaskDelegate", "Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "Lcom/avito/android/util/DataDiskUsageDelegate;", "dataDiskUsageDelegate", "provideDataDiskUsageMetricProvider", "(Lcom/avito/android/util/DataDirectoryProvider;Lcom/avito/android/util/DataDiskUsageDelegate;)Lcom/avito/android/service/short_task/metrics/DataDiskUsageMetricProvider;", "Landroid/content/Context;", "context", "provideDataDiskUsageDelegate", "(Lcom/avito/android/util/DataDirectoryProvider;Landroid/content/Context;)Lcom/avito/android/util/DataDiskUsageDelegate;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "provideDataDirectoryProviderFactory", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/util/DataDirectoryProvider;", "Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "provideSendMetricTask", "()Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "<init>", "()V", "Bindings", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class SendMetricsModule {
    @NotNull
    public static final SendMetricsModule INSTANCE = new SendMetricsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/SendMetricsModule$Bindings;", "", "Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapperImpl;", "wrapper", "Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;", "bindsAccessibilityManagerWrapper", "(Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapperImpl;)Lcom/avito/android/service/short_task/metrics/AccessibilityManagerWrapper;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @PerService
        @Binds
        @NotNull
        AccessibilityManagerWrapper bindsAccessibilityManagerWrapper(@NotNull AccessibilityManagerWrapperImpl accessibilityManagerWrapperImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final DataDirectoryProvider provideDataDirectoryProviderFactory(@NotNull Context context, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new DataDirectoryProviderFactory(context, buildInfo).getDataDirectoryProvider();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final DataDiskUsageDelegate provideDataDiskUsageDelegate(@NotNull DataDirectoryProvider dataDirectoryProvider, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return new DataDiskUsagePreOreoDelegate(dataDirectoryProvider);
        }
        return new DataDiskUsageOreoDelegate(context);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final DataDiskUsageMetricProvider provideDataDiskUsageMetricProvider(@NotNull DataDirectoryProvider dataDirectoryProvider, @NotNull DataDiskUsageDelegate dataDiskUsageDelegate) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        Intrinsics.checkNotNullParameter(dataDiskUsageDelegate, "dataDiskUsageDelegate");
        return new DataDiskUsageMetricProvider(new DataDiskUsageImpl(dataDirectoryProvider, dataDiskUsageDelegate));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final SendMetricsTaskDelegate provideSendMetricsTaskDelegate$application_release(@NotNull PermissionInfoProvider permissionInfoProvider, @NotNull DeviceInfoMetricProvider deviceInfoMetricProvider, @NotNull AccessibilityInfoProvider accessibilityInfoProvider, @NotNull GooglePlayServicesInfoProvider googlePlayServicesInfoProvider, @NotNull DataDiskUsageMetricProvider dataDiskUsageMetricProvider, @NotNull NetworkMetricProvider networkMetricProvider, @NotNull DarkThemeDetectionProvider darkThemeDetectionProvider, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(permissionInfoProvider, "permissionInfoProvider");
        Intrinsics.checkNotNullParameter(deviceInfoMetricProvider, "deviceInfoMetricProvider");
        Intrinsics.checkNotNullParameter(accessibilityInfoProvider, "accessibilityInfoProvider");
        Intrinsics.checkNotNullParameter(googlePlayServicesInfoProvider, "googlePlayServicesInfoProvider");
        Intrinsics.checkNotNullParameter(dataDiskUsageMetricProvider, "dataDiskUsageMetricProvider");
        Intrinsics.checkNotNullParameter(networkMetricProvider, "networkMetricProvider");
        Intrinsics.checkNotNullParameter(darkThemeDetectionProvider, "darkThemeDetectionProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new SendMetricsTaskDelegateImpl(CollectionsKt__CollectionsKt.listOf((Object[]) new MetricProvider[]{permissionInfoProvider, accessibilityInfoProvider, deviceInfoMetricProvider, googlePlayServicesInfoProvider, dataDiskUsageMetricProvider, networkMetricProvider, darkThemeDetectionProvider}), analytics, schedulersFactory);
    }

    @Provides
    @NotNull
    public final SendMetricTask provideSendMetricTask() {
        return new SendMetricTask();
    }
}
