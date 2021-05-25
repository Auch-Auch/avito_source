package com.avito.android.advert.item.title;

import dagger.internal.Factory;
public final class AdvertDetailsTitlePresenterImpl_Factory implements Factory<AdvertDetailsTitlePresenterImpl> {

    public static final class a {
        public static final AdvertDetailsTitlePresenterImpl_Factory a = new AdvertDetailsTitlePresenterImpl_Factory();
    }

    public static AdvertDetailsTitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsTitlePresenterImpl newInstance() {
        return new AdvertDetailsTitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsTitlePresenterImpl get() {
        return newInstance();
    }
}
