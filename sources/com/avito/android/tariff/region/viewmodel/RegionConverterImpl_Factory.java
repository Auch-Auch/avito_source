package com.avito.android.tariff.region.viewmodel;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RegionConverterImpl_Factory implements Factory<RegionConverterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public RegionConverterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static RegionConverterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new RegionConverterImpl_Factory(provider);
    }

    public static RegionConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new RegionConverterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public RegionConverterImpl get() {
        return newInstance(this.a.get());
    }
}
