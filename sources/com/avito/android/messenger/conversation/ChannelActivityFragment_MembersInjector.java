package com.avito.android.messenger.conversation;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChannelActivityFragment_MembersInjector implements MembersInjector<ChannelActivityFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<Features> c;
    public final Provider<TreeStateIdGenerator> d;
    public final Provider<ServiceIntentFactory> e;

    public ChannelActivityFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Features> provider3, Provider<TreeStateIdGenerator> provider4, Provider<ServiceIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<ChannelActivityFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Features> provider3, Provider<TreeStateIdGenerator> provider4, Provider<ServiceIntentFactory> provider5) {
        return new ChannelActivityFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelActivityFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ChannelActivityFragment channelActivityFragment, ActivityIntentFactory activityIntentFactory) {
        channelActivityFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelActivityFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ChannelActivityFragment channelActivityFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        channelActivityFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelActivityFragment.features")
    public static void injectFeatures(ChannelActivityFragment channelActivityFragment, Features features) {
        channelActivityFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelActivityFragment.serviceIntentFactory")
    public static void injectServiceIntentFactory(ChannelActivityFragment channelActivityFragment, ServiceIntentFactory serviceIntentFactory) {
        channelActivityFragment.serviceIntentFactory = serviceIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelActivityFragment.treeStateIdGenerator")
    public static void injectTreeStateIdGenerator(ChannelActivityFragment channelActivityFragment, TreeStateIdGenerator treeStateIdGenerator) {
        channelActivityFragment.treeStateIdGenerator = treeStateIdGenerator;
    }

    public void injectMembers(ChannelActivityFragment channelActivityFragment) {
        injectActivityIntentFactory(channelActivityFragment, this.a.get());
        injectDeepLinkIntentFactory(channelActivityFragment, this.b.get());
        injectFeatures(channelActivityFragment, this.c.get());
        injectTreeStateIdGenerator(channelActivityFragment, this.d.get());
        injectServiceIntentFactory(channelActivityFragment, this.e.get());
    }
}
