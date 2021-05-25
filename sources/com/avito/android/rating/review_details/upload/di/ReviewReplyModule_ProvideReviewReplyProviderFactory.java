package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.review_details.upload.ReplyUploadPresenterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ReviewReplyModule_ProvideReviewReplyProviderFactory implements Factory<ReviewReplyProvider> {
    public final ReviewReplyModule a;
    public final Provider<ReplyUploadPresenterImpl> b;

    public ReviewReplyModule_ProvideReviewReplyProviderFactory(ReviewReplyModule reviewReplyModule, Provider<ReplyUploadPresenterImpl> provider) {
        this.a = reviewReplyModule;
        this.b = provider;
    }

    public static ReviewReplyModule_ProvideReviewReplyProviderFactory create(ReviewReplyModule reviewReplyModule, Provider<ReplyUploadPresenterImpl> provider) {
        return new ReviewReplyModule_ProvideReviewReplyProviderFactory(reviewReplyModule, provider);
    }

    public static ReviewReplyProvider provideReviewReplyProvider(ReviewReplyModule reviewReplyModule, ReplyUploadPresenterImpl replyUploadPresenterImpl) {
        return (ReviewReplyProvider) Preconditions.checkNotNullFromProvides(reviewReplyModule.provideReviewReplyProvider(replyUploadPresenterImpl));
    }

    @Override // javax.inject.Provider
    public ReviewReplyProvider get() {
        return provideReviewReplyProvider(this.a, this.b.get());
    }
}
