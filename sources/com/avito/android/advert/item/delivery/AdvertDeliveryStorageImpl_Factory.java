package com.avito.android.advert.item.delivery;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDeliveryStorageImpl_Factory implements Factory<AdvertDeliveryStorageImpl> {
    public final Provider<Preferences> a;

    public AdvertDeliveryStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static AdvertDeliveryStorageImpl_Factory create(Provider<Preferences> provider) {
        return new AdvertDeliveryStorageImpl_Factory(provider);
    }

    public static AdvertDeliveryStorageImpl newInstance(Preferences preferences) {
        return new AdvertDeliveryStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public AdvertDeliveryStorageImpl get() {
        return newInstance(this.a.get());
    }
}
