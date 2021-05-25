package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.deeplinks.payout.SafeDealPayoutInteractor;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSafeDealPayoutInteractor$messenger_releaseFactory implements Factory<SafeDealPayoutInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<SafeDealApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public ChannelFragmentModule_ProvideSafeDealPayoutInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<SafeDealApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideSafeDealPayoutInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<SafeDealApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new ChannelFragmentModule_ProvideSafeDealPayoutInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static SafeDealPayoutInteractor provideSafeDealPayoutInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, SafeDealApi safeDealApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (SafeDealPayoutInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSafeDealPayoutInteractor$messenger_release(safeDealApi, schedulersFactory, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public SafeDealPayoutInteractor get() {
        return provideSafeDealPayoutInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
