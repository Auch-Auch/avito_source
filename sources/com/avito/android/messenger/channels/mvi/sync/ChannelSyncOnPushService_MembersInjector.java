package com.avito.android.messenger.channels.mvi.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChannelSyncOnPushService_MembersInjector implements MembersInjector<ChannelSyncOnPushService> {
    public final Provider<ChannelSyncOnPushAgent> a;

    public ChannelSyncOnPushService_MembersInjector(Provider<ChannelSyncOnPushAgent> provider) {
        this.a = provider;
    }

    public static MembersInjector<ChannelSyncOnPushService> create(Provider<ChannelSyncOnPushAgent> provider) {
        return new ChannelSyncOnPushService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushService.agent")
    public static void injectAgent(ChannelSyncOnPushService channelSyncOnPushService, ChannelSyncOnPushAgent channelSyncOnPushAgent) {
        channelSyncOnPushService.agent = channelSyncOnPushAgent;
    }

    public void injectMembers(ChannelSyncOnPushService channelSyncOnPushService) {
        injectAgent(channelSyncOnPushService, this.a.get());
    }
}
