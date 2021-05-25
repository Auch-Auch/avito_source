package com.avito.android.di.module;

import com.avito.android.serp.adapter.map_banner.MapBannerItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideMapBannerConverterFactory implements Factory<MapBannerItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideMapBannerConverterFactory a = new SerpItemConverterModule_ProvideMapBannerConverterFactory();
    }

    public static SerpItemConverterModule_ProvideMapBannerConverterFactory create() {
        return a.a;
    }

    public static MapBannerItemConverter provideMapBannerConverter() {
        return (MapBannerItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideMapBannerConverter());
    }

    @Override // javax.inject.Provider
    public MapBannerItemConverter get() {
        return provideMapBannerConverter();
    }
}
