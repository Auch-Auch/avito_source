package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ReviewReplyModule_ProvideReviewReplyInteractorFactory implements Factory<ReviewReplyInteractor> {
    public final ReviewReplyModule a;
    public final Provider<RatingApi> b;
    public final Provider<SchedulersFactory3> c;

    public ReviewReplyModule_ProvideReviewReplyInteractorFactory(ReviewReplyModule reviewReplyModule, Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = reviewReplyModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ReviewReplyModule_ProvideReviewReplyInteractorFactory create(ReviewReplyModule reviewReplyModule, Provider<RatingApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ReviewReplyModule_ProvideReviewReplyInteractorFactory(reviewReplyModule, provider, provider2);
    }

    public static ReviewReplyInteractor provideReviewReplyInteractor(ReviewReplyModule reviewReplyModule, RatingApi ratingApi, SchedulersFactory3 schedulersFactory3) {
        return (ReviewReplyInteractor) Preconditions.checkNotNullFromProvides(reviewReplyModule.provideReviewReplyInteractor(ratingApi, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ReviewReplyInteractor get() {
        return provideReviewReplyInteractor(this.a, this.b.get(), this.c.get());
    }
}
