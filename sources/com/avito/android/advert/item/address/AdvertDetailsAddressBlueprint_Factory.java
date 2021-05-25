package com.avito.android.advert.item.address;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAddressBlueprint_Factory implements Factory<AdvertDetailsAddressBlueprint> {
    public final Provider<AdvertDetailsAddressPresenter> a;

    public AdvertDetailsAddressBlueprint_Factory(Provider<AdvertDetailsAddressPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAddressBlueprint_Factory create(Provider<AdvertDetailsAddressPresenter> provider) {
        return new AdvertDetailsAddressBlueprint_Factory(provider);
    }

    public static AdvertDetailsAddressBlueprint newInstance(AdvertDetailsAddressPresenter advertDetailsAddressPresenter) {
        return new AdvertDetailsAddressBlueprint(advertDetailsAddressPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAddressBlueprint get() {
        return newInstance(this.a.get());
    }
}
