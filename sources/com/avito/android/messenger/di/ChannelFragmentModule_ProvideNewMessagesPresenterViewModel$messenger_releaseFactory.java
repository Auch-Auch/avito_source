package com.avito.android.messenger.di;

import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideNewMessagesPresenterViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;
    public final Provider<MessageRepo> c;
    public final Provider<ChannelContextInteractor> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<TimeSource> f;

    public ChannelFragmentModule_ProvideNewMessagesPresenterViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<MessageRepo> provider2, Provider<ChannelContextInteractor> provider3, Provider<SchedulersFactory> provider4, Provider<TimeSource> provider5) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static ChannelFragmentModule_ProvideNewMessagesPresenterViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<MessageRepo> provider2, Provider<ChannelContextInteractor> provider3, Provider<SchedulersFactory> provider4, Provider<TimeSource> provider5) {
        return new ChannelFragmentModule_ProvideNewMessagesPresenterViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5);
    }

    public static ViewModel provideNewMessagesPresenterViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params, MessageRepo messageRepo, ChannelContextInteractor channelContextInteractor, SchedulersFactory schedulersFactory, TimeSource timeSource) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideNewMessagesPresenterViewModel$messenger_release(params, messageRepo, channelContextInteractor, schedulersFactory, timeSource));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideNewMessagesPresenterViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
