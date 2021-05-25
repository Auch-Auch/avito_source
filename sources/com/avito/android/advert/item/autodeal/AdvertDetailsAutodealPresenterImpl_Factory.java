package com.avito.android.advert.item.autodeal;

import com.avito.android.advert.item.AdvertDetailsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutodealPresenterImpl_Factory implements Factory<AdvertDetailsAutodealPresenterImpl> {
    public final Provider<AdvertDetailsPresenter> a;

    public AdvertDetailsAutodealPresenterImpl_Factory(Provider<AdvertDetailsPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAutodealPresenterImpl_Factory create(Provider<AdvertDetailsPresenter> provider) {
        return new AdvertDetailsAutodealPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsAutodealPresenterImpl newInstance(AdvertDetailsPresenter advertDetailsPresenter) {
        return new AdvertDetailsAutodealPresenterImpl(advertDetailsPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutodealPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
