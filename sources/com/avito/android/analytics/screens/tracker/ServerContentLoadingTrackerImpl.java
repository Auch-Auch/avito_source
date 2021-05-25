package com.avito.android.analytics.screens.tracker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.event.perfomance.ScreenServerLoadingEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.connection_quality.NetworkSpeedProvider;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b3\u00104J)\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ServerContentLoadingTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/AbstractTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentLoadingTracker;", "", "page", "", PublicConstantsKt.FAILURE, "", "durationMs", "", "trackContentLoading", "(Ljava/lang/Integer;Ljava/lang/String;J)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "screenName", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/NetworkTypeProvider;", g.a, "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "f", "contentType", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "k", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "formatter", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "j", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "d", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/screens/Screen;", "e", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "h", "Lcom/avito/android/connection_quality/NetworkSpeedProvider;", "networkSpeedProvider", "Lcom/avito/android/analytics/screens/Timer;", "timer", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;Lcom/avito/android/analytics/NetworkTypeProvider;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/connection_quality/NetworkSpeedProvider;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ServerContentLoadingTrackerImpl extends AbstractTracker implements ContentLoadingTracker {
    public final String b;
    public final Analytics c;
    public final TrackerInfoProvider d;
    public final Screen e;
    public final String f;
    public final NetworkTypeProvider g;
    public final NetworkSpeedProvider h;
    public final Features i;
    public final ScreenTimeProvider j;
    public final AnalyticMetricsFormatter k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServerContentLoadingTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull String str, @NotNull NetworkTypeProvider networkTypeProvider, @NotNull Timer timer, @NotNull NetworkSpeedProvider networkSpeedProvider, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull AnalyticMetricsFormatter analyticMetricsFormatter) {
        super(timer);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(str, "contentType");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(networkSpeedProvider, "networkSpeedProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(analyticMetricsFormatter, "formatter");
        this.c = analytics;
        this.d = trackerInfoProvider;
        this.e = screen;
        this.f = str;
        this.g = networkTypeProvider;
        this.h = networkSpeedProvider;
        this.i = features;
        this.j = screenTimeProvider;
        this.k = analyticMetricsFormatter;
        this.b = screen.getName();
    }

    @Override // com.avito.android.analytics.screens.tracker.ContentLoadingTracker
    public void trackContentLoading(@Nullable Integer num, @NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, PublicConstantsKt.FAILURE);
        long elapsed = j2 == -1 ? elapsed() : j2;
        String formatInt$analytics_screens_release = this.k.formatInt$analytics_screens_release(num);
        String networkType = this.g.networkType();
        if (this.i.getScreenPerformanceMetricsToStatsd().invoke().booleanValue() || (this.e.getHasSmallEventsCount() && this.i.getSendSmallMetrics().invoke().booleanValue())) {
            StringBuilder sb = new StringBuilder();
            a.J0(this.d, sb, ".absolute", FormatterType.defaultDecimalSeparator);
            sb.append(this.b);
            sb.append(".-");
            sb.append(".content-loading-server");
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(this.f);
            sb.append(".page-");
            sb.append(formatInt$analytics_screens_release);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(networkType);
            sb.append(".-");
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(str);
            this.c.track(new StatsdEvent.TimeEvent(sb.toString(), Long.valueOf(elapsed)));
        }
        if (this.i.getScreenPerformanceMetricsToDwh().invoke().booleanValue() || (this.e.getHasSmallEventsCount() && this.i.getSendSmallMetrics().invoke().booleanValue())) {
            this.c.track(new ScreenServerLoadingEvent(this.b, this.j.screenStartTimestamp(), elapsed, networkType, this.k.format(this.h.networkSpeed()), this.f, num != null ? num.intValue() : 0, this.j.timestampSince1970(), this.k.formatError(str), this.j.lastClickTimestamp(), this.j.startupTimeTimestamp()));
        }
    }
}
