package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.remote.CheckoutApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutRepositoryImpl_Factory implements Factory<CheckoutRepositoryImpl> {
    public final Provider<CheckoutApi> a;
    public final Provider<SchedulersFactory> b;

    public CheckoutRepositoryImpl_Factory(Provider<CheckoutApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CheckoutRepositoryImpl_Factory create(Provider<CheckoutApi> provider, Provider<SchedulersFactory> provider2) {
        return new CheckoutRepositoryImpl_Factory(provider, provider2);
    }

    public static CheckoutRepositoryImpl newInstance(CheckoutApi checkoutApi, SchedulersFactory schedulersFactory) {
        return new CheckoutRepositoryImpl(checkoutApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CheckoutRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
