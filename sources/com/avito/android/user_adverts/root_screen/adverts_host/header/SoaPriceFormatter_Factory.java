package com.avito.android.user_adverts.root_screen.adverts_host.header;

import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class SoaPriceFormatter_Factory implements Factory<SoaPriceFormatter> {
    public final Provider<Locale> a;

    public SoaPriceFormatter_Factory(Provider<Locale> provider) {
        this.a = provider;
    }

    public static SoaPriceFormatter_Factory create(Provider<Locale> provider) {
        return new SoaPriceFormatter_Factory(provider);
    }

    public static SoaPriceFormatter newInstance(Locale locale) {
        return new SoaPriceFormatter(locale);
    }

    @Override // javax.inject.Provider
    public SoaPriceFormatter get() {
        return newInstance(this.a.get());
    }
}
