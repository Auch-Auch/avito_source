package com.avito.android.advert.item.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsTitleBlueprint_Factory implements Factory<AdvertDetailsTitleBlueprint> {
    public final Provider<AdvertDetailsTitlePresenter> a;

    public AdvertDetailsTitleBlueprint_Factory(Provider<AdvertDetailsTitlePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsTitleBlueprint_Factory create(Provider<AdvertDetailsTitlePresenter> provider) {
        return new AdvertDetailsTitleBlueprint_Factory(provider);
    }

    public static AdvertDetailsTitleBlueprint newInstance(AdvertDetailsTitlePresenter advertDetailsTitlePresenter) {
        return new AdvertDetailsTitleBlueprint(advertDetailsTitlePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
