package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.analytics.clickstream.AnalyticMetricsFormatter;
import com.avito.android.app.task.ScheduleMetricSendingTask$execute$callbacks$1;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.metrics.SendMetricTaskKt;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
public final class v0<T> implements Consumer<Long> {
    public final /* synthetic */ ScheduleMetricSendingTask$execute$callbacks$1 a;
    public final /* synthetic */ long b;

    public v0(ScheduleMetricSendingTask$execute$callbacks$1 scheduleMetricSendingTask$execute$callbacks$1, long j) {
        this.a = scheduleMetricSendingTask$execute$callbacks$1;
        this.b = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Long l) {
        Long l2 = l;
        AnalyticMetricsFormatter analyticMetricsFormatter = this.a.a;
        long j = this.b;
        Intrinsics.checkNotNullExpressionValue(l2, "startTimeElapsedMs");
        ShortTaskExactScheduler.DefaultImpls.schedule$default(this.a.b.taskScheduler, this.a.b.task, new LongRange(1000, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS), false, a.y1(SendMetricTaskKt.KEY_OPEN_APP_TIME_TO_INTERACT, analyticMetricsFormatter.formatTime(j - l2.longValue(), TimeUnit.MILLISECONDS)), 4, null);
    }
}
