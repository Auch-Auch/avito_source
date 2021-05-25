package com.avito.android.di.module;

import com.avito.android.serp.adapter.HeaderElementConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideHeaderElementConverterFactory implements Factory<HeaderElementConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideHeaderElementConverterFactory a = new SerpItemConverterModule_ProvideHeaderElementConverterFactory();
    }

    public static SerpItemConverterModule_ProvideHeaderElementConverterFactory create() {
        return a.a;
    }

    public static HeaderElementConverter provideHeaderElementConverter() {
        return (HeaderElementConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideHeaderElementConverter());
    }

    @Override // javax.inject.Provider
    public HeaderElementConverter get() {
        return provideHeaderElementConverter();
    }
}
