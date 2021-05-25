package com.avito.android.messenger.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.data.DraftRepo;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.OpenedFrom;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentInteractor;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSendMessagePresenterViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;
    public final Provider<OpenedFrom> c;
    public final Provider<SendMessagePresenter.State> d;
    public final Provider<SendMessageInteractor> e;
    public final Provider<ChannelContextInteractor> f;
    public final Provider<FileAttachmentInteractor> g;
    public final Provider<MessageRepo> h;
    public final Provider<RandomKeyProvider> i;
    public final Provider<Resources> j;
    public final Provider<Analytics> k;
    public final Provider<SchedulersFactory> l;
    public final Provider<Features> m;
    public final Provider<OnboardingsInteractor> n;
    public final Provider<DraftRepo> o;

    public ChannelFragmentModule_ProvideSendMessagePresenterViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<OpenedFrom> provider2, Provider<SendMessagePresenter.State> provider3, Provider<SendMessageInteractor> provider4, Provider<ChannelContextInteractor> provider5, Provider<FileAttachmentInteractor> provider6, Provider<MessageRepo> provider7, Provider<RandomKeyProvider> provider8, Provider<Resources> provider9, Provider<Analytics> provider10, Provider<SchedulersFactory> provider11, Provider<Features> provider12, Provider<OnboardingsInteractor> provider13, Provider<DraftRepo> provider14) {
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
    }

    public static ChannelFragmentModule_ProvideSendMessagePresenterViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<OpenedFrom> provider2, Provider<SendMessagePresenter.State> provider3, Provider<SendMessageInteractor> provider4, Provider<ChannelContextInteractor> provider5, Provider<FileAttachmentInteractor> provider6, Provider<MessageRepo> provider7, Provider<RandomKeyProvider> provider8, Provider<Resources> provider9, Provider<Analytics> provider10, Provider<SchedulersFactory> provider11, Provider<Features> provider12, Provider<OnboardingsInteractor> provider13, Provider<DraftRepo> provider14) {
        return new ChannelFragmentModule_ProvideSendMessagePresenterViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static ViewModel provideSendMessagePresenterViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params, OpenedFrom openedFrom, SendMessagePresenter.State state, SendMessageInteractor sendMessageInteractor, ChannelContextInteractor channelContextInteractor, FileAttachmentInteractor fileAttachmentInteractor, MessageRepo messageRepo, RandomKeyProvider randomKeyProvider, Resources resources, Analytics analytics, SchedulersFactory schedulersFactory, Features features, OnboardingsInteractor onboardingsInteractor, DraftRepo draftRepo) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSendMessagePresenterViewModel$messenger_release(params, openedFrom, state, sendMessageInteractor, channelContextInteractor, fileAttachmentInteractor, messageRepo, randomKeyProvider, resources, analytics, schedulersFactory, features, onboardingsInteractor, draftRepo));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideSendMessagePresenterViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get());
    }
}
