package com.avito.android.advert.item.show_description_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsShowDescriptionBlueprint_Factory implements Factory<AdvertDetailsShowDescriptionBlueprint> {
    public final Provider<AdvertDetailsShowDescriptionPresenter> a;

    public AdvertDetailsShowDescriptionBlueprint_Factory(Provider<AdvertDetailsShowDescriptionPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsShowDescriptionBlueprint_Factory create(Provider<AdvertDetailsShowDescriptionPresenter> provider) {
        return new AdvertDetailsShowDescriptionBlueprint_Factory(provider);
    }

    public static AdvertDetailsShowDescriptionBlueprint newInstance(AdvertDetailsShowDescriptionPresenter advertDetailsShowDescriptionPresenter) {
        return new AdvertDetailsShowDescriptionBlueprint(advertDetailsShowDescriptionPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShowDescriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
