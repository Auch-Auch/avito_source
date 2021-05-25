package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import com.avito.android.app.task.SubscribeToForegroundStateTask;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideSubscribeToForegroundStateTaskFactory implements Factory<SubscribeToForegroundStateTask> {
    public final Provider<List<ApplicationForegroundStartupTask>> a;
    public final Provider<MutableApplicationStartupTasksRegistry> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Analytics> d;

    public CoreTasksModule_ProvideSubscribeToForegroundStateTaskFactory(Provider<List<ApplicationForegroundStartupTask>> provider, Provider<MutableApplicationStartupTasksRegistry> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CoreTasksModule_ProvideSubscribeToForegroundStateTaskFactory create(Provider<List<ApplicationForegroundStartupTask>> provider, Provider<MutableApplicationStartupTasksRegistry> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4) {
        return new CoreTasksModule_ProvideSubscribeToForegroundStateTaskFactory(provider, provider2, provider3, provider4);
    }

    public static SubscribeToForegroundStateTask provideSubscribeToForegroundStateTask(List<ApplicationForegroundStartupTask> list, MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, SchedulersFactory3 schedulersFactory3, Analytics analytics) {
        return (SubscribeToForegroundStateTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideSubscribeToForegroundStateTask(list, mutableApplicationStartupTasksRegistry, schedulersFactory3, analytics));
    }

    @Override // javax.inject.Provider
    public SubscribeToForegroundStateTask get() {
        return provideSubscribeToForegroundStateTask(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
