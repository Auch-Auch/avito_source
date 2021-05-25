package com.avito.android.express_cv.di;

import android.app.Activity;
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
public final class ExpressCvModule_ProvideElementConverterFactory implements Factory<CategoryParametersElementConverter> {
    public final ExpressCvModule a;
    public final Provider<Formatter<String>> b;
    public final Provider<TimeSource> c;
    public final Provider<Locale> d;
    public final Provider<Activity> e;
    public final Provider<Features> f;
    public final Provider<HtmlCleaner> g;
    public final Provider<HtmlNodeFactory> h;

    public ExpressCvModule_ProvideElementConverterFactory(ExpressCvModule expressCvModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Activity> provider4, Provider<Features> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static ExpressCvModule_ProvideElementConverterFactory create(ExpressCvModule expressCvModule, Provider<Formatter<String>> provider, Provider<TimeSource> provider2, Provider<Locale> provider3, Provider<Activity> provider4, Provider<Features> provider5, Provider<HtmlCleaner> provider6, Provider<HtmlNodeFactory> provider7) {
        return new ExpressCvModule_ProvideElementConverterFactory(expressCvModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static CategoryParametersElementConverter provideElementConverter(ExpressCvModule expressCvModule, Formatter<String> formatter, TimeSource timeSource, Locale locale, Activity activity, Features features, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory) {
        return (CategoryParametersElementConverter) Preconditions.checkNotNullFromProvides(expressCvModule.provideElementConverter(formatter, timeSource, locale, activity, features, htmlCleaner, htmlNodeFactory));
    }

    @Override // javax.inject.Provider
    public CategoryParametersElementConverter get() {
        return provideElementConverter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
