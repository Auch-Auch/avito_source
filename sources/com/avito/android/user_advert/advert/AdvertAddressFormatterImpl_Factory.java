package com.avito.android.user_advert.advert;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertAddressFormatterImpl_Factory implements Factory<AdvertAddressFormatterImpl> {
    public final Provider<Resources> a;

    public AdvertAddressFormatterImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertAddressFormatterImpl_Factory create(Provider<Resources> provider) {
        return new AdvertAddressFormatterImpl_Factory(provider);
    }

    public static AdvertAddressFormatterImpl newInstance(Resources resources) {
        return new AdvertAddressFormatterImpl(resources);
    }

    @Override // javax.inject.Provider
    public AdvertAddressFormatterImpl get() {
        return newInstance(this.a.get());
    }
}
