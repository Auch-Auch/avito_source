package com.avito.android.advert_core.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.advert_core.task.FirstTimeRunTask;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class AdvertCoreTasksModule_ProvideBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<FirstTimeRunTask> a;

    public AdvertCoreTasksModule_ProvideBackgroundTasksFactory(Provider<FirstTimeRunTask> provider) {
        this.a = provider;
    }

    public static AdvertCoreTasksModule_ProvideBackgroundTasksFactory create(Provider<FirstTimeRunTask> provider) {
        return new AdvertCoreTasksModule_ProvideBackgroundTasksFactory(provider);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<FirstTimeRunTask> lazy) {
        return (List) Preconditions.checkNotNullFromProvides(AdvertCoreTasksModule.INSTANCE.provideBackgroundTasks(lazy));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a));
    }
}
