package com.avito.android.advert.item.show_on_map;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsShowOnMapBlueprint_Factory implements Factory<AdvertDetailsShowOnMapBlueprint> {
    public final Provider<AdvertDetailsShowOnMapPresenter> a;

    public AdvertDetailsShowOnMapBlueprint_Factory(Provider<AdvertDetailsShowOnMapPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsShowOnMapBlueprint_Factory create(Provider<AdvertDetailsShowOnMapPresenter> provider) {
        return new AdvertDetailsShowOnMapBlueprint_Factory(provider);
    }

    public static AdvertDetailsShowOnMapBlueprint newInstance(AdvertDetailsShowOnMapPresenter advertDetailsShowOnMapPresenter) {
        return new AdvertDetailsShowOnMapBlueprint(advertDetailsShowOnMapPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShowOnMapBlueprint get() {
        return newInstance(this.a.get());
    }
}
