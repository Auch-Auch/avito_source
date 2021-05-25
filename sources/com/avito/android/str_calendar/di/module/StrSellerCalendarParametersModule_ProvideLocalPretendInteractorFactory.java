package com.avito.android.str_calendar.di.module;

import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory implements Factory<LocalPretendInteractor> {
    public final Provider<ParametersValidator> a;

    public StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory(Provider<ParametersValidator> provider) {
        this.a = provider;
    }

    public static StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory create(Provider<ParametersValidator> provider) {
        return new StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory(provider);
    }

    public static LocalPretendInteractor provideLocalPretendInteractor(ParametersValidator parametersValidator) {
        return (LocalPretendInteractor) Preconditions.checkNotNullFromProvides(StrSellerCalendarParametersModule.provideLocalPretendInteractor(parametersValidator));
    }

    @Override // javax.inject.Provider
    public LocalPretendInteractor get() {
        return provideLocalPretendInteractor(this.a.get());
    }
}
