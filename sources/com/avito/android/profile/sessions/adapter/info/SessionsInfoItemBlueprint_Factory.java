package com.avito.android.profile.sessions.adapter.info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsInfoItemBlueprint_Factory implements Factory<SessionsInfoItemBlueprint> {
    public final Provider<SessionsInfoItemPresenter> a;

    public SessionsInfoItemBlueprint_Factory(Provider<SessionsInfoItemPresenter> provider) {
        this.a = provider;
    }

    public static SessionsInfoItemBlueprint_Factory create(Provider<SessionsInfoItemPresenter> provider) {
        return new SessionsInfoItemBlueprint_Factory(provider);
    }

    public static SessionsInfoItemBlueprint newInstance(SessionsInfoItemPresenter sessionsInfoItemPresenter) {
        return new SessionsInfoItemBlueprint(sessionsInfoItemPresenter);
    }

    @Override // javax.inject.Provider
    public SessionsInfoItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
