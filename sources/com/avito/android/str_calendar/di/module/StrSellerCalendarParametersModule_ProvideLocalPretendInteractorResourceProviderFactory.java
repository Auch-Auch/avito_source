package com.avito.android.str_calendar.di.module;

import android.content.res.Resources;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final Provider<Resources> a;

    public StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory create(Provider<Resources> provider) {
        return new StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory(provider);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(Resources resources) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(StrSellerCalendarParametersModule.provideLocalPretendInteractorResourceProvider(resources));
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a.get());
    }
}
