package com.avito.android.abuse.auth;

import dagger.internal.Factory;
public final class AuthQueryPresenterImpl_Factory implements Factory<AuthQueryPresenterImpl> {

    public static final class a {
        public static final AuthQueryPresenterImpl_Factory a = new AuthQueryPresenterImpl_Factory();
    }

    public static AuthQueryPresenterImpl_Factory create() {
        return a.a;
    }

    public static AuthQueryPresenterImpl newInstance() {
        return new AuthQueryPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AuthQueryPresenterImpl get() {
        return newInstance();
    }
}
