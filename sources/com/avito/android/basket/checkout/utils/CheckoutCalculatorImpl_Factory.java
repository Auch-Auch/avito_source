package com.avito.android.basket.checkout.utils;

import dagger.internal.Factory;
public final class CheckoutCalculatorImpl_Factory implements Factory<CheckoutCalculatorImpl> {

    public static final class a {
        public static final CheckoutCalculatorImpl_Factory a = new CheckoutCalculatorImpl_Factory();
    }

    public static CheckoutCalculatorImpl_Factory create() {
        return a.a;
    }

    public static CheckoutCalculatorImpl newInstance() {
        return new CheckoutCalculatorImpl();
    }

    @Override // javax.inject.Provider
    public CheckoutCalculatorImpl get() {
        return newInstance();
    }
}
