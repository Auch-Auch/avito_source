package com.avito.android.advert.item.header;

import dagger.internal.Factory;
public final class AdvertDetailsHeaderPresenterImpl_Factory implements Factory<AdvertDetailsHeaderPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsHeaderPresenterImpl_Factory a = new AdvertDetailsHeaderPresenterImpl_Factory();
    }

    public static AdvertDetailsHeaderPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsHeaderPresenterImpl newInstance() {
        return new AdvertDetailsHeaderPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsHeaderPresenterImpl get() {
        return newInstance();
    }
}
