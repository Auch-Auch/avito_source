package com.avito.android.brandspace.items.marketplace.banner;

import dagger.internal.Factory;
public final class BannerPresenterImpl_Factory implements Factory<BannerPresenterImpl> {

    public static final class a {
        public static final BannerPresenterImpl_Factory a = new BannerPresenterImpl_Factory();
    }

    public static BannerPresenterImpl_Factory create() {
        return a.a;
    }

    public static BannerPresenterImpl newInstance() {
        return new BannerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BannerPresenterImpl get() {
        return newInstance();
    }
}
