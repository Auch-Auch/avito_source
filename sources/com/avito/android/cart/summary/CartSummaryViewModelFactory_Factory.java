package com.avito.android.cart.summary;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
import kotlin.Pair;
public final class CartSummaryViewModelFactory_Factory implements Factory<CartSummaryViewModelFactory> {
    public final Provider<CartSummaryAnalyticsTracker> a;
    public final Provider<CartSummaryRepository> b;
    public final Provider<CartSummaryItemsConverter> c;
    public final Provider<CartSummaryResourceProvider> d;
    public final Provider<AccountStateProvider> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<Observable<Pair<ProductItem, Integer>>> h;
    public final Provider<Observable<ProductItem>> i;
    public final Provider<Observable<String>> j;
    public final Provider<Observable<Pair<ProductItem, StepperUsageType>>> k;
    public final Provider<BaseScreenPerformanceTracker> l;

    public CartSummaryViewModelFactory_Factory(Provider<CartSummaryAnalyticsTracker> provider, Provider<CartSummaryRepository> provider2, Provider<CartSummaryItemsConverter> provider3, Provider<CartSummaryResourceProvider> provider4, Provider<AccountStateProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<ActivityIntentFactory> provider7, Provider<Observable<Pair<ProductItem, Integer>>> provider8, Provider<Observable<ProductItem>> provider9, Provider<Observable<String>> provider10, Provider<Observable<Pair<ProductItem, StepperUsageType>>> provider11, Provider<BaseScreenPerformanceTracker> provider12) {
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
    }

    public static CartSummaryViewModelFactory_Factory create(Provider<CartSummaryAnalyticsTracker> provider, Provider<CartSummaryRepository> provider2, Provider<CartSummaryItemsConverter> provider3, Provider<CartSummaryResourceProvider> provider4, Provider<AccountStateProvider> provider5, Provider<SchedulersFactory3> provider6, Provider<ActivityIntentFactory> provider7, Provider<Observable<Pair<ProductItem, Integer>>> provider8, Provider<Observable<ProductItem>> provider9, Provider<Observable<String>> provider10, Provider<Observable<Pair<ProductItem, StepperUsageType>>> provider11, Provider<BaseScreenPerformanceTracker> provider12) {
        return new CartSummaryViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static CartSummaryViewModelFactory newInstance(CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker, CartSummaryRepository cartSummaryRepository, CartSummaryItemsConverter cartSummaryItemsConverter, CartSummaryResourceProvider cartSummaryResourceProvider, AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3, ActivityIntentFactory activityIntentFactory, Observable<Pair<ProductItem, Integer>> observable, Observable<ProductItem> observable2, Observable<String> observable3, Observable<Pair<ProductItem, StepperUsageType>> observable4, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new CartSummaryViewModelFactory(cartSummaryAnalyticsTracker, cartSummaryRepository, cartSummaryItemsConverter, cartSummaryResourceProvider, accountStateProvider, schedulersFactory3, activityIntentFactory, observable, observable2, observable3, observable4, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public CartSummaryViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
