package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.ChannelFragment;
import dagger.internal.Factory;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
public final class ChannelFragmentModule_ProvideMessageIdFactory implements Factory<String> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;

    public ChannelFragmentModule_ProvideMessageIdFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideMessageIdFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider) {
        return new ChannelFragmentModule_ProvideMessageIdFactory(channelFragmentModule, provider);
    }

    @Nullable
    public static String provideMessageId(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params) {
        return channelFragmentModule.provideMessageId(params);
    }

    @Override // javax.inject.Provider
    @Nullable
    public String get() {
        return provideMessageId(this.a, this.b.get());
    }
}
