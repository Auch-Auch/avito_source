package com.avito.android.payment.di.module;

import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopUpFormModule_ProvideLocalPretendInteractorFactory implements Factory<LocalPretendInteractor> {
    public final TopUpFormModule a;
    public final Provider<ParametersValidator> b;

    public TopUpFormModule_ProvideLocalPretendInteractorFactory(TopUpFormModule topUpFormModule, Provider<ParametersValidator> provider) {
        this.a = topUpFormModule;
        this.b = provider;
    }

    public static TopUpFormModule_ProvideLocalPretendInteractorFactory create(TopUpFormModule topUpFormModule, Provider<ParametersValidator> provider) {
        return new TopUpFormModule_ProvideLocalPretendInteractorFactory(topUpFormModule, provider);
    }

    public static LocalPretendInteractor provideLocalPretendInteractor(TopUpFormModule topUpFormModule, ParametersValidator parametersValidator) {
        return (LocalPretendInteractor) Preconditions.checkNotNullFromProvides(topUpFormModule.provideLocalPretendInteractor(parametersValidator));
    }

    @Override // javax.inject.Provider
    public LocalPretendInteractor get() {
        return provideLocalPretendInteractor(this.a, this.b.get());
    }
}
