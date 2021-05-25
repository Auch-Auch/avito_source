package com.avito.android.messenger.di;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerModule_ProvideMessengerPreferencesFactory implements Factory<Preferences> {
    public final MessengerModule a;
    public final Provider<Application> b;
    public final Provider<PreferenceFactory> c;

    public MessengerModule_ProvideMessengerPreferencesFactory(MessengerModule messengerModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        this.a = messengerModule;
        this.b = provider;
        this.c = provider2;
    }

    public static MessengerModule_ProvideMessengerPreferencesFactory create(MessengerModule messengerModule, Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        return new MessengerModule_ProvideMessengerPreferencesFactory(messengerModule, provider, provider2);
    }

    public static Preferences provideMessengerPreferences(MessengerModule messengerModule, Application application, PreferenceFactory preferenceFactory) {
        return (Preferences) Preconditions.checkNotNullFromProvides(messengerModule.provideMessengerPreferences(application, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideMessengerPreferences(this.a, this.b.get(), this.c.get());
    }
}
