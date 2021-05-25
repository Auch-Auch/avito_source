package com.avito.android.advert.item.price;

import dagger.internal.Factory;
public final class AdvertDetailsPricePresenterImpl_Factory implements Factory<AdvertDetailsPricePresenterImpl> {

    public static final class a {
        public static final AdvertDetailsPricePresenterImpl_Factory a = new AdvertDetailsPricePresenterImpl_Factory();
    }

    public static AdvertDetailsPricePresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsPricePresenterImpl newInstance() {
        return new AdvertDetailsPricePresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsPricePresenterImpl get() {
        return newInstance();
    }
}
