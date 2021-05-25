package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import com.avito.android.rating.remote.RatingApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RequestReviewInteractorImpl_Factory implements Factory<RequestReviewInteractorImpl> {
    public final Provider<RatingApi> a;

    public RequestReviewInteractorImpl_Factory(Provider<RatingApi> provider) {
        this.a = provider;
    }

    public static RequestReviewInteractorImpl_Factory create(Provider<RatingApi> provider) {
        return new RequestReviewInteractorImpl_Factory(provider);
    }

    public static RequestReviewInteractorImpl newInstance(RatingApi ratingApi) {
        return new RequestReviewInteractorImpl(ratingApi);
    }

    @Override // javax.inject.Provider
    public RequestReviewInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
