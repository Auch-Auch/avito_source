package com.avito.android.messenger.analytics.graphite_counter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.timer.AnalyticsTimer;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\t\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingTimer;", "Lcom/avito/android/analytics/timer/AnalyticsTimer;", "Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingResult;", "", "dispose", "()V", "result", "trackEnd", "(Lcom/avito/android/messenger/analytics/graphite_counter/ChatLoadingResult;)V", "trackStart", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatLoadingTimer implements AnalyticsTimer<ChatLoadingResult> {
    public final /* synthetic */ GraphiteTimer<? super ChatLoadingResult> a;

    public ChatLoadingTimer(@NotNull TimeSource timeSource, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = new GraphiteTimer<>(timeSource, analytics, r.mapOf(TuplesKt.to(ChatLoadingResult.SUCCESS, "chat.success"), TuplesKt.to(ChatLoadingResult.ERROR, "chat.error")));
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void dispose() {
        this.a.dispose();
    }

    public void trackEnd(@NotNull ChatLoadingResult chatLoadingResult) {
        Intrinsics.checkNotNullParameter(chatLoadingResult, "result");
        this.a.trackEnd(chatLoadingResult);
    }

    @Override // com.avito.android.analytics.timer.AnalyticsTimer
    public void trackStart() {
        this.a.trackStart();
    }
}
