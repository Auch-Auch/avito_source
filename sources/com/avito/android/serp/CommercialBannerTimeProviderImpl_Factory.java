package com.avito.android.serp;

import dagger.internal.Factory;
public final class CommercialBannerTimeProviderImpl_Factory implements Factory<CommercialBannerTimeProviderImpl> {

    public static final class a {
        public static final CommercialBannerTimeProviderImpl_Factory a = new CommercialBannerTimeProviderImpl_Factory();
    }

    public static CommercialBannerTimeProviderImpl_Factory create() {
        return a.a;
    }

    public static CommercialBannerTimeProviderImpl newInstance() {
        return new CommercialBannerTimeProviderImpl();
    }

    @Override // javax.inject.Provider
    public CommercialBannerTimeProviderImpl get() {
        return newInstance();
    }
}
