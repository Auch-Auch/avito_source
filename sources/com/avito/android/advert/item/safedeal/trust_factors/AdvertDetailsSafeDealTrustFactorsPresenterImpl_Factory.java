package com.avito.android.advert.item.safedeal.trust_factors;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealTrustFactorsPresenterImpl> {
    public final Provider<AdvertSafeDealPresenter> a;

    public AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory(Provider<AdvertSafeDealPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory create(Provider<AdvertSafeDealPresenter> provider) {
        return new AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSafeDealTrustFactorsPresenterImpl newInstance(AdvertSafeDealPresenter advertSafeDealPresenter) {
        return new AdvertDetailsSafeDealTrustFactorsPresenterImpl(advertSafeDealPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealTrustFactorsPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
