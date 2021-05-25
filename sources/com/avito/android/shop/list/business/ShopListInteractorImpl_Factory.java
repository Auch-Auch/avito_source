package com.avito.android.shop.list.business;

import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopListInteractorImpl_Factory implements Factory<ShopListInteractorImpl> {
    public final Provider<ShopsApi> a;
    public final Provider<LocationApi> b;
    public final Provider<SavedLocationInteractor> c;
    public final Provider<ShopSearchParamsConverter> d;
    public final Provider<ShopListResultConverter> e;
    public final Provider<TypedErrorThrowableConverter> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<Kundle> h;

    public ShopListInteractorImpl_Factory(Provider<ShopsApi> provider, Provider<LocationApi> provider2, Provider<SavedLocationInteractor> provider3, Provider<ShopSearchParamsConverter> provider4, Provider<ShopListResultConverter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ShopListInteractorImpl_Factory create(Provider<ShopsApi> provider, Provider<LocationApi> provider2, Provider<SavedLocationInteractor> provider3, Provider<ShopSearchParamsConverter> provider4, Provider<ShopListResultConverter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<SchedulersFactory3> provider7, Provider<Kundle> provider8) {
        return new ShopListInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ShopListInteractorImpl newInstance(ShopsApi shopsApi, LocationApi locationApi, SavedLocationInteractor savedLocationInteractor, ShopSearchParamsConverter shopSearchParamsConverter, ShopListResultConverter shopListResultConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3, Kundle kundle) {
        return new ShopListInteractorImpl(shopsApi, locationApi, savedLocationInteractor, shopSearchParamsConverter, shopListResultConverter, typedErrorThrowableConverter, schedulersFactory3, kundle);
    }

    @Override // javax.inject.Provider
    public ShopListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
