package com.avito.android.rating.publish.select_advert;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTracker;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class SelectAdvertPresenterImpl_Factory implements Factory<SelectAdvertPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<SelectAdvertInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Observable<SelectAdvertAction>> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<ErrorHelper> f;
    public final Provider<RatingPublishData> g;
    public final Provider<RatingPublishViewData> h;
    public final Provider<SelectAdvertTracker> i;
    public final Provider<Observable<LoadingItemNextPageAction>> j;
    public final Provider<Kundle> k;

    public SelectAdvertPresenterImpl_Factory(Provider<StepListener> provider, Provider<SelectAdvertInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<Observable<SelectAdvertAction>> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorHelper> provider6, Provider<RatingPublishData> provider7, Provider<RatingPublishViewData> provider8, Provider<SelectAdvertTracker> provider9, Provider<Observable<LoadingItemNextPageAction>> provider10, Provider<Kundle> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static SelectAdvertPresenterImpl_Factory create(Provider<StepListener> provider, Provider<SelectAdvertInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<Observable<SelectAdvertAction>> provider4, Provider<SchedulersFactory3> provider5, Provider<ErrorHelper> provider6, Provider<RatingPublishData> provider7, Provider<RatingPublishViewData> provider8, Provider<SelectAdvertTracker> provider9, Provider<Observable<LoadingItemNextPageAction>> provider10, Provider<Kundle> provider11) {
        return new SelectAdvertPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SelectAdvertPresenterImpl newInstance(StepListener stepListener, SelectAdvertInteractor selectAdvertInteractor, AdapterPresenter adapterPresenter, Observable<SelectAdvertAction> observable, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, SelectAdvertTracker selectAdvertTracker, Observable<LoadingItemNextPageAction> observable2, Kundle kundle) {
        return new SelectAdvertPresenterImpl(stepListener, selectAdvertInteractor, adapterPresenter, observable, schedulersFactory3, errorHelper, ratingPublishData, ratingPublishViewData, selectAdvertTracker, observable2, kundle);
    }

    @Override // javax.inject.Provider
    public SelectAdvertPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
