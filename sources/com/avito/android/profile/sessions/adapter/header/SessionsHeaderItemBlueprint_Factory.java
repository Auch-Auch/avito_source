package com.avito.android.profile.sessions.adapter.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsHeaderItemBlueprint_Factory implements Factory<SessionsHeaderItemBlueprint> {
    public final Provider<SessionsHeaderItemPresenter> a;

    public SessionsHeaderItemBlueprint_Factory(Provider<SessionsHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static SessionsHeaderItemBlueprint_Factory create(Provider<SessionsHeaderItemPresenter> provider) {
        return new SessionsHeaderItemBlueprint_Factory(provider);
    }

    public static SessionsHeaderItemBlueprint newInstance(SessionsHeaderItemPresenter sessionsHeaderItemPresenter) {
        return new SessionsHeaderItemBlueprint(sessionsHeaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public SessionsHeaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
