package com.avito.android.di.module;

import com.avito.android.serp.adapter.empty_search.EmptySearchItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory implements Factory<EmptySearchItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory a = new SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory();
    }

    public static SerpItemConverterModule_ProvideSerpEmptySearchConverterFactory create() {
        return a.a;
    }

    public static EmptySearchItemConverter provideSerpEmptySearchConverter() {
        return (EmptySearchItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSerpEmptySearchConverter());
    }

    @Override // javax.inject.Provider
    public EmptySearchItemConverter get() {
        return provideSerpEmptySearchConverter();
    }
}
