package com.avito.android.section;

import com.avito.android.serp.adapter.SerpAdvertConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SectionInsideItemsConverterImpl_Factory implements Factory<SectionInsideItemsConverterImpl> {
    public final Provider<SerpAdvertConverter> a;

    public SectionInsideItemsConverterImpl_Factory(Provider<SerpAdvertConverter> provider) {
        this.a = provider;
    }

    public static SectionInsideItemsConverterImpl_Factory create(Provider<SerpAdvertConverter> provider) {
        return new SectionInsideItemsConverterImpl_Factory(provider);
    }

    public static SectionInsideItemsConverterImpl newInstance(SerpAdvertConverter serpAdvertConverter) {
        return new SectionInsideItemsConverterImpl(serpAdvertConverter);
    }

    @Override // javax.inject.Provider
    public SectionInsideItemsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
