package com.avito.android.basket_legacy.ui;

import com.avito.android.analytics.Analytics;
import com.avito.android.basket_legacy.LegacyPaidServicesTracker;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BasketActivity_MembersInjector implements MembersInjector<BasketActivity> {
    public final Provider<BasketViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<SharedBasketViewModelFactory> c;
    public final Provider<LegacyPaidServicesTracker> d;

    public BasketActivity_MembersInjector(Provider<BasketViewModel> provider, Provider<Analytics> provider2, Provider<SharedBasketViewModelFactory> provider3, Provider<LegacyPaidServicesTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<BasketActivity> create(Provider<BasketViewModel> provider, Provider<Analytics> provider2, Provider<SharedBasketViewModelFactory> provider3, Provider<LegacyPaidServicesTracker> provider4) {
        return new BasketActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.BasketActivity.analytics")
    public static void injectAnalytics(BasketActivity basketActivity, Analytics analytics) {
        basketActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.BasketActivity.factory")
    public static void injectFactory(BasketActivity basketActivity, SharedBasketViewModelFactory sharedBasketViewModelFactory) {
        basketActivity.factory = sharedBasketViewModelFactory;
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.BasketActivity.tracker")
    public static void injectTracker(BasketActivity basketActivity, LegacyPaidServicesTracker legacyPaidServicesTracker) {
        basketActivity.tracker = legacyPaidServicesTracker;
    }

    @InjectedFieldSignature("com.avito.android.basket_legacy.ui.BasketActivity.viewModelProvider")
    public static void injectViewModelProvider(BasketActivity basketActivity, Lazy<BasketViewModel> lazy) {
        basketActivity.viewModelProvider = lazy;
    }

    public void injectMembers(BasketActivity basketActivity) {
        injectViewModelProvider(basketActivity, DoubleCheck.lazy(this.a));
        injectAnalytics(basketActivity, this.b.get());
        injectFactory(basketActivity, this.c.get());
        injectTracker(basketActivity, this.d.get());
    }
}
