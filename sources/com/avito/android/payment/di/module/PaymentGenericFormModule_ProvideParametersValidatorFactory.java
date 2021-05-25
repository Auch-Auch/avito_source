package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideParametersValidatorFactory implements Factory<ParametersValidator> {
    public final PaymentGenericFormModule a;
    public final Provider<ParametersValidatorResourceProvider> b;
    public final Provider<Features> c;
    public final Provider<HtmlRenderer> d;
    public final Provider<HtmlCleaner> e;

    public PaymentGenericFormModule_ProvideParametersValidatorFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        this.a = paymentGenericFormModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static PaymentGenericFormModule_ProvideParametersValidatorFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<ParametersValidatorResourceProvider> provider, Provider<Features> provider2, Provider<HtmlRenderer> provider3, Provider<HtmlCleaner> provider4) {
        return new PaymentGenericFormModule_ProvideParametersValidatorFactory(paymentGenericFormModule, provider, provider2, provider3, provider4);
    }

    public static ParametersValidator provideParametersValidator(PaymentGenericFormModule paymentGenericFormModule, ParametersValidatorResourceProvider parametersValidatorResourceProvider, Features features, HtmlRenderer htmlRenderer, HtmlCleaner htmlCleaner) {
        return (ParametersValidator) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideParametersValidator(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner));
    }

    @Override // javax.inject.Provider
    public ParametersValidator get() {
        return provideParametersValidator(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
