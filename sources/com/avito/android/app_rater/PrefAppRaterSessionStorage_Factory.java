package com.avito.android.app_rater;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefAppRaterSessionStorage_Factory implements Factory<PrefAppRaterSessionStorage> {
    public final Provider<Preferences> a;

    public PrefAppRaterSessionStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefAppRaterSessionStorage_Factory create(Provider<Preferences> provider) {
        return new PrefAppRaterSessionStorage_Factory(provider);
    }

    public static PrefAppRaterSessionStorage newInstance(Preferences preferences) {
        return new PrefAppRaterSessionStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefAppRaterSessionStorage get() {
        return newInstance(this.a.get());
    }
}
