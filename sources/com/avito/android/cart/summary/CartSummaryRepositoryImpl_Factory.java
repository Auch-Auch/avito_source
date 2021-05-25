package com.avito.android.cart.summary;

import com.avito.android.remote.cart.CartApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartSummaryRepositoryImpl_Factory implements Factory<CartSummaryRepositoryImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<CartApi> b;

    public CartSummaryRepositoryImpl_Factory(Provider<SchedulersFactory3> provider, Provider<CartApi> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CartSummaryRepositoryImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<CartApi> provider2) {
        return new CartSummaryRepositoryImpl_Factory(provider, provider2);
    }

    public static CartSummaryRepositoryImpl newInstance(SchedulersFactory3 schedulersFactory3, CartApi cartApi) {
        return new CartSummaryRepositoryImpl(schedulersFactory3, cartApi);
    }

    @Override // javax.inject.Provider
    public CartSummaryRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
