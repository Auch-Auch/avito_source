package com.avito.android.user_adverts.tab_screens;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import com.avito.android.user_adverts.tracker.UserAdvertsListTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.Observable;
import java.util.Set;
import javax.inject.Provider;
public final class UserAdvertsListPresenterImpl_Factory implements Factory<UserAdvertsListPresenterImpl> {
    public final Provider<String> a;
    public final Provider<UserAdvertsListInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<UserItemConverter> e;
    public final Provider<FloatingViewsPresenter> f;
    public final Provider<UserAdvertsHostPresenter> g;
    public final Provider<UserAdvertsCountUpdater> h;
    public final Provider<UserAdvertsListTracker> i;
    public final Provider<Kundle> j;
    public final Provider<Set<DeeplinkClickStreamProvider>> k;
    public final Provider<Analytics> l;
    public final Provider<Observable<UserAdvertItemAction>> m;
    public final Provider<LinkedInfoBannerPresenter> n;

    public UserAdvertsListPresenterImpl_Factory(Provider<String> provider, Provider<UserAdvertsListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<UserItemConverter> provider5, Provider<FloatingViewsPresenter> provider6, Provider<UserAdvertsHostPresenter> provider7, Provider<UserAdvertsCountUpdater> provider8, Provider<UserAdvertsListTracker> provider9, Provider<Kundle> provider10, Provider<Set<DeeplinkClickStreamProvider>> provider11, Provider<Analytics> provider12, Provider<Observable<UserAdvertItemAction>> provider13, Provider<LinkedInfoBannerPresenter> provider14) {
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
    }

    public static UserAdvertsListPresenterImpl_Factory create(Provider<String> provider, Provider<UserAdvertsListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<AdapterPresenter> provider4, Provider<UserItemConverter> provider5, Provider<FloatingViewsPresenter> provider6, Provider<UserAdvertsHostPresenter> provider7, Provider<UserAdvertsCountUpdater> provider8, Provider<UserAdvertsListTracker> provider9, Provider<Kundle> provider10, Provider<Set<DeeplinkClickStreamProvider>> provider11, Provider<Analytics> provider12, Provider<Observable<UserAdvertItemAction>> provider13, Provider<LinkedInfoBannerPresenter> provider14) {
        return new UserAdvertsListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static UserAdvertsListPresenterImpl newInstance(String str, UserAdvertsListInteractor userAdvertsListInteractor, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, UserItemConverter userItemConverter, FloatingViewsPresenter floatingViewsPresenter, UserAdvertsHostPresenter userAdvertsHostPresenter, UserAdvertsCountUpdater userAdvertsCountUpdater, UserAdvertsListTracker userAdvertsListTracker, Kundle kundle, Set<DeeplinkClickStreamProvider> set, Analytics analytics, Observable<UserAdvertItemAction> observable, LinkedInfoBannerPresenter linkedInfoBannerPresenter) {
        return new UserAdvertsListPresenterImpl(str, userAdvertsListInteractor, schedulersFactory, adapterPresenter, userItemConverter, floatingViewsPresenter, userAdvertsHostPresenter, userAdvertsCountUpdater, userAdvertsListTracker, kundle, set, analytics, observable, linkedInfoBannerPresenter);
    }

    @Override // javax.inject.Provider
    public UserAdvertsListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get());
    }
}
