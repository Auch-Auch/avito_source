package com.avito.android.social;

import dagger.internal.Factory;
public final class EsiaSignInManagerImpl_Factory implements Factory<EsiaSignInManagerImpl> {

    public static final class a {
        public static final EsiaSignInManagerImpl_Factory a = new EsiaSignInManagerImpl_Factory();
    }

    public static EsiaSignInManagerImpl_Factory create() {
        return a.a;
    }

    public static EsiaSignInManagerImpl newInstance() {
        return new EsiaSignInManagerImpl();
    }

    @Override // javax.inject.Provider
    public EsiaSignInManagerImpl get() {
        return newInstance();
    }
}
