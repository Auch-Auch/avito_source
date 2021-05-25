package com.avito.android.tariff.count.viewmodel;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffCountConverterImpl_Factory implements Factory<TariffCountConverterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<PriceConverter> b;

    public TariffCountConverterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<PriceConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffCountConverterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<PriceConverter> provider2) {
        return new TariffCountConverterImpl_Factory(provider, provider2);
    }

    public static TariffCountConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter, PriceConverter priceConverter) {
        return new TariffCountConverterImpl(attributedTextFormatter, priceConverter);
    }

    @Override // javax.inject.Provider
    public TariffCountConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
