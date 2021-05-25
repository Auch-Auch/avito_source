package com.avito.android.express_cv.di;

import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.express_cv.ExpressCvDataConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCvModule_ProvideExpressCvDataConverterFactory implements Factory<ExpressCvDataConverter> {
    public final ExpressCvModule a;
    public final Provider<CategoryParametersElementConverter> b;
    public final Provider<Features> c;

    public ExpressCvModule_ProvideExpressCvDataConverterFactory(ExpressCvModule expressCvModule, Provider<CategoryParametersElementConverter> provider, Provider<Features> provider2) {
        this.a = expressCvModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ExpressCvModule_ProvideExpressCvDataConverterFactory create(ExpressCvModule expressCvModule, Provider<CategoryParametersElementConverter> provider, Provider<Features> provider2) {
        return new ExpressCvModule_ProvideExpressCvDataConverterFactory(expressCvModule, provider, provider2);
    }

    public static ExpressCvDataConverter provideExpressCvDataConverter(ExpressCvModule expressCvModule, CategoryParametersElementConverter categoryParametersElementConverter, Features features) {
        return (ExpressCvDataConverter) Preconditions.checkNotNullFromProvides(expressCvModule.provideExpressCvDataConverter(categoryParametersElementConverter, features));
    }

    @Override // javax.inject.Provider
    public ExpressCvDataConverter get() {
        return provideExpressCvDataConverter(this.a, this.b.get(), this.c.get());
    }
}
