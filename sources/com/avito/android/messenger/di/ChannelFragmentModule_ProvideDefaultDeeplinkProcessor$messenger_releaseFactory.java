package com.avito.android.messenger.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDefaultDeeplinkProcessor$messenger_releaseFactory implements Factory<DefaultDeeplinkProcessor> {
    public final ChannelFragmentModule a;
    public final Provider<DeepLinkIntentFactory> b;

    public ChannelFragmentModule_ProvideDefaultDeeplinkProcessor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeepLinkIntentFactory> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideDefaultDeeplinkProcessor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeepLinkIntentFactory> provider) {
        return new ChannelFragmentModule_ProvideDefaultDeeplinkProcessor$messenger_releaseFactory(channelFragmentModule, provider);
    }

    public static DefaultDeeplinkProcessor provideDefaultDeeplinkProcessor$messenger_release(ChannelFragmentModule channelFragmentModule, DeepLinkIntentFactory deepLinkIntentFactory) {
        return (DefaultDeeplinkProcessor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDefaultDeeplinkProcessor$messenger_release(deepLinkIntentFactory));
    }

    @Override // javax.inject.Provider
    public DefaultDeeplinkProcessor get() {
        return provideDefaultDeeplinkProcessor$messenger_release(this.a, this.b.get());
    }
}
