package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.review_details.upload.ReplyUploadPresenterImpl;
import com.avito.android.rating.review_details.upload.ReviewReplyConverter;
import com.avito.android.rating.review_details.upload.ReviewReplyInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ReviewReplyModule_ProvideUploadPresenterImplFactory implements Factory<ReplyUploadPresenterImpl> {
    public final ReviewReplyModule a;
    public final Provider<ReviewReplyInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ReviewReplyConverter> d;

    public ReviewReplyModule_ProvideUploadPresenterImplFactory(ReviewReplyModule reviewReplyModule, Provider<ReviewReplyInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ReviewReplyConverter> provider3) {
        this.a = reviewReplyModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ReviewReplyModule_ProvideUploadPresenterImplFactory create(ReviewReplyModule reviewReplyModule, Provider<ReviewReplyInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<ReviewReplyConverter> provider3) {
        return new ReviewReplyModule_ProvideUploadPresenterImplFactory(reviewReplyModule, provider, provider2, provider3);
    }

    public static ReplyUploadPresenterImpl provideUploadPresenterImpl(ReviewReplyModule reviewReplyModule, ReviewReplyInteractor reviewReplyInteractor, SchedulersFactory3 schedulersFactory3, ReviewReplyConverter reviewReplyConverter) {
        return (ReplyUploadPresenterImpl) Preconditions.checkNotNullFromProvides(reviewReplyModule.provideUploadPresenterImpl(reviewReplyInteractor, schedulersFactory3, reviewReplyConverter));
    }

    @Override // javax.inject.Provider
    public ReplyUploadPresenterImpl get() {
        return provideUploadPresenterImpl(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
