package com.avito.android.brandspace.items.adverts;

import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertItemPresenterImpl_Factory implements Factory<AdvertItemPresenterImpl> {
    public final Provider<RdsAdvertItemPresenter> a;

    public AdvertItemPresenterImpl_Factory(Provider<RdsAdvertItemPresenter> provider) {
        this.a = provider;
    }

    public static AdvertItemPresenterImpl_Factory create(Provider<RdsAdvertItemPresenter> provider) {
        return new AdvertItemPresenterImpl_Factory(provider);
    }

    public static AdvertItemPresenterImpl newInstance(RdsAdvertItemPresenter rdsAdvertItemPresenter) {
        return new AdvertItemPresenterImpl(rdsAdvertItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
