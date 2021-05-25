package com.avito.android.user_adverts.tab_screens.advert_list.discount_banner;

import dagger.internal.Factory;
public final class DiscountBannerPresenterImpl_Factory implements Factory<DiscountBannerPresenterImpl> {

    public static final class a {
        public static final DiscountBannerPresenterImpl_Factory a = new DiscountBannerPresenterImpl_Factory();
    }

    public static DiscountBannerPresenterImpl_Factory create() {
        return a.a;
    }

    public static DiscountBannerPresenterImpl newInstance() {
        return new DiscountBannerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DiscountBannerPresenterImpl get() {
        return newInstance();
    }
}
