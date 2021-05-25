package com.avito.android.advert.item.sellersubscription;

import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class SellerSubscriptionPresenterImpl_Factory implements Factory<SellerSubscriptionPresenterImpl> {
    public final Provider<SellerSubscriptionInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<NotificationManagerProvider> c;
    public final Provider<SellerSubscriptionResourceProvider> d;
    public final Provider<Formatter<Throwable>> e;
    public final Provider<Observable<SellerSubscriptionAction>> f;
    public final Provider<CompositeSnackbarPresenter> g;
    public final Provider<Analytics> h;

    public SellerSubscriptionPresenterImpl_Factory(Provider<SellerSubscriptionInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<NotificationManagerProvider> provider3, Provider<SellerSubscriptionResourceProvider> provider4, Provider<Formatter<Throwable>> provider5, Provider<Observable<SellerSubscriptionAction>> provider6, Provider<CompositeSnackbarPresenter> provider7, Provider<Analytics> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static SellerSubscriptionPresenterImpl_Factory create(Provider<SellerSubscriptionInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<NotificationManagerProvider> provider3, Provider<SellerSubscriptionResourceProvider> provider4, Provider<Formatter<Throwable>> provider5, Provider<Observable<SellerSubscriptionAction>> provider6, Provider<CompositeSnackbarPresenter> provider7, Provider<Analytics> provider8) {
        return new SellerSubscriptionPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static SellerSubscriptionPresenterImpl newInstance(SellerSubscriptionInteractor sellerSubscriptionInteractor, SchedulersFactory3 schedulersFactory3, NotificationManagerProvider notificationManagerProvider, SellerSubscriptionResourceProvider sellerSubscriptionResourceProvider, Formatter<Throwable> formatter, Observable<SellerSubscriptionAction> observable, CompositeSnackbarPresenter compositeSnackbarPresenter, Analytics analytics) {
        return new SellerSubscriptionPresenterImpl(sellerSubscriptionInteractor, schedulersFactory3, notificationManagerProvider, sellerSubscriptionResourceProvider, formatter, observable, compositeSnackbarPresenter, analytics);
    }

    @Override // javax.inject.Provider
    public SellerSubscriptionPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
