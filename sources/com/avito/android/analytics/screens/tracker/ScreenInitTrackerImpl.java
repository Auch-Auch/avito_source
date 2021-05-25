package com.avito.android.analytics.screens.tracker;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenInitEvent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u000bR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u000fR\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ScreenInitTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "", Tracker.Events.CREATIVE_START, "()V", "", "durationMs", "trackInit", "(J)V", "", "d", "Z", "isFirstTime", "", "l", "Ljava/lang/String;", "contentType", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "k", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "c", "init", "Lcom/avito/android/analytics/screens/Timer;", "i", "Lcom/avito/android/analytics/screens/Timer;", "timer", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", AuthSource.SEND_ABUSE, "isNotComponent", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "f", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "h", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", AuthSource.BOOKING_ORDER, "screenName", "Lcom/avito/android/analytics/screens/Screen;", g.a, "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Ljava/lang/String;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenInitTrackerImpl implements ScreenInitTracker {
    public final boolean a;
    public final String b;
    public final String c;
    public boolean d;
    public final Analytics e;
    public final TrackerInfoProvider f;
    public final Screen g;
    public final SessionResolver h;
    public final Timer i;
    public final Features j;
    public final ScreenTimeProvider k;
    public final String l;

    public ScreenInitTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull SessionResolver sessionResolver, @NotNull Timer timer, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(str, "contentType");
        this.e = analytics;
        this.f = trackerInfoProvider;
        this.g = screen;
        this.h = sessionResolver;
        this.i = timer;
        this.j = features;
        this.k = screenTimeProvider;
        this.l = str;
        boolean areEqual = Intrinsics.areEqual(str, InternalConstsKt.SCREEN);
        this.a = areEqual;
        this.b = screen.getName();
        if (areEqual) {
            str2 = InternalConstsKt.SCREEN_INIT;
        } else {
            str2 = a.c3("component-init.", str);
        }
        this.c = str2;
        this.d = true;
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenInitTracker
    public void start() {
        this.i.start();
    }

    @Override // com.avito.android.analytics.screens.tracker.ScreenInitTracker
    public void trackInit(long j2) {
        if (j2 == -1) {
            j2 = this.i.elapsed();
        }
        if (this.j.getScreenPerformanceMetricsToStatsd().invoke().booleanValue() || (this.g.getHasSmallEventsCount() && this.j.getSendSmallMetrics().invoke().booleanValue())) {
            if (this.d && this.a) {
                StringBuilder sb = new StringBuilder();
                a.J0(this.f, sb, ".chronological", FormatterType.defaultDecimalSeparator);
                sb.append(this.h.sessionName());
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(this.b);
                sb.append(".-");
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(this.c);
                this.e.track(new StatsdEvent.TimeEvent(sb.toString(), Long.valueOf(this.h.elapsed())));
                this.d = false;
            }
            StringBuilder sb2 = new StringBuilder();
            a.J0(this.f, sb2, ".absolute", FormatterType.defaultDecimalSeparator);
            sb2.append(this.b);
            sb2.append(".-");
            sb2.append(FormatterType.defaultDecimalSeparator);
            sb2.append(this.c);
            this.e.track(new StatsdEvent.TimeEvent(sb2.toString(), Long.valueOf(j2)));
        }
        if (this.j.getScreenPerformanceMetricsToDwh().invoke().booleanValue() || (this.g.getHasSmallEventsCount() && this.j.getSendSmallMetrics().invoke().booleanValue())) {
            this.e.track(new ScreenInitEvent(this.b, this.k.screenStartTimestamp(), j2, this.k.timestampSince1970(), this.k.lastClickTimestamp(), this.k.startupTimeTimestamp(), this.l));
        }
    }
}
