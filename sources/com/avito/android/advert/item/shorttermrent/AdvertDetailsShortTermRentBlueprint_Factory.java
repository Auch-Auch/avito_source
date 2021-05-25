package com.avito.android.advert.item.shorttermrent;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsShortTermRentBlueprint_Factory implements Factory<AdvertDetailsShortTermRentBlueprint> {
    public final Provider<AdvertDetailsShortTermRentPresenter> a;

    public AdvertDetailsShortTermRentBlueprint_Factory(Provider<AdvertDetailsShortTermRentPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsShortTermRentBlueprint_Factory create(Provider<AdvertDetailsShortTermRentPresenter> provider) {
        return new AdvertDetailsShortTermRentBlueprint_Factory(provider);
    }

    public static AdvertDetailsShortTermRentBlueprint newInstance(AdvertDetailsShortTermRentPresenter advertDetailsShortTermRentPresenter) {
        return new AdvertDetailsShortTermRentBlueprint(advertDetailsShortTermRentPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShortTermRentBlueprint get() {
        return newInstance(this.a.get());
    }
}
