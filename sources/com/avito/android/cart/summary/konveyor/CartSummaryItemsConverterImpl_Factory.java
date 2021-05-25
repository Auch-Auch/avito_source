package com.avito.android.cart.summary.konveyor;

import dagger.internal.Factory;
public final class CartSummaryItemsConverterImpl_Factory implements Factory<CartSummaryItemsConverterImpl> {

    public static final class a {
        public static final CartSummaryItemsConverterImpl_Factory a = new CartSummaryItemsConverterImpl_Factory();
    }

    public static CartSummaryItemsConverterImpl_Factory create() {
        return a.a;
    }

    public static CartSummaryItemsConverterImpl newInstance() {
        return new CartSummaryItemsConverterImpl();
    }

    @Override // javax.inject.Provider
    public CartSummaryItemsConverterImpl get() {
        return newInstance();
    }
}
