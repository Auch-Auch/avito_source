package com.avito.android.favorite_sellers;

import dagger.internal.Factory;
public final class SellerCarouselItemConverterImpl_Factory implements Factory<SellerCarouselItemConverterImpl> {

    public static final class a {
        public static final SellerCarouselItemConverterImpl_Factory a = new SellerCarouselItemConverterImpl_Factory();
    }

    public static SellerCarouselItemConverterImpl_Factory create() {
        return a.a;
    }

    public static SellerCarouselItemConverterImpl newInstance() {
        return new SellerCarouselItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public SellerCarouselItemConverterImpl get() {
        return newInstance();
    }
}
