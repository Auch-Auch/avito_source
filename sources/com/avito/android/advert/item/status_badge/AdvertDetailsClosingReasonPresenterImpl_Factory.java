package com.avito.android.advert.item.status_badge;

import dagger.internal.Factory;
public final class AdvertDetailsClosingReasonPresenterImpl_Factory implements Factory<AdvertDetailsClosingReasonPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsClosingReasonPresenterImpl_Factory a = new AdvertDetailsClosingReasonPresenterImpl_Factory();
    }

    public static AdvertDetailsClosingReasonPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsClosingReasonPresenterImpl newInstance() {
        return new AdvertDetailsClosingReasonPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsClosingReasonPresenterImpl get() {
        return newInstance();
    }
}
