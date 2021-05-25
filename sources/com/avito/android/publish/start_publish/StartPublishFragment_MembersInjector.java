package com.avito.android.publish.start_publish;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.PublishEventTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class StartPublishFragment_MembersInjector implements MembersInjector<StartPublishFragment> {
    public final Provider<StartPublishViewModelFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<Analytics> d;
    public final Provider<PublishEventTracker> e;

    public StartPublishFragment_MembersInjector(Provider<StartPublishViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4, Provider<PublishEventTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<StartPublishFragment> create(Provider<StartPublishViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4, Provider<PublishEventTracker> provider5) {
        return new StartPublishFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishFragment.analytics")
    public static void injectAnalytics(StartPublishFragment startPublishFragment, Analytics analytics) {
        startPublishFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(StartPublishFragment startPublishFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        startPublishFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishFragment.eventTracker")
    public static void injectEventTracker(StartPublishFragment startPublishFragment, PublishEventTracker publishEventTracker) {
        startPublishFragment.eventTracker = publishEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishFragment.intentFactory")
    public static void injectIntentFactory(StartPublishFragment startPublishFragment, ActivityIntentFactory activityIntentFactory) {
        startPublishFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.start_publish.StartPublishFragment.viewModelFactory")
    public static void injectViewModelFactory(StartPublishFragment startPublishFragment, StartPublishViewModelFactory startPublishViewModelFactory) {
        startPublishFragment.viewModelFactory = startPublishViewModelFactory;
    }

    public void injectMembers(StartPublishFragment startPublishFragment) {
        injectViewModelFactory(startPublishFragment, this.a.get());
        injectIntentFactory(startPublishFragment, this.b.get());
        injectDeepLinkIntentFactory(startPublishFragment, this.c.get());
        injectAnalytics(startPublishFragment, this.d.get());
        injectEventTracker(startPublishFragment, this.e.get());
    }
}
