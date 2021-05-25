package com.avito.android.messenger.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.messenger.analytics.graphite_counter.ChatAppendCounter;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadManager;
import com.avito.android.messenger.conversation.mvi.file_download.FileMessageClickInteractor;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.MessageEraser;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageListPresenterViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;
    public final Provider<MessageListInteractor> c;
    public final Provider<MessageListItemConverter> d;
    public final Provider<ChannelContextInteractor> e;
    public final Provider<ChannelMenuInteractor> f;
    public final Provider<MessageSpamActionsInteractor> g;
    public final Provider<SchedulersFactory> h;
    public final Provider<Resources> i;
    public final Provider<Features> j;
    public final Provider<DeepLinkFactory> k;
    public final Provider<DeeplinkProcessor> l;
    public final Provider<Analytics> m;
    public final Provider<ChatAppendCounter> n;
    public final Provider<ChannelTracker> o;
    public final Provider<TimeSource> p;
    public final Provider<FileDownloadManager> q;
    public final Provider<FileMessageClickInteractor> r;
    public final Provider<MessageEraser> s;
    public final Provider<MissingUsersSyncAgent> t;

    public ChannelFragmentModule_ProvideMessageListPresenterViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<MessageListInteractor> provider2, Provider<MessageListItemConverter> provider3, Provider<ChannelContextInteractor> provider4, Provider<ChannelMenuInteractor> provider5, Provider<MessageSpamActionsInteractor> provider6, Provider<SchedulersFactory> provider7, Provider<Resources> provider8, Provider<Features> provider9, Provider<DeepLinkFactory> provider10, Provider<DeeplinkProcessor> provider11, Provider<Analytics> provider12, Provider<ChatAppendCounter> provider13, Provider<ChannelTracker> provider14, Provider<TimeSource> provider15, Provider<FileDownloadManager> provider16, Provider<FileMessageClickInteractor> provider17, Provider<MessageEraser> provider18, Provider<MissingUsersSyncAgent> provider19) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
        this.s = provider18;
        this.t = provider19;
    }

    public static ChannelFragmentModule_ProvideMessageListPresenterViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<MessageListInteractor> provider2, Provider<MessageListItemConverter> provider3, Provider<ChannelContextInteractor> provider4, Provider<ChannelMenuInteractor> provider5, Provider<MessageSpamActionsInteractor> provider6, Provider<SchedulersFactory> provider7, Provider<Resources> provider8, Provider<Features> provider9, Provider<DeepLinkFactory> provider10, Provider<DeeplinkProcessor> provider11, Provider<Analytics> provider12, Provider<ChatAppendCounter> provider13, Provider<ChannelTracker> provider14, Provider<TimeSource> provider15, Provider<FileDownloadManager> provider16, Provider<FileMessageClickInteractor> provider17, Provider<MessageEraser> provider18, Provider<MissingUsersSyncAgent> provider19) {
        return new ChannelFragmentModule_ProvideMessageListPresenterViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    public static ViewModel provideMessageListPresenterViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params, MessageListInteractor messageListInteractor, MessageListItemConverter messageListItemConverter, ChannelContextInteractor channelContextInteractor, ChannelMenuInteractor channelMenuInteractor, MessageSpamActionsInteractor messageSpamActionsInteractor, SchedulersFactory schedulersFactory, Resources resources, Features features, DeepLinkFactory deepLinkFactory, DeeplinkProcessor deeplinkProcessor, Analytics analytics, ChatAppendCounter chatAppendCounter, ChannelTracker channelTracker, TimeSource timeSource, FileDownloadManager fileDownloadManager, FileMessageClickInteractor fileMessageClickInteractor, MessageEraser messageEraser, MissingUsersSyncAgent missingUsersSyncAgent) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageListPresenterViewModel$messenger_release(params, messageListInteractor, messageListItemConverter, channelContextInteractor, channelMenuInteractor, messageSpamActionsInteractor, schedulersFactory, resources, features, deepLinkFactory, deeplinkProcessor, analytics, chatAppendCounter, channelTracker, timeSource, fileDownloadManager, fileMessageClickInteractor, messageEraser, missingUsersSyncAgent));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideMessageListPresenterViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get());
    }
}
