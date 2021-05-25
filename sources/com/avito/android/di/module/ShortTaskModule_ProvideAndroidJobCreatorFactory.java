package com.avito.android.di.module;

import com.avito.android.service.short_task.AndroidJobCreator;
import com.avito.android.service.short_task.RunJobFailedListener;
import com.avito.android.service.short_task.ShortTaskFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShortTaskModule_ProvideAndroidJobCreatorFactory implements Factory<AndroidJobCreator> {
    public final ShortTaskModule a;
    public final Provider<ShortTaskFactory> b;
    public final Provider<RunJobFailedListener> c;

    public ShortTaskModule_ProvideAndroidJobCreatorFactory(ShortTaskModule shortTaskModule, Provider<ShortTaskFactory> provider, Provider<RunJobFailedListener> provider2) {
        this.a = shortTaskModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ShortTaskModule_ProvideAndroidJobCreatorFactory create(ShortTaskModule shortTaskModule, Provider<ShortTaskFactory> provider, Provider<RunJobFailedListener> provider2) {
        return new ShortTaskModule_ProvideAndroidJobCreatorFactory(shortTaskModule, provider, provider2);
    }

    public static AndroidJobCreator provideAndroidJobCreator(ShortTaskModule shortTaskModule, ShortTaskFactory shortTaskFactory, RunJobFailedListener runJobFailedListener) {
        return (AndroidJobCreator) Preconditions.checkNotNullFromProvides(shortTaskModule.provideAndroidJobCreator(shortTaskFactory, runJobFailedListener));
    }

    @Override // javax.inject.Provider
    public AndroidJobCreator get() {
        return provideAndroidJobCreator(this.a, this.b.get(), this.c.get());
    }
}
