package com.avito.android.analytics.screens;

import a2.g.r.g;
import android.os.Handler;
import android.os.Looper;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.screens.image.ImageBucketProvider;
import com.avito.android.analytics.screens.image.ImageContentTypeResolver;
import com.avito.android.analytics.screens.image.ImageLoadingTracker;
import com.avito.android.analytics.screens.image.ImageLoadingTrackerImpl;
import com.avito.android.analytics.screens.tracker.AnalyticMetricsFormatter;
import com.avito.android.analytics.screens.tracker.ContentDrawingTracker;
import com.avito.android.analytics.screens.tracker.ContentDrawingTrackerImpl;
import com.avito.android.analytics.screens.tracker.ContentLoadingTracker;
import com.avito.android.analytics.screens.tracker.LocalContentLoadingTrackerImpl;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTracker;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTrackerImpl;
import com.avito.android.analytics.screens.tracker.ScreenMemoryMeasureTrackerStub;
import com.avito.android.analytics.screens.tracker.ServerContentLoadingTrackerImpl;
import com.avito.android.analytics.screens.tracker.SessionResolver;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker;
import com.avito.android.analytics.screens.tracker.ViewDataPreparingTrackerImpl;
import com.avito.android.connection_quality.NetworkSpeedProvider;
import com.avito.android.memory_consumption.MemoryMetricsReporter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010A\u001a\u00020>¢\u0006\u0004\bR\u0010SJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/avito/android/analytics/screens/ScreenFlowTrackerProviderImpl;", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "contentType", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "getContentLoadingFromLocalStorage", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "getContentLoadingFromRemoteStorage", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "getViewPreparing", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "getContentDrawing", "(Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;", "typeResolver", "Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "getImageLoading", "(Lcom/avito/android/analytics/screens/image/ImageContentTypeResolver;)Lcom/avito/android/analytics/screens/image/ImageLoadingTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "getMemoryMeasureTracker", "()Lcom/avito/android/analytics/screens/tracker/ScreenMemoryMeasureTracker;", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "l", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/Screen;", "e", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/NetworkTypeProvider;", g.a, "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "i", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "networkSpeedProvider", "Lcom/avito/android/Features;", "k", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "n", "Lcom/avito/android/memory_consumption/MemoryMetricsReporter;", "memoryMetricsReporter", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "formatter", "", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "drawingCache", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "f", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", "Lcom/avito/android/util/BuildInfo;", "o", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/screens/TimerFactory;", "h", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "j", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "imageBucketProvider", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "d", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Landroid/os/Handler;", AuthSource.SEND_ABUSE, "Landroid/os/Handler;", "handler", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/analytics/screens/TimerFactory;Lcom/avito/android/connection_quality/NetworkSpeedProvider;Lcom/avito/android/analytics/screens/image/ImageBucketProvider;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;Lcom/avito/android/memory_consumption/MemoryMetricsReporter;Lcom/avito/android/util/BuildInfo;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenFlowTrackerProviderImpl implements ScreenFlowTrackerProvider {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Set<String> b = new LinkedHashSet();
    public final Analytics c;
    public final TrackerInfoProvider d;
    public final Screen e;
    public final SessionResolver f;
    public final NetworkTypeProvider g;
    public final TimerFactory h;
    public final NetworkSpeedProvider i;
    public final ImageBucketProvider j;
    public final Features k;
    public final ScreenTimeProvider l;
    public final AnalyticMetricsFormatter m;
    public final MemoryMetricsReporter n;
    public final BuildInfo o;

    public ScreenFlowTrackerProviderImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull SessionResolver sessionResolver, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull TimerFactory timerFactory, @NotNull NetworkSpeedProvider networkSpeedProvider, @NotNull ImageBucketProvider imageBucketProvider, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull AnalyticMetricsFormatter analyticMetricsFormatter, @NotNull MemoryMetricsReporter memoryMetricsReporter, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(networkSpeedProvider, "networkSpeedProvider");
        Intrinsics.checkNotNullParameter(imageBucketProvider, "imageBucketProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(analyticMetricsFormatter, "formatter");
        Intrinsics.checkNotNullParameter(memoryMetricsReporter, "memoryMetricsReporter");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.c = analytics;
        this.d = trackerInfoProvider;
        this.e = screen;
        this.f = sessionResolver;
        this.g = networkTypeProvider;
        this.h = timerFactory;
        this.i = networkSpeedProvider;
        this.j = imageBucketProvider;
        this.k = features;
        this.l = screenTimeProvider;
        this.m = analyticMetricsFormatter;
        this.n = memoryMetricsReporter;
        this.o = buildInfo;
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ContentDrawingTracker getContentDrawing(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentType");
        Logs.debug$default("ScreenFlowTrackerProvider", "getContentDrawing", null, 4, null);
        boolean z = !this.b.contains(str);
        this.b.add(str);
        return new ContentDrawingTrackerImpl(this.c, this.d, this.e, this.f, str, this.a, this.h.timer(), this.k, this.l, this.m, z);
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ContentLoadingTracker getContentLoadingFromLocalStorage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentType");
        Logs.debug$default("ScreenFlowTrackerProvider", "getContentLoadingFromLocalStorage", null, 4, null);
        return new LocalContentLoadingTrackerImpl(this.c, this.d, this.e, str, this.h.timer(), this.k, this.l, this.m);
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ContentLoadingTracker getContentLoadingFromRemoteStorage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentType");
        Logs.debug$default("ScreenFlowTrackerProvider", "getContentLoadingFromRemoteStorage", null, 4, null);
        return new ServerContentLoadingTrackerImpl(this.c, this.d, this.e, str, this.g, this.h.timer(), this.i, this.k, this.l, this.m);
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ImageLoadingTracker getImageLoading(@NotNull ImageContentTypeResolver imageContentTypeResolver) {
        Intrinsics.checkNotNullParameter(imageContentTypeResolver, "typeResolver");
        Logs.debug$default("ScreenFlowTrackerProvider", "getImageLoading", null, 4, null);
        return new ImageLoadingTrackerImpl(this.c, this.d, this.e, this.f, imageContentTypeResolver, this.g, this.a, this.h.timer(), this.k, this.j, this.l);
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ScreenMemoryMeasureTracker getMemoryMeasureTracker() {
        if (this.o.getSdkVersion() < 23 || !this.k.getCollectMemoryMetrics().invoke().booleanValue()) {
            return new ScreenMemoryMeasureTrackerStub();
        }
        return new ScreenMemoryMeasureTrackerImpl(this.c, this.d, this.e, new Handler(Looper.getMainLooper()), this.h.timer(), this.k, this.n);
    }

    @Override // com.avito.android.analytics.screens.ScreenFlowTrackerProvider
    @NotNull
    public ViewDataPreparingTracker getViewPreparing(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentType");
        Logs.debug$default("ScreenFlowTrackerProvider", "getViewPreparing", null, 4, null);
        return new ViewDataPreparingTrackerImpl(this.c, this.d, this.e, str, this.h.timer(), this.k, this.l, this.m);
    }
}
