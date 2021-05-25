package com.avito.android.rating.user_reviews.di;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserReviewsModule_ProvideRatingDetailsItemStream$rating_releaseFactory implements Factory<PublishRelay<RatingDetailsItem>> {

    public static final class a {
        public static final UserReviewsModule_ProvideRatingDetailsItemStream$rating_releaseFactory a = new UserReviewsModule_ProvideRatingDetailsItemStream$rating_releaseFactory();
    }

    public static UserReviewsModule_ProvideRatingDetailsItemStream$rating_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<RatingDetailsItem> provideRatingDetailsItemStream$rating_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(UserReviewsModule.provideRatingDetailsItemStream$rating_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<RatingDetailsItem> get() {
        return provideRatingDetailsItemStream$rating_release();
    }
}
