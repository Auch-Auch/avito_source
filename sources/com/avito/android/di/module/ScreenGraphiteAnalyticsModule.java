package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.ScreenTimeProviderImpl;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.TrackerInfoProviderImpl;
import com.avito.android.analytics.screens.fps.FpsMetricsCalculator;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.fps.RefreshRateProvider;
import com.avito.android.analytics.screens.image.ImageBucketProvider;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactoryImpl;
import com.avito.android.analytics.screens.tracker.SessionResolver;
import com.avito.android.connection_quality.NetworkSpeedProvider;
import com.avito.android.fps.di.FpsCommunication;
import com.avito.android.fps.di.FpsTrackingThreshold;
import com.avito.android.memory_consumption.GcUsageCollector;
import com.avito.android.memory_consumption.MemoryMetricsProvider;
import com.avito.android.memory_consumption.MemoryMetricsReporter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(J_\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001e2\u000e\b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0017¢\u0006\u0004\b\u001f\u0010 J%\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0!2\u000e\b\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0017¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/di/module/ScreenGraphiteAnalyticsModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "networkSpeedProvider", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "imageBucketProvider", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "memoryMetricsReporter", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "providesScreenTrackerFactory", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/connection_quality/NetworkSpeedProvider;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/image/ImageBucketProvider;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Lcom/avito/android/Features;Lcom/avito/android/memory_consumption/MemoryMetricsReporter;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "provideCommunication", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "communication", "Lio/reactivex/Observable;", "provideCommunicationObservable", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "provideCommunicationConsumer", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/functions/Consumer;", "", "provideThreshold", "()I", "<init>", "()V", "Declarations", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public class ScreenGraphiteAnalyticsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/avito/android/di/module/ScreenGraphiteAnalyticsModule$Declarations;", "", "Lcom/avito/android/analytics/screens/TrackerInfoProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "bindTrackerInfoProvider", "(Lcom/avito/android/analytics/screens/TrackerInfoProviderImpl;)Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "Lcom/avito/android/analytics/screens/fps/RefreshRateProvider$Impl;", "Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "bindRefreshRateProvider", "(Lcom/avito/android/analytics/screens/fps/RefreshRateProvider$Impl;)Lcom/avito/android/analytics/screens/fps/RefreshRateProvider;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker$Impl;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "bindFpsMetricsTracker", "(Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker$Impl;)Lcom/avito/android/analytics/screens/fps/FpsMetricsTracker;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator$Impl;", "Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "bindFpsMetricsCalculator", "(Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator$Impl;)Lcom/avito/android/analytics/screens/fps/FpsMetricsCalculator;", "Lcom/avito/android/analytics/screens/ScreenTimeProviderImpl;", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "bindScreenTimeProvider", "(Lcom/avito/android/analytics/screens/ScreenTimeProviderImpl;)Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider$Impl;", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "bindImageBucketProvider", "(Lcom/avito/android/analytics/screens/image/ImageBucketProvider$Impl;)Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "Lcom/avito/android/analytics/screens/tracker/SessionResolver$Impl;", "resolver", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "bindSessionResolver", "(Lcom/avito/android/analytics/screens/tracker/SessionResolver$Impl;)Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter$Impl;", "reporter", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "bindMemoryMetricsReporter", "(Lcom/avito/android/memory_consumption/MemoryMetricsReporter$Impl;)Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "Lcom/avito/android/memory_consumption/MemoryMetricsProvider$Impl;", "Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "bindMemoryMetricsProvider", "(Lcom/avito/android/memory_consumption/MemoryMetricsProvider$Impl;)Lcom/avito/android/memory_consumption/MemoryMetricsProvider;", "Lcom/avito/android/memory_consumption/GcUsageCollector$Impl;", "collector", "Lcom/avito/android/memory_consumption/GcUsageCollector;", "bindGcUsageCollector", "(Lcom/avito/android/memory_consumption/GcUsageCollector$Impl;)Lcom/avito/android/memory_consumption/GcUsageCollector;", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        FpsMetricsCalculator bindFpsMetricsCalculator(@NotNull FpsMetricsCalculator.Impl impl);

        @Singleton
        @Binds
        @NotNull
        FpsMetricsTracker bindFpsMetricsTracker(@NotNull FpsMetricsTracker.Impl impl);

        @Binds
        @NotNull
        GcUsageCollector bindGcUsageCollector(@NotNull GcUsageCollector.Impl impl);

        @Binds
        @NotNull
        ImageBucketProvider bindImageBucketProvider(@NotNull ImageBucketProvider.Impl impl);

        @Binds
        @NotNull
        MemoryMetricsProvider bindMemoryMetricsProvider(@NotNull MemoryMetricsProvider.Impl impl);

        @Binds
        @NotNull
        MemoryMetricsReporter bindMemoryMetricsReporter(@NotNull MemoryMetricsReporter.Impl impl);

        @Binds
        @NotNull
        RefreshRateProvider bindRefreshRateProvider(@NotNull RefreshRateProvider.Impl impl);

        @Binds
        @NotNull
        ScreenTimeProvider bindScreenTimeProvider(@NotNull ScreenTimeProviderImpl screenTimeProviderImpl);

        @Binds
        @NotNull
        SessionResolver bindSessionResolver(@NotNull SessionResolver.Impl impl);

        @Binds
        @NotNull
        TrackerInfoProvider bindTrackerInfoProvider(@NotNull TrackerInfoProviderImpl trackerInfoProviderImpl);
    }

    @Provides
    @FpsCommunication
    @NotNull
    @Singleton
    public PublishRelay<Long> provideCommunication() {
        PublishRelay<Long> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @FpsCommunication
    @NotNull
    @Singleton
    public Consumer<Long> provideCommunicationConsumer(@FpsCommunication @NotNull PublishRelay<Long> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "communication");
        return publishRelay;
    }

    @Provides
    @FpsCommunication
    @NotNull
    @Singleton
    public Observable<Long> provideCommunicationObservable(@FpsCommunication @NotNull PublishRelay<Long> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "communication");
        return publishRelay;
    }

    @FpsTrackingThreshold
    @Provides
    public int provideThreshold() {
        return 50;
    }

    @Provides
    @NotNull
    public ScreenTrackerFactory providesScreenTrackerFactory(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull NetworkSpeedProvider networkSpeedProvider, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull ImageBucketProvider imageBucketProvider, @NotNull SessionResolver sessionResolver, @NotNull Features features, @NotNull MemoryMetricsReporter memoryMetricsReporter, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(networkSpeedProvider, "networkSpeedProvider");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(imageBucketProvider, "imageBucketProvider");
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(memoryMetricsReporter, "memoryMetricsReporter");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new ScreenTrackerFactoryImpl(analytics, trackerInfoProvider, networkTypeProvider, networkSpeedProvider, imageBucketProvider, features, screenTimeProvider, sessionResolver, memoryMetricsReporter, buildInfo);
    }
}
