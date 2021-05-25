package com.avito.android.notification_center.landing.unified;

import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingUnifiedPresenterImpl_Factory implements Factory<NotificationCenterLandingUnifiedPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Analytics> c;
    public final Provider<NotificationCenterLandingUnifiedInteractor> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<NotificationsCenterLandingUnifiedConverter> f;
    public final Provider<Relay<UnifiedAdvertItem>> g;
    public final Provider<Relay<FavorableItem>> h;
    public final Provider<Relay<UnifiedButtonItem>> i;
    public final Provider<Relay<UnifiedPairButtonItem>> j;
    public final Provider<Relay<UnifiedPairButtonItem>> k;
    public final Provider<Relay<UnifiedSubtitleItem>> l;
    public final Provider<FavoriteAdvertsPresenter> m;
    public final Provider<ViewedAdvertsPresenter> n;
    public final Provider<Kundle> o;

    public NotificationCenterLandingUnifiedPresenterImpl_Factory(Provider<String> provider, Provider<AdapterPresenter> provider2, Provider<Analytics> provider3, Provider<NotificationCenterLandingUnifiedInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<NotificationsCenterLandingUnifiedConverter> provider6, Provider<Relay<UnifiedAdvertItem>> provider7, Provider<Relay<FavorableItem>> provider8, Provider<Relay<UnifiedButtonItem>> provider9, Provider<Relay<UnifiedPairButtonItem>> provider10, Provider<Relay<UnifiedPairButtonItem>> provider11, Provider<Relay<UnifiedSubtitleItem>> provider12, Provider<FavoriteAdvertsPresenter> provider13, Provider<ViewedAdvertsPresenter> provider14, Provider<Kundle> provider15) {
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
    }

    public static NotificationCenterLandingUnifiedPresenterImpl_Factory create(Provider<String> provider, Provider<AdapterPresenter> provider2, Provider<Analytics> provider3, Provider<NotificationCenterLandingUnifiedInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<NotificationsCenterLandingUnifiedConverter> provider6, Provider<Relay<UnifiedAdvertItem>> provider7, Provider<Relay<FavorableItem>> provider8, Provider<Relay<UnifiedButtonItem>> provider9, Provider<Relay<UnifiedPairButtonItem>> provider10, Provider<Relay<UnifiedPairButtonItem>> provider11, Provider<Relay<UnifiedSubtitleItem>> provider12, Provider<FavoriteAdvertsPresenter> provider13, Provider<ViewedAdvertsPresenter> provider14, Provider<Kundle> provider15) {
        return new NotificationCenterLandingUnifiedPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static NotificationCenterLandingUnifiedPresenterImpl newInstance(String str, AdapterPresenter adapterPresenter, Analytics analytics, NotificationCenterLandingUnifiedInteractor notificationCenterLandingUnifiedInteractor, SchedulersFactory schedulersFactory, NotificationsCenterLandingUnifiedConverter notificationsCenterLandingUnifiedConverter, Relay<UnifiedAdvertItem> relay, Relay<FavorableItem> relay2, Relay<UnifiedButtonItem> relay3, Relay<UnifiedPairButtonItem> relay4, Relay<UnifiedPairButtonItem> relay5, Relay<UnifiedSubtitleItem> relay6, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, Kundle kundle) {
        return new NotificationCenterLandingUnifiedPresenterImpl(str, adapterPresenter, analytics, notificationCenterLandingUnifiedInteractor, schedulersFactory, notificationsCenterLandingUnifiedConverter, relay, relay2, relay3, relay4, relay5, relay6, favoriteAdvertsPresenter, viewedAdvertsPresenter, kundle);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingUnifiedPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get());
    }
}
