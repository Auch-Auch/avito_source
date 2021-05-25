package com.avito.android;

import dagger.internal.Factory;
public final class IdProviderImpl_Factory implements Factory<IdProviderImpl> {

    public static final class a {
        public static final IdProviderImpl_Factory a = new IdProviderImpl_Factory();
    }

    public static IdProviderImpl_Factory create() {
        return a.a;
    }

    public static IdProviderImpl newInstance() {
        return new IdProviderImpl();
    }

    @Override // javax.inject.Provider
    public IdProviderImpl get() {
        return newInstance();
    }
}
