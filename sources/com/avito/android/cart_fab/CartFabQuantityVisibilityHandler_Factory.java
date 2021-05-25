package com.avito.android.cart_fab;

import dagger.internal.Factory;
public final class CartFabQuantityVisibilityHandler_Factory implements Factory<CartFabQuantityVisibilityHandler> {

    public static final class a {
        public static final CartFabQuantityVisibilityHandler_Factory a = new CartFabQuantityVisibilityHandler_Factory();
    }

    public static CartFabQuantityVisibilityHandler_Factory create() {
        return a.a;
    }

    public static CartFabQuantityVisibilityHandler newInstance() {
        return new CartFabQuantityVisibilityHandler();
    }

    @Override // javax.inject.Provider
    public CartFabQuantityVisibilityHandler get() {
        return newInstance();
    }
}
