package com.avito.android.brandspace.presenter;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.interactor.BrandspaceInteractor;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspacePresenterImpl_Factory implements Factory<BrandspacePresenterImpl> {
    public final Provider<BrandspaceItemBuilder> a;
    public final Provider<BrandspaceInteractor> b;
    public final Provider<BrandspaceAnalyticsInteractor> c;
    public final Provider<BrandspaceTracker> d;
    public final Provider<FavoriteAdvertsPresenter> e;
    public final Provider<TypedErrorThrowableConverter> f;
    public final Provider<BrandspaceResourcesProvider> g;
    public final Provider<SchedulersFactory3> h;

    public BrandspacePresenterImpl_Factory(Provider<BrandspaceItemBuilder> provider, Provider<BrandspaceInteractor> provider2, Provider<BrandspaceAnalyticsInteractor> provider3, Provider<BrandspaceTracker> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<BrandspaceResourcesProvider> provider7, Provider<SchedulersFactory3> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static BrandspacePresenterImpl_Factory create(Provider<BrandspaceItemBuilder> provider, Provider<BrandspaceInteractor> provider2, Provider<BrandspaceAnalyticsInteractor> provider3, Provider<BrandspaceTracker> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<TypedErrorThrowableConverter> provider6, Provider<BrandspaceResourcesProvider> provider7, Provider<SchedulersFactory3> provider8) {
        return new BrandspacePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static BrandspacePresenterImpl newInstance(BrandspaceItemBuilder brandspaceItemBuilder, BrandspaceInteractor brandspaceInteractor, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor, BrandspaceTracker brandspaceTracker, FavoriteAdvertsPresenter favoriteAdvertsPresenter, TypedErrorThrowableConverter typedErrorThrowableConverter, BrandspaceResourcesProvider brandspaceResourcesProvider, SchedulersFactory3 schedulersFactory3) {
        return new BrandspacePresenterImpl(brandspaceItemBuilder, brandspaceInteractor, brandspaceAnalyticsInteractor, brandspaceTracker, favoriteAdvertsPresenter, typedErrorThrowableConverter, brandspaceResourcesProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public BrandspacePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
