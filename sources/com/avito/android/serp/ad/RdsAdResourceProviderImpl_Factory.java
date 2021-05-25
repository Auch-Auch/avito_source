package com.avito.android.serp.ad;

import dagger.internal.Factory;
public final class RdsAdResourceProviderImpl_Factory implements Factory<RdsAdResourceProviderImpl> {

    public static final class a {
        public static final RdsAdResourceProviderImpl_Factory a = new RdsAdResourceProviderImpl_Factory();
    }

    public static RdsAdResourceProviderImpl_Factory create() {
        return a.a;
    }

    public static RdsAdResourceProviderImpl newInstance() {
        return new RdsAdResourceProviderImpl();
    }

    @Override // javax.inject.Provider
    public RdsAdResourceProviderImpl get() {
        return newInstance();
    }
}
