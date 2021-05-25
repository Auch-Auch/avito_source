package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ChannelFragmentModule_ProvideDefaultDeeplinkProcessorListener$messenger_releaseFactory implements Factory<AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor>> {
    public final ChannelFragmentModule a;

    public ChannelFragmentModule_ProvideDefaultDeeplinkProcessorListener$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule) {
        this.a = channelFragmentModule;
    }

    public static ChannelFragmentModule_ProvideDefaultDeeplinkProcessorListener$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule) {
        return new ChannelFragmentModule_ProvideDefaultDeeplinkProcessorListener$messenger_releaseFactory(channelFragmentModule);
    }

    public static AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> provideDefaultDeeplinkProcessorListener$messenger_release(ChannelFragmentModule channelFragmentModule) {
        return (AbstractDeeplinkProcessorListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDefaultDeeplinkProcessorListener$messenger_release());
    }

    @Override // javax.inject.Provider
    public AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> get() {
        return provideDefaultDeeplinkProcessorListener$messenger_release(this.a);
    }
}
