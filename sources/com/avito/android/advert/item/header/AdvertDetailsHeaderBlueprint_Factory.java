package com.avito.android.advert.item.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsHeaderBlueprint_Factory implements Factory<AdvertDetailsHeaderBlueprint> {
    public final Provider<AdvertDetailsHeaderPresenter> a;

    public AdvertDetailsHeaderBlueprint_Factory(Provider<AdvertDetailsHeaderPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsHeaderBlueprint_Factory create(Provider<AdvertDetailsHeaderPresenter> provider) {
        return new AdvertDetailsHeaderBlueprint_Factory(provider);
    }

    public static AdvertDetailsHeaderBlueprint newInstance(AdvertDetailsHeaderPresenter advertDetailsHeaderPresenter) {
        return new AdvertDetailsHeaderBlueprint(advertDetailsHeaderPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsHeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
