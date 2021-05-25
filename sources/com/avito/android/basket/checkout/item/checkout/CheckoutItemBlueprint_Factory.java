package com.avito.android.basket.checkout.item.checkout;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutItemBlueprint_Factory implements Factory<CheckoutItemBlueprint> {
    public final Provider<CheckoutItemPresenter> a;

    public CheckoutItemBlueprint_Factory(Provider<CheckoutItemPresenter> provider) {
        this.a = provider;
    }

    public static CheckoutItemBlueprint_Factory create(Provider<CheckoutItemPresenter> provider) {
        return new CheckoutItemBlueprint_Factory(provider);
    }

    public static CheckoutItemBlueprint newInstance(CheckoutItemPresenter checkoutItemPresenter) {
        return new CheckoutItemBlueprint(checkoutItemPresenter);
    }

    @Override // javax.inject.Provider
    public CheckoutItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
