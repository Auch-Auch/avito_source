package com.avito.android.shop.list.presentation;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopListPresenterImpl_Factory implements Factory<ShopListPresenterImpl> {
    public final Provider<ShopListTracker> a;
    public final Provider<ShopListInteractor> b;
    public final Provider<ShopListConverter> c;
    public final Provider<ShopListDataChangeListener> d;
    public final Provider<PersistableFloatingViewsPresenter> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<ShortcutNavigationItemConverter> g;
    public final Provider<Analytics> h;
    public final Provider<Features> i;
    public final Provider<ShopsSearchParameters> j;
    public final Provider<String> k;
    public final Provider<Kundle> l;

    public ShopListPresenterImpl_Factory(Provider<ShopListTracker> provider, Provider<ShopListInteractor> provider2, Provider<ShopListConverter> provider3, Provider<ShopListDataChangeListener> provider4, Provider<PersistableFloatingViewsPresenter> provider5, Provider<SchedulersFactory3> provider6, Provider<ShortcutNavigationItemConverter> provider7, Provider<Analytics> provider8, Provider<Features> provider9, Provider<ShopsSearchParameters> provider10, Provider<String> provider11, Provider<Kundle> provider12) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
    }

    public static ShopListPresenterImpl_Factory create(Provider<ShopListTracker> provider, Provider<ShopListInteractor> provider2, Provider<ShopListConverter> provider3, Provider<ShopListDataChangeListener> provider4, Provider<PersistableFloatingViewsPresenter> provider5, Provider<SchedulersFactory3> provider6, Provider<ShortcutNavigationItemConverter> provider7, Provider<Analytics> provider8, Provider<Features> provider9, Provider<ShopsSearchParameters> provider10, Provider<String> provider11, Provider<Kundle> provider12) {
        return new ShopListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static ShopListPresenterImpl newInstance(ShopListTracker shopListTracker, ShopListInteractor shopListInteractor, ShopListConverter shopListConverter, ShopListDataChangeListener shopListDataChangeListener, PersistableFloatingViewsPresenter persistableFloatingViewsPresenter, SchedulersFactory3 schedulersFactory3, ShortcutNavigationItemConverter shortcutNavigationItemConverter, Analytics analytics, Features features, ShopsSearchParameters shopsSearchParameters, String str, Kundle kundle) {
        return new ShopListPresenterImpl(shopListTracker, shopListInteractor, shopListConverter, shopListDataChangeListener, persistableFloatingViewsPresenter, schedulersFactory3, shortcutNavigationItemConverter, analytics, features, shopsSearchParameters, str, kundle);
    }

    @Override // javax.inject.Provider
    public ShopListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
