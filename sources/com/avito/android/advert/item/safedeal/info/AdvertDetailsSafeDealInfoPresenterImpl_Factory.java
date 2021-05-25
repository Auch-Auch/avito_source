package com.avito.android.advert.item.safedeal.info;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealInfoPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealInfoPresenterImpl> {
    public final Provider<AdvertSafeDealPresenter> a;

    public AdvertDetailsSafeDealInfoPresenterImpl_Factory(Provider<AdvertSafeDealPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealInfoPresenterImpl_Factory create(Provider<AdvertSafeDealPresenter> provider) {
        return new AdvertDetailsSafeDealInfoPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSafeDealInfoPresenterImpl newInstance(AdvertSafeDealPresenter advertSafeDealPresenter) {
        return new AdvertDetailsSafeDealInfoPresenterImpl(advertSafeDealPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealInfoPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
