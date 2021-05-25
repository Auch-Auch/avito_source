package com.avito.android.favorite_sellers;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class FavoriteSellersPresenterImpl_Factory implements Factory<FavoriteSellersPresenterImpl> {
    public final Provider<FavoriteSellersInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Observable<FavoriteSellersItemAction>> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<FavoriteSellersResourceProvider> e;
    public final Provider<NotificationManagerProvider> f;
    public final Provider<FavoriteSellersConverter> g;
    public final Provider<FavoriteSellerAdvertsStatusProcessor> h;
    public final Provider<AccountStateProvider> i;
    public final Provider<DialogPresenter> j;
    public final Provider<ErrorHelper> k;
    public final Provider<ScreenTracker> l;
    public final Provider<ScreenModeButtons> m;
    public final Provider<Analytics> n;
    public final Provider<TabOpenAnalytics> o;
    public final Provider<ContentTracker> p;
    public final Provider<FavoriteAdvertsPresenter> q;
    public final Provider<Kundle> r;
    public final Provider<ConnectivityProvider> s;
    public final Provider<Observable<NotificationSettingsChangeEvent>> t;
    public final Provider<CompositeSnackbarPresenter> u;
    public final Provider<Features> v;

    public FavoriteSellersPresenterImpl_Factory(Provider<FavoriteSellersInteractor> provider, Provider<AdapterPresenter> provider2, Provider<Observable<FavoriteSellersItemAction>> provider3, Provider<SchedulersFactory3> provider4, Provider<FavoriteSellersResourceProvider> provider5, Provider<NotificationManagerProvider> provider6, Provider<FavoriteSellersConverter> provider7, Provider<FavoriteSellerAdvertsStatusProcessor> provider8, Provider<AccountStateProvider> provider9, Provider<DialogPresenter> provider10, Provider<ErrorHelper> provider11, Provider<ScreenTracker> provider12, Provider<ScreenModeButtons> provider13, Provider<Analytics> provider14, Provider<TabOpenAnalytics> provider15, Provider<ContentTracker> provider16, Provider<FavoriteAdvertsPresenter> provider17, Provider<Kundle> provider18, Provider<ConnectivityProvider> provider19, Provider<Observable<NotificationSettingsChangeEvent>> provider20, Provider<CompositeSnackbarPresenter> provider21, Provider<Features> provider22) {
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
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
    }

    public static FavoriteSellersPresenterImpl_Factory create(Provider<FavoriteSellersInteractor> provider, Provider<AdapterPresenter> provider2, Provider<Observable<FavoriteSellersItemAction>> provider3, Provider<SchedulersFactory3> provider4, Provider<FavoriteSellersResourceProvider> provider5, Provider<NotificationManagerProvider> provider6, Provider<FavoriteSellersConverter> provider7, Provider<FavoriteSellerAdvertsStatusProcessor> provider8, Provider<AccountStateProvider> provider9, Provider<DialogPresenter> provider10, Provider<ErrorHelper> provider11, Provider<ScreenTracker> provider12, Provider<ScreenModeButtons> provider13, Provider<Analytics> provider14, Provider<TabOpenAnalytics> provider15, Provider<ContentTracker> provider16, Provider<FavoriteAdvertsPresenter> provider17, Provider<Kundle> provider18, Provider<ConnectivityProvider> provider19, Provider<Observable<NotificationSettingsChangeEvent>> provider20, Provider<CompositeSnackbarPresenter> provider21, Provider<Features> provider22) {
        return new FavoriteSellersPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22);
    }

    public static FavoriteSellersPresenterImpl newInstance(FavoriteSellersInteractor favoriteSellersInteractor, AdapterPresenter adapterPresenter, Observable<FavoriteSellersItemAction> observable, SchedulersFactory3 schedulersFactory3, FavoriteSellersResourceProvider favoriteSellersResourceProvider, NotificationManagerProvider notificationManagerProvider, FavoriteSellersConverter favoriteSellersConverter, FavoriteSellerAdvertsStatusProcessor favoriteSellerAdvertsStatusProcessor, AccountStateProvider accountStateProvider, DialogPresenter dialogPresenter, ErrorHelper errorHelper, ScreenTracker screenTracker, ScreenModeButtons screenModeButtons, Analytics analytics, TabOpenAnalytics tabOpenAnalytics, ContentTracker contentTracker, FavoriteAdvertsPresenter favoriteAdvertsPresenter, Kundle kundle, ConnectivityProvider connectivityProvider, Observable<NotificationSettingsChangeEvent> observable2, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features) {
        return new FavoriteSellersPresenterImpl(favoriteSellersInteractor, adapterPresenter, observable, schedulersFactory3, favoriteSellersResourceProvider, notificationManagerProvider, favoriteSellersConverter, favoriteSellerAdvertsStatusProcessor, accountStateProvider, dialogPresenter, errorHelper, screenTracker, screenModeButtons, analytics, tabOpenAnalytics, contentTracker, favoriteAdvertsPresenter, kundle, connectivityProvider, observable2, compositeSnackbarPresenter, features);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get());
    }
}
