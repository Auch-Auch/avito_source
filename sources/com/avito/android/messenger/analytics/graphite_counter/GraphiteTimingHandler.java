package com.avito.android.messenger.analytics.graphite_counter;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B#\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t8\b@\bX\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/analytics/graphite_counter/GraphiteTimingHandler;", "T", "Lcom/avito/android/analytics/timer/AnalyticsTimer$TimingHandler;", "", "timing", "result", "", "handle", "(ILjava/lang/Object;)V", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "resultToKey", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GraphiteTimingHandler<T> implements AnalyticsTimer.TimingHandler<T> {
    public final Analytics a;
    public final Map<T, String> b;

    public GraphiteTimingHandler(@NotNull Analytics analytics, @NotNull Map<T, String> map) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(map, "resultToKey");
        this.a = analytics;
        this.b = map;
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer.TimingHandler
    public void handle(int i, T t) {
        String str = this.b.get(t);
        StatsdEvent.TimeEvent timeEvent = new StatsdEvent.TimeEvent(a.c3("messenger.", str), Integer.valueOf(i));
        Logs.debug$default("graphite", "timing: key=" + str + ", time=" + i, null, 4, null);
        this.a.track(timeEvent);
    }
}
