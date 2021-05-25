package com.avito.android.advert.item.autodeal;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutodealBlueprint_Factory implements Factory<AdvertDetailsAutodealBlueprint> {
    public final Provider<AdvertDetailsAutodealPresenter> a;

    public AdvertDetailsAutodealBlueprint_Factory(Provider<AdvertDetailsAutodealPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAutodealBlueprint_Factory create(Provider<AdvertDetailsAutodealPresenter> provider) {
        return new AdvertDetailsAutodealBlueprint_Factory(provider);
    }

    public static AdvertDetailsAutodealBlueprint newInstance(AdvertDetailsAutodealPresenter advertDetailsAutodealPresenter) {
        return new AdvertDetailsAutodealBlueprint(advertDetailsAutodealPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutodealBlueprint get() {
        return newInstance(this.a.get());
    }
}
