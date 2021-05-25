package com.avito.android.cart_fab;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.google.common.base.Optional;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartFabViewModelFactory_Factory implements Factory<CartFabViewModelFactory> {
    public final Provider<Features> a;
    public final Provider<CartFabRepository> b;
    public final Provider<CartFabPreferences> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<Analytics> f;
    public final Provider<Optional<SearchContextWrapper>> g;

    public CartFabViewModelFactory_Factory(Provider<Features> provider, Provider<CartFabRepository> provider2, Provider<CartFabPreferences> provider3, Provider<AccountStateProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<Analytics> provider6, Provider<Optional<SearchContextWrapper>> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static CartFabViewModelFactory_Factory create(Provider<Features> provider, Provider<CartFabRepository> provider2, Provider<CartFabPreferences> provider3, Provider<AccountStateProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<Analytics> provider6, Provider<Optional<SearchContextWrapper>> provider7) {
        return new CartFabViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CartFabViewModelFactory newInstance(Features features, CartFabRepository cartFabRepository, CartFabPreferences cartFabPreferences, AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3, Analytics analytics, Optional<SearchContextWrapper> optional) {
        return new CartFabViewModelFactory(features, cartFabRepository, cartFabPreferences, accountStateProvider, schedulersFactory3, analytics, optional);
    }

    @Override // javax.inject.Provider
    public CartFabViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
