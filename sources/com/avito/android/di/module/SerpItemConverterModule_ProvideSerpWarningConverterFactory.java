package com.avito.android.di.module;

import com.avito.android.serp.adapter.warning.SerpWarningConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideSerpWarningConverterFactory implements Factory<SerpWarningConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideSerpWarningConverterFactory a = new SerpItemConverterModule_ProvideSerpWarningConverterFactory();
    }

    public static SerpItemConverterModule_ProvideSerpWarningConverterFactory create() {
        return a.a;
    }

    public static SerpWarningConverter provideSerpWarningConverter() {
        return (SerpWarningConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSerpWarningConverter());
    }

    @Override // javax.inject.Provider
    public SerpWarningConverter get() {
        return provideSerpWarningConverter();
    }
}
