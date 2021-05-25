package com.avito.android.di.module;

import com.avito.android.serp.adapter.vertical_main.VerticalFilterItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory implements Factory<VerticalFilterItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory a = new SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory();
    }

    public static SerpItemConverterModule_ProvideVerticalFilterItemConverterFactory create() {
        return a.a;
    }

    public static VerticalFilterItemConverter provideVerticalFilterItemConverter() {
        return (VerticalFilterItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideVerticalFilterItemConverter());
    }

    @Override // javax.inject.Provider
    public VerticalFilterItemConverter get() {
        return provideVerticalFilterItemConverter();
    }
}
