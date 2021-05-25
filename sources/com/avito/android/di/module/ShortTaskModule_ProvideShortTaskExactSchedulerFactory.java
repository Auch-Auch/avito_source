package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.service.short_task.AndroidJobCreator;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShortTaskModule_ProvideShortTaskExactSchedulerFactory implements Factory<ShortTaskExactScheduler> {
    public final ShortTaskModule a;
    public final Provider<Application> b;
    public final Provider<AndroidJobCreator> c;

    public ShortTaskModule_ProvideShortTaskExactSchedulerFactory(ShortTaskModule shortTaskModule, Provider<Application> provider, Provider<AndroidJobCreator> provider2) {
        this.a = shortTaskModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ShortTaskModule_ProvideShortTaskExactSchedulerFactory create(ShortTaskModule shortTaskModule, Provider<Application> provider, Provider<AndroidJobCreator> provider2) {
        return new ShortTaskModule_ProvideShortTaskExactSchedulerFactory(shortTaskModule, provider, provider2);
    }

    public static ShortTaskExactScheduler provideShortTaskExactScheduler(ShortTaskModule shortTaskModule, Application application, Lazy<AndroidJobCreator> lazy) {
        return (ShortTaskExactScheduler) Preconditions.checkNotNullFromProvides(shortTaskModule.provideShortTaskExactScheduler(application, lazy));
    }

    @Override // javax.inject.Provider
    public ShortTaskExactScheduler get() {
        return provideShortTaskExactScheduler(this.a, this.b.get(), DoubleCheck.lazy(this.c));
    }
}
