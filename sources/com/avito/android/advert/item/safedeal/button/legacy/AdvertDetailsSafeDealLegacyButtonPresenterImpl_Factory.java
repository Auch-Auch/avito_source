package com.avito.android.advert.item.safedeal.button.legacy;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealLegacyButtonPresenterImpl> {
    public final Provider<AdvertSafeDealPresenter> a;

    public AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory(Provider<AdvertSafeDealPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory create(Provider<AdvertSafeDealPresenter> provider) {
        return new AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSafeDealLegacyButtonPresenterImpl newInstance(AdvertSafeDealPresenter advertSafeDealPresenter) {
        return new AdvertDetailsSafeDealLegacyButtonPresenterImpl(advertSafeDealPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealLegacyButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
