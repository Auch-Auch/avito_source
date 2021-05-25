package com.avito.android.tariff.info.viewmodel;

import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffInfoConverterImpl_Factory implements Factory<TariffInfoConverterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<TariffBarConverter> b;

    public TariffInfoConverterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<TariffBarConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffInfoConverterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<TariffBarConverter> provider2) {
        return new TariffInfoConverterImpl_Factory(provider, provider2);
    }

    public static TariffInfoConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter, TariffBarConverter tariffBarConverter) {
        return new TariffInfoConverterImpl(attributedTextFormatter, tariffBarConverter);
    }

    @Override // javax.inject.Provider
    public TariffInfoConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
