package com.avito.android.di.module;

import com.avito.android.app.task.FingerprintCalculationSchedulerTask;
import com.avito.android.service.short_task.FingerprintCalculationTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideFingerprintCalculationSchedulerTaskFactory implements Factory<FingerprintCalculationSchedulerTask> {
    public final Provider<FingerprintCalculationTask> a;
    public final Provider<ShortTaskExactScheduler> b;

    public CoreTasksModule_ProvideFingerprintCalculationSchedulerTaskFactory(Provider<FingerprintCalculationTask> provider, Provider<ShortTaskExactScheduler> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CoreTasksModule_ProvideFingerprintCalculationSchedulerTaskFactory create(Provider<FingerprintCalculationTask> provider, Provider<ShortTaskExactScheduler> provider2) {
        return new CoreTasksModule_ProvideFingerprintCalculationSchedulerTaskFactory(provider, provider2);
    }

    public static FingerprintCalculationSchedulerTask provideFingerprintCalculationSchedulerTask(FingerprintCalculationTask fingerprintCalculationTask, ShortTaskExactScheduler shortTaskExactScheduler) {
        return (FingerprintCalculationSchedulerTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideFingerprintCalculationSchedulerTask(fingerprintCalculationTask, shortTaskExactScheduler));
    }

    @Override // javax.inject.Provider
    public FingerprintCalculationSchedulerTask get() {
        return provideFingerprintCalculationSchedulerTask(this.a.get(), this.b.get());
    }
}
