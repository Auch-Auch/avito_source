package com.avito.android.messenger.search.adapter;

import com.avito.android.Features;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsSearchResultConverterImpl_Factory implements Factory<ChannelsSearchResultConverterImpl> {
    public final Provider<LocalMessagePreviewProvider> a;
    public final Provider<RelativeDateFormatter> b;
    public final Provider<Features> c;

    public ChannelsSearchResultConverterImpl_Factory(Provider<LocalMessagePreviewProvider> provider, Provider<RelativeDateFormatter> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ChannelsSearchResultConverterImpl_Factory create(Provider<LocalMessagePreviewProvider> provider, Provider<RelativeDateFormatter> provider2, Provider<Features> provider3) {
        return new ChannelsSearchResultConverterImpl_Factory(provider, provider2, provider3);
    }

    public static ChannelsSearchResultConverterImpl newInstance(LocalMessagePreviewProvider localMessagePreviewProvider, RelativeDateFormatter relativeDateFormatter, Features features) {
        return new ChannelsSearchResultConverterImpl(localMessagePreviewProvider, relativeDateFormatter, features);
    }

    @Override // javax.inject.Provider
    public ChannelsSearchResultConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
