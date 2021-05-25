package com.avito.android.di.module;

import com.avito.android.service.short_task.ShortTaskDailyScheduler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShortTaskModule_ProvideShortTaskDailySchedulerFactory implements Factory<ShortTaskDailyScheduler> {
    public final ShortTaskModule a;

    public ShortTaskModule_ProvideShortTaskDailySchedulerFactory(ShortTaskModule shortTaskModule) {
        this.a = shortTaskModule;
    }

    public static ShortTaskModule_ProvideShortTaskDailySchedulerFactory create(ShortTaskModule shortTaskModule) {
        return new ShortTaskModule_ProvideShortTaskDailySchedulerFactory(shortTaskModule);
    }

    public static ShortTaskDailyScheduler provideShortTaskDailyScheduler(ShortTaskModule shortTaskModule) {
        return (ShortTaskDailyScheduler) Preconditions.checkNotNullFromProvides(shortTaskModule.provideShortTaskDailyScheduler());
    }

    @Override // javax.inject.Provider
    public ShortTaskDailyScheduler get() {
        return provideShortTaskDailyScheduler(this.a);
    }
}
