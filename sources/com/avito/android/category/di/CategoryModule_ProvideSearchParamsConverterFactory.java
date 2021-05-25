package com.avito.android.category.di;

import com.avito.android.remote.model.SearchParamsConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CategoryModule_ProvideSearchParamsConverterFactory implements Factory<SearchParamsConverter> {

    public static final class a {
        public static final CategoryModule_ProvideSearchParamsConverterFactory a = new CategoryModule_ProvideSearchParamsConverterFactory();
    }

    public static CategoryModule_ProvideSearchParamsConverterFactory create() {
        return a.a;
    }

    public static SearchParamsConverter provideSearchParamsConverter() {
        return (SearchParamsConverter) Preconditions.checkNotNullFromProvides(CategoryModule.provideSearchParamsConverter());
    }

    @Override // javax.inject.Provider
    public SearchParamsConverter get() {
        return provideSearchParamsConverter();
    }
}
