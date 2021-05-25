package com.avito.android.advert_core.advert;

import com.avito.android.remote.cart.CartApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartInteractorImpl_Factory implements Factory<CartInteractorImpl> {
    public final Provider<CartApi> a;
    public final Provider<SchedulersFactory3> b;

    public CartInteractorImpl_Factory(Provider<CartApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CartInteractorImpl_Factory create(Provider<CartApi> provider, Provider<SchedulersFactory3> provider2) {
        return new CartInteractorImpl_Factory(provider, provider2);
    }

    public static CartInteractorImpl newInstance(CartApi cartApi, SchedulersFactory3 schedulersFactory3) {
        return new CartInteractorImpl(cartApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public CartInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
