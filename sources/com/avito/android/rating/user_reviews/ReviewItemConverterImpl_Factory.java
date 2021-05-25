package com.avito.android.rating.user_reviews;

import com.avito.android.rating.details.ReviewReplyResultConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReviewItemConverterImpl_Factory implements Factory<ReviewItemConverterImpl> {
    public final Provider<ReviewReplyResultConverter> a;

    public ReviewItemConverterImpl_Factory(Provider<ReviewReplyResultConverter> provider) {
        this.a = provider;
    }

    public static ReviewItemConverterImpl_Factory create(Provider<ReviewReplyResultConverter> provider) {
        return new ReviewItemConverterImpl_Factory(provider);
    }

    public static ReviewItemConverterImpl newInstance(ReviewReplyResultConverter reviewReplyResultConverter) {
        return new ReviewItemConverterImpl(reviewReplyResultConverter);
    }

    @Override // javax.inject.Provider
    public ReviewItemConverterImpl get() {
        return newInstance(this.a.get());
    }
}
