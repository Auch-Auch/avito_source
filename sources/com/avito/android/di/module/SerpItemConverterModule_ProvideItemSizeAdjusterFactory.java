package com.avito.android.di.module;

import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideItemSizeAdjusterFactory implements Factory<SerpItemSizeAdjuster> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideItemSizeAdjusterFactory a = new SerpItemConverterModule_ProvideItemSizeAdjusterFactory();
    }

    public static SerpItemConverterModule_ProvideItemSizeAdjusterFactory create() {
        return a.a;
    }

    public static SerpItemSizeAdjuster provideItemSizeAdjuster() {
        return (SerpItemSizeAdjuster) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideItemSizeAdjuster());
    }

    @Override // javax.inject.Provider
    public SerpItemSizeAdjuster get() {
        return provideItemSizeAdjuster();
    }
}
