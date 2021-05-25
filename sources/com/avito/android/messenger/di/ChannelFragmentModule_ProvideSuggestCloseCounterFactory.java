package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.SuggestCloseCounter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSuggestCloseCounterFactory implements Factory<SuggestCloseCounter> {
    public final ChannelFragmentModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public ChannelFragmentModule_ProvideSuggestCloseCounterFactory(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideSuggestCloseCounterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelFragmentModule_ProvideSuggestCloseCounterFactory(channelFragmentModule, provider, provider2);
    }

    public static SuggestCloseCounter provideSuggestCloseCounter(ChannelFragmentModule channelFragmentModule, Analytics analytics, Features features) {
        return (SuggestCloseCounter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSuggestCloseCounter(analytics, features));
    }

    @Override // javax.inject.Provider
    public SuggestCloseCounter get() {
        return provideSuggestCloseCounter(this.a, this.b.get(), this.c.get());
    }
}
