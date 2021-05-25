package com.avito.android.rating.publish.select_advert.adapter.advert;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertItemBlueprint_Factory implements Factory<AdvertItemBlueprint> {
    public final Provider<AdvertItemPresenter> a;

    public AdvertItemBlueprint_Factory(Provider<AdvertItemPresenter> provider) {
        this.a = provider;
    }

    public static AdvertItemBlueprint_Factory create(Provider<AdvertItemPresenter> provider) {
        return new AdvertItemBlueprint_Factory(provider);
    }

    public static AdvertItemBlueprint newInstance(AdvertItemPresenter advertItemPresenter) {
        return new AdvertItemBlueprint(advertItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
