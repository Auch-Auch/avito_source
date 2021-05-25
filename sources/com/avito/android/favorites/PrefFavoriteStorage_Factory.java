package com.avito.android.favorites;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefFavoriteStorage_Factory implements Factory<PrefFavoriteStorage> {
    public final Provider<Preferences> a;

    public PrefFavoriteStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefFavoriteStorage_Factory create(Provider<Preferences> provider) {
        return new PrefFavoriteStorage_Factory(provider);
    }

    public static PrefFavoriteStorage newInstance(Preferences preferences) {
        return new PrefFavoriteStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefFavoriteStorage get() {
        return newInstance(this.a.get());
    }
}
