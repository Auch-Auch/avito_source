package com.avito.android.di.module;

import com.avito.android.service.short_task.ShortTaskPeriodicScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShortTaskModule_ProvideShortTaskPeriodicSchedulerFactory implements Factory<ShortTaskPeriodicScheduler> {
    public final ShortTaskModule a;

    public ShortTaskModule_ProvideShortTaskPeriodicSchedulerFactory(ShortTaskModule shortTaskModule) {
        this.a = shortTaskModule;
    }

    public static ShortTaskModule_ProvideShortTaskPeriodicSchedulerFactory create(ShortTaskModule shortTaskModule) {
        return new ShortTaskModule_ProvideShortTaskPeriodicSchedulerFactory(shortTaskModule);
    }

    public static ShortTaskPeriodicScheduler provideShortTaskPeriodicScheduler(ShortTaskModule shortTaskModule) {
        return (ShortTaskPeriodicScheduler) Preconditions.checkNotNullFromProvides(shortTaskModule.provideShortTaskPeriodicScheduler());
    }

    @Override // javax.inject.Provider
    public ShortTaskPeriodicScheduler get() {
        return provideShortTaskPeriodicScheduler(this.a);
    }
}
