package com.avito.android.di.module;

import com.avito.android.app.task.ScheduleMetricSendingTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideScheduleMetricSendingTaskFactory implements Factory<ScheduleMetricSendingTask> {
    public final Provider<SchedulersFactory> a;
    public final Provider<ShortTaskExactScheduler> b;
    public final Provider<SendMetricTask> c;

    public AnalyticsTasksModule_ProvideScheduleMetricSendingTaskFactory(Provider<SchedulersFactory> provider, Provider<ShortTaskExactScheduler> provider2, Provider<SendMetricTask> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticsTasksModule_ProvideScheduleMetricSendingTaskFactory create(Provider<SchedulersFactory> provider, Provider<ShortTaskExactScheduler> provider2, Provider<SendMetricTask> provider3) {
        return new AnalyticsTasksModule_ProvideScheduleMetricSendingTaskFactory(provider, provider2, provider3);
    }

    public static ScheduleMetricSendingTask provideScheduleMetricSendingTask(SchedulersFactory schedulersFactory, ShortTaskExactScheduler shortTaskExactScheduler, SendMetricTask sendMetricTask) {
        return (ScheduleMetricSendingTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideScheduleMetricSendingTask(schedulersFactory, shortTaskExactScheduler, sendMetricTask));
    }

    @Override // javax.inject.Provider
    public ScheduleMetricSendingTask get() {
        return provideScheduleMetricSendingTask(this.a.get(), this.b.get(), this.c.get());
    }
}
