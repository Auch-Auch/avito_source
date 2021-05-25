package com.avito.android.validation;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class ParametersListModule_ProvideCategoryParameterStringValueConverterFactory implements Factory<CategoryParameterStringValueConverter> {
    public final ParametersListModule a;
    public final Provider<Locale> b;
    public final Provider<Resources> c;
    public final Provider<Formatter<String>> d;

    public ParametersListModule_ProvideCategoryParameterStringValueConverterFactory(ParametersListModule parametersListModule, Provider<Locale> provider, Provider<Resources> provider2, Provider<Formatter<String>> provider3) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ParametersListModule_ProvideCategoryParameterStringValueConverterFactory create(ParametersListModule parametersListModule, Provider<Locale> provider, Provider<Resources> provider2, Provider<Formatter<String>> provider3) {
        return new ParametersListModule_ProvideCategoryParameterStringValueConverterFactory(parametersListModule, provider, provider2, provider3);
    }

    public static CategoryParameterStringValueConverter provideCategoryParameterStringValueConverter(ParametersListModule parametersListModule, Locale locale, Resources resources, Formatter<String> formatter) {
        return (CategoryParameterStringValueConverter) Preconditions.checkNotNullFromProvides(parametersListModule.provideCategoryParameterStringValueConverter(locale, resources, formatter));
    }

    @Override // javax.inject.Provider
    public CategoryParameterStringValueConverter get() {
        return provideCategoryParameterStringValueConverter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
