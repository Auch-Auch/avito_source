package com.avito.android.advert_core.gap;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGapBlueprint_Factory implements Factory<AdvertDetailsGapBlueprint> {
    public final Provider<AdvertDetailsGapPresenter> a;

    public AdvertDetailsGapBlueprint_Factory(Provider<AdvertDetailsGapPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGapBlueprint_Factory create(Provider<AdvertDetailsGapPresenter> provider) {
        return new AdvertDetailsGapBlueprint_Factory(provider);
    }

    public static AdvertDetailsGapBlueprint newInstance(AdvertDetailsGapPresenter advertDetailsGapPresenter) {
        return new AdvertDetailsGapBlueprint(advertDetailsGapPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGapBlueprint get() {
        return newInstance(this.a.get());
    }
}
