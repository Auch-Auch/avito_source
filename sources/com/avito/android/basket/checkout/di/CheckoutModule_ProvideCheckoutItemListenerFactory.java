package com.avito.android.basket.checkout.di;

import com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckoutModule_ProvideCheckoutItemListenerFactory implements Factory<CheckoutItemClickListener> {
    public final Provider<CheckoutViewModel> a;

    public CheckoutModule_ProvideCheckoutItemListenerFactory(Provider<CheckoutViewModel> provider) {
        this.a = provider;
    }

    public static CheckoutModule_ProvideCheckoutItemListenerFactory create(Provider<CheckoutViewModel> provider) {
        return new CheckoutModule_ProvideCheckoutItemListenerFactory(provider);
    }

    public static CheckoutItemClickListener provideCheckoutItemListener(CheckoutViewModel checkoutViewModel) {
        return (CheckoutItemClickListener) Preconditions.checkNotNullFromProvides(CheckoutModule.provideCheckoutItemListener(checkoutViewModel));
    }

    @Override // javax.inject.Provider
    public CheckoutItemClickListener get() {
        return provideCheckoutItemListener(this.a.get());
    }
}
