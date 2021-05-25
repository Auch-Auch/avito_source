package com.avito.android.notification_center.landing.recommends.review_list;

import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewListPresenterImpl_Factory implements Factory<NcRecommendsReviewListPresenterImpl> {
    public final Provider<NcRecommendsReviewListInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Relay<Integer>> d;
    public final Provider<Kundle> e;

    public NcRecommendsReviewListPresenterImpl_Factory(Provider<NcRecommendsReviewListInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<Relay<Integer>> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static NcRecommendsReviewListPresenterImpl_Factory create(Provider<NcRecommendsReviewListInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<Relay<Integer>> provider4, Provider<Kundle> provider5) {
        return new NcRecommendsReviewListPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NcRecommendsReviewListPresenterImpl newInstance(NcRecommendsReviewListInteractor ncRecommendsReviewListInteractor, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, Relay<Integer> relay, Kundle kundle) {
        return new NcRecommendsReviewListPresenterImpl(ncRecommendsReviewListInteractor, schedulersFactory, adapterPresenter, relay, kundle);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
