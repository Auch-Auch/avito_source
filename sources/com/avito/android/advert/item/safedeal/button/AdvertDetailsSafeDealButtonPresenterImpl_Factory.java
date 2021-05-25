package com.avito.android.advert.item.safedeal.button;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealButtonPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealButtonPresenterImpl> {
    public final Provider<AdvertSafeDealPresenter> a;

    public AdvertDetailsSafeDealButtonPresenterImpl_Factory(Provider<AdvertSafeDealPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealButtonPresenterImpl_Factory create(Provider<AdvertSafeDealPresenter> provider) {
        return new AdvertDetailsSafeDealButtonPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSafeDealButtonPresenterImpl newInstance(AdvertSafeDealPresenter advertSafeDealPresenter) {
        return new AdvertDetailsSafeDealButtonPresenterImpl(advertSafeDealPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
