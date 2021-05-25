package com.avito.android.advert.item.domoteka.conveyor;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDomotekaTeaserBlueprint_Factory implements Factory<AdvertDetailsDomotekaTeaserBlueprint> {
    public final Provider<AdvertDetailsDomotekaTeaserPresenter> a;

    public AdvertDetailsDomotekaTeaserBlueprint_Factory(Provider<AdvertDetailsDomotekaTeaserPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDomotekaTeaserBlueprint_Factory create(Provider<AdvertDetailsDomotekaTeaserPresenter> provider) {
        return new AdvertDetailsDomotekaTeaserBlueprint_Factory(provider);
    }

    public static AdvertDetailsDomotekaTeaserBlueprint newInstance(AdvertDetailsDomotekaTeaserPresenter advertDetailsDomotekaTeaserPresenter) {
        return new AdvertDetailsDomotekaTeaserBlueprint(advertDetailsDomotekaTeaserPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDomotekaTeaserBlueprint get() {
        return newInstance(this.a.get());
    }
}
