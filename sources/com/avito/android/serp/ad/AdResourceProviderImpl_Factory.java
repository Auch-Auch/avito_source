package com.avito.android.serp.ad;

import dagger.internal.Factory;
public final class AdResourceProviderImpl_Factory implements Factory<AdResourceProviderImpl> {

    public static final class a {
        public static final AdResourceProviderImpl_Factory a = new AdResourceProviderImpl_Factory();
    }

    public static AdResourceProviderImpl_Factory create() {
        return a.a;
    }

    public static AdResourceProviderImpl newInstance() {
        return new AdResourceProviderImpl();
    }

    @Override // javax.inject.Provider
    public AdResourceProviderImpl get() {
        return newInstance();
    }
}
