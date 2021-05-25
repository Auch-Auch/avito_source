package com.avito.android.cart.summary;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartSummaryResourceProvider_Factory implements Factory<CartSummaryResourceProvider> {
    public final Provider<Resources> a;

    public CartSummaryResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static CartSummaryResourceProvider_Factory create(Provider<Resources> provider) {
        return new CartSummaryResourceProvider_Factory(provider);
    }

    public static CartSummaryResourceProvider newInstance(Resources resources) {
        return new CartSummaryResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public CartSummaryResourceProvider get() {
        return newInstance(this.a.get());
    }
}
