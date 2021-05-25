package com.avito.android.serp;

import dagger.internal.Factory;
public final class BannerInfoFactoryImpl_Factory implements Factory<BannerInfoFactoryImpl> {

    public static final class a {
        public static final BannerInfoFactoryImpl_Factory a = new BannerInfoFactoryImpl_Factory();
    }

    public static BannerInfoFactoryImpl_Factory create() {
        return a.a;
    }

    public static BannerInfoFactoryImpl newInstance() {
        return new BannerInfoFactoryImpl();
    }

    @Override // javax.inject.Provider
    public BannerInfoFactoryImpl get() {
        return newInstance();
    }
}
