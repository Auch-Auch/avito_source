package com.avito.android.in_app_calls.di;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideInAppCallsPreferencesFactory implements Factory<Preferences> {
    public final InAppCallsModule a;
    public final Provider<Application> b;
    public final Provider<PreferenceFactory> c;

    public InAppCallsModule_ProvideInAppCallsPreferencesFactory(InAppCallsModule inAppCallsModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        this.a = inAppCallsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static InAppCallsModule_ProvideInAppCallsPreferencesFactory create(InAppCallsModule inAppCallsModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        return new InAppCallsModule_ProvideInAppCallsPreferencesFactory(inAppCallsModule, provider, provider2);
    }

    public static Preferences provideInAppCallsPreferences(InAppCallsModule inAppCallsModule, Application application, PreferenceFactory preferenceFactory) {
        return (Preferences) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideInAppCallsPreferences(application, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideInAppCallsPreferences(this.a, this.b.get(), this.c.get());
    }
}
