package com.avito.android.util;

import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertOldPriceFormatter_Factory implements Factory<AdvertOldPriceFormatter> {
    public final Provider<Locale> a;

    public AdvertOldPriceFormatter_Factory(Provider<Locale> provider) {
        this.a = provider;
    }

    public static AdvertOldPriceFormatter_Factory create(Provider<Locale> provider) {
        return new AdvertOldPriceFormatter_Factory(provider);
    }

    public static AdvertOldPriceFormatter newInstance(Locale locale) {
        return new AdvertOldPriceFormatter(locale);
    }

    @Override // javax.inject.Provider
    public AdvertOldPriceFormatter get() {
        return newInstance(this.a.get());
    }
}
