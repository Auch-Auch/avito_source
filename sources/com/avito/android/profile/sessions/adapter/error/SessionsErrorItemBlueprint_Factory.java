package com.avito.android.profile.sessions.adapter.error;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsErrorItemBlueprint_Factory implements Factory<SessionsErrorItemBlueprint> {
    public final Provider<SessionsErrorItemPresenter> a;

    public SessionsErrorItemBlueprint_Factory(Provider<SessionsErrorItemPresenter> provider) {
        this.a = provider;
    }

    public static SessionsErrorItemBlueprint_Factory create(Provider<SessionsErrorItemPresenter> provider) {
        return new SessionsErrorItemBlueprint_Factory(provider);
    }

    public static SessionsErrorItemBlueprint newInstance(SessionsErrorItemPresenter sessionsErrorItemPresenter) {
        return new SessionsErrorItemBlueprint(sessionsErrorItemPresenter);
    }

    @Override // javax.inject.Provider
    public SessionsErrorItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
