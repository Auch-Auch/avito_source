package com.avito.android.public_profile.di;

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
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileFragmentModule_ProvideSubscriptionsPresenterFactory implements Factory<SubscriptionsPresenter> {
    public final Provider<NotificationManagerProvider> a;
    public final Provider<FavoriteSellersRepository> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<SubscriptionsResourceProvider> d;
    public final Provider<SubscribeInteractor> e;
    public final Provider<ErrorHelper> f;
    public final Provider<Analytics> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<Kundle> i;
    public final Provider<CompositeSnackbarPresenter> j;
    public final Provider<Features> k;

    public PublicProfileFragmentModule_ProvideSubscriptionsPresenterFactory(Provider<NotificationManagerProvider> provider, Provider<FavoriteSellersRepository> provider2, Provider<AccountStateProvider> provider3, Provider<SubscriptionsResourceProvider> provider4, Provider<SubscribeInteractor> provider5, Provider<ErrorHelper> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory3> provider8, Provider<Kundle> provider9, Provider<CompositeSnackbarPresenter> provider10, Provider<Features> provider11) {
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
    }

    public static PublicProfileFragmentModule_ProvideSubscriptionsPresenterFactory create(Provider<NotificationManagerProvider> provider, Provider<FavoriteSellersRepository> provider2, Provider<AccountStateProvider> provider3, Provider<SubscriptionsResourceProvider> provider4, Provider<SubscribeInteractor> provider5, Provider<ErrorHelper> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory3> provider8, Provider<Kundle> provider9, Provider<CompositeSnackbarPresenter> provider10, Provider<Features> provider11) {
        return new PublicProfileFragmentModule_ProvideSubscriptionsPresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SubscriptionsPresenter provideSubscriptionsPresenter(NotificationManagerProvider notificationManagerProvider, FavoriteSellersRepository favoriteSellersRepository, AccountStateProvider accountStateProvider, SubscriptionsResourceProvider subscriptionsResourceProvider, SubscribeInteractor subscribeInteractor, ErrorHelper errorHelper, Analytics analytics, SchedulersFactory3 schedulersFactory3, Kundle kundle, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features) {
        return (SubscriptionsPresenter) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.provideSubscriptionsPresenter(notificationManagerProvider, favoriteSellersRepository, accountStateProvider, subscriptionsResourceProvider, subscribeInteractor, errorHelper, analytics, schedulersFactory3, kundle, compositeSnackbarPresenter, features));
    }

    @Override // javax.inject.Provider
    public SubscriptionsPresenter get() {
        return provideSubscriptionsPresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
