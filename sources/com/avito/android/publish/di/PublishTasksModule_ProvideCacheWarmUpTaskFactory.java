package com.avito.android.publish.di;

import com.avito.android.app.task.CacheWarmUpTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class PublishTasksModule_ProvideCacheWarmUpTaskFactory implements Factory<CacheWarmUpTask> {
    public final Provider<AddAdvertInteractor> a;

    public PublishTasksModule_ProvideCacheWarmUpTaskFactory(Provider<AddAdvertInteractor> provider) {
        this.a = provider;
    }

    public static PublishTasksModule_ProvideCacheWarmUpTaskFactory create(Provider<AddAdvertInteractor> provider) {
        return new PublishTasksModule_ProvideCacheWarmUpTaskFactory(provider);
    }

    public static CacheWarmUpTask provideCacheWarmUpTask(AddAdvertInteractor addAdvertInteractor) {
        return (CacheWarmUpTask) Preconditions.checkNotNullFromProvides(PublishTasksModule.INSTANCE.provideCacheWarmUpTask(addAdvertInteractor));
    }

    @Override // javax.inject.Provider
    public CacheWarmUpTask get() {
        return provideCacheWarmUpTask(this.a.get());
    }
}
