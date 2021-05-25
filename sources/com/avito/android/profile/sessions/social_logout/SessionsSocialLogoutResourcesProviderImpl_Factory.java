package com.avito.android.profile.sessions.social_logout;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsSocialLogoutResourcesProviderImpl_Factory implements Factory<SessionsSocialLogoutResourcesProviderImpl> {
    public final Provider<Resources> a;

    public SessionsSocialLogoutResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SessionsSocialLogoutResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new SessionsSocialLogoutResourcesProviderImpl_Factory(provider);
    }

    public static SessionsSocialLogoutResourcesProviderImpl newInstance(Resources resources) {
        return new SessionsSocialLogoutResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SessionsSocialLogoutResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
