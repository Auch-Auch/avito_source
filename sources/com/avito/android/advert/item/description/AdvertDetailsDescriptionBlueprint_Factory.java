package com.avito.android.advert.item.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDescriptionBlueprint_Factory implements Factory<AdvertDetailsDescriptionBlueprint> {
    public final Provider<AdvertDetailsDescriptionPresenter> a;

    public AdvertDetailsDescriptionBlueprint_Factory(Provider<AdvertDetailsDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDescriptionBlueprint_Factory create(Provider<AdvertDetailsDescriptionPresenter> provider) {
        return new AdvertDetailsDescriptionBlueprint_Factory(provider);
    }

    public static AdvertDetailsDescriptionBlueprint newInstance(AdvertDetailsDescriptionPresenter advertDetailsDescriptionPresenter) {
        return new AdvertDetailsDescriptionBlueprint(advertDetailsDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
