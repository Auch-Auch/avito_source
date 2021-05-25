package com.avito.android.advert.item.safedeal.label;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealLabelBlueprint_Factory implements Factory<AdvertDetailsSafeDealLabelBlueprint> {
    public final Provider<AdvertDetailsSafeDealLabelPresenter> a;

    public AdvertDetailsSafeDealLabelBlueprint_Factory(Provider<AdvertDetailsSafeDealLabelPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealLabelBlueprint_Factory create(Provider<AdvertDetailsSafeDealLabelPresenter> provider) {
        return new AdvertDetailsSafeDealLabelBlueprint_Factory(provider);
    }

    public static AdvertDetailsSafeDealLabelBlueprint newInstance(AdvertDetailsSafeDealLabelPresenter advertDetailsSafeDealLabelPresenter) {
        return new AdvertDetailsSafeDealLabelBlueprint(advertDetailsSafeDealLabelPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealLabelBlueprint get() {
        return newInstance(this.a.get());
    }
}
