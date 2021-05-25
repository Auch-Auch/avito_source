package com.avito.android.advert.item.autoteka;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutotekaBlueprint_Factory implements Factory<AdvertDetailsAutotekaBlueprint> {
    public final Provider<AdvertDetailsAutotekaPresenter> a;

    public AdvertDetailsAutotekaBlueprint_Factory(Provider<AdvertDetailsAutotekaPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAutotekaBlueprint_Factory create(Provider<AdvertDetailsAutotekaPresenter> provider) {
        return new AdvertDetailsAutotekaBlueprint_Factory(provider);
    }

    public static AdvertDetailsAutotekaBlueprint newInstance(AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter) {
        return new AdvertDetailsAutotekaBlueprint(advertDetailsAutotekaPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutotekaBlueprint get() {
        return newInstance(this.a.get());
    }
}
