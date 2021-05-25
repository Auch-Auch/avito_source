package com.avito.android.publish.di;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.CacheWarmUpTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class PublishTasksModule_ProvideBlockingTasksFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final Provider<CacheWarmUpTask> a;

    public PublishTasksModule_ProvideBlockingTasksFactory(Provider<CacheWarmUpTask> provider) {
        this.a = provider;
    }

    public static PublishTasksModule_ProvideBlockingTasksFactory create(Provider<CacheWarmUpTask> provider) {
        return new PublishTasksModule_ProvideBlockingTasksFactory(provider);
    }

    public static List<ApplicationBlockingStartupTask> provideBlockingTasks(CacheWarmUpTask cacheWarmUpTask) {
        return (List) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.provideBlockingTasks(cacheWarmUpTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideBlockingTasks(this.a.get());
    }
}
