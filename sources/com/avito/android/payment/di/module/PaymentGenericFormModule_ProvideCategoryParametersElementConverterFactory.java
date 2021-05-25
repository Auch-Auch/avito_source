package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory implements Factory<CategoryParametersElementConverter> {
    public final PaymentGenericFormModule a;
    public final Provider<Formatter<String>> b;
    public final Provider<TimeSource> c;
    public final Provider<Locale> d;
    public final Provider<Features> e;
    public final Provider<HtmlCleaner> f;
    public final Provider<HtmlNodeFactory> g;

    public PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Features> provider4, Provider<HtmlCleaner> provider5, Provider<HtmlNodeFactory> provider6) {
        this.a = paymentGenericFormModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Features> provider4, Provider<HtmlCleaner> provider5, Provider<HtmlNodeFactory> provider6) {
        return new PaymentGenericFormModule_ProvideCategoryParametersElementConverterFactory(paymentGenericFormModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CategoryParametersElementConverter provideCategoryParametersElementConverter(PaymentGenericFormModule paymentGenericFormModule, Formatter<String> formatter, TimeSource timeSource, Locale locale, Features features, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory) {
        return (CategoryParametersElementConverter) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideCategoryParametersElementConverter(formatter, timeSource, locale, features, htmlCleaner, htmlNodeFactory));
    }

    @Override // javax.inject.Provider
    public CategoryParametersElementConverter get() {
        return provideCategoryParametersElementConverter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
