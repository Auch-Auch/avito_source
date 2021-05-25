package com.avito.android.short_term_rent.di.module;

import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingModule_ProvideLocalPretendInteractorFactory implements Factory<LocalPretendInteractor> {
    public final Provider<ParametersValidator> a;

    public StrConfirmBookingModule_ProvideLocalPretendInteractorFactory(Provider<ParametersValidator> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingModule_ProvideLocalPretendInteractorFactory create(Provider<ParametersValidator> provider) {
        return new StrConfirmBookingModule_ProvideLocalPretendInteractorFactory(provider);
    }

    public static LocalPretendInteractor provideLocalPretendInteractor(ParametersValidator parametersValidator) {
        return (LocalPretendInteractor) Preconditions.checkNotNullFromProvides(StrConfirmBookingModule.provideLocalPretendInteractor(parametersValidator));
    }

    @Override // javax.inject.Provider
    public LocalPretendInteractor get() {
        return provideLocalPretendInteractor(this.a.get());
    }
}
