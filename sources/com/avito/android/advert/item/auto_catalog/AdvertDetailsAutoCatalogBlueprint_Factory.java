package com.avito.android.advert.item.auto_catalog;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutoCatalogBlueprint_Factory implements Factory<AdvertDetailsAutoCatalogBlueprint> {
    public final Provider<AdvertDetailsAutoCatalogPresenter> a;

    public AdvertDetailsAutoCatalogBlueprint_Factory(Provider<AdvertDetailsAutoCatalogPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAutoCatalogBlueprint_Factory create(Provider<AdvertDetailsAutoCatalogPresenter> provider) {
        return new AdvertDetailsAutoCatalogBlueprint_Factory(provider);
    }

    public static AdvertDetailsAutoCatalogBlueprint newInstance(AdvertDetailsAutoCatalogPresenter advertDetailsAutoCatalogPresenter) {
        return new AdvertDetailsAutoCatalogBlueprint(advertDetailsAutoCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutoCatalogBlueprint get() {
        return newInstance(this.a.get());
    }
}
