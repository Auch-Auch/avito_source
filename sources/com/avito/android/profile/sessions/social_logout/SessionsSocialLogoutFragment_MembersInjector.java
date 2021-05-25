package com.avito.android.profile.sessions.social_logout;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SessionsSocialLogoutFragment_MembersInjector implements MembersInjector<SessionsSocialLogoutFragment> {
    public final Provider<SessionsSocialLogoutPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<ActivityIntentFactory> c;

    public SessionsSocialLogoutFragment_MembersInjector(Provider<SessionsSocialLogoutPresenter> provider, Provider<Analytics> provider2, Provider<ActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<SessionsSocialLogoutFragment> create(Provider<SessionsSocialLogoutPresenter> provider, Provider<Analytics> provider2, Provider<ActivityIntentFactory> provider3) {
        return new SessionsSocialLogoutFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SessionsSocialLogoutFragment sessionsSocialLogoutFragment, ActivityIntentFactory activityIntentFactory) {
        sessionsSocialLogoutFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment.analytics")
    public static void injectAnalytics(SessionsSocialLogoutFragment sessionsSocialLogoutFragment, Analytics analytics) {
        sessionsSocialLogoutFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment.presenter")
    public static void injectPresenter(SessionsSocialLogoutFragment sessionsSocialLogoutFragment, SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter) {
        sessionsSocialLogoutFragment.presenter = sessionsSocialLogoutPresenter;
    }

    public void injectMembers(SessionsSocialLogoutFragment sessionsSocialLogoutFragment) {
        injectPresenter(sessionsSocialLogoutFragment, this.a.get());
        injectAnalytics(sessionsSocialLogoutFragment, this.b.get());
        injectActivityIntentFactory(sessionsSocialLogoutFragment, this.c.get());
    }
}
