package com.avito.android.advert_core.contactbar;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertContactsResourceProviderImpl_Factory implements Factory<AdvertContactsResourceProviderImpl> {
    public final Provider<Resources> a;

    public AdvertContactsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertContactsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AdvertContactsResourceProviderImpl_Factory(provider);
    }

    public static AdvertContactsResourceProviderImpl newInstance(Resources resources) {
        return new AdvertContactsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AdvertContactsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
