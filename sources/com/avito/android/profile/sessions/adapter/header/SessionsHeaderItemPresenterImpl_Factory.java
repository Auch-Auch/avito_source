package com.avito.android.profile.sessions.adapter.header;

import dagger.internal.Factory;
public final class SessionsHeaderItemPresenterImpl_Factory implements Factory<SessionsHeaderItemPresenterImpl> {

    public static final class a {
        public static final SessionsHeaderItemPresenterImpl_Factory a = new SessionsHeaderItemPresenterImpl_Factory();
    }

    public static SessionsHeaderItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SessionsHeaderItemPresenterImpl newInstance() {
        return new SessionsHeaderItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SessionsHeaderItemPresenterImpl get() {
        return newInstance();
    }
}
