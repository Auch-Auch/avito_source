package com.avito.android.payment.di.module;

import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final TopUpFormModule a;

    public TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory(TopUpFormModule topUpFormModule) {
        this.a = topUpFormModule;
    }

    public static TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory create(TopUpFormModule topUpFormModule) {
        return new TopUpFormModule_ProvideLocalPretendInteractorResourceProviderFactory(topUpFormModule);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(TopUpFormModule topUpFormModule) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(topUpFormModule.provideLocalPretendInteractorResourceProvider());
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a);
    }
}
