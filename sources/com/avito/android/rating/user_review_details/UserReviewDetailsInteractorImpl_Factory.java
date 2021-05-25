package com.avito.android.rating.user_review_details;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserReviewDetailsInteractorImpl_Factory implements Factory<UserReviewDetailsInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<SchedulersFactory3> b;

    public UserReviewDetailsInteractorImpl_Factory(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserReviewDetailsInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        return new UserReviewDetailsInteractorImpl_Factory(provider, provider2);
    }

    public static UserReviewDetailsInteractorImpl newInstance(RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new UserReviewDetailsInteractorImpl(ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public UserReviewDetailsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
