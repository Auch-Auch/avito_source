package com.avito.android.shop.awards.di;

import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.AwardsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvideInteractorFactory implements Factory<AwardsInteractor> {
    public final Provider<SellerVerification.AwardsItem> a;

    public AwardsModule_ProvideInteractorFactory(Provider<SellerVerification.AwardsItem> provider) {
        this.a = provider;
    }

    public static AwardsModule_ProvideInteractorFactory create(Provider<SellerVerification.AwardsItem> provider) {
        return new AwardsModule_ProvideInteractorFactory(provider);
    }

    public static AwardsInteractor provideInteractor(SellerVerification.AwardsItem awardsItem) {
        return (AwardsInteractor) Preconditions.checkNotNullFromProvides(AwardsModule.provideInteractor(awardsItem));
    }

    @Override // javax.inject.Provider
    public AwardsInteractor get() {
        return provideInteractor(this.a.get());
    }
}
