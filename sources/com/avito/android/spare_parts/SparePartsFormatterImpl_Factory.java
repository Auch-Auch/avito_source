package com.avito.android.spare_parts;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsFormatterImpl_Factory implements Factory<SparePartsFormatterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<SparePartsResourceProvider> b;

    public SparePartsFormatterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<SparePartsResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SparePartsFormatterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<SparePartsResourceProvider> provider2) {
        return new SparePartsFormatterImpl_Factory(provider, provider2);
    }

    public static SparePartsFormatterImpl newInstance(AttributedTextFormatter attributedTextFormatter, SparePartsResourceProvider sparePartsResourceProvider) {
        return new SparePartsFormatterImpl(attributedTextFormatter, sparePartsResourceProvider);
    }

    @Override // javax.inject.Provider
    public SparePartsFormatterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
