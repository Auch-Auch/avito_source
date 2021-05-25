package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.FetchABTestsConfigTask;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestsTasksModule_ProvideLoadAbTestsConfigTaskFactory implements Factory<FetchABTestsConfigTask> {
    public final Provider<AbTestsReloadTask> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<BuildInfo> c;

    public AbTestsTasksModule_ProvideLoadAbTestsConfigTaskFactory(Provider<AbTestsReloadTask> provider, Provider<AccountStateProvider> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AbTestsTasksModule_ProvideLoadAbTestsConfigTaskFactory create(Provider<AbTestsReloadTask> provider, Provider<AccountStateProvider> provider2, Provider<BuildInfo> provider3) {
        return new AbTestsTasksModule_ProvideLoadAbTestsConfigTaskFactory(provider, provider2, provider3);
    }

    public static FetchABTestsConfigTask provideLoadAbTestsConfigTask(AbTestsReloadTask abTestsReloadTask, AccountStateProvider accountStateProvider, BuildInfo buildInfo) {
        return (FetchABTestsConfigTask) Preconditions.checkNotNullFromProvides(AbTestsTasksModule.INSTANCE.provideLoadAbTestsConfigTask(abTestsReloadTask, accountStateProvider, buildInfo));
    }

    @Override // javax.inject.Provider
    public FetchABTestsConfigTask get() {
        return provideLoadAbTestsConfigTask(this.a.get(), this.b.get(), this.c.get());
    }
}
