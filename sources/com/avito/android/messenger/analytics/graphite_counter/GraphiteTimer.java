package com.avito.android.messenger.analytics.graphite_counter;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.analytics.timer.AnalyticsTimerImpl;
import com.avito.android.server_time.TimeSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B+\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\t\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/analytics/graphite_counter/GraphiteTimer;", "T", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "", "dispose", "()V", "result", "trackEnd", "(Ljava/lang/Object;)V", "trackStart", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "", "resultToKey", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/Analytics;Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GraphiteTimer<T> implements AnalyticsTimer<T> {
    public final /* synthetic */ AnalyticsTimerImpl<? super T> a;

    public GraphiteTimer(@NotNull TimeSource timeSource, @NotNull Analytics analytics, @NotNull Map<T, String> map) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(map, "resultToKey");
        this.a = new AnalyticsTimerImpl<>(timeSource, new GraphiteTimingHandler(analytics, map));
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void dispose() {
        this.a.dispose();
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void trackEnd(T t) {
        this.a.trackEnd(t);
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void trackStart() {
        this.a.trackStart();
    }
}
