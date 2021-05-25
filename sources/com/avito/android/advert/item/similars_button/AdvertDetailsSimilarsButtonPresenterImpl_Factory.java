package com.avito.android.advert.item.similars_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSimilarsButtonPresenterImpl_Factory implements Factory<AdvertDetailsSimilarsButtonPresenterImpl> {
    public final Provider<SimilarsButtonClickListener> a;

    public AdvertDetailsSimilarsButtonPresenterImpl_Factory(Provider<SimilarsButtonClickListener> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSimilarsButtonPresenterImpl_Factory create(Provider<SimilarsButtonClickListener> provider) {
        return new AdvertDetailsSimilarsButtonPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSimilarsButtonPresenterImpl newInstance(SimilarsButtonClickListener similarsButtonClickListener) {
        return new AdvertDetailsSimilarsButtonPresenterImpl(similarsButtonClickListener);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSimilarsButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
