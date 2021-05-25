package com.avito.android.str_calendar.di.module;

import com.avito.android.Features;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrSellerCalendarParametersModule_ProvideParametersValidatorFactory implements Factory<ParametersValidator> {
    public final Provider<ParametersValidatorResourceProvider> a;
    public final Provider<Features> b;
    public final Provider<HtmlRenderer> c;
    public final Provider<HtmlCleaner> d;

    public StrSellerCalendarParametersModule_ProvideParametersValidatorFactory(Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static StrSellerCalendarParametersModule_ProvideParametersValidatorFactory create(Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        return new StrSellerCalendarParametersModule_ProvideParametersValidatorFactory(provider, provider2, provider3, provider4);
    }

    public static ParametersValidator provideParametersValidator(ParametersValidatorResourceProvider parametersValidatorResourceProvider, Features features, HtmlRenderer htmlRenderer, HtmlCleaner htmlCleaner) {
        return (ParametersValidator) Preconditions.checkNotNullFromProvides(StrSellerCalendarParametersModule.provideParametersValidator(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner));
    }

    @Override // javax.inject.Provider
    public ParametersValidator get() {
        return provideParametersValidator(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
