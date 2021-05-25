package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ReviewReplyModule_ProvidePresenterFactory implements Factory<ReplyUploadPresenter> {
    public final ReviewReplyModule a;
    public final Provider<ReplyUploadPresenterImpl> b;

    public ReviewReplyModule_ProvidePresenterFactory(ReviewReplyModule reviewReplyModule, Provider<ReplyUploadPresenterImpl> provider) {
        this.a = reviewReplyModule;
        this.b = provider;
    }

    public static ReviewReplyModule_ProvidePresenterFactory create(ReviewReplyModule reviewReplyModule, Provider<ReplyUploadPresenterImpl> provider) {
        return new ReviewReplyModule_ProvidePresenterFactory(reviewReplyModule, provider);
    }

    public static ReplyUploadPresenter providePresenter(ReviewReplyModule reviewReplyModule, ReplyUploadPresenterImpl replyUploadPresenterImpl) {
        return (ReplyUploadPresenter) Preconditions.checkNotNullFromProvides(reviewReplyModule.providePresenter(replyUploadPresenterImpl));
    }

    @Override // javax.inject.Provider
    public ReplyUploadPresenter get() {
        return providePresenter(this.a, this.b.get());
    }
}
