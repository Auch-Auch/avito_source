package com.avito.android.rating.publish.select_rating;

import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectRatingPresenterImpl_Factory implements Factory<SelectRatingPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<RatingPublishData> b;
    public final Provider<RatingPublishViewData> c;
    public final Provider<Kundle> d;

    public SelectRatingPresenterImpl_Factory(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SelectRatingPresenterImpl_Factory create(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<Kundle> provider4) {
        return new SelectRatingPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SelectRatingPresenterImpl newInstance(StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, Kundle kundle) {
        return new SelectRatingPresenterImpl(stepListener, ratingPublishData, ratingPublishViewData, kundle);
    }

    @Override // javax.inject.Provider
    public SelectRatingPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
