package com.avito.android.validation;

import com.avito.android.Features;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideParametersValidatorFactory implements Factory<ParametersValidator> {
    public final ParametersListModule a;
    public final Provider<ParametersValidatorResourceProvider> b;
    public final Provider<Features> c;
    public final Provider<HtmlRenderer> d;
    public final Provider<HtmlCleaner> e;

    public ParametersListModule_ProvideParametersValidatorFactory(ParametersListModule parametersListModule, Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ParametersListModule_ProvideParametersValidatorFactory create(ParametersListModule parametersListModule, Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        return new ParametersListModule_ProvideParametersValidatorFactory(parametersListModule, provider, provider2, provider3, provider4);
    }

    public static ParametersValidator provideParametersValidator(ParametersListModule parametersListModule, ParametersValidatorResourceProvider parametersValidatorResourceProvider, Features features, HtmlRenderer htmlRenderer, HtmlCleaner htmlCleaner) {
        return (ParametersValidator) Preconditions.checkNotNullFromProvides(parametersListModule.provideParametersValidator(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner));
    }

    @Override // javax.inject.Provider
    public ParametersValidator get() {
        return provideParametersValidator(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
