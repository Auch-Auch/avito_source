package com.avito.android.cart_fab;

import com.avito.android.remote.cart.CartApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartFabRepositoryImpl_Factory implements Factory<CartFabRepositoryImpl> {
    public final Provider<CartApi> a;
    public final Provider<SchedulersFactory3> b;

    public CartFabRepositoryImpl_Factory(Provider<CartApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CartFabRepositoryImpl_Factory create(Provider<CartApi> provider, Provider<SchedulersFactory3> provider2) {
        return new CartFabRepositoryImpl_Factory(provider, provider2);
    }

    public static CartFabRepositoryImpl newInstance(CartApi cartApi, SchedulersFactory3 schedulersFactory3) {
        return new CartFabRepositoryImpl(cartApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public CartFabRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
