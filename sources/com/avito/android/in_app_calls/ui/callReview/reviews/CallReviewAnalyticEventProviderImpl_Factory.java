package com.avito.android.in_app_calls.ui.callReview.reviews;

import dagger.internal.Factory;
public final class CallReviewAnalyticEventProviderImpl_Factory implements Factory<CallReviewAnalyticEventProviderImpl> {

    public static final class a {
        public static final CallReviewAnalyticEventProviderImpl_Factory a = new CallReviewAnalyticEventProviderImpl_Factory();
    }

    public static CallReviewAnalyticEventProviderImpl_Factory create() {
        return a.a;
    }

    public static CallReviewAnalyticEventProviderImpl newInstance() {
        return new CallReviewAnalyticEventProviderImpl();
    }

    @Override // javax.inject.Provider
    public CallReviewAnalyticEventProviderImpl get() {
        return newInstance();
    }
}
