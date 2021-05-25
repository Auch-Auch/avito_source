package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.ShortcutManagerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideShortcutManagerFactoryFactory implements Factory<ShortcutManagerFactory> {
    public final Provider<Application> a;

    public CoreTasksModule_ProvideShortcutManagerFactoryFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvideShortcutManagerFactoryFactory create(Provider<Application> provider) {
        return new CoreTasksModule_ProvideShortcutManagerFactoryFactory(provider);
    }

    public static ShortcutManagerFactory provideShortcutManagerFactory(Application application) {
        return (ShortcutManagerFactory) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideShortcutManagerFactory(application));
    }

    @Override // javax.inject.Provider
    public ShortcutManagerFactory get() {
        return provideShortcutManagerFactory(this.a.get());
    }
}
