package com.avito.android.advert.item.show_on_map;

import dagger.internal.Factory;
public final class AdvertDetailsShowOnMapPresenterImpl_Factory implements Factory<AdvertDetailsShowOnMapPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsShowOnMapPresenterImpl_Factory a = new AdvertDetailsShowOnMapPresenterImpl_Factory();
    }

    public static AdvertDetailsShowOnMapPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsShowOnMapPresenterImpl newInstance() {
        return new AdvertDetailsShowOnMapPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShowOnMapPresenterImpl get() {
        return newInstance();
    }
}
