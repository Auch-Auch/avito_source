package com.avito.android.basket_legacy.fees;

import dagger.internal.Factory;
public final class SingleFeeServiceConverterImpl_Factory implements Factory<SingleFeeServiceConverterImpl> {

    public static final class a {
        public static final SingleFeeServiceConverterImpl_Factory a = new SingleFeeServiceConverterImpl_Factory();
    }

    public static SingleFeeServiceConverterImpl_Factory create() {
        return a.a;
    }

    public static SingleFeeServiceConverterImpl newInstance() {
        return new SingleFeeServiceConverterImpl();
    }

    @Override // javax.inject.Provider
    public SingleFeeServiceConverterImpl get() {
        return newInstance();
    }
}
