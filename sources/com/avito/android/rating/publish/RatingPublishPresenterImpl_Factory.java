package com.avito.android.rating.publish;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingPublishPresenterImpl_Factory implements Factory<RatingPublishPresenterImpl> {
    public final Provider<RatingPublishInteractor> a;
    public final Provider<RatingPublishTracker> b;
    public final Provider<RandomKeyProvider> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<ErrorHelper> e;
    public final Provider<RatingPublishPresenter.StepHolder> f;
    public final Provider<Kundle> g;

    public RatingPublishPresenterImpl_Factory(Provider<RatingPublishInteractor> provider, Provider<RatingPublishTracker> provider2, Provider<RandomKeyProvider> provider3, Provider<SchedulersFactory3> provider4, Provider<ErrorHelper> provider5, Provider<RatingPublishPresenter.StepHolder> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static RatingPublishPresenterImpl_Factory create(Provider<RatingPublishInteractor> provider, Provider<RatingPublishTracker> provider2, Provider<RandomKeyProvider> provider3, Provider<SchedulersFactory3> provider4, Provider<ErrorHelper> provider5, Provider<RatingPublishPresenter.StepHolder> provider6, Provider<Kundle> provider7) {
        return new RatingPublishPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static RatingPublishPresenterImpl newInstance(RatingPublishInteractor ratingPublishInteractor, RatingPublishTracker ratingPublishTracker, RandomKeyProvider randomKeyProvider, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper, RatingPublishPresenter.StepHolder stepHolder, Kundle kundle) {
        return new RatingPublishPresenterImpl(ratingPublishInteractor, ratingPublishTracker, randomKeyProvider, schedulersFactory3, errorHelper, stepHolder, kundle);
    }

    @Override // javax.inject.Provider
    public RatingPublishPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
