package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProviderErrorFormatter$messenger_releaseFactory implements Factory<Formatter<Throwable>> {
    public final ChannelFragmentModule a;
    public final Provider<Resources> b;

    public ChannelFragmentModule_ProviderErrorFormatter$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<Resources> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProviderErrorFormatter$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<Resources> provider) {
        return new ChannelFragmentModule_ProviderErrorFormatter$messenger_releaseFactory(channelFragmentModule, provider);
    }

    public static Formatter<Throwable> providerErrorFormatter$messenger_release(ChannelFragmentModule channelFragmentModule, Resources resources) {
        return (Formatter) Preconditions.checkNotNullFromProvides(channelFragmentModule.providerErrorFormatter$messenger_release(resources));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return providerErrorFormatter$messenger_release(this.a, this.b.get());
    }
}
