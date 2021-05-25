package com.avito.android.basket_legacy.utils;

import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class PriceFormatterImpl_Factory implements Factory<PriceFormatterImpl> {
    public final Provider<Locale> a;

    public PriceFormatterImpl_Factory(Provider<Locale> provider) {
        this.a = provider;
    }

    public static PriceFormatterImpl_Factory create(Provider<Locale> provider) {
        return new PriceFormatterImpl_Factory(provider);
    }

    public static PriceFormatterImpl newInstance(Locale locale) {
        return new PriceFormatterImpl(locale);
    }

    @Override // javax.inject.Provider
    public PriceFormatterImpl get() {
        return newInstance(this.a.get());
    }
}
