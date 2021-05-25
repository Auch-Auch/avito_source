package com.avito.android.favorite_sellers.adapter.recommendation;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class RecommendationItemPresenterImpl_Factory implements Factory<RecommendationItemPresenterImpl> {
    public final Provider<RecommendationInteractor> a;
    public final Provider<FavoriteSellersRepository> b;
    public final Provider<Observable<FavoriteSellersItemAction>> c;
    public final Provider<NotificationManagerProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<ErrorFormatter> f;
    public final Provider<Analytics> g;
    public final Provider<SubscriptionSource> h;
    public final Provider<CompositeSnackbarPresenter> i;
    public final Provider<Kundle> j;

    public RecommendationItemPresenterImpl_Factory(Provider<RecommendationInteractor> provider, Provider<FavoriteSellersRepository> provider2, Provider<Observable<FavoriteSellersItemAction>> provider3, Provider<NotificationManagerProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorFormatter> provider6, Provider<Analytics> provider7, Provider<SubscriptionSource> provider8, Provider<CompositeSnackbarPresenter> provider9, Provider<Kundle> provider10) {
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
    }

    public static RecommendationItemPresenterImpl_Factory create(Provider<RecommendationInteractor> provider, Provider<FavoriteSellersRepository> provider2, Provider<Observable<FavoriteSellersItemAction>> provider3, Provider<NotificationManagerProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorFormatter> provider6, Provider<Analytics> provider7, Provider<SubscriptionSource> provider8, Provider<CompositeSnackbarPresenter> provider9, Provider<Kundle> provider10) {
        return new RecommendationItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static RecommendationItemPresenterImpl newInstance(RecommendationInteractor recommendationInteractor, FavoriteSellersRepository favoriteSellersRepository, Observable<FavoriteSellersItemAction> observable, NotificationManagerProvider notificationManagerProvider, SchedulersFactory3 schedulersFactory3, ErrorFormatter errorFormatter, Analytics analytics, SubscriptionSource subscriptionSource, CompositeSnackbarPresenter compositeSnackbarPresenter, Kundle kundle) {
        return new RecommendationItemPresenterImpl(recommendationInteractor, favoriteSellersRepository, observable, notificationManagerProvider, schedulersFactory3, errorFormatter, analytics, subscriptionSource, compositeSnackbarPresenter, kundle);
    }

    @Override // javax.inject.Provider
    public RecommendationItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
