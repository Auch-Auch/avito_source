package com.avito.android.rating.publish.deal_proofs;

import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DealProofsPresenterImpl_Factory implements Factory<DealProofsPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<ImageListPresenter> b;
    public final Provider<RatingPublishData> c;
    public final Provider<RatingPublishViewData> d;

    public DealProofsPresenterImpl_Factory(Provider<StepListener> provider, Provider<ImageListPresenter> provider2, Provider<RatingPublishData> provider3, Provider<RatingPublishViewData> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DealProofsPresenterImpl_Factory create(Provider<StepListener> provider, Provider<ImageListPresenter> provider2, Provider<RatingPublishData> provider3, Provider<RatingPublishViewData> provider4) {
        return new DealProofsPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DealProofsPresenterImpl newInstance(StepListener stepListener, ImageListPresenter imageListPresenter, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData) {
        return new DealProofsPresenterImpl(stepListener, imageListPresenter, ratingPublishData, ratingPublishViewData);
    }

    @Override // javax.inject.Provider
    public DealProofsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
