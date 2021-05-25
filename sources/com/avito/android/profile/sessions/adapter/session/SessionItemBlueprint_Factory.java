package com.avito.android.profile.sessions.adapter.session;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionItemBlueprint_Factory implements Factory<SessionItemBlueprint> {
    public final Provider<SessionItemPresenter> a;

    public SessionItemBlueprint_Factory(Provider<SessionItemPresenter> provider) {
        this.a = provider;
    }

    public static SessionItemBlueprint_Factory create(Provider<SessionItemPresenter> provider) {
        return new SessionItemBlueprint_Factory(provider);
    }

    public static SessionItemBlueprint newInstance(SessionItemPresenter sessionItemPresenter) {
        return new SessionItemBlueprint(sessionItemPresenter);
    }

    @Override // javax.inject.Provider
    public SessionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
