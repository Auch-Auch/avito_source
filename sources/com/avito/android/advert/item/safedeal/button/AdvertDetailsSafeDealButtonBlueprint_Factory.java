package com.avito.android.advert.item.safedeal.button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealButtonBlueprint_Factory implements Factory<AdvertDetailsSafeDealButtonBlueprint> {
    public final Provider<AdvertDetailsSafeDealButtonPresenter> a;

    public AdvertDetailsSafeDealButtonBlueprint_Factory(Provider<AdvertDetailsSafeDealButtonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealButtonBlueprint_Factory create(Provider<AdvertDetailsSafeDealButtonPresenter> provider) {
        return new AdvertDetailsSafeDealButtonBlueprint_Factory(provider);
    }

    public static AdvertDetailsSafeDealButtonBlueprint newInstance(AdvertDetailsSafeDealButtonPresenter advertDetailsSafeDealButtonPresenter) {
        return new AdvertDetailsSafeDealButtonBlueprint(advertDetailsSafeDealButtonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
