package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksExecutor;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class ApplicationStartupTasksModule_ProvideApplicationStartupTasksExecutorFactory implements Factory<ApplicationStartupTasksExecutor> {
    public final Provider<List<ApplicationBlockingStartupTask>> a;
    public final Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> b;
    public final Provider<MutableApplicationStartupTasksRegistry> c;
    public final Provider<StartupAnalyticsTracker> d;
    public final Provider<SchedulersFactory3> e;

    public ApplicationStartupTasksModule_ProvideApplicationStartupTasksExecutorFactory(Provider<List<ApplicationBlockingStartupTask>> provider, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider2, Provider<MutableApplicationStartupTasksRegistry> provider3, Provider<StartupAnalyticsTracker> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ApplicationStartupTasksModule_ProvideApplicationStartupTasksExecutorFactory create(Provider<List<ApplicationBlockingStartupTask>> provider, Provider<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> provider2, Provider<MutableApplicationStartupTasksRegistry> provider3, Provider<StartupAnalyticsTracker> provider4, Provider<SchedulersFactory3> provider5) {
        return new ApplicationStartupTasksModule_ProvideApplicationStartupTasksExecutorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ApplicationStartupTasksExecutor provideApplicationStartupTasksExecutor(List<ApplicationBlockingStartupTask> list, List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list2, MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, StartupAnalyticsTracker startupAnalyticsTracker, SchedulersFactory3 schedulersFactory3) {
        return (ApplicationStartupTasksExecutor) Preconditions.checkNotNullFromProvides(ApplicationStartupTasksModule.INSTANCE.provideApplicationStartupTasksExecutor(list, list2, mutableApplicationStartupTasksRegistry, startupAnalyticsTracker, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ApplicationStartupTasksExecutor get() {
        return provideApplicationStartupTasksExecutor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
