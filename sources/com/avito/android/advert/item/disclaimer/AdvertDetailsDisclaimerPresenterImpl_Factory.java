package com.avito.android.advert.item.disclaimer;

import dagger.internal.Factory;
public final class AdvertDetailsDisclaimerPresenterImpl_Factory implements Factory<AdvertDetailsDisclaimerPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsDisclaimerPresenterImpl_Factory a = new AdvertDetailsDisclaimerPresenterImpl_Factory();
    }

    public static AdvertDetailsDisclaimerPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsDisclaimerPresenterImpl newInstance() {
        return new AdvertDetailsDisclaimerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDisclaimerPresenterImpl get() {
        return newInstance();
    }
}
