package com.avito.android.publish.new_advert;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper;
import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NewAdvertFragment_MembersInjector implements MembersInjector<NewAdvertFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<FloatingAddAdvertAnalyticsWrapper> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<NewAdvertPresenter> d;
    public final Provider<SchedulersFactory> e;

    public NewAdvertFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<FloatingAddAdvertAnalyticsWrapper> provider2, Provider<ActivityIntentFactory> provider3, Provider<NewAdvertPresenter> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<NewAdvertFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<FloatingAddAdvertAnalyticsWrapper> provider2, Provider<ActivityIntentFactory> provider3, Provider<NewAdvertPresenter> provider4, Provider<SchedulersFactory> provider5) {
        return new NewAdvertFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.publish.new_advert.NewAdvertFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(NewAdvertFragment newAdvertFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        newAdvertFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.new_advert.NewAdvertFragment.floatingAddAdvertWrapper")
    public static void injectFloatingAddAdvertWrapper(NewAdvertFragment newAdvertFragment, FloatingAddAdvertAnalyticsWrapper floatingAddAdvertAnalyticsWrapper) {
        newAdvertFragment.floatingAddAdvertWrapper = floatingAddAdvertAnalyticsWrapper;
    }

    @InjectedFieldSignature("com.avito.android.publish.new_advert.NewAdvertFragment.intentFactory")
    public static void injectIntentFactory(NewAdvertFragment newAdvertFragment, ActivityIntentFactory activityIntentFactory) {
        newAdvertFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.new_advert.NewAdvertFragment.presenter")
    public static void injectPresenter(NewAdvertFragment newAdvertFragment, NewAdvertPresenter newAdvertPresenter) {
        newAdvertFragment.presenter = newAdvertPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.new_advert.NewAdvertFragment.schedulers")
    public static void injectSchedulers(NewAdvertFragment newAdvertFragment, SchedulersFactory schedulersFactory) {
        newAdvertFragment.schedulers = schedulersFactory;
    }

    public void injectMembers(NewAdvertFragment newAdvertFragment) {
        injectDeepLinkIntentFactory(newAdvertFragment, this.a.get());
        injectFloatingAddAdvertWrapper(newAdvertFragment, this.b.get());
        injectIntentFactory(newAdvertFragment, this.c.get());
        injectPresenter(newAdvertFragment, this.d.get());
        injectSchedulers(newAdvertFragment, this.e.get());
    }
}
