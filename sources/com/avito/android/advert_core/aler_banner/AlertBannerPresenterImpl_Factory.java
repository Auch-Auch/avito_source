package com.avito.android.advert_core.aler_banner;

import dagger.internal.Factory;
public final class AlertBannerPresenterImpl_Factory implements Factory<AlertBannerPresenterImpl> {

    public static final class a {
        public static final AlertBannerPresenterImpl_Factory a = new AlertBannerPresenterImpl_Factory();
    }

    public static AlertBannerPresenterImpl_Factory create() {
        return a.a;
    }

    public static AlertBannerPresenterImpl newInstance() {
        return new AlertBannerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AlertBannerPresenterImpl get() {
        return newInstance();
    }
}
