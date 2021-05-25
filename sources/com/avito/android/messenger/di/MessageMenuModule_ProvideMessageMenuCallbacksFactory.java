package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageMenuModule_ProvideMessageMenuCallbacksFactory implements Factory<MessageMenuCallbacks> {
    public final Provider<ViewModelFactory> a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;

    public MessageMenuModule_ProvideMessageMenuCallbacksFactory(Provider<ViewModelFactory> provider, Provider<ChannelFragment> provider2, Provider<ChannelFragment.Params> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MessageMenuModule_ProvideMessageMenuCallbacksFactory create(Provider<ViewModelFactory> provider, Provider<ChannelFragment> provider2, Provider<ChannelFragment.Params> provider3) {
        return new MessageMenuModule_ProvideMessageMenuCallbacksFactory(provider, provider2, provider3);
    }

    public static MessageMenuCallbacks provideMessageMenuCallbacks(ViewModelFactory viewModelFactory, ChannelFragment channelFragment, ChannelFragment.Params params) {
        return (MessageMenuCallbacks) Preconditions.checkNotNullFromProvides(MessageMenuModule.provideMessageMenuCallbacks(viewModelFactory, channelFragment, params));
    }

    @Override // javax.inject.Provider
    public MessageMenuCallbacks get() {
        return provideMessageMenuCallbacks(this.a.get(), this.b.get(), this.c.get());
    }
}
