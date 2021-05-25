package com.avito.android.di.module;

import com.avito.android.service.short_task.FingerprintCalculationTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CoreTasksModule_ProvideFingerprintCalculationTaskFactory implements Factory<FingerprintCalculationTask> {

    public static final class a {
        public static final CoreTasksModule_ProvideFingerprintCalculationTaskFactory a = new CoreTasksModule_ProvideFingerprintCalculationTaskFactory();
    }

    public static CoreTasksModule_ProvideFingerprintCalculationTaskFactory create() {
        return a.a;
    }

    public static FingerprintCalculationTask provideFingerprintCalculationTask() {
        return (FingerprintCalculationTask) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideFingerprintCalculationTask());
    }

    @Override // javax.inject.Provider
    public FingerprintCalculationTask get() {
        return provideFingerprintCalculationTask();
    }
}
