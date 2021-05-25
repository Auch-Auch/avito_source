package com.avito.android.messenger.channels.mvi.di;

import dagger.internal.Factory;
public final class ChannelsModule_ProvideChannelsBannerDismissPeriodFactory implements Factory<Long> {

    public static final class a {
        public static final ChannelsModule_ProvideChannelsBannerDismissPeriodFactory a = new ChannelsModule_ProvideChannelsBannerDismissPeriodFactory();
    }

    public static ChannelsModule_ProvideChannelsBannerDismissPeriodFactory create() {
        return a.a;
    }

    public static long provideChannelsBannerDismissPeriod() {
        return ChannelsModule.INSTANCE.provideChannelsBannerDismissPeriod();
    }

    @Override // javax.inject.Provider
    public Long get() {
        return Long.valueOf(provideChannelsBannerDismissPeriod());
    }
}
