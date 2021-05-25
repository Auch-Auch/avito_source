package com.avito.android.basket_legacy.di.shared;

import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharedModule_ProvideBasketRepositoryFactory implements Factory<BasketRepository> {
    public final SharedModule a;
    public final Provider<SharedBasketViewModel> b;

    public SharedModule_ProvideBasketRepositoryFactory(SharedModule sharedModule, Provider<SharedBasketViewModel> provider) {
        this.a = sharedModule;
        this.b = provider;
    }

    public static SharedModule_ProvideBasketRepositoryFactory create(SharedModule sharedModule, Provider<SharedBasketViewModel> provider) {
        return new SharedModule_ProvideBasketRepositoryFactory(sharedModule, provider);
    }

    public static BasketRepository provideBasketRepository(SharedModule sharedModule, SharedBasketViewModel sharedBasketViewModel) {
        return (BasketRepository) Preconditions.checkNotNullFromProvides(sharedModule.provideBasketRepository(sharedBasketViewModel));
    }

    @Override // javax.inject.Provider
    public BasketRepository get() {
        return provideBasketRepository(this.a, this.b.get());
    }
}
