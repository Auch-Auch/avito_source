package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAbTestsModule_ProvideAbTestsPreferencesFactory implements Factory<Preferences> {
    public final PersistenceAbTestsModule a;
    public final Provider<PreferenceFactory> b;
    public final Provider<Application> c;

    public PersistenceAbTestsModule_ProvideAbTestsPreferencesFactory(PersistenceAbTestsModule persistenceAbTestsModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        this.a = persistenceAbTestsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PersistenceAbTestsModule_ProvideAbTestsPreferencesFactory create(PersistenceAbTestsModule persistenceAbTestsModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        return new PersistenceAbTestsModule_ProvideAbTestsPreferencesFactory(persistenceAbTestsModule, provider, provider2);
    }

    public static Preferences provideAbTestsPreferences(PersistenceAbTestsModule persistenceAbTestsModule, PreferenceFactory preferenceFactory, Application application) {
        return (Preferences) Preconditions.checkNotNullFromProvides(persistenceAbTestsModule.provideAbTestsPreferences(preferenceFactory, application));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideAbTestsPreferences(this.a, this.b.get(), this.c.get());
    }
}
