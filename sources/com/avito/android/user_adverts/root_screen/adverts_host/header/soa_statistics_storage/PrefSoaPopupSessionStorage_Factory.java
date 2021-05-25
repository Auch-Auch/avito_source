package com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrefSoaPopupSessionStorage_Factory implements Factory<PrefSoaPopupSessionStorage> {
    public final Provider<Preferences> a;

    public PrefSoaPopupSessionStorage_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PrefSoaPopupSessionStorage_Factory create(Provider<Preferences> provider) {
        return new PrefSoaPopupSessionStorage_Factory(provider);
    }

    public static PrefSoaPopupSessionStorage newInstance(Preferences preferences) {
        return new PrefSoaPopupSessionStorage(preferences);
    }

    @Override // javax.inject.Provider
    public PrefSoaPopupSessionStorage get() {
        return newInstance(this.a.get());
    }
}
