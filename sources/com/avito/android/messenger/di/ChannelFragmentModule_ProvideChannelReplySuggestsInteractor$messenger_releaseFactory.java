package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelFragmentModule_ProvideChannelReplySuggestsInteractor$messenger_releaseFactory implements Factory<ChannelReplySuggestsInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;
    public final Provider<ChannelContextInteractor> c;
    public final Provider<MessengerClient<AvitoMessengerApi>> d;
    public final Provider<SchedulersFactory> e;

    public ChannelFragmentModule_ProvideChannelReplySuggestsInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<ChannelContextInteractor> provider2, Provider<MessengerClient<AvitoMessengerApi>> provider3, Provider<SchedulersFactory> provider4) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ChannelFragmentModule_ProvideChannelReplySuggestsInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider, Provider<ChannelContextInteractor> provider2, Provider<MessengerClient<AvitoMessengerApi>> provider3, Provider<SchedulersFactory> provider4) {
        return new ChannelFragmentModule_ProvideChannelReplySuggestsInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4);
    }

    public static ChannelReplySuggestsInteractor provideChannelReplySuggestsInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params, ChannelContextInteractor channelContextInteractor, MessengerClient<AvitoMessengerApi> messengerClient, SchedulersFactory schedulersFactory) {
        return (ChannelReplySuggestsInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChannelReplySuggestsInteractor$messenger_release(params, channelContextInteractor, messengerClient, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ChannelReplySuggestsInteractor get() {
        return provideChannelReplySuggestsInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
