package com.avito.android.profile.sessions.info;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SessionsInfoFragment_MembersInjector implements MembersInjector<SessionsInfoFragment> {
    public final Provider<SessionsInfoPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Analytics> c;

    public SessionsInfoFragment_MembersInjector(Provider<SessionsInfoPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<SessionsInfoFragment> create(Provider<SessionsInfoPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        return new SessionsInfoFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.info.SessionsInfoFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SessionsInfoFragment sessionsInfoFragment, ActivityIntentFactory activityIntentFactory) {
        sessionsInfoFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.info.SessionsInfoFragment.analytics")
    public static void injectAnalytics(SessionsInfoFragment sessionsInfoFragment, Analytics analytics) {
        sessionsInfoFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile.sessions.info.SessionsInfoFragment.presenter")
    public static void injectPresenter(SessionsInfoFragment sessionsInfoFragment, SessionsInfoPresenter sessionsInfoPresenter) {
        sessionsInfoFragment.presenter = sessionsInfoPresenter;
    }

    public void injectMembers(SessionsInfoFragment sessionsInfoFragment) {
        injectPresenter(sessionsInfoFragment, this.a.get());
        injectActivityIntentFactory(sessionsInfoFragment, this.b.get());
        injectAnalytics(sessionsInfoFragment, this.c.get());
    }
}
