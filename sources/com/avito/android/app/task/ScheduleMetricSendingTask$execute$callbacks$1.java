package com.avito.android.app.task;

import a2.a.a.j.a.u0;
import a2.a.a.j.a.v0;
import a2.a.a.j.a.w0;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import com.avito.android.analytics.clickstream.AnalyticMetricsFormatter;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.app.task.ScheduleMetricSendingTask;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"com/avito/android/app/task/ScheduleMetricSendingTask$execute$callbacks$1", "Lcom/avito/android/app/SimpleActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "", "onActivityResumed", "(Landroid/app/Activity;)V", "Landroid/content/Intent;", "", "isFromLauncher", "(Landroid/content/Intent;)Z", "scheduleTaskImmediately", "()V", "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "timeFormatter", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ScheduleMetricSendingTask$execute$callbacks$1 extends SimpleActivityLifecycleCallbacks {
    public final AnalyticMetricsFormatter a = new AnalyticMetricsFormatter();
    public final /* synthetic */ ScheduleMetricSendingTask b;
    public final /* synthetic */ Application c;

    public ScheduleMetricSendingTask$execute$callbacks$1(ScheduleMetricSendingTask scheduleMetricSendingTask, Application application) {
        this.b = scheduleMetricSendingTask;
        this.c = application;
    }

    public final boolean isFromLauncher(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$isFromLauncher");
        return intent.hasCategory("android.intent.category.LAUNCHER") && Intrinsics.areEqual(intent.getAction(), "android.intent.action.MAIN");
    }

    @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.unregisterActivityLifecycleCallbacks(this);
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        if (isFromLauncher(intent)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Application application = this.c;
            if (!(application instanceof ScheduleMetricSendingTask.StartupTimeHolder)) {
                application = null;
            }
            ScheduleMetricSendingTask.StartupTimeHolder startupTimeHolder = (ScheduleMetricSendingTask.StartupTimeHolder) application;
            if (startupTimeHolder != null) {
                Single.fromCallable(new u0(startupTimeHolder)).subscribeOn(this.b.schedulers.computation()).observeOn(this.b.schedulers.computation()).subscribe(new v0(this, elapsedRealtime), w0.a);
                return;
            }
            return;
        }
        scheduleTaskImmediately();
    }

    public final void scheduleTaskImmediately() {
        ShortTaskExactScheduler.DefaultImpls.schedule$default(this.b.taskScheduler, this.b.task, new LongRange(1000, DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS), false, null, 12, null);
    }
}
