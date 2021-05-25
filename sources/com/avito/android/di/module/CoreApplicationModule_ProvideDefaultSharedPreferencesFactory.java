package com.avito.android.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CoreApplicationModule_ProvideDefaultSharedPreferencesFactory implements Factory<SharedPreferences> {
    public final CoreApplicationModule a;
    public final Provider<Application> b;

    public CoreApplicationModule_ProvideDefaultSharedPreferencesFactory(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        this.a = coreApplicationModule;
        this.b = provider;
    }

    public static CoreApplicationModule_ProvideDefaultSharedPreferencesFactory create(CoreApplicationModule coreApplicationModule, Provider<Application> provider) {
        return new CoreApplicationModule_ProvideDefaultSharedPreferencesFactory(coreApplicationModule, provider);
    }

    public static SharedPreferences provideDefaultSharedPreferences(CoreApplicationModule coreApplicationModule, Application application) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(coreApplicationModule.provideDefaultSharedPreferences(application));
    }

    @Override // javax.inject.Provider
    public SharedPreferences get() {
        return provideDefaultSharedPreferences(this.a, this.b.get());
    }
}
