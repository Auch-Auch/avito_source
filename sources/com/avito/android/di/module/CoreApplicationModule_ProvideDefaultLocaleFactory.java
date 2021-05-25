package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
public final class CoreApplicationModule_ProvideDefaultLocaleFactory implements Factory<Locale> {
    public final CoreApplicationModule a;

    public CoreApplicationModule_ProvideDefaultLocaleFactory(CoreApplicationModule coreApplicationModule) {
        this.a = coreApplicationModule;
    }

    public static CoreApplicationModule_ProvideDefaultLocaleFactory create(CoreApplicationModule coreApplicationModule) {
        return new CoreApplicationModule_ProvideDefaultLocaleFactory(coreApplicationModule);
    }

    public static Locale provideDefaultLocale(CoreApplicationModule coreApplicationModule) {
        return (Locale) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideDefaultLocale());
    }

    @Override // javax.inject.Provider
    public Locale get() {
        return provideDefaultLocale(this.a);
    }
}
