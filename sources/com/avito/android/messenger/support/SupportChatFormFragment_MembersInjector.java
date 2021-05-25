package com.avito.android.messenger.support;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SupportChatFormFragment_MembersInjector implements MembersInjector<SupportChatFormFragment> {
    public final Provider<SupportChatFormPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Analytics> c;

    public SupportChatFormFragment_MembersInjector(Provider<SupportChatFormPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<SupportChatFormFragment> create(Provider<SupportChatFormPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        return new SupportChatFormFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.messenger.support.SupportChatFormFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SupportChatFormFragment supportChatFormFragment, ActivityIntentFactory activityIntentFactory) {
        supportChatFormFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.support.SupportChatFormFragment.analytics")
    public static void injectAnalytics(SupportChatFormFragment supportChatFormFragment, Analytics analytics) {
        supportChatFormFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.support.SupportChatFormFragment.presenter")
    public static void injectPresenter(SupportChatFormFragment supportChatFormFragment, SupportChatFormPresenter supportChatFormPresenter) {
        supportChatFormFragment.presenter = supportChatFormPresenter;
    }

    public void injectMembers(SupportChatFormFragment supportChatFormFragment) {
        injectPresenter(supportChatFormFragment, this.a.get());
        injectActivityIntentFactory(supportChatFormFragment, this.b.get());
        injectAnalytics(supportChatFormFragment, this.c.get());
    }
}
