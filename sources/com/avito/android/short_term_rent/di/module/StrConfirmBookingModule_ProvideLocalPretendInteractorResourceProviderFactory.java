package com.avito.android.short_term_rent.di.module;

import android.content.res.Resources;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final Provider<Resources> a;

    public StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory create(Provider<Resources> provider) {
        return new StrConfirmBookingModule_ProvideLocalPretendInteractorResourceProviderFactory(provider);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(Resources resources) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(StrConfirmBookingModule.provideLocalPretendInteractorResourceProvider(resources));
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a.get());
    }
}
