package com.avito.android.messenger.search;

import com.avito.android.messenger.search.adapter.ChannelsSearchResultConverter;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsSearchPresenterImpl_Factory implements Factory<ChannelsSearchPresenterImpl> {
    public final Provider<ChannelsSearchInteractor> a;
    public final Provider<ChannelsSearchResultConverter> b;
    public final Provider<Formatter<Throwable>> c;
    public final Provider<SchedulersFactory> d;

    public ChannelsSearchPresenterImpl_Factory(Provider<ChannelsSearchInteractor> provider, Provider<ChannelsSearchResultConverter> provider2, Provider<Formatter<Throwable>> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChannelsSearchPresenterImpl_Factory create(Provider<ChannelsSearchInteractor> provider, Provider<ChannelsSearchResultConverter> provider2, Provider<Formatter<Throwable>> provider3, Provider<SchedulersFactory> provider4) {
        return new ChannelsSearchPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChannelsSearchPresenterImpl newInstance(ChannelsSearchInteractor channelsSearchInteractor, ChannelsSearchResultConverter channelsSearchResultConverter, Formatter<Throwable> formatter, SchedulersFactory schedulersFactory) {
        return new ChannelsSearchPresenterImpl(channelsSearchInteractor, channelsSearchResultConverter, formatter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ChannelsSearchPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
