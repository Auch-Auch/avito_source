package com.avito.android.messenger.conversation.create;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CreateChannelFragment_MembersInjector implements MembersInjector<CreateChannelFragment> {
    public final Provider<CreateChannelPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Analytics> c;

    public CreateChannelFragment_MembersInjector(Provider<CreateChannelPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<CreateChannelFragment> create(Provider<CreateChannelPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3) {
        return new CreateChannelFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.create.CreateChannelFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(CreateChannelFragment createChannelFragment, ActivityIntentFactory activityIntentFactory) {
        createChannelFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.create.CreateChannelFragment.analytics")
    public static void injectAnalytics(CreateChannelFragment createChannelFragment, Analytics analytics) {
        createChannelFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.create.CreateChannelFragment.presenter")
    public static void injectPresenter(CreateChannelFragment createChannelFragment, CreateChannelPresenter createChannelPresenter) {
        createChannelFragment.presenter = createChannelPresenter;
    }

    public void injectMembers(CreateChannelFragment createChannelFragment) {
        injectPresenter(createChannelFragment, this.a.get());
        injectActivityIntentFactory(createChannelFragment, this.b.get());
        injectAnalytics(createChannelFragment, this.c.get());
    }
}
