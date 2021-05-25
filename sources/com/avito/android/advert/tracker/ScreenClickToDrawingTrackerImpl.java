package com.avito.android.advert.tracker;

import a2.b.a.a.a;
import android.os.SystemClock;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/tracker/ScreenClickToDrawingTrackerImpl;", "Lcom/avito/android/advert/tracker/ScreenClickToDrawingTracker;", "", "clickTime", "", "trackDrawingContent", "(J)V", "", "c", "Ljava/lang/String;", "screenName", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/screens/TrackerInfoProvider;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenClickToDrawingTrackerImpl implements ScreenClickToDrawingTracker {
    public final Analytics a;
    public final TrackerInfoProvider b;
    public final String c;

    public ScreenClickToDrawingTrackerImpl(@NotNull Analytics analytics, @NotNull TrackerInfoProvider trackerInfoProvider, @NotNull String str) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(trackerInfoProvider, "trackerInfoProvider");
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.a = analytics;
        this.b = trackerInfoProvider;
        this.c = str;
    }

    @Override // com.avito.android.advert.tracker.ScreenClickToDrawingTracker
    public void trackDrawingContent(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder();
        a.J0(this.b, sb, ".absolute", FormatterType.defaultDecimalSeparator);
        this.a.track(new StatsdEvent.TimeEvent(a.u(sb, this.c, ".$-", ".from-click-to-drawing"), Long.valueOf(elapsedRealtime)));
    }
}
