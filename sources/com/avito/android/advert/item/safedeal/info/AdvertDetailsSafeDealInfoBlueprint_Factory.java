package com.avito.android.advert.item.safedeal.info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealInfoBlueprint_Factory implements Factory<AdvertDetailsSafeDealInfoBlueprint> {
    public final Provider<AdvertDetailsSafeDealInfoPresenter> a;

    public AdvertDetailsSafeDealInfoBlueprint_Factory(Provider<AdvertDetailsSafeDealInfoPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealInfoBlueprint_Factory create(Provider<AdvertDetailsSafeDealInfoPresenter> provider) {
        return new AdvertDetailsSafeDealInfoBlueprint_Factory(provider);
    }

    public static AdvertDetailsSafeDealInfoBlueprint newInstance(AdvertDetailsSafeDealInfoPresenter advertDetailsSafeDealInfoPresenter) {
        return new AdvertDetailsSafeDealInfoBlueprint(advertDetailsSafeDealInfoPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealInfoBlueprint get() {
        return newInstance(this.a.get());
    }
}
