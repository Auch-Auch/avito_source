package com.avito.android.messenger.search.adapter.supportchannel;

import com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SupportChannelItemPresenter_Factory implements Factory<SupportChannelItemPresenter> {
    public final Provider<SupportChannelItemPresenter.Listener> a;

    public SupportChannelItemPresenter_Factory(Provider<SupportChannelItemPresenter.Listener> provider) {
        this.a = provider;
    }

    public static SupportChannelItemPresenter_Factory create(Provider<SupportChannelItemPresenter.Listener> provider) {
        return new SupportChannelItemPresenter_Factory(provider);
    }

    public static SupportChannelItemPresenter newInstance(Lazy<SupportChannelItemPresenter.Listener> lazy) {
        return new SupportChannelItemPresenter(lazy);
    }

    @Override // javax.inject.Provider
    public SupportChannelItemPresenter get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
