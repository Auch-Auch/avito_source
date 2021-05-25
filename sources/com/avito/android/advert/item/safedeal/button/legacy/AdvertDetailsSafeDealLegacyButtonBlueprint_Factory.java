package com.avito.android.advert.item.safedeal.button.legacy;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealLegacyButtonBlueprint_Factory implements Factory<AdvertDetailsSafeDealLegacyButtonBlueprint> {
    public final Provider<AdvertDetailsSafeDealLegacyButtonPresenter> a;

    public AdvertDetailsSafeDealLegacyButtonBlueprint_Factory(Provider<AdvertDetailsSafeDealLegacyButtonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealLegacyButtonBlueprint_Factory create(Provider<AdvertDetailsSafeDealLegacyButtonPresenter> provider) {
        return new AdvertDetailsSafeDealLegacyButtonBlueprint_Factory(provider);
    }

    public static AdvertDetailsSafeDealLegacyButtonBlueprint newInstance(AdvertDetailsSafeDealLegacyButtonPresenter advertDetailsSafeDealLegacyButtonPresenter) {
        return new AdvertDetailsSafeDealLegacyButtonBlueprint(advertDetailsSafeDealLegacyButtonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealLegacyButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
