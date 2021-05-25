package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.app.task.InitTimberLoggerTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import timber.log.Timber;
public final class ApplicationDelegateOptionalModule_ProvideInitTimberLoggerTaskFactory implements Factory<InitTimberLoggerTask> {
    public final ApplicationDelegateOptionalModule a;
    public final Provider<Timber.Tree> b;
    public final Provider<Features> c;

    public ApplicationDelegateOptionalModule_ProvideInitTimberLoggerTaskFactory(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, Provider<Timber.Tree> provider, Provider<Features> provider2) {
        this.a = applicationDelegateOptionalModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ApplicationDelegateOptionalModule_ProvideInitTimberLoggerTaskFactory create(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, Provider<Timber.Tree> provider, Provider<Features> provider2) {
        return new ApplicationDelegateOptionalModule_ProvideInitTimberLoggerTaskFactory(applicationDelegateOptionalModule, provider, provider2);
    }

    public static InitTimberLoggerTask provideInitTimberLoggerTask(ApplicationDelegateOptionalModule applicationDelegateOptionalModule, Timber.Tree tree, Features features) {
        return (InitTimberLoggerTask) Preconditions.checkNotNullFromProvides(applicationDelegateOptionalModule.provideInitTimberLoggerTask(tree, features));
    }

    @Override // javax.inject.Provider
    public InitTimberLoggerTask get() {
        return provideInitTimberLoggerTask(this.a, this.b.get(), this.c.get());
    }
}
