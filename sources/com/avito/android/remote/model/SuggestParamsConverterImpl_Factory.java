package com.avito.android.remote.model;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestParamsConverterImpl_Factory implements Factory<SuggestParamsConverterImpl> {
    private final Provider<SearchParamsConverter> searchParamsConverterProvider;

    public SuggestParamsConverterImpl_Factory(Provider<SearchParamsConverter> provider) {
        this.searchParamsConverterProvider = provider;
    }

    public static SuggestParamsConverterImpl_Factory create(Provider<SearchParamsConverter> provider) {
        return new SuggestParamsConverterImpl_Factory(provider);
    }

    public static SuggestParamsConverterImpl newInstance(SearchParamsConverter searchParamsConverter) {
        return new SuggestParamsConverterImpl(searchParamsConverter);
    }

    @Override // javax.inject.Provider
    public SuggestParamsConverterImpl get() {
        return newInstance(this.searchParamsConverterProvider.get());
    }
}
