package com.avito.android.advert.item.georeference;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsGeoReferenceBlueprint_Factory implements Factory<AdvertDetailsGeoReferenceBlueprint> {
    public final Provider<AdvertDetailsGeoReferencePresenter> a;

    public AdvertDetailsGeoReferenceBlueprint_Factory(Provider<AdvertDetailsGeoReferencePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGeoReferenceBlueprint_Factory create(Provider<AdvertDetailsGeoReferencePresenter> provider) {
        return new AdvertDetailsGeoReferenceBlueprint_Factory(provider);
    }

    public static AdvertDetailsGeoReferenceBlueprint newInstance(AdvertDetailsGeoReferencePresenter advertDetailsGeoReferencePresenter) {
        return new AdvertDetailsGeoReferenceBlueprint(advertDetailsGeoReferencePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGeoReferenceBlueprint get() {
        return newInstance(this.a.get());
    }
}
