package com.avito.android.analytics.screens.tracker;

import a2.g.r.g;
import android.os.Handler;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.perfomance.ScreenDataDrawingEvent;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0005¢\u0006\u0004\b5\u00106J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/avito/android/analytics/screens/tracker/ContentDrawingTrackerImpl;", "Lcom/avito/android/analytics/screens/tracker/AbstractTracker;", "Lcom/avito/android/analytics/screens/tracker/ContentDrawingTracker;", "", "page", "", PublicConstantsKt.FAILURE, "", "trackContentDrawingTracker", "(Ljava/lang/Integer;Z)V", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "f", "Lcom/avito/android/analytics/screens/tracker/SessionResolver;", "sessionResolver", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "k", "Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;", "formatter", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "screenName", g.a, "contentType", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "handler", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/screens/Screen;", "e", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "l", "Z", "isFirstTime", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "d", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "j", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "screenTimeProvider", "Lcom/avito/android/analytics/screens/Timer;", "timer", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Lcom/avito/android/analytics/screens/Screen;Lcom/avito/android/analytics/screens/tracker/SessionResolver;Ljava/lang/String;Landroid/os/Handler;Lcom/avito/android/analytics/screens/Timer;Lcom/avito/android/Features;Lcom/avito/android/analytics/screens/ScreenTimeProvider;Lcom/avito/android/analytics/screens/tracker/AnalyticMetricsFormatter;Z)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ContentDrawingTrackerImpl extends AbstractTracker implements ContentDrawingTracker {
    public final String b;
    public final Analytics c;
    public final TrackerInfoProvider d;
    public final Screen e;
    public final SessionResolver f;
    public final String g;
    public final Handler h;
    public final Features i;
    public final ScreenTimeProvider j;
    public final AnalyticMetricsFormatter k;
    public boolean l;

    public static final class a implements Runnable {
        public final /* synthetic */ ContentDrawingTrackerImpl a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ boolean c;

        public a(ContentDrawingTrackerImpl contentDrawingTrackerImpl, Integer num, boolean z) {
            this.a = contentDrawingTrackerImpl;
            this.b = num;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContentDrawingTrackerImpl.access$track(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentDrawingTrackerImpl(Analytics analytics, TrackerInfoProvider trackerInfoProvider, Screen screen, SessionResolver sessionResolver, String str, Handler handler, Timer timer, Features features, ScreenTimeProvider screenTimeProvider, AnalyticMetricsFormatter analyticMetricsFormatter, boolean z, int i2, j jVar) {
        this(analytics, trackerInfoProvider, screen, sessionResolver, str, handler, timer, features, screenTimeProvider, analyticMetricsFormatter, (i2 & 1024) != 0 ? true : z);
    }

    public static final void access$track(ContentDrawingTrackerImpl contentDrawingTrackerImpl, Integer num, boolean z) {
        String formatInt$analytics_screens_release = contentDrawingTrackerImpl.k.formatInt$analytics_screens_release(num);
        String str = z ? InternalConstsKt.PLACEHOLDER : InternalConstsKt.NOT_PLACEHOLDER;
        long elapsed = contentDrawingTrackerImpl.elapsed();
        if (contentDrawingTrackerImpl.i.getScreenPerformanceMetricsToStatsd().invoke().booleanValue() || (contentDrawingTrackerImpl.e.getHasSmallEventsCount() && contentDrawingTrackerImpl.i.getSendSmallMetrics().invoke().booleanValue())) {
            if (contentDrawingTrackerImpl.l) {
                StringBuilder sb = new StringBuilder();
                a2.b.a.a.a.J0(contentDrawingTrackerImpl.d, sb, ".chronological", FormatterType.defaultDecimalSeparator);
                sb.append(contentDrawingTrackerImpl.f.sessionName());
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(contentDrawingTrackerImpl.b);
                sb.append(".-");
                sb.append(".content-drawing");
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(contentDrawingTrackerImpl.g);
                sb.append(".page-");
                sb.append(formatInt$analytics_screens_release);
                sb.append(FormatterType.defaultDecimalSeparator);
                sb.append(str);
                contentDrawingTrackerImpl.c.track(new StatsdEvent.TimeEvent(sb.toString(), Long.valueOf(contentDrawingTrackerImpl.f.elapsed())));
                contentDrawingTrackerImpl.l = false;
            }
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.J0(contentDrawingTrackerImpl.d, sb2, ".absolute", FormatterType.defaultDecimalSeparator);
            sb2.append(contentDrawingTrackerImpl.b);
            sb2.append(".-");
            sb2.append(".content-drawing");
            sb2.append(FormatterType.defaultDecimalSeparator);
            sb2.append(contentDrawingTrackerImpl.g);
            sb2.append(".page-");
            sb2.append(formatInt$analytics_screens_release);
            sb2.append(FormatterType.defaultDecimalSeparator);
            sb2.append(str);
            contentDrawingTrackerImpl.c.track(new StatsdEvent.TimeEvent(sb2.toString(), Long.valueOf(elapsed)));
        }
        if (contentDrawingTrackerImpl.i.getScreenPerformanceMetricsToDwh().invoke().booleanValue() || (contentDrawingTrackerImpl.e.getHasSmallEventsCount() && contentDrawingTrackerImpl.i.getSendSmallMetrics().invoke().booleanValue())) {
            contentDrawingTrackerImpl.c.track(new ScreenDataDrawingEvent(contentDrawingTrackerImpl.b, contentDrawingTrackerImpl.j.screenStartTimestamp(), elapsed, contentDrawingTrackerImpl.g, num != null ? num.intValue() : 0, contentDrawingTrackerImpl.j.timestampSince1970(), contentDrawingTrackerImpl.k.formatError(z), contentDrawingTrackerImpl.j.lastClickTimestamp(), contentDrawingTrackerImpl.j.startupTimeTimestamp()));
        }
    }

    @Override // com.avito.android.analytics.screens.tracker.ContentDrawingTracker
    public void trackContentDrawingTracker(@Nullable Integer num, boolean z) {
        this.h.post(new a(this, num, z));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentDrawingTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull Screen screen, @NotNull SessionResolver sessionResolver, @NotNull String str, @NotNull Handler handler, @NotNull Timer timer, @NotNull Features features, @NotNull ScreenTimeProvider screenTimeProvider, @NotNull AnalyticMetricsFormatter analyticMetricsFormatter, boolean z) {
        super(timer);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(sessionResolver, "sessionResolver");
        Intrinsics.checkNotNullParameter(str, "contentType");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(screenTimeProvider, "screenTimeProvider");
        Intrinsics.checkNotNullParameter(analyticMetricsFormatter, "formatter");
        this.c = analytics;
        this.d = trackerInfoProvider;
        this.e = screen;
        this.f = sessionResolver;
        this.g = str;
        this.h = handler;
        this.i = features;
        this.j = screenTimeProvider;
        this.k = analyticMetricsFormatter;
        this.l = z;
        this.b = screen.getName();
    }
}
