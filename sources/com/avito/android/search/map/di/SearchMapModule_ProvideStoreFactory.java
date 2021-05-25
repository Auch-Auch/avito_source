package com.avito.android.search.map.di;

import com.avito.android.redux.SubscribableStore;
import com.avito.android.search.map.SearchMapFragment;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.middleware.AdvertItemEventMiddleware;
import com.avito.android.search.map.middleware.LoadMiddleware;
import com.avito.android.search.map.middleware.LocationMiddleware;
import com.avito.android.search.map.middleware.LoggingMiddleware;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.search.map.middleware.SubscriptionMiddleware;
import com.avito.android.search.map.reducer.LoadReducer;
import com.avito.android.search.map.reducer.MapReducer;
import com.avito.android.search.map.reducer.PinAdvertsReducer;
import com.avito.android.search.map.reducer.SerpReducer;
import com.avito.android.search.map.reducer.SubscriptionReducer;
import com.avito.android.search.map.reducer.UiReducer;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchMapModule_ProvideStoreFactory implements Factory<SubscribableStore<SearchMapState, ? super MapAction>> {
    public final Provider<LoggingMiddleware> a;
    public final Provider<NavigationMiddleware> b;
    public final Provider<LoadMiddleware> c;
    public final Provider<AdvertItemEventMiddleware> d;
    public final Provider<LocationMiddleware> e;
    public final Provider<SubscriptionMiddleware> f;
    public final Provider<LoadReducer> g;
    public final Provider<SerpReducer> h;
    public final Provider<MapReducer> i;
    public final Provider<PinAdvertsReducer> j;
    public final Provider<UiReducer> k;
    public final Provider<SubscriptionReducer> l;
    public final Provider<SchedulersFactory3> m;
    public final Provider<SerpListResourcesProvider> n;
    public final Provider<SearchMapState> o;
    public final Provider<SearchMapFragment.Factory.Arguments> p;

    public SearchMapModule_ProvideStoreFactory(Provider<LoggingMiddleware> provider, Provider<NavigationMiddleware> provider2, Provider<LoadMiddleware> provider3, Provider<AdvertItemEventMiddleware> provider4, Provider<LocationMiddleware> provider5, Provider<SubscriptionMiddleware> provider6, Provider<LoadReducer> provider7, Provider<SerpReducer> provider8, Provider<MapReducer> provider9, Provider<PinAdvertsReducer> provider10, Provider<UiReducer> provider11, Provider<SubscriptionReducer> provider12, Provider<SchedulersFactory3> provider13, Provider<SerpListResourcesProvider> provider14, Provider<SearchMapState> provider15, Provider<SearchMapFragment.Factory.Arguments> provider16) {
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
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
    }

    public static SearchMapModule_ProvideStoreFactory create(Provider<LoggingMiddleware> provider, Provider<NavigationMiddleware> provider2, Provider<LoadMiddleware> provider3, Provider<AdvertItemEventMiddleware> provider4, Provider<LocationMiddleware> provider5, Provider<SubscriptionMiddleware> provider6, Provider<LoadReducer> provider7, Provider<SerpReducer> provider8, Provider<MapReducer> provider9, Provider<PinAdvertsReducer> provider10, Provider<UiReducer> provider11, Provider<SubscriptionReducer> provider12, Provider<SchedulersFactory3> provider13, Provider<SerpListResourcesProvider> provider14, Provider<SearchMapState> provider15, Provider<SearchMapFragment.Factory.Arguments> provider16) {
        return new SearchMapModule_ProvideStoreFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    public static SubscribableStore<SearchMapState, ? super MapAction> provideStore(LoggingMiddleware loggingMiddleware, NavigationMiddleware navigationMiddleware, LoadMiddleware loadMiddleware, AdvertItemEventMiddleware advertItemEventMiddleware, LocationMiddleware locationMiddleware, SubscriptionMiddleware subscriptionMiddleware, LoadReducer loadReducer, SerpReducer serpReducer, MapReducer mapReducer, PinAdvertsReducer pinAdvertsReducer, UiReducer uiReducer, SubscriptionReducer subscriptionReducer, SchedulersFactory3 schedulersFactory3, SerpListResourcesProvider serpListResourcesProvider, SearchMapState searchMapState, SearchMapFragment.Factory.Arguments arguments) {
        return (SubscribableStore) Preconditions.checkNotNullFromProvides(SearchMapModule.provideStore(loggingMiddleware, navigationMiddleware, loadMiddleware, advertItemEventMiddleware, locationMiddleware, subscriptionMiddleware, loadReducer, serpReducer, mapReducer, pinAdvertsReducer, uiReducer, subscriptionReducer, schedulersFactory3, serpListResourcesProvider, searchMapState, arguments));
    }

    @Override // javax.inject.Provider
    public SubscribableStore<SearchMapState, ? super MapAction> get() {
        return provideStore(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get());
    }
}
