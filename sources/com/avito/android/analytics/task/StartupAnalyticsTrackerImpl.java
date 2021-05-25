package com.avito.android.analytics.task;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/task/StartupAnalyticsTrackerImpl;", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "", "name", "", "elapsed", "", "track", "(Ljava/lang/String;J)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "prefix", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "<init>", "(Lcom/avito/android/analytics/grafana/GraphitePrefix;Lcom/avito/android/analytics/Analytics;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class StartupAnalyticsTrackerImpl implements StartupAnalyticsTracker {
    public final String a;
    public final Analytics b;

    @Inject
    public StartupAnalyticsTrackerImpl(@NotNull GraphitePrefix graphitePrefix, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = analytics;
        this.a = graphitePrefix.getVersionsPrefix() + ".startup-events";
    }

    @Override // com.avito.android.analytics.task.StartupAnalyticsTracker
    public void track(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        Analytics analytics = this.b;
        analytics.track(new StatsdEvent.TimeEvent(this.a + FormatterType.defaultDecimalSeparator + str, Long.valueOf(j)));
    }
}
