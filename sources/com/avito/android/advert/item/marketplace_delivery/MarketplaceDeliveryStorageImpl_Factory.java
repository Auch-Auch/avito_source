package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceDeliveryStorageImpl_Factory implements Factory<MarketplaceDeliveryStorageImpl> {
    public final Provider<Preferences> a;

    public MarketplaceDeliveryStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static MarketplaceDeliveryStorageImpl_Factory create(Provider<Preferences> provider) {
        return new MarketplaceDeliveryStorageImpl_Factory(provider);
    }

    public static MarketplaceDeliveryStorageImpl newInstance(Preferences preferences) {
        return new MarketplaceDeliveryStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public MarketplaceDeliveryStorageImpl get() {
        return newInstance(this.a.get());
    }
}
