package com.avito.android.di.module;

import android.content.Context;
import android.os.Build;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.di.PerService;
import com.avito.android.service.short_task.metrics.SendDataSizeTaskDelegate;
import com.avito.android.service.short_task.metrics.SendDataSizeTaskDelegateImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DataDirectoryProvider;
import com.avito.android.util.DataDirectoryProviderFactory;
import com.avito.android.util.DataDiskUsageDelegate;
import com.avito.android.util.DataDiskUsageOreoDelegate;
import com.avito.android.util.DataDiskUsagePreOreoDelegate;
import com.avito.android.util.DiskSpaceAnalyticsTraverser;
import com.avito.android.util.DiskSpaceAnalyticsTraverserImpl;
import com.avito.android.util.DiskSpaceAnalyticsTraverserStub;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/di/module/SendDataSizeModule;", "", "Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;", "traverser", "Lcom/avito/android/service/short_task/metrics/SendDataSizeTaskDelegate;", "provideSendDataSizeDelegate$application_release", "(Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;)Lcom/avito/android/service/short_task/metrics/SendDataSizeTaskDelegate;", "provideSendDataSizeDelegate", "Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "Lcom/avito/android/util/DataDiskUsageDelegate;", "delegate", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "provideDiskSpaceAnalyticsTraverser", "(Lcom/avito/android/util/DataDirectoryProvider;Lcom/avito/android/util/DataDiskUsageDelegate;Lcom/avito/android/analytics/grafana/GraphitePrefix;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;", "Landroid/content/Context;", "context", "provideDataDiskUsageDelegate", "(Lcom/avito/android/util/DataDirectoryProvider;Landroid/content/Context;)Lcom/avito/android/util/DataDiskUsageDelegate;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "provideDataDirectoryProviderFactory", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/util/DataDirectoryProvider;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SendDataSizeModule {
    @NotNull
    public static final SendDataSizeModule INSTANCE = new SendDataSizeModule();

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
    public static final DiskSpaceAnalyticsTraverser provideDiskSpaceAnalyticsTraverser(@NotNull DataDirectoryProvider dataDirectoryProvider, @NotNull DataDiskUsageDelegate dataDiskUsageDelegate, @NotNull GraphitePrefix graphitePrefix, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        Intrinsics.checkNotNullParameter(dataDiskUsageDelegate, "delegate");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getAppDiskSize().invoke().booleanValue()) {
            return new DiskSpaceAnalyticsTraverserImpl(dataDirectoryProvider, dataDiskUsageDelegate, graphitePrefix, analytics);
        }
        return new DiskSpaceAnalyticsTraverserStub();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final SendDataSizeTaskDelegate provideSendDataSizeDelegate$application_release(@NotNull DiskSpaceAnalyticsTraverser diskSpaceAnalyticsTraverser) {
        Intrinsics.checkNotNullParameter(diskSpaceAnalyticsTraverser, "traverser");
        return new SendDataSizeTaskDelegateImpl(diskSpaceAnalyticsTraverser);
    }
}
