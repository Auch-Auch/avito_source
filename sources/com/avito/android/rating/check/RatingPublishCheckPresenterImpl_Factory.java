package com.avito.android.rating.check;

import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RatingPublishCheckPresenterImpl_Factory implements Factory<RatingPublishCheckPresenterImpl> {
    public final Provider<RatingPublishCheckInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<DialogPresenter> c;
    public final Provider<ErrorHelper> d;
    public final Provider<UnknownScreenTracker> e;
    public final Provider<Kundle> f;

    public RatingPublishCheckPresenterImpl_Factory(Provider<RatingPublishCheckInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<DialogPresenter> provider3, Provider<ErrorHelper> provider4, Provider<UnknownScreenTracker> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static RatingPublishCheckPresenterImpl_Factory create(Provider<RatingPublishCheckInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<DialogPresenter> provider3, Provider<ErrorHelper> provider4, Provider<UnknownScreenTracker> provider5, Provider<Kundle> provider6) {
        return new RatingPublishCheckPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static RatingPublishCheckPresenterImpl newInstance(RatingPublishCheckInteractor ratingPublishCheckInteractor, SchedulersFactory3 schedulersFactory3, DialogPresenter dialogPresenter, ErrorHelper errorHelper, UnknownScreenTracker unknownScreenTracker, Kundle kundle) {
        return new RatingPublishCheckPresenterImpl(ratingPublishCheckInteractor, schedulersFactory3, dialogPresenter, errorHelper, unknownScreenTracker, kundle);
    }

    @Override // javax.inject.Provider
    public RatingPublishCheckPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
