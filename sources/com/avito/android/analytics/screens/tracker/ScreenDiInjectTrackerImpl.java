package com.avito.android.analytics.screens.tracker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenDIEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010&\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\tR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\t¨\u0006)"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "", "durationMs", "", "track", "(J)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "screenName", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "e", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "", AuthSource.SEND_ABUSE, "Z", "isNotComponent", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "init", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "h", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/Screen;", "f", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "i", "contentType", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Ljava/lang/String;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenDiInjectTrackerImpl implements ScreenDiInjectTracker {
    public final boolean a;
    public final String b;
    public final String c;
    public final Analytics d;
    public final TrackerInfoProvider e;
    public final Screen f;
    public final Features g;
    public final ScreenTimeProvider h;
    public final String i;

    public ScreenDiInjectTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(str, "contentType");
        this.d = analytics;
        this.e = trackerInfoProvider;
        this.f = screen;
        this.g = features;
        this.h = screenTimeProvider;
        this.i = str;
        boolean areEqual = Intrinsics.areEqual(str, InternalConstsKt.SCREEN);
        this.a = areEqual;
        this.b = screen.getName();
        if (areEqual) {
            str2 = InternalConstsKt.SCREEN_DI_INJECT;
        } else {
            str2 = a.c3("component-di.", str);
        }
        this.c = str2;
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker
    public void track(long j) {
        if (this.g.getScreenPerformanceMetricsToStatsd().invoke().booleanValue() || (this.f.getHasSmallEventsCount() && this.g.getSendSmallMetrics().invoke().booleanValue())) {
            if (this.a) {
                long preInitTime = this.h.preInitTime();
                if (preInitTime > 0) {
                    StringBuilder sb = new StringBuilder();
                    a.J0(this.e, sb, ".absolute", FormatterType.defaultDecimalSeparator);
                    this.d.track(new StatsdEvent.TimeEvent(a.u(sb, this.b, ".-", ".screen-preinitialization"), Long.valueOf(preInitTime)));
                }
            }
            StringBuilder sb2 = new StringBuilder();
            a.J0(this.e, sb2, ".absolute", FormatterType.defaultDecimalSeparator);
            sb2.append(this.b);
            sb2.append(".-");
            sb2.append(FormatterType.defaultDecimalSeparator);
            sb2.append(this.c);
            this.d.track(new StatsdEvent.TimeEvent(sb2.toString(), Long.valueOf(j)));
        }
        if (this.g.getScreenPerformanceMetricsToDwh().invoke().booleanValue() || (this.f.getHasSmallEventsCount() && this.g.getSendSmallMetrics().invoke().booleanValue())) {
            this.d.track(new ScreenDIEvent(this.b, this.h.screenStartTimestamp(), j, this.h.timestampSince1970(), this.h.lastClickTimestamp(), this.h.startupTimeTimestamp(), this.i));
        }
    }
}
