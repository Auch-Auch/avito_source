package com.avito.android.profile.sessions.adapter.info;

import dagger.internal.Factory;
public final class SessionsInfoItemPresenterImpl_Factory implements Factory<SessionsInfoItemPresenterImpl> {

    public static final class a {
        public static final SessionsInfoItemPresenterImpl_Factory a = new SessionsInfoItemPresenterImpl_Factory();
    }

    public static SessionsInfoItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SessionsInfoItemPresenterImpl newInstance() {
        return new SessionsInfoItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SessionsInfoItemPresenterImpl get() {
        return newInstance();
    }
}
