package com.avito.android.in_app_calls.ui.callReview;

import com.avito.android.analytics.Analytics;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReview;
import com.avito.android.in_app_calls.ui.callReview.reviews.CallReviewAnalyticEventProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallReviewPresenterImpl_Factory implements Factory<CallReviewPresenterImpl> {
    public final Provider<Analytics> a;
    public final Provider<CallReview> b;
    public final Provider<CallReviewAnalyticEventProvider> c;
    public final Provider<SchedulersFactory> d;

    public CallReviewPresenterImpl_Factory(Provider<Analytics> provider, Provider<CallReview> provider2, Provider<CallReviewAnalyticEventProvider> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CallReviewPresenterImpl_Factory create(Provider<Analytics> provider, Provider<CallReview> provider2, Provider<CallReviewAnalyticEventProvider> provider3, Provider<SchedulersFactory> provider4) {
        return new CallReviewPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CallReviewPresenterImpl newInstance(Analytics analytics, CallReview callReview, CallReviewAnalyticEventProvider callReviewAnalyticEventProvider, SchedulersFactory schedulersFactory) {
        return new CallReviewPresenterImpl(analytics, callReview, callReviewAnalyticEventProvider, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CallReviewPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
