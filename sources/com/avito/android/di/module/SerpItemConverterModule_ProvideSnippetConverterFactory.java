package com.avito.android.di.module;

import com.avito.android.serp.adapter.snippet.SnippetConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideSnippetConverterFactory implements Factory<SnippetConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideSnippetConverterFactory a = new SerpItemConverterModule_ProvideSnippetConverterFactory();
    }

    public static SerpItemConverterModule_ProvideSnippetConverterFactory create() {
        return a.a;
    }

    public static SnippetConverter provideSnippetConverter() {
        return (SnippetConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSnippetConverter());
    }

    @Override // javax.inject.Provider
    public SnippetConverter get() {
        return provideSnippetConverter();
    }
}
