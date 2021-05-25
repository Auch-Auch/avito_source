package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.SuggestShowCounter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSuggestShowCounterFactory implements Factory<SuggestShowCounter> {
    public final ChannelFragmentModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public ChannelFragmentModule_ProvideSuggestShowCounterFactory(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideSuggestShowCounterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelFragmentModule_ProvideSuggestShowCounterFactory(channelFragmentModule, provider, provider2);
    }

    public static SuggestShowCounter provideSuggestShowCounter(ChannelFragmentModule channelFragmentModule, Analytics analytics, Features features) {
        return (SuggestShowCounter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSuggestShowCounter(analytics, features));
    }

    @Override // javax.inject.Provider
    public SuggestShowCounter get() {
        return provideSuggestShowCounter(this.a, this.b.get(), this.c.get());
    }
}
