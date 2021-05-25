package com.avito.android.advert.item.flats;

import dagger.internal.Factory;
public final class AdvertDetailsFlatsPresenterImpl_Factory implements Factory<AdvertDetailsFlatsPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsFlatsPresenterImpl_Factory a = new AdvertDetailsFlatsPresenterImpl_Factory();
    }

    public static AdvertDetailsFlatsPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsFlatsPresenterImpl newInstance() {
        return new AdvertDetailsFlatsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFlatsPresenterImpl get() {
        return newInstance();
    }
}
