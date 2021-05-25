package com.avito.android.util;

import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertPriceFormatter_Factory implements Factory<AdvertPriceFormatter> {
    public final Provider<Locale> a;

    public AdvertPriceFormatter_Factory(Provider<Locale> provider) {
        this.a = provider;
    }

    public static AdvertPriceFormatter_Factory create(Provider<Locale> provider) {
        return new AdvertPriceFormatter_Factory(provider);
    }

    public static AdvertPriceFormatter newInstance(Locale locale) {
        return new AdvertPriceFormatter(locale);
    }

    @Override // javax.inject.Provider
    public AdvertPriceFormatter get() {
        return newInstance(this.a.get());
    }
}
