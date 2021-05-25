package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.deeplinks.payout.StrPayoutInteractor;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideStrPayoutInteractor$messenger_releaseFactory implements Factory<StrPayoutInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<ShortTermRentApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public ChannelFragmentModule_ProvideStrPayoutInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideStrPayoutInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new ChannelFragmentModule_ProvideStrPayoutInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static StrPayoutInteractor provideStrPayoutInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, ShortTermRentApi shortTermRentApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (StrPayoutInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideStrPayoutInteractor$messenger_release(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public StrPayoutInteractor get() {
        return provideStrPayoutInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
