package com.avito.android.rating.review_details.upload;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReviewReplyInteractorImpl_Factory implements Factory<ReviewReplyInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<SchedulersFactory3> b;

    public ReviewReplyInteractorImpl_Factory(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ReviewReplyInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ReviewReplyInteractorImpl_Factory(provider, provider2);
    }

    public static ReviewReplyInteractorImpl newInstance(RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new ReviewReplyInteractorImpl(ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ReviewReplyInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
