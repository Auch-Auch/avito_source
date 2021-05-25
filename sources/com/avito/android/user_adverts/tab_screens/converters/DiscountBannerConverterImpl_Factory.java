package com.avito.android.user_adverts.tab_screens.converters;

import dagger.internal.Factory;
public final class DiscountBannerConverterImpl_Factory implements Factory<DiscountBannerConverterImpl> {

    public static final class a {
        public static final DiscountBannerConverterImpl_Factory a = new DiscountBannerConverterImpl_Factory();
    }

    public static DiscountBannerConverterImpl_Factory create() {
        return a.a;
    }

    public static DiscountBannerConverterImpl newInstance() {
        return new DiscountBannerConverterImpl();
    }

    @Override // javax.inject.Provider
    public DiscountBannerConverterImpl get() {
        return newInstance();
    }
}
