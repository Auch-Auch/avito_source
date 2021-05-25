package com.avito.android.rating.user_reviews;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserReviewsInteractorImpl_Factory implements Factory<UserReviewsInteractorImpl> {
    public final Provider<RatingApi> a;
    public final Provider<SchedulersFactory3> b;

    public UserReviewsInteractorImpl_Factory(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserReviewsInteractorImpl_Factory create(Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        return new UserReviewsInteractorImpl_Factory(provider, provider2);
    }

    public static UserReviewsInteractorImpl newInstance(RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return new UserReviewsInteractorImpl(ratingApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public UserReviewsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
