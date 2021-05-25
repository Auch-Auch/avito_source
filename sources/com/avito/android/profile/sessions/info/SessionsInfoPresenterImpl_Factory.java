package com.avito.android.profile.sessions.info;

import com.avito.android.analytics.Analytics;
import com.avito.android.profile.sessions.info.SessionsInfoPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsInfoPresenterImpl_Factory implements Factory<SessionsInfoPresenterImpl> {
    public final Provider<SessionsInfoPresenter.Mode> a;
    public final Provider<Analytics> b;

    public SessionsInfoPresenterImpl_Factory(Provider<SessionsInfoPresenter.Mode> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SessionsInfoPresenterImpl_Factory create(Provider<SessionsInfoPresenter.Mode> provider, Provider<Analytics> provider2) {
        return new SessionsInfoPresenterImpl_Factory(provider, provider2);
    }

    public static SessionsInfoPresenterImpl newInstance(SessionsInfoPresenter.Mode mode, Analytics analytics) {
        return new SessionsInfoPresenterImpl(mode, analytics);
    }

    @Override // javax.inject.Provider
    public SessionsInfoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
