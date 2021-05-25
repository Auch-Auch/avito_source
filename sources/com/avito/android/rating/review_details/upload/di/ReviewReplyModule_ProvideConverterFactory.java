package com.avito.android.rating.review_details.upload.di;

import com.avito.android.rating.review_details.upload.ReviewReplyConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ReviewReplyModule_ProvideConverterFactory implements Factory<ReviewReplyConverter> {
    public final ReviewReplyModule a;

    public ReviewReplyModule_ProvideConverterFactory(ReviewReplyModule reviewReplyModule) {
        this.a = reviewReplyModule;
    }

    public static ReviewReplyModule_ProvideConverterFactory create(ReviewReplyModule reviewReplyModule) {
        return new ReviewReplyModule_ProvideConverterFactory(reviewReplyModule);
    }

    public static ReviewReplyConverter provideConverter(ReviewReplyModule reviewReplyModule) {
        return (ReviewReplyConverter) Preconditions.checkNotNullFromProvides(reviewReplyModule.provideConverter());
    }

    @Override // javax.inject.Provider
    public ReviewReplyConverter get() {
        return provideConverter(this.a);
    }
}
