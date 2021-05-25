package com.avito.android.notification_center.landing.recommends.review;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewPresenterImpl_Factory implements Factory<NcRecommendsReviewPresenterImpl> {
    public final Provider<String> a;
    public final Provider<NcRecommendsReviewInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Kundle> d;

    public NcRecommendsReviewPresenterImpl_Factory(Provider<String> provider, Provider<NcRecommendsReviewInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static NcRecommendsReviewPresenterImpl_Factory create(Provider<String> provider, Provider<NcRecommendsReviewInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Kundle> provider4) {
        return new NcRecommendsReviewPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static NcRecommendsReviewPresenterImpl newInstance(String str, NcRecommendsReviewInteractor ncRecommendsReviewInteractor, SchedulersFactory schedulersFactory, Kundle kundle) {
        return new NcRecommendsReviewPresenterImpl(str, ncRecommendsReviewInteractor, schedulersFactory, kundle);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
