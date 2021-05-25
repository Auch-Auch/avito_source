package com.avito.android.advert.item.safedeal.services;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealServicesPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealServicesPresenterImpl> {
    public final Provider<MyAdvertSafeDealServicesViewModel> a;
    public final Provider<AdvertSafeDealPresenter> b;
    public final Provider<Relay<MyAdvertSafeDeal>> c;

    public AdvertDetailsSafeDealServicesPresenterImpl_Factory(Provider<MyAdvertSafeDealServicesViewModel> provider, Provider<AdvertSafeDealPresenter> provider2, Provider<Relay<MyAdvertSafeDeal>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsSafeDealServicesPresenterImpl_Factory create(Provider<MyAdvertSafeDealServicesViewModel> provider, Provider<AdvertSafeDealPresenter> provider2, Provider<Relay<MyAdvertSafeDeal>> provider3) {
        return new AdvertDetailsSafeDealServicesPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsSafeDealServicesPresenterImpl newInstance(MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel, AdvertSafeDealPresenter advertSafeDealPresenter, Relay<MyAdvertSafeDeal> relay) {
        return new AdvertDetailsSafeDealServicesPresenterImpl(myAdvertSafeDealServicesViewModel, advertSafeDealPresenter, relay);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealServicesPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
