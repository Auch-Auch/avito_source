package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/app/task/ScheduleMetricSendingTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "taskScheduler", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "task", "Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "<init>", "(Lcom/avito/android/service/short_task/metrics/SendMetricTask;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)V", "StartupTimeHolder", "application_release"}, k = 1, mv = {1, 4, 2})
public class ScheduleMetricSendingTask implements ApplicationBlockingStartupTask {
    public final SchedulersFactory schedulers;
    public final SendMetricTask task;
    public final ShortTaskExactScheduler taskScheduler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/app/task/ScheduleMetricSendingTask$StartupTimeHolder;", "", "", "getStartupBeginElapsedMs", "()J", "startupBeginElapsedMs", "application_release"}, k = 1, mv = {1, 4, 2})
    public interface StartupTimeHolder {
        long getStartupBeginElapsedMs();
    }

    public ScheduleMetricSendingTask(@NotNull SendMetricTask sendMetricTask, @NotNull SchedulersFactory schedulersFactory, @NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(sendMetricTask, "task");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        this.task = sendMetricTask;
        this.schedulers = schedulersFactory;
        this.taskScheduler = shortTaskExactScheduler;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(new ScheduleMetricSendingTask$execute$callbacks$1(this, application));
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
