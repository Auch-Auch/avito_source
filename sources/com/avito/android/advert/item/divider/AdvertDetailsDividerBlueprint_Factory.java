package com.avito.android.advert.item.divider;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDividerBlueprint_Factory implements Factory<AdvertDetailsDividerBlueprint> {
    public final Provider<AdvertDetailsDividerPresenter> a;

    public AdvertDetailsDividerBlueprint_Factory(Provider<AdvertDetailsDividerPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDividerBlueprint_Factory create(Provider<AdvertDetailsDividerPresenter> provider) {
        return new AdvertDetailsDividerBlueprint_Factory(provider);
    }

    public static AdvertDetailsDividerBlueprint newInstance(AdvertDetailsDividerPresenter advertDetailsDividerPresenter) {
        return new AdvertDetailsDividerBlueprint(advertDetailsDividerPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDividerBlueprint get() {
        return newInstance(this.a.get());
    }
}
