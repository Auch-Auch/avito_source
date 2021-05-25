package com.avito.android.advert.item.similars_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSimilarsButtonBlueprint_Factory implements Factory<AdvertDetailsSimilarsButtonBlueprint> {
    public final Provider<AdvertDetailsSimilarsButtonPresenter> a;

    public AdvertDetailsSimilarsButtonBlueprint_Factory(Provider<AdvertDetailsSimilarsButtonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSimilarsButtonBlueprint_Factory create(Provider<AdvertDetailsSimilarsButtonPresenter> provider) {
        return new AdvertDetailsSimilarsButtonBlueprint_Factory(provider);
    }

    public static AdvertDetailsSimilarsButtonBlueprint newInstance(AdvertDetailsSimilarsButtonPresenter advertDetailsSimilarsButtonPresenter) {
        return new AdvertDetailsSimilarsButtonBlueprint(advertDetailsSimilarsButtonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSimilarsButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
