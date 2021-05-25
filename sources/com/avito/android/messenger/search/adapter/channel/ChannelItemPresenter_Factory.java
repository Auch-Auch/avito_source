package com.avito.android.messenger.search.adapter.channel;

import com.avito.android.messenger.search.adapter.channel.ChannelItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelItemPresenter_Factory implements Factory<ChannelItemPresenter> {
    public final Provider<ChannelItemPresenter.Listener> a;

    public ChannelItemPresenter_Factory(Provider<ChannelItemPresenter.Listener> provider) {
        this.a = provider;
    }

    public static ChannelItemPresenter_Factory create(Provider<ChannelItemPresenter.Listener> provider) {
        return new ChannelItemPresenter_Factory(provider);
    }

    public static ChannelItemPresenter newInstance(Lazy<ChannelItemPresenter.Listener> lazy) {
        return new ChannelItemPresenter(lazy);
    }

    @Override // javax.inject.Provider
    public ChannelItemPresenter get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
