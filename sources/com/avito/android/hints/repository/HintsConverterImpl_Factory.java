package com.avito.android.hints.repository;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HintsConverterImpl_Factory implements Factory<HintsConverterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public HintsConverterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static HintsConverterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new HintsConverterImpl_Factory(provider);
    }

    public static HintsConverterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new HintsConverterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public HintsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
