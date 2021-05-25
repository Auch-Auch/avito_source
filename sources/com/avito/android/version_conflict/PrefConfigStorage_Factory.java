package com.avito.android.version_conflict;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefConfigStorage_Factory implements Factory<PrefConfigStorage> {
    public final Provider<Preferences> a;

    public PrefConfigStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefConfigStorage_Factory create(Provider<Preferences> provider) {
        return new PrefConfigStorage_Factory(provider);
    }

    public static PrefConfigStorage newInstance(Preferences preferences) {
        return new PrefConfigStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefConfigStorage get() {
        return newInstance(this.a.get());
    }
}
