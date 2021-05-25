package com.avito.android.notification_center.landing.recommends;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsPresenterImpl_Factory implements Factory<NotificationCenterLandingRecommendsPresenterImpl> {
    public final Provider<String> a;
    public final Provider<NotificationCenterLandingRecommendsConverter> b;
    public final Provider<NotificationCenterLandingRecommendsInteractor> c;
    public final Provider<Relay<Integer>> d;
    public final Provider<Relay<FavorableItem>> e;
    public final Provider<Relay<Integer>> f;
    public final Provider<Relay<Integer>> g;
    public final Provider<AdapterPresenter> h;
    public final Provider<Analytics> i;
    public final Provider<FavoriteAdvertsPresenter> j;
    public final Provider<ViewedAdvertsPresenter> k;
    public final Provider<SchedulersFactory> l;
    public final Provider<Kundle> m;

    public NotificationCenterLandingRecommendsPresenterImpl_Factory(Provider<String> provider, Provider<NotificationCenterLandingRecommendsConverter> provider2, Provider<NotificationCenterLandingRecommendsInteractor> provider3, Provider<Relay<Integer>> provider4, Provider<Relay<FavorableItem>> provider5, Provider<Relay<Integer>> provider6, Provider<Relay<Integer>> provider7, Provider<AdapterPresenter> provider8, Provider<Analytics> provider9, Provider<FavoriteAdvertsPresenter> provider10, Provider<ViewedAdvertsPresenter> provider11, Provider<SchedulersFactory> provider12, Provider<Kundle> provider13) {
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
    }

    public static NotificationCenterLandingRecommendsPresenterImpl_Factory create(Provider<String> provider, Provider<NotificationCenterLandingRecommendsConverter> provider2, Provider<NotificationCenterLandingRecommendsInteractor> provider3, Provider<Relay<Integer>> provider4, Provider<Relay<FavorableItem>> provider5, Provider<Relay<Integer>> provider6, Provider<Relay<Integer>> provider7, Provider<AdapterPresenter> provider8, Provider<Analytics> provider9, Provider<FavoriteAdvertsPresenter> provider10, Provider<ViewedAdvertsPresenter> provider11, Provider<SchedulersFactory> provider12, Provider<Kundle> provider13) {
        return new NotificationCenterLandingRecommendsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static NotificationCenterLandingRecommendsPresenterImpl newInstance(String str, NotificationCenterLandingRecommendsConverter notificationCenterLandingRecommendsConverter, NotificationCenterLandingRecommendsInteractor notificationCenterLandingRecommendsInteractor, Relay<Integer> relay, Relay<FavorableItem> relay2, Relay<Integer> relay3, Relay<Integer> relay4, AdapterPresenter adapterPresenter, Analytics analytics, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new NotificationCenterLandingRecommendsPresenterImpl(str, notificationCenterLandingRecommendsConverter, notificationCenterLandingRecommendsInteractor, relay, relay2, relay3, relay4, adapterPresenter, analytics, favoriteAdvertsPresenter, viewedAdvertsPresenter, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
