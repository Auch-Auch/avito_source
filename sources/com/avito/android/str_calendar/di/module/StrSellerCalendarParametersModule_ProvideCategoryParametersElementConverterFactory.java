package com.avito.android.str_calendar.di.module;

import android.content.res.Resources;
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
public final class StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory implements Factory<CategoryParametersElementConverter> {
    public final Provider<Formatter<String>> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<Resources> d;
    public final Provider<Features> e;
    public final Provider<HtmlCleaner> f;
    public final Provider<HtmlNodeFactory> g;

    public StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory(Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Resources> provider4, Provider<Features> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory create(Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Resources> provider4, Provider<Features> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        return new StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CategoryParametersElementConverter provideCategoryParametersElementConverter(Formatter<String> formatter, TimeSource timeSource, Locale locale, Resources resources, Features features, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory) {
        return (CategoryParametersElementConverter) Preconditions.checkNotNullFromProvides(StrSellerCalendarParametersModule.provideCategoryParametersElementConverter(formatter, timeSource, locale, resources, features, htmlCleaner, htmlNodeFactory));
    }

    @Override // javax.inject.Provider
    public CategoryParametersElementConverter get() {
        return provideCategoryParametersElementConverter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
