package com.avito.android.shop.detailed.di;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopDetailedModule_ProvideSubscriptionsPresenterImplFactory implements Factory<SubscriptionsPresenter> {
    public final ShopDetailedModule a;
    public final Provider<ShopDetailedPresenter> b;
    public final Provider<NotificationManagerProvider> c;
    public final Provider<FavoriteSellersRepository> d;
    public final Provider<AccountStateProvider> e;
    public final Provider<SubscriptionsResourceProvider> f;
    public final Provider<SubscribeInteractor> g;
    public final Provider<ErrorHelper> h;
    public final Provider<Analytics> i;
    public final Provider<SchedulersFactory3> j;
    public final Provider<CompositeSnackbarPresenter> k;
    public final Provider<Features> l;

    public ShopDetailedModule_ProvideSubscriptionsPresenterImplFactory(ShopDetailedModule shopDetailedModule, Provider<ShopDetailedPresenter> provider, Provider<NotificationManagerProvider> provider2, Provider<FavoriteSellersRepository> provider3, Provider<AccountStateProvider> provider4, Provider<SubscriptionsResourceProvider> provider5, Provider<SubscribeInteractor> provider6, Provider<ErrorHelper> provider7, Provider<Analytics> provider8, Provider<SchedulersFactory3> provider9, Provider<CompositeSnackbarPresenter> provider10, Provider<Features> provider11) {
        this.a = shopDetailedModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
    }

    public static ShopDetailedModule_ProvideSubscriptionsPresenterImplFactory create(ShopDetailedModule shopDetailedModule, Provider<ShopDetailedPresenter> provider, Provider<NotificationManagerProvider> provider2, Provider<FavoriteSellersRepository> provider3, Provider<AccountStateProvider> provider4, Provider<SubscriptionsResourceProvider> provider5, Provider<SubscribeInteractor> provider6, Provider<ErrorHelper> provider7, Provider<Analytics> provider8, Provider<SchedulersFactory3> provider9, Provider<CompositeSnackbarPresenter> provider10, Provider<Features> provider11) {
        return new ShopDetailedModule_ProvideSubscriptionsPresenterImplFactory(shopDetailedModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SubscriptionsPresenter provideSubscriptionsPresenterImpl(ShopDetailedModule shopDetailedModule, Lazy<ShopDetailedPresenter> lazy, NotificationManagerProvider notificationManagerProvider, FavoriteSellersRepository favoriteSellersRepository, AccountStateProvider accountStateProvider, SubscriptionsResourceProvider subscriptionsResourceProvider, SubscribeInteractor subscribeInteractor, ErrorHelper errorHelper, Analytics analytics, SchedulersFactory3 schedulersFactory3, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features) {
        return (SubscriptionsPresenter) Preconditions.checkNotNullFromProvides(shopDetailedModule.provideSubscriptionsPresenterImpl(lazy, notificationManagerProvider, favoriteSellersRepository, accountStateProvider, subscriptionsResourceProvider, subscribeInteractor, errorHelper, analytics, schedulersFactory3, compositeSnackbarPresenter, features));
    }

    @Override // javax.inject.Provider
    public SubscriptionsPresenter get() {
        return provideSubscriptionsPresenterImpl(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
