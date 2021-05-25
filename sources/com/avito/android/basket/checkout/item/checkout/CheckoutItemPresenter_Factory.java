package com.avito.android.basket.checkout.item.checkout;

import com.avito.android.basket.checkout.ResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutItemPresenter_Factory implements Factory<CheckoutItemPresenter> {
    public final Provider<ResourceProvider> a;
    public final Provider<CheckoutItemClickListener> b;

    public CheckoutItemPresenter_Factory(Provider<ResourceProvider> provider, Provider<CheckoutItemClickListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CheckoutItemPresenter_Factory create(Provider<ResourceProvider> provider, Provider<CheckoutItemClickListener> provider2) {
        return new CheckoutItemPresenter_Factory(provider, provider2);
    }

    public static CheckoutItemPresenter newInstance(ResourceProvider resourceProvider, CheckoutItemClickListener checkoutItemClickListener) {
        return new CheckoutItemPresenter(resourceProvider, checkoutItemClickListener);
    }

    @Override // javax.inject.Provider
    public CheckoutItemPresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
