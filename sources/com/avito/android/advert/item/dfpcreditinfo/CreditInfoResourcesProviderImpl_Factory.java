package com.avito.android.advert.item.dfpcreditinfo;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreditInfoResourcesProviderImpl_Factory implements Factory<CreditInfoResourcesProviderImpl> {
    public final Provider<Resources> a;

    public CreditInfoResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static CreditInfoResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new CreditInfoResourcesProviderImpl_Factory(provider);
    }

    public static CreditInfoResourcesProviderImpl newInstance(Resources resources) {
        return new CreditInfoResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public CreditInfoResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
