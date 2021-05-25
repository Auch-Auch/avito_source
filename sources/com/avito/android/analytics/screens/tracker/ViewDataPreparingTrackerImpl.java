package com.avito.android.analytics.screens.tracker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenDataPreparingEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u0012\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b*\u0010+J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/AbstractTracker;", "Lcom/avito/android/analytics/screens/tracker/ViewDataPreparingTracker;", "", "page", "", PublicConstantsKt.FAILURE, "", "trackViewDataPreparing", "(Ljava/lang/Integer;Z)V", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "d", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "screenName", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "i", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "formatter", "Lcom/avito/android/analytics/screens/Screen;", "e", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "f", "contentType", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "h", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/Timer;", "timer", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ViewDataPreparingTrackerImpl extends AbstractTracker implements ViewDataPreparingTracker {
    public final String b;
    public final Analytics c;
    public final TrackerInfoProvider d;
    public final Screen e;
    public final String f;
    public final Features g;
    public final ScreenTimeProvider h;
    public final AnalyticMetricsFormatter i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDataPreparingTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull String str, @NotNull Timer timer, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull AnalyticMetricsFormatter analyticMetricsFormatter) {
        super(timer);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(str, "contentType");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(analyticMetricsFormatter, "formatter");
        this.c = analytics;
        this.d = trackerInfoProvider;
        this.e = screen;
        this.f = str;
        this.g = features;
        this.h = screenTimeProvider;
        this.i = analyticMetricsFormatter;
        this.b = screen.getName();
    }

    @Override // com.avito.android.analytics.screens.tracker.ViewDataPreparingTracker
    public void trackViewDataPreparing(@Nullable Integer num, boolean z) {
        String formatInt$analytics_screens_release = this.i.formatInt$analytics_screens_release(num);
        String str = z ? InternalConstsKt.PLACEHOLDER : InternalConstsKt.NOT_PLACEHOLDER;
        long elapsed = elapsed();
        if (this.g.getScreenPerformanceMetricsToStatsd().invoke().booleanValue() || (this.e.getHasSmallEventsCount() && this.g.getSendSmallMetrics().invoke().booleanValue())) {
            StringBuilder sb = new StringBuilder();
            a.J0(this.d, sb, ".absolute", FormatterType.defaultDecimalSeparator);
            sb.append(this.b);
            sb.append(".-");
            sb.append(".view-data-preparing");
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(this.f);
            sb.append(".page-");
            sb.append(formatInt$analytics_screens_release);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(str);
            this.c.track(new StatsdEvent.TimeEvent(sb.toString(), Long.valueOf(elapsed)));
        }
        if (this.g.getScreenPerformanceMetricsToDwh().invoke().booleanValue() || (this.e.getHasSmallEventsCount() && this.g.getSendSmallMetrics().invoke().booleanValue())) {
            this.c.track(new ScreenDataPreparingEvent(this.b, this.h.screenStartTimestamp(), elapsed, this.f, num != null ? num.intValue() : 0, this.h.timestampSince1970(), this.i.formatError(z), this.h.lastClickTimestamp(), this.h.startupTimeTimestamp()));
        }
    }
}
