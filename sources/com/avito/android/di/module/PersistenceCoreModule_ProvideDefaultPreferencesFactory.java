package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideDefaultPreferencesFactory implements Factory<Preferences> {
    public final PersistenceCoreModule a;
    public final Provider<PreferenceFactory> b;
    public final Provider<Application> c;

    public PersistenceCoreModule_ProvideDefaultPreferencesFactory(PersistenceCoreModule persistenceCoreModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        this.a = persistenceCoreModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PersistenceCoreModule_ProvideDefaultPreferencesFactory create(PersistenceCoreModule persistenceCoreModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        return new PersistenceCoreModule_ProvideDefaultPreferencesFactory(persistenceCoreModule, provider, provider2);
    }

    public static Preferences provideDefaultPreferences(PersistenceCoreModule persistenceCoreModule, PreferenceFactory preferenceFactory, Application application) {
        return (Preferences) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideDefaultPreferences(preferenceFactory, application));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideDefaultPreferences(this.a, this.b.get(), this.c.get());
    }
}
