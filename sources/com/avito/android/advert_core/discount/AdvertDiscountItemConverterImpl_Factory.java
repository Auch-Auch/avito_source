package com.avito.android.advert_core.discount;

import dagger.internal.Factory;
public final class AdvertDiscountItemConverterImpl_Factory implements Factory<AdvertDiscountItemConverterImpl> {

    public static final class a {
        public static final AdvertDiscountItemConverterImpl_Factory a = new AdvertDiscountItemConverterImpl_Factory();
    }

    public static AdvertDiscountItemConverterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDiscountItemConverterImpl newInstance() {
        return new AdvertDiscountItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDiscountItemConverterImpl get() {
        return newInstance();
    }
}
