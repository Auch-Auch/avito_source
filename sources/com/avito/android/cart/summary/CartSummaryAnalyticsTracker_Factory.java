package com.avito.android.cart.summary;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CartSummaryAnalyticsTracker_Factory implements Factory<CartSummaryAnalyticsTracker> {
    public final Provider<Analytics> a;

    public CartSummaryAnalyticsTracker_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static CartSummaryAnalyticsTracker_Factory create(Provider<Analytics> provider) {
        return new CartSummaryAnalyticsTracker_Factory(provider);
    }

    public static CartSummaryAnalyticsTracker newInstance(Analytics analytics) {
        return new CartSummaryAnalyticsTracker(analytics);
    }

    @Override // javax.inject.Provider
    public CartSummaryAnalyticsTracker get() {
        return newInstance(this.a.get());
    }
}
