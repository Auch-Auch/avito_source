package com.avito.android.cart_fab;

import androidx.lifecycle.ViewModelStoreOwner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CartFabModule_ProvideCartFabViewModelFactory implements Factory<CartFabViewModel> {
    public final Provider<ViewModelStoreOwner> a;
    public final Provider<CartFabViewModelFactory> b;

    public CartFabModule_ProvideCartFabViewModelFactory(Provider<ViewModelStoreOwner> provider, Provider<CartFabViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CartFabModule_ProvideCartFabViewModelFactory create(Provider<ViewModelStoreOwner> provider, Provider<CartFabViewModelFactory> provider2) {
        return new CartFabModule_ProvideCartFabViewModelFactory(provider, provider2);
    }

    public static CartFabViewModel provideCartFabViewModel(ViewModelStoreOwner viewModelStoreOwner, CartFabViewModelFactory cartFabViewModelFactory) {
        return (CartFabViewModel) Preconditions.checkNotNullFromProvides(CartFabModule.INSTANCE.provideCartFabViewModel(viewModelStoreOwner, cartFabViewModelFactory));
    }

    @Override // javax.inject.Provider
    public CartFabViewModel get() {
        return provideCartFabViewModel(this.a.get(), this.b.get());
    }
}
