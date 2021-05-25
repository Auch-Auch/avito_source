package com.avito.android.messenger.conversation.mvi.menu;

import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter;
import com.avito.android.messenger.channels.mvi.data.DraftRepoWriter;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelMenuInteractorImpl_Factory implements Factory<ChannelMenuInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;
    public final Provider<BlockUserInteractor> b;
    public final Provider<Analytics> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ChannelContextInteractor> e;
    public final Provider<DraftRepoWriter> f;
    public final Provider<ChannelRepoWriter> g;
    public final Provider<ChannelSyncAgent> h;
    public final Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> i;

    public ChannelMenuInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<BlockUserInteractor> provider2, Provider<Analytics> provider3, Provider<SchedulersFactory> provider4, Provider<ChannelContextInteractor> provider5, Provider<DraftRepoWriter> provider6, Provider<ChannelRepoWriter> provider7, Provider<ChannelSyncAgent> provider8, Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static ChannelMenuInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider, Provider<BlockUserInteractor> provider2, Provider<Analytics> provider3, Provider<SchedulersFactory> provider4, Provider<ChannelContextInteractor> provider5, Provider<DraftRepoWriter> provider6, Provider<ChannelRepoWriter> provider7, Provider<ChannelSyncAgent> provider8, Provider<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> provider9) {
        return new ChannelMenuInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ChannelMenuInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient, BlockUserInteractor blockUserInteractor, Analytics analytics, SchedulersFactory schedulersFactory, ChannelContextInteractor channelContextInteractor, DraftRepoWriter draftRepoWriter, ChannelRepoWriter channelRepoWriter, ChannelSyncAgent channelSyncAgent, SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> singleManuallyExposedAbTestGroup) {
        return new ChannelMenuInteractorImpl(messengerClient, blockUserInteractor, analytics, schedulersFactory, channelContextInteractor, draftRepoWriter, channelRepoWriter, channelSyncAgent, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public ChannelMenuInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
