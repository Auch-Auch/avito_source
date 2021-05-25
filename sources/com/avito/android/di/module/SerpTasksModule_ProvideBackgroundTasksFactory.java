package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.SerpDbDeleteTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class SerpTasksModule_ProvideBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<SerpDbDeleteTask> a;

    public SerpTasksModule_ProvideBackgroundTasksFactory(Provider<SerpDbDeleteTask> provider) {
        this.a = provider;
    }

    public static SerpTasksModule_ProvideBackgroundTasksFactory create(Provider<SerpDbDeleteTask> provider) {
        return new SerpTasksModule_ProvideBackgroundTasksFactory(provider);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<SerpDbDeleteTask> lazy) {
        return (List) Preconditions.checkNotNullFromProvides(SerpTasksModule.INSTANCE.provideBackgroundTasks(lazy));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a));
    }
}
