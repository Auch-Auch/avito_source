package com.avito.android.profile.sessions.adapter.loading;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsLoadingItemBlueprint_Factory implements Factory<SessionsLoadingItemBlueprint> {
    public final Provider<SessionsLoadingItemPresenter> a;

    public SessionsLoadingItemBlueprint_Factory(Provider<SessionsLoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static SessionsLoadingItemBlueprint_Factory create(Provider<SessionsLoadingItemPresenter> provider) {
        return new SessionsLoadingItemBlueprint_Factory(provider);
    }

    public static SessionsLoadingItemBlueprint newInstance(SessionsLoadingItemPresenter sessionsLoadingItemPresenter) {
        return new SessionsLoadingItemBlueprint(sessionsLoadingItemPresenter);
    }

    @Override // javax.inject.Provider
    public SessionsLoadingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
