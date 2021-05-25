package com.avito.android.advert.item.georeference;

import dagger.internal.Factory;
public final class AdvertDetailsGeoReferencePresenterImpl_Factory implements Factory<AdvertDetailsGeoReferencePresenterImpl> {

    public static final class a {
        public static final AdvertDetailsGeoReferencePresenterImpl_Factory a = new AdvertDetailsGeoReferencePresenterImpl_Factory();
    }

    public static AdvertDetailsGeoReferencePresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsGeoReferencePresenterImpl newInstance() {
        return new AdvertDetailsGeoReferencePresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGeoReferencePresenterImpl get() {
        return newInstance();
    }
}
