package com.avito.android.validation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final ParametersListModule a;

    public ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory(ParametersListModule parametersListModule) {
        this.a = parametersListModule;
    }

    public static ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory create(ParametersListModule parametersListModule) {
        return new ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory(parametersListModule);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(ParametersListModule parametersListModule) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(parametersListModule.provideLocalPretendInteractorResourceProvider());
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a);
    }
}
