package com.avito.android.vas_discount.business;

import dagger.internal.Factory;
public final class DiscountToItemConverterImpl_Factory implements Factory<DiscountToItemConverterImpl> {

    public static final class a {
        public static final DiscountToItemConverterImpl_Factory a = new DiscountToItemConverterImpl_Factory();
    }

    public static DiscountToItemConverterImpl_Factory create() {
        return a.a;
    }

    public static DiscountToItemConverterImpl newInstance() {
        return new DiscountToItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public DiscountToItemConverterImpl get() {
        return newInstance();
    }
}
