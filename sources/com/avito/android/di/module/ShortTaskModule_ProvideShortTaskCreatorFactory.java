package com.avito.android.di.module;

import com.avito.android.service.short_task.ShortTaskFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShortTaskModule_ProvideShortTaskCreatorFactory implements Factory<ShortTaskFactory> {
    public final ShortTaskModule a;

    public ShortTaskModule_ProvideShortTaskCreatorFactory(ShortTaskModule shortTaskModule) {
        this.a = shortTaskModule;
    }

    public static ShortTaskModule_ProvideShortTaskCreatorFactory create(ShortTaskModule shortTaskModule) {
        return new ShortTaskModule_ProvideShortTaskCreatorFactory(shortTaskModule);
    }

    public static ShortTaskFactory provideShortTaskCreator(ShortTaskModule shortTaskModule) {
        return (ShortTaskFactory) Preconditions.checkNotNullFromProvides(shortTaskModule.provideShortTaskCreator());
    }

    @Override // javax.inject.Provider
    public ShortTaskFactory get() {
        return provideShortTaskCreator(this.a);
    }
}
