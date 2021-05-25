package com.avito.android.publish.objects.di;

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
public final class ObjectsEditModule_ProvideCategoryParametersElementConverterFactory implements Factory<CategoryParametersElementConverter> {
    public final Provider<Resources> a;
    public final Provider<Formatter<String>> b;
    public final Provider<TimeSource> c;
    public final Provider<Features> d;
    public final Provider<Locale> e;
    public final Provider<HtmlCleaner> f;
    public final Provider<HtmlNodeFactory> g;

    public ObjectsEditModule_ProvideCategoryParametersElementConverterFactory(Provider<Resources> provider, Provider<Formatter<String>> provider2, Provider<TimeSource> provider3, Provider<Features> provider4, Provider<Locale> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ObjectsEditModule_ProvideCategoryParametersElementConverterFactory create(Provider<Resources> provider, Provider<Formatter<String>> provider2, Provider<TimeSource> provider3, Provider<Features> provider4, Provider<Locale> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        return new ObjectsEditModule_ProvideCategoryParametersElementConverterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CategoryParametersElementConverter provideCategoryParametersElementConverter(Resources resources, Formatter<String> formatter, TimeSource timeSource, Features features, Locale locale, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory) {
        return (CategoryParametersElementConverter) Preconditions.checkNotNullFromProvides(ObjectsEditModule.INSTANCE.provideCategoryParametersElementConverter(resources, formatter, timeSource, features, locale, htmlCleaner, htmlNodeFactory));
    }

    @Override // javax.inject.Provider
    public CategoryParametersElementConverter get() {
        return provideCategoryParametersElementConverter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
