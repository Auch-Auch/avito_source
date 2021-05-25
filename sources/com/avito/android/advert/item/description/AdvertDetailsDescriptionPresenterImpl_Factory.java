package com.avito.android.advert.item.description;

import dagger.internal.Factory;
public final class AdvertDetailsDescriptionPresenterImpl_Factory implements Factory<AdvertDetailsDescriptionPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsDescriptionPresenterImpl_Factory a = new AdvertDetailsDescriptionPresenterImpl_Factory();
    }

    public static AdvertDetailsDescriptionPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsDescriptionPresenterImpl newInstance() {
        return new AdvertDetailsDescriptionPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDescriptionPresenterImpl get() {
        return newInstance();
    }
}
