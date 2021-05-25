package com.avito.android.di.module;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.util.ShortcutInfoFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreTasksModule_ProvideShortcutInfoFactoryFactory implements Factory<ShortcutInfoFactory> {
    public final Provider<ActivityIntentFactory> a;

    public CoreTasksModule_ProvideShortcutInfoFactoryFactory(Provider<ActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static CoreTasksModule_ProvideShortcutInfoFactoryFactory create(Provider<ActivityIntentFactory> provider) {
        return new CoreTasksModule_ProvideShortcutInfoFactoryFactory(provider);
    }

    public static ShortcutInfoFactory provideShortcutInfoFactory(ActivityIntentFactory activityIntentFactory) {
        return (ShortcutInfoFactory) Preconditions.checkNotNullFromProvides(CoreTasksModule.INSTANCE.provideShortcutInfoFactory(activityIntentFactory));
    }

    @Override // javax.inject.Provider
    public ShortcutInfoFactory get() {
        return provideShortcutInfoFactory(this.a.get());
    }
}
