package com.avito.android.profile.sessions.social_logout;

import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionsSocialLogoutPresenterImpl_Factory implements Factory<SessionsSocialLogoutPresenterImpl> {
    public final Provider<SessionsSocialLogoutInteractor> a;
    public final Provider<SessionsSocialLogoutPresenter.SessionParams> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SessionsSocialLogoutResourcesProvider> d;

    public SessionsSocialLogoutPresenterImpl_Factory(Provider<SessionsSocialLogoutInteractor> provider, Provider<SessionsSocialLogoutPresenter.SessionParams> provider2, Provider<SchedulersFactory3> provider3, Provider<SessionsSocialLogoutResourcesProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SessionsSocialLogoutPresenterImpl_Factory create(Provider<SessionsSocialLogoutInteractor> provider, Provider<SessionsSocialLogoutPresenter.SessionParams> provider2, Provider<SchedulersFactory3> provider3, Provider<SessionsSocialLogoutResourcesProvider> provider4) {
        return new SessionsSocialLogoutPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SessionsSocialLogoutPresenterImpl newInstance(SessionsSocialLogoutInteractor sessionsSocialLogoutInteractor, SessionsSocialLogoutPresenter.SessionParams sessionParams, SchedulersFactory3 schedulersFactory3, SessionsSocialLogoutResourcesProvider sessionsSocialLogoutResourcesProvider) {
        return new SessionsSocialLogoutPresenterImpl(sessionsSocialLogoutInteractor, sessionParams, schedulersFactory3, sessionsSocialLogoutResourcesProvider);
    }

    @Override // javax.inject.Provider
    public SessionsSocialLogoutPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
