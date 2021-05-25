package com.avito.android.serp.ad;

import dagger.internal.Factory;
public final class HomeAdResourceProviderImpl_Factory implements Factory<HomeAdResourceProviderImpl> {

    public static final class a {
        public static final HomeAdResourceProviderImpl_Factory a = new HomeAdResourceProviderImpl_Factory();
    }

    public static HomeAdResourceProviderImpl_Factory create() {
        return a.a;
    }

    public static HomeAdResourceProviderImpl newInstance() {
        return new HomeAdResourceProviderImpl();
    }

    @Override // javax.inject.Provider
    public HomeAdResourceProviderImpl get() {
        return newInstance();
    }
}
