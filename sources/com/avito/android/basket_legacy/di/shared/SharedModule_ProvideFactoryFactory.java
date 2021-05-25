package com.avito.android.basket_legacy.di.shared;

import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SharedModule_ProvideFactoryFactory implements Factory<SharedBasketViewModelFactory> {
    public final SharedModule a;

    public SharedModule_ProvideFactoryFactory(SharedModule sharedModule) {
        this.a = sharedModule;
    }

    public static SharedModule_ProvideFactoryFactory create(SharedModule sharedModule) {
        return new SharedModule_ProvideFactoryFactory(sharedModule);
    }

    public static SharedBasketViewModelFactory provideFactory(SharedModule sharedModule) {
        return (SharedBasketViewModelFactory) Preconditions.checkNotNullFromProvides(sharedModule.provideFactory());
    }

    @Override // javax.inject.Provider
    public SharedBasketViewModelFactory get() {
        return provideFactory(this.a);
    }
}
