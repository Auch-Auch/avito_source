package com.avito.android.advert.item.dfpcreditinfo;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsCreditStorageImpl_Factory implements Factory<AdvertDetailsCreditStorageImpl> {
    public final Provider<Preferences> a;

    public AdvertDetailsCreditStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static AdvertDetailsCreditStorageImpl_Factory create(Provider<Preferences> provider) {
        return new AdvertDetailsCreditStorageImpl_Factory(provider);
    }

    public static AdvertDetailsCreditStorageImpl newInstance(Preferences preferences) {
        return new AdvertDetailsCreditStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsCreditStorageImpl get() {
        return newInstance(this.a.get());
    }
}
