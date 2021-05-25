package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.ChannelFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideChannelIdFactory implements Factory<String> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment.Params> b;

    public ChannelFragmentModule_ProvideChannelIdFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideChannelIdFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment.Params> provider) {
        return new ChannelFragmentModule_ProvideChannelIdFactory(channelFragmentModule, provider);
    }

    public static String provideChannelId(ChannelFragmentModule channelFragmentModule, ChannelFragment.Params params) {
        return (String) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChannelId(params));
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideChannelId(this.a, this.b.get());
    }
}
