package com.avito.android.di.module;

import com.avito.android.serp.adapter.SellerElementConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideSellerElementConverterFactory implements Factory<SellerElementConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideSellerElementConverterFactory a = new SerpItemConverterModule_ProvideSellerElementConverterFactory();
    }

    public static SerpItemConverterModule_ProvideSellerElementConverterFactory create() {
        return a.a;
    }

    public static SellerElementConverter provideSellerElementConverter() {
        return (SellerElementConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSellerElementConverter());
    }

    @Override // javax.inject.Provider
    public SellerElementConverter get() {
        return provideSellerElementConverter();
    }
}
