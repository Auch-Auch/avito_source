package com.avito.android.rating.publish.buyer_info;

import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BuyerInfoPresenterImpl_Factory implements Factory<BuyerInfoPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<RatingPublishData> b;
    public final Provider<RatingPublishViewData> c;
    public final Provider<Kundle> d;

    public BuyerInfoPresenterImpl_Factory(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static BuyerInfoPresenterImpl_Factory create(Provider<StepListener> provider, Provider<RatingPublishData> provider2, Provider<RatingPublishViewData> provider3, Provider<Kundle> provider4) {
        return new BuyerInfoPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static BuyerInfoPresenterImpl newInstance(StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, Kundle kundle) {
        return new BuyerInfoPresenterImpl(stepListener, ratingPublishData, ratingPublishViewData, kundle);
    }

    @Override // javax.inject.Provider
    public BuyerInfoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
