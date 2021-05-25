package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.FetchABTestsConfigTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class AbTestsTasksModule_ProvideBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<FetchABTestsConfigTask> a;

    public AbTestsTasksModule_ProvideBackgroundTasksFactory(Provider<FetchABTestsConfigTask> provider) {
        this.a = provider;
    }

    public static AbTestsTasksModule_ProvideBackgroundTasksFactory create(Provider<FetchABTestsConfigTask> provider) {
        return new AbTestsTasksModule_ProvideBackgroundTasksFactory(provider);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<FetchABTestsConfigTask> lazy) {
        return (List) Preconditions.checkNotNullFromProvides(AbTestsTasksModule.INSTANCE.provideBackgroundTasks(lazy));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a));
    }
}
