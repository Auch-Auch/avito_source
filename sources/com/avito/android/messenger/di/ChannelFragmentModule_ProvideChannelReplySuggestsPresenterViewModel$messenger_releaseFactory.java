package com.avito.android.messenger.di;

import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.SuggestClickCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestCloseCounter;
import com.avito.android.messenger.analytics.graphite_counter.SuggestShowCounter;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractor;
import com.avito.android.messenger.conversation.mvi.send.SendMessageInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideChannelReplySuggestsPresenterViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<ChannelReplySuggestsInteractor> c;
    public final Provider<SendMessageInteractor> d;
    public final Provider<SuggestShowCounter> e;
    public final Provider<SuggestClickCounter> f;
    public final Provider<SuggestCloseCounter> g;
    public final Provider<Analytics> h;
    public final Provider<Features> i;

    public ChannelFragmentModule_ProvideChannelReplySuggestsPresenterViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<SchedulersFactory> provider, Provider<ChannelReplySuggestsInteractor> provider2, Provider<SendMessageInteractor> provider3, Provider<SuggestShowCounter> provider4, Provider<SuggestClickCounter> provider5, Provider<SuggestCloseCounter> provider6, Provider<Analytics> provider7, Provider<Features> provider8) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    public static ChannelFragmentModule_ProvideChannelReplySuggestsPresenterViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<SchedulersFactory> provider, Provider<ChannelReplySuggestsInteractor> provider2, Provider<SendMessageInteractor> provider3, Provider<SuggestShowCounter> provider4, Provider<SuggestClickCounter> provider5, Provider<SuggestCloseCounter> provider6, Provider<Analytics> provider7, Provider<Features> provider8) {
        return new ChannelFragmentModule_ProvideChannelReplySuggestsPresenterViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ViewModel provideChannelReplySuggestsPresenterViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, SchedulersFactory schedulersFactory, ChannelReplySuggestsInteractor channelReplySuggestsInteractor, SendMessageInteractor sendMessageInteractor, SuggestShowCounter suggestShowCounter, SuggestClickCounter suggestClickCounter, SuggestCloseCounter suggestCloseCounter, Analytics analytics, Features features) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChannelReplySuggestsPresenterViewModel$messenger_release(schedulersFactory, channelReplySuggestsInteractor, sendMessageInteractor, suggestShowCounter, suggestClickCounter, suggestCloseCounter, analytics, features));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideChannelReplySuggestsPresenterViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
