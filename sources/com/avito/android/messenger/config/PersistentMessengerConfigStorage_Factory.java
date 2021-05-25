package com.avito.android.messenger.config;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PersistentMessengerConfigStorage_Factory implements Factory<PersistentMessengerConfigStorage> {
    public final Provider<Preferences> a;

    public PersistentMessengerConfigStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PersistentMessengerConfigStorage_Factory create(Provider<Preferences> provider) {
        return new PersistentMessengerConfigStorage_Factory(provider);
    }

    public static PersistentMessengerConfigStorage newInstance(Preferences preferences) {
        return new PersistentMessengerConfigStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PersistentMessengerConfigStorage get() {
        return newInstance(this.a.get());
    }
}
