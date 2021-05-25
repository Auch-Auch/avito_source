package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsErrorInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class ChannelsHeaderPresenterImpl_Factory implements Factory<ChannelsHeaderPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<ChannelsErrorInteractor> c;
    public final Provider<BlockUserInteractor> d;

    public ChannelsHeaderPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<ChannelsErrorInteractor> provider3, Provider<BlockUserInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChannelsHeaderPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<ChannelsErrorInteractor> provider3, Provider<BlockUserInteractor> provider4) {
        return new ChannelsHeaderPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChannelsHeaderPresenterImpl newInstance(SchedulersFactory schedulersFactory, MessengerClient<AvitoMessengerApi> messengerClient, ChannelsErrorInteractor channelsErrorInteractor, BlockUserInteractor blockUserInteractor) {
        return new ChannelsHeaderPresenterImpl(schedulersFactory, messengerClient, channelsErrorInteractor, blockUserInteractor);
    }

    @Override // javax.inject.Provider
    public ChannelsHeaderPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
