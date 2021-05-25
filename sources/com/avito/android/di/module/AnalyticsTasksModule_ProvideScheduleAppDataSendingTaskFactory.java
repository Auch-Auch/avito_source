package com.avito.android.di.module;

import com.avito.android.app.task.ScheduleAppDataSendingTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideScheduleAppDataSendingTaskFactory implements Factory<ScheduleAppDataSendingTask> {
    public final Provider<ShortTaskExactScheduler> a;

    public AnalyticsTasksModule_ProvideScheduleAppDataSendingTaskFactory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static AnalyticsTasksModule_ProvideScheduleAppDataSendingTaskFactory create(Provider<ShortTaskExactScheduler> provider) {
        return new AnalyticsTasksModule_ProvideScheduleAppDataSendingTaskFactory(provider);
    }

    public static ScheduleAppDataSendingTask provideScheduleAppDataSendingTask(ShortTaskExactScheduler shortTaskExactScheduler) {
        return (ScheduleAppDataSendingTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideScheduleAppDataSendingTask(shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public ScheduleAppDataSendingTask get() {
        return provideScheduleAppDataSendingTask(this.a.get());
    }
}
