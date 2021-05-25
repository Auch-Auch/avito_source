package com.avito.android.advert.item.booking;

import dagger.internal.Factory;
public final class AdvertBookingPresenterImpl_Factory implements Factory<AdvertBookingPresenterImpl> {

    public static final class a {
        public static final AdvertBookingPresenterImpl_Factory a = new AdvertBookingPresenterImpl_Factory();
    }

    public static AdvertBookingPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertBookingPresenterImpl newInstance() {
        return new AdvertBookingPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertBookingPresenterImpl get() {
        return newInstance();
    }
}
