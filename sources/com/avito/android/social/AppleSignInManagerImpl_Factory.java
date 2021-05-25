package com.avito.android.social;

import dagger.internal.Factory;
public final class AppleSignInManagerImpl_Factory implements Factory<AppleSignInManagerImpl> {

    public static final class a {
        public static final AppleSignInManagerImpl_Factory a = new AppleSignInManagerImpl_Factory();
    }

    public static AppleSignInManagerImpl_Factory create() {
        return a.a;
    }

    public static AppleSignInManagerImpl newInstance() {
        return new AppleSignInManagerImpl();
    }

    @Override // javax.inject.Provider
    public AppleSignInManagerImpl get() {
        return newInstance();
    }
}
