package com.avito.android.di.module;

import com.avito.android.app.task.UpdateVersionTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideUpdateVersionTaskFactory implements Factory<UpdateVersionTask> {
    public final Provider<ShortTaskExactScheduler> a;

    public AnalyticsTasksModule_ProvideUpdateVersionTaskFactory(Provider<ShortTaskExactScheduler> provider) {
        this.a = provider;
    }

    public static AnalyticsTasksModule_ProvideUpdateVersionTaskFactory create(Provider<ShortTaskExactScheduler> provider) {
        return new AnalyticsTasksModule_ProvideUpdateVersionTaskFactory(provider);
    }

    public static UpdateVersionTask provideUpdateVersionTask(ShortTaskExactScheduler shortTaskExactScheduler) {
        return (UpdateVersionTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideUpdateVersionTask(shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public UpdateVersionTask get() {
        return provideUpdateVersionTask(this.a.get());
    }
}
