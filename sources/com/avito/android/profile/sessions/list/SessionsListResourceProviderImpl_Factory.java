package com.avito.android.profile.sessions.list;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsListResourceProviderImpl_Factory implements Factory<SessionsListResourceProviderImpl> {
    public final Provider<Resources> a;

    public SessionsListResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SessionsListResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SessionsListResourceProviderImpl_Factory(provider);
    }

    public static SessionsListResourceProviderImpl newInstance(Resources resources) {
        return new SessionsListResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SessionsListResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
