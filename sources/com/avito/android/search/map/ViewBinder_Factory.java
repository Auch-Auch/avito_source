package com.avito.android.search.map;

import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.SerpListViewBinder;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewBinder_Factory implements Factory<ViewBinder> {
    public final Provider<SubscribableStore<SearchMapState, ? super MapAction>> a;
    public final Provider<PinAdvertsListViewBinder> b;
    public final Provider<SerpListViewBinder> c;
    public final Provider<AdvertItemEventListener> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<SavedLocationInteractor> f;

    public ViewBinder_Factory(Provider<SubscribableStore<SearchMapState, ? super MapAction>> provider, Provider<PinAdvertsListViewBinder> provider2, Provider<SerpListViewBinder> provider3, Provider<AdvertItemEventListener> provider4, Provider<SchedulersFactory3> provider5, Provider<SavedLocationInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ViewBinder_Factory create(Provider<SubscribableStore<SearchMapState, ? super MapAction>> provider, Provider<PinAdvertsListViewBinder> provider2, Provider<SerpListViewBinder> provider3, Provider<AdvertItemEventListener> provider4, Provider<SchedulersFactory3> provider5, Provider<SavedLocationInteractor> provider6) {
        return new ViewBinder_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ViewBinder newInstance(SubscribableStore<SearchMapState, ? super MapAction> subscribableStore, PinAdvertsListViewBinder pinAdvertsListViewBinder, SerpListViewBinder serpListViewBinder, AdvertItemEventListener advertItemEventListener, SchedulersFactory3 schedulersFactory3, SavedLocationInteractor savedLocationInteractor) {
        return new ViewBinder(subscribableStore, pinAdvertsListViewBinder, serpListViewBinder, advertItemEventListener, schedulersFactory3, savedLocationInteractor);
    }

    @Override // javax.inject.Provider
    public ViewBinder get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
