package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.SuggestClickCounter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSuggestClickCounterFactory implements Factory<SuggestClickCounter> {
    public final ChannelFragmentModule a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public ChannelFragmentModule_ProvideSuggestClickCounterFactory(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideSuggestClickCounterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChannelFragmentModule_ProvideSuggestClickCounterFactory(channelFragmentModule, provider, provider2);
    }

    public static SuggestClickCounter provideSuggestClickCounter(ChannelFragmentModule channelFragmentModule, Analytics analytics, Features features) {
        return (SuggestClickCounter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSuggestClickCounter(analytics, features));
    }

    @Override // javax.inject.Provider
    public SuggestClickCounter get() {
        return provideSuggestClickCounter(this.a, this.b.get(), this.c.get());
    }
}
