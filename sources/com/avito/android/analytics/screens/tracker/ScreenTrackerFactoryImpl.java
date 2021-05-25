package com.avito.android.analytics.screens.tracker;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProviderImpl;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.image.ImageBucketProvider;
import com.avito.android.connection_quality.NetworkSpeedProvider;
import com.avito.android.memory_consumption.MemoryMetricsReporter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b9\u0010:J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactoryImpl;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "", "contentType", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "createInitTracker", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "createScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "createDiInjectTracker", "(Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "d", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "networkSpeedProvider", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", g.a, "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/util/BuildInfo;", "j", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "e", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "imageBucketProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "h", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", "Lcom/avito/android/analytics/NetworkTypeProvider;", "c", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "i", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "memoryMetricsReporter", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/connection_quality/NetworkSpeedProvider;Lcom/avito/android/analytics/screens/image/ImageBucketProvider;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Lcom/avito/android/memory_consumption/MemoryMetricsReporter;Lcom/avito/android/util/BuildInfo;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenTrackerFactoryImpl implements ScreenTrackerFactory {
    public final Analytics a;
    public final TrackerInfoProvider b;
    public final NetworkTypeProvider c;
    public final NetworkSpeedProvider d;
    public final ImageBucketProvider e;
    public final Features f;
    public final ScreenTimeProvider g;
    public final SessionResolver h;
    public final MemoryMetricsReporter i;
    public final BuildInfo j;

    public ScreenTrackerFactoryImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull NetworkSpeedProvider networkSpeedProvider, @NotNull ImageBucketProvider imageBucketProvider, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull SessionResolver sessionResolver, @NotNull MemoryMetricsReporter memoryMetricsReporter, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(networkSpeedProvider, "networkSpeedProvider");
        Intrinsics.checkNotNullParameter(imageBucketProvider, "imageBucketProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(memoryMetricsReporter, "memoryMetricsReporter");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = analytics;
        this.b = trackerInfoProvider;
        this.c = networkTypeProvider;
        this.d = networkSpeedProvider;
        this.e = imageBucketProvider;
        this.f = features;
        this.g = screenTimeProvider;
        this.h = sessionResolver;
        this.i = memoryMetricsReporter;
        this.j = buildInfo;
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenTrackerFactory
    @NotNull
    public ScreenDiInjectTracker createDiInjectTracker(@NotNull Screen screen, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return new ScreenDiInjectTrackerImpl(this.a, this.b, screen, this.f, this.g, str);
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenTrackerFactory
    @NotNull
    public ScreenInitTracker createInitTracker(@NotNull Screen screen, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return new ScreenInitTrackerImpl(this.a, this.b, screen, this.h, timerFactory.timer(), this.f, this.g, str);
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenTrackerFactory
    @NotNull
    public ScreenFlowTrackerProvider createScreenFlowTrackerProvider(@NotNull Screen screen, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return new ScreenFlowTrackerProviderImpl(this.a, this.b, screen, this.h, this.c, timerFactory, this.d, this.e, this.f, this.g, new AnalyticMetricsFormatter(), this.i, this.j);
    }
}
