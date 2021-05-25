package com.avito.android.price;

import dagger.internal.Factory;
public final class PriceInputFormatterImpl_Factory implements Factory<PriceInputFormatterImpl> {

    public static final class a {
        public static final PriceInputFormatterImpl_Factory a = new PriceInputFormatterImpl_Factory();
    }

    public static PriceInputFormatterImpl_Factory create() {
        return a.a;
    }

    public static PriceInputFormatterImpl newInstance() {
        return new PriceInputFormatterImpl();
    }

    @Override // javax.inject.Provider
    public PriceInputFormatterImpl get() {
        return newInstance();
    }
}
