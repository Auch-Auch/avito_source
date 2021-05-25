package com.avito.android.messenger.channels.mvi.di;

import android.content.SharedPreferences;
import com.avito.android.messenger.channels.action_banner.ChannelsBannerShowTimeStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideChannelsBannerShowTimeStorageFactory implements Factory<ChannelsBannerShowTimeStorage> {
    public final Provider<SharedPreferences> a;

    public ChannelsModule_ProvideChannelsBannerShowTimeStorageFactory(Provider<SharedPreferences> provider) {
        this.a = provider;
    }

    public static ChannelsModule_ProvideChannelsBannerShowTimeStorageFactory create(Provider<SharedPreferences> provider) {
        return new ChannelsModule_ProvideChannelsBannerShowTimeStorageFactory(provider);
    }

    public static ChannelsBannerShowTimeStorage provideChannelsBannerShowTimeStorage(SharedPreferences sharedPreferences) {
        return (ChannelsBannerShowTimeStorage) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideChannelsBannerShowTimeStorage(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public ChannelsBannerShowTimeStorage get() {
        return provideChannelsBannerShowTimeStorage(this.a.get());
    }
}
