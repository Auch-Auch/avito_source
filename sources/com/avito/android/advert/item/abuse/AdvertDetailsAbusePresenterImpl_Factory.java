package com.avito.android.advert.item.abuse;

import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAbusePresenterImpl_Factory implements Factory<AdvertDetailsAbusePresenterImpl> {
    public final Provider<AdvertDetailsAbusePresenter.Listener> a;

    public AdvertDetailsAbusePresenterImpl_Factory(Provider<AdvertDetailsAbusePresenter.Listener> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAbusePresenterImpl_Factory create(Provider<AdvertDetailsAbusePresenter.Listener> provider) {
        return new AdvertDetailsAbusePresenterImpl_Factory(provider);
    }

    public static AdvertDetailsAbusePresenterImpl newInstance(AdvertDetailsAbusePresenter.Listener listener) {
        return new AdvertDetailsAbusePresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAbusePresenterImpl get() {
        return newInstance(this.a.get());
    }
}
