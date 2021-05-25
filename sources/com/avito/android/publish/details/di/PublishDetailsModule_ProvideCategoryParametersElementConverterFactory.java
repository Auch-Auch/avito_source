package com.avito.android.publish.details.di;

import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideCategoryParametersElementConverterFactory implements Factory<CategoryParametersElementConverter> {
    public final PublishDetailsModule a;
    public final Provider<Formatter<String>> b;
    public final Provider<TimeSource> c;
    public final Provider<Locale> d;
    public final Provider<Features> e;
    public final Provider<AbTestsConfigProvider> f;
    public final Provider<HtmlCleaner> g;
    public final Provider<HtmlNodeFactory> h;

    public PublishDetailsModule_ProvideCategoryParametersElementConverterFactory(PublishDetailsModule publishDetailsModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Features> provider4, Provider<AbTestsConfigProvider> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static PublishDetailsModule_ProvideCategoryParametersElementConverterFactory create(PublishDetailsModule publishDetailsModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Features> provider4, Provider<AbTestsConfigProvider> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        return new PublishDetailsModule_ProvideCategoryParametersElementConverterFactory(publishDetailsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CategoryParametersElementConverter provideCategoryParametersElementConverter(PublishDetailsModule publishDetailsModule, Formatter<String> formatter, TimeSource timeSource, Locale locale, Features features, AbTestsConfigProvider abTestsConfigProvider, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory) {
        return (CategoryParametersElementConverter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideCategoryParametersElementConverter(formatter, timeSource, locale, features, abTestsConfigProvider, htmlCleaner, htmlNodeFactory));
    }

    @Override // javax.inject.Provider
    public CategoryParametersElementConverter get() {
        return provideCategoryParametersElementConverter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
