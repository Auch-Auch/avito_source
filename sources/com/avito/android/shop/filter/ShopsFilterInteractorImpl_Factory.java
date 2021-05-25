package com.avito.android.shop.filter;

import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopsFilterInteractorImpl_Factory implements Factory<ShopsFilterInteractorImpl> {
    public final Provider<CategoriesInteractor> a;
    public final Provider<Features> b;
    public final Provider<LocationApi> c;
    public final Provider<TopLocationInteractor> d;
    public final Provider<SchedulersFactory3> e;

    public ShopsFilterInteractorImpl_Factory(Provider<CategoriesInteractor> provider, Provider<Features> provider2, Provider<LocationApi> provider3, Provider<TopLocationInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ShopsFilterInteractorImpl_Factory create(Provider<CategoriesInteractor> provider, Provider<Features> provider2, Provider<LocationApi> provider3, Provider<TopLocationInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        return new ShopsFilterInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ShopsFilterInteractorImpl newInstance(CategoriesInteractor categoriesInteractor, Features features, LocationApi locationApi, TopLocationInteractor topLocationInteractor, SchedulersFactory3 schedulersFactory3) {
        return new ShopsFilterInteractorImpl(categoriesInteractor, features, locationApi, topLocationInteractor, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ShopsFilterInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
