package com.avito.android.advert.item.address;

import dagger.internal.Factory;
public final class AdvertDetailsAddressPresenterImpl_Factory implements Factory<AdvertDetailsAddressPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsAddressPresenterImpl_Factory a = new AdvertDetailsAddressPresenterImpl_Factory();
    }

    public static AdvertDetailsAddressPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsAddressPresenterImpl newInstance() {
        return new AdvertDetailsAddressPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAddressPresenterImpl get() {
        return newInstance();
    }
}
