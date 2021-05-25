package com.avito.android.rating.publish.review_input;

import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReviewInputPresenterImpl_Factory implements Factory<ReviewInputPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<RatingPublishData> b;
    public final Provider<RatingPublishViewData> c;
    public final Provider<NextStagePayload> d;
    public final Provider<Kundle> e;

    public ReviewInputPresenterImpl_Factory(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<NextStagePayload> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ReviewInputPresenterImpl_Factory create(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<NextStagePayload> provider4, Provider<Kundle> provider5) {
        return new ReviewInputPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ReviewInputPresenterImpl newInstance(StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload, Kundle kundle) {
        return new ReviewInputPresenterImpl(stepListener, ratingPublishData, ratingPublishViewData, nextStagePayload, kundle);
    }

    @Override // javax.inject.Provider
    public ReviewInputPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
