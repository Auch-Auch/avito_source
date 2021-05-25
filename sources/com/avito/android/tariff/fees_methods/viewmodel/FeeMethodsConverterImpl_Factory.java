package com.avito.android.tariff.fees_methods.viewmodel;

import com.avito.android.Features;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeMethodsConverterImpl_Factory implements Factory<FeeMethodsConverterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<Features> b;

    public FeeMethodsConverterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FeeMethodsConverterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<Features> provider2) {
        return new FeeMethodsConverterImpl_Factory(provider, provider2);
    }

    public static FeeMethodsConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter, Features features) {
        return new FeeMethodsConverterImpl(attributedTextFormatter, features);
    }

    @Override // javax.inject.Provider
    public FeeMethodsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
