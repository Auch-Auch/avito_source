package com.avito.android.user_adverts_common.safety.storage;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefSafetyInfoSessionStorage_Factory implements Factory<PrefSafetyInfoSessionStorage> {
    public final Provider<Preferences> a;

    public PrefSafetyInfoSessionStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefSafetyInfoSessionStorage_Factory create(Provider<Preferences> provider) {
        return new PrefSafetyInfoSessionStorage_Factory(provider);
    }

    public static PrefSafetyInfoSessionStorage newInstance(Preferences preferences) {
        return new PrefSafetyInfoSessionStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefSafetyInfoSessionStorage get() {
        return newInstance(this.a.get());
    }
}
