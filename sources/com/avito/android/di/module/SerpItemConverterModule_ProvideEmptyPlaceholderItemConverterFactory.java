package com.avito.android.di.module;

import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory implements Factory<EmptyPlaceholderItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory a = new SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory();
    }

    public static SerpItemConverterModule_ProvideEmptyPlaceholderItemConverterFactory create() {
        return a.a;
    }

    public static EmptyPlaceholderItemConverter provideEmptyPlaceholderItemConverter() {
        return (EmptyPlaceholderItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideEmptyPlaceholderItemConverter());
    }

    @Override // javax.inject.Provider
    public EmptyPlaceholderItemConverter get() {
        return provideEmptyPlaceholderItemConverter();
    }
}
