package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.CheckRequestTask;
import com.avito.android.app.task.FingerprintCalculationSchedulerTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideBackgroundTasksFactory implements Factory<Set<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<CheckRequestTask> a;
    public final Provider<FingerprintCalculationSchedulerTask> b;

    public CoreTasksModule_ProvideBackgroundTasksFactory(Provider<CheckRequestTask> provider, Provider<FingerprintCalculationSchedulerTask> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreTasksModule_ProvideBackgroundTasksFactory create(Provider<CheckRequestTask> provider, Provider<FingerprintCalculationSchedulerTask> provider2) {
        return new CoreTasksModule_ProvideBackgroundTasksFactory(provider, provider2);
    }

    public static Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<CheckRequestTask> lazy, Lazy<FingerprintCalculationSchedulerTask> lazy2) {
        return (Set) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideBackgroundTasks(lazy, lazy2));
    }

    @Override // javax.inject.Provider
    public Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a), DoubleCheck.lazy(this.b));
    }
}
